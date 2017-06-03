package baekjoon.Tree_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Occidere {
	private static boolean[] isRootNode = null;
	private static boolean[] isVisited = null;
	private static ArrayList<Integer>[] adjacencyLists = null;
	private static int leafNodeCnt = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		adjacencyLists = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adjacencyLists[i] = new ArrayList<>();
		}

		isRootNode = new boolean[N];

		for (int i = 0; i < N; i++) {
			int parentNode = Integer.parseInt(st.nextToken());

			if (parentNode != -1) {
				adjacencyLists[parentNode].add(i);
			}

			else {
				isRootNode[i] = true;
			}
		}

		int D = Integer.parseInt(br.readLine());

		for (ArrayList<Integer> adjacencyList : adjacencyLists) {
			int adjacencyListSize = adjacencyList.size();

			for (int i = 0; i < adjacencyListSize; i++) {
				if (adjacencyList.get(i) == D) {
					adjacencyList.remove(i);

					break;
				}
			}
		}

		adjacencyLists[D].clear();

		isVisited = new boolean[N];

		for (int i = 0; i < N; i++) {
			if (isRootNode[i] && !isVisited[i] && i != D) {
				isVisited[i] = true;

				dfs(i);
			}
		}

		System.out.println(leafNodeCnt);
	}

	private static void dfs(int current) {
		if (adjacencyLists[current].size() == 0) {
			leafNodeCnt++;

			return;
		}

		for (int next : adjacencyLists[current]) {
			if (!isVisited[next]) {
				isVisited[next] = true;

				dfs(next);
			}
		}
	}
}