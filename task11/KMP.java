package dsaa.lab12;

import java.util.LinkedList;

public class KMP implements IStringMatcher {

	@Override
	public LinkedList<Integer> validShifts(String pattern, String text) {
		// TODO Auto-generated method stub
		LinkedList<Integer> positions = new LinkedList<>();
		if (pattern.length() == 0 || text.length() == 0)
			return positions;

		int n = text.length();
		int m = pattern.length();
		int[] pi = Compute_Prefix_Function(pattern);
		int q = 0;
		for (int i = 0; i < n; i++) {
			while (q>0 && pattern.charAt(q) != text.charAt(i)){
				q = pi[q-1];
			}
			if (pattern.charAt(q) == text.charAt(i)){
				q++;
			}
			if (q==m){
				positions.add(i-m+1);
				q=pi[q-1];
			}
		}

		return positions;
	}

	private int[] Compute_Prefix_Function(String P){
		int m = P.length();
		int k = 0;
		int[] pi = new int[m];

		for (int i = 0; i < pi.length; i++) {
			pi[i] =0;
		}

		for (int q = 2; q <= m; q++) {
			while (k>0 && P.charAt(k) != P.charAt(q-1)){
				k=pi[k-1];
			}
			if (P.charAt(k) == P.charAt(q-1))
				k++;
			pi[q-1] = k;
		}
		return pi;
	}

}
