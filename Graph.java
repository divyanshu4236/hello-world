package Trees;

import java.util.Scanner;

public class Graph {
		
	
	public static boolean hasPath(int[][] edges,int sv,int ev) {
		
	}
	public static void bfsHelper(int[][] edges,int sv,boolean[] visited) {
		
		Queue<Integer> q = new Queue<>();
		q.enqueue(sv);
		visited[sv] = true;
		
		while(!q.isEmpty()) {
			int currVertex = q.dequeue();
			System.out.println(currVertex);
			
			int n = edges.length;
			for(int i=0;i<n;i++) {
				if(edges[currVertex][i] == 1 && !visited[i]) {
					q.enqueue(i);
					visited[i] = true;
				}
			}
		}
	}
	public static void bfs(int[][] edges) {
		
		boolean[] visited = new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(!visited[i]) {
				bfsHelper(edges,i,visited);
			}
		}
		
	}

	
	public static void dfsHelper(int[][] edges,int cv,boolean[] visited) {
		
		System.out.println(cv);
		visited[cv] = true;
		int n = edges.length;
		for(int i=0;i<n;i++) {
			
			if(edges[cv][i] == 1 && !visited[i]) {
				dfsHelper(edges,i,visited);
			}
		}
	}
	public static void dfs(int[][] edges) {
		
		boolean[] visited = new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(!visited[i]) {
				dfsHelper(edges,i,visited);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] edges = new int[n][n];
		int e = s.nextInt();
		for(int i=0;i<e;i++) {
			int sv = s.nextInt();
			int ev = s.nextInt();
			edges[sv][ev] = 1;
			edges[ev][sv] = 1;
		}
		bfs(edges);
	}

}
