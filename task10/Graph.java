package dsaa.lab11;

import java.util.*;
import java.util.Map.Entry;
final

public class Graph {
	int arr[][];
	//TODO? Collection to map Document to index of vertex 
	// You can change it
	HashMap<String,Integer> name2Int;
	@SuppressWarnings("unchecked")
	//TODO? Collection to map index of vertex to Document
	// You can change it
	Entry<String, Document>[] arrDoc=(Map.Entry<String, Document>[])new Map.Entry[0];
	private String reStr = "";
	private int infinity = Integer.MAX_VALUE;
	private SortedMap<String, Document> inter;
	private ArrayList<String> visited = new ArrayList();
	private ArrayList<String> added = new ArrayList();
	// The argument type depend on a selected collection in the Main class
	public Graph(SortedMap<String,Document> internet)
	{
		int size=internet.size();
		arr=new int[size][size];
		// TODO
		inter = internet;
		name2Int = new HashMap<>();
		int i = 0;
		for ( String key: internet.keySet()) {
			name2Int.put(key, i);
			i++;
		}

		for (String key: internet.keySet()){
			Document temp = internet.get(key);
			for (String val: temp.link.keySet()){
				arr[name2Int.get(key)][name2Int.get(val)] = internet.get(key).link.get(val).weight;}

		}

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (arr[x][y] == 0){
					if (x == y)
						arr[x][y] = 0;
					else
						arr[x][y] = infinity;
				}
			}
		}
		//print(size);
	}
	private void print(int size)
	{
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				System.out.print(arr[x][y] + "\t\t");
			}
			System.out.println();
		}
	}

	public String bfs(String start)
	{
		// TODO
		reStr = "";
		visited.clear();
		visited.add(start);
		added.clear();
		added.add(start);
		if (inter.isEmpty()|| !inter.containsKey(start))
			return null;
		reStr += start;
		findconnectionBFS(start);
		return reStr;
	}
	
	public String dfs(String start)
	{
		// TODO
		reStr = "";
		visited.clear();
		visited.add(start);
		if (inter.isEmpty() || !inter.containsKey(start))
			return null;
		reStr += start;
		findconnectionDFS(start);
		return reStr;
	}

	private void findconnectionBFS(String key)
	{
		for (String val: inter.keySet()) {
			if (arr[name2Int.get(key)][name2Int.get(val)] != 0 && arr[name2Int.get(key)][name2Int.get(val)] != infinity){
				if (!added.contains(val)){
					reStr += ", ";
					reStr += val;
					added.add(val);
				}
			}
		}
		for (String val: inter.keySet())
			if (arr[name2Int.get(key)][name2Int.get(val)] != 0 && arr[name2Int.get(key)][name2Int.get(val)] != infinity) {
				if (!visited.contains(val)){
					visited.add(val);
					findconnectionBFS(val);
				}
			}
	}

	private void findconnectionDFS(String key)
	{
		for (String val: inter.keySet()) {
			if (arr[name2Int.get(key)][name2Int.get(val)] != 0 && arr[name2Int.get(key)][name2Int.get(val)] != infinity){
				if (!visited.contains(val)){
					reStr += ", ";
					reStr += val;
					visited.add(val);
					findconnectionDFS(val);
				}
			}
		}
	}

	public int connectedComponents()
	{
		// TODO
		DisjointSetForest DSF = new DisjointSetForest(inter.size());
		for (int i = 0; i < inter.size(); i++)
			DSF.makeSet(i);

		for (int x = 0; x < inter.size(); x++) {
			for (int y = 0; y < inter.size(); y++) {
				if (arr[x][y] != 0 && arr[x][y] != infinity){
					DSF.union(x, y);
				}
			}
		}

		return DSF.countSets();
	}
	
	public String DijkstraSSSP(String startVertexStr)
	{
		if (!inter.keySet().contains(startVertexStr) || inter.isEmpty())
			return null;
		String result = "";
		String[] paths = new String[inter.size()];
		for (int i = 0; i < paths.length; i++)
			paths[i] = startVertexStr;

		for (String key: inter.keySet()) {
			if (startVertexStr.equals(key)){
				result += startVertexStr + "=0";
			}
			else if (!dfs(startVertexStr).contains(key)){
				result += "no path to " + key;
			}
			else {
				int dist[] = new int[inter.size()];
				Boolean sptSet[] = new Boolean[inter.size()];
				for (int i = 0; i < dist.length; i++) {
					dist[i] = infinity;
					sptSet[i] = false;
				}
				dist[name2Int.get(startVertexStr)] = 0;
				for (int count = 0; count < dist.length - 1; count++) {
					int u = minDistance(dist, sptSet);

					sptSet[u] = true;
					for (int v = 0; v < dist.length; v++)
						if (!sptSet[v] && arr[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + arr[u][v] < dist[v] && arr[u][v] != infinity) {
							dist[v] = dist[u] + arr[u][v];
							paths[v] = paths[u] + "->" + inter.keySet().toArray()[v];
						}
				}
				result += paths[name2Int.get(key)] + "=" + dist[name2Int.get(key)];
			}
			result += "\n";
		}
		return result;
	}

	private int minDistance(int[] dist, Boolean[] sptSet)
	{
		int min = infinity, min_index = -1;

		for (int v = 0; v < inter.size(); v++)
			if (!sptSet[v] && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}
}
