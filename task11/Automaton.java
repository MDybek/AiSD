package dsaa.lab12;

import java.util.LinkedList;

public class Automaton implements IStringMatcher {

	@Override
	public LinkedList<Integer> validShifts(String pattern, String text) {
		//TODO
		LinkedList<Integer> positions = new LinkedList<>();
		if (pattern.length() == 0 || text.length() == 0)
			return positions;
		int minChar = findmin(pattern);
		int[][] CTF = Compute_Transition_Function(pattern);
		int n = text.length();
		int q = 0;
		int m = pattern.length();
		for (int i = 0; i < n; i++) {
			if (text.charAt(i) - minChar >= 0 && text.charAt(i) - minChar < CTF[q].length) {
				q = CTF[q][text.charAt(i) - minChar];
				if (q == m)
					positions.add( i - m + 1 );
			}
			else
				q=0;

		}
		return positions;
	}

	private int[][] Compute_Transition_Function (String P){
		int m = P.length();
		int maxsize = findmax(P);
		int minsize = findmin(P);
		int size = maxsize-minsize;
		int [][] CTF = new int[m+1][size+1];
		for(int i = 0; i < CTF.length; i++)
			for(int j = 0; j < CTF[0].length; j++)
				CTF[i][j] = 0;

		int k;
		String suffix;
		String preffix;

		for(int q = 0; q <= m; q++){
			for(int a = 0; a <= size; a++){
				k = min(m+1, q+2);

				do{
					k--;
					suffix = P.substring(0, k);
					preffix = P.substring(0, q);
					preffix += (char)(a + minsize);

				}while (!preffix.endsWith(suffix));
				CTF[q][a] = k;
			}
		}
		return CTF;
	}

	private int min(int a, int b){
		return a <= b ? a : b;
	}

	private int findmax(String str){
		int max = 0;
		int n = str.length();
		for (int i=0; i<n; i++)
			if (str.charAt(i) > max)
				max = str.charAt(i);

		return max;
	}

	private int findmin(String str){
		int min = 250;
		int n = str.length();
		for (int i=0; i<n; i++)
			if (str.charAt(i) < min)
				min = str.charAt(i);

		return min;
	}
}