package com.ns.graph.prac;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> {
	private static int v;
	private static LinkedList<Integer> adjListArray[];

	public Graph(int v) {
		this.v = v;
		adjListArray = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adjListArray[i] = new LinkedList<Integer>();
		}

	}

	static void addEdge(Graph<Integer> graph, int src, int dest) {
		// Add an edge from src to dest.
		graph.adjListArray[src].add(dest);
		// Since graph is undirected, add an edge from dest
		// to src also
		graph.adjListArray[dest].add(src);
	}

	static void printGraph(Graph graph) {

		for (int i = 0; i < graph.v; i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.print("head");
			for (Object vetices : graph.adjListArray[i]) {
				System.out.print(" -> " + vetices);
			}
			System.out.println("\n");
		}
	}

	static void BFS(int s) {
		boolean[] visited = new boolean[v];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		int vertices;
		Iterator<Integer> integerItr;
		while (!queue.isEmpty()) {
			vertices = queue.poll();
			System.out.println(vertices + " ");
			integerItr = adjListArray[vertices].iterator();
			while (integerItr.hasNext()) {
				vertices = integerItr.next();
				if (!visited[vertices]) {
					visited[vertices] = true;
					queue.add(vertices);
				}
			}
		}
	}

	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 5;
		Graph g = new Graph(V);
		g.addEdge(g, 0, 1);
		g.addEdge(g, 0, 2);
		g.addEdge(g, 1, 2);
		g.addEdge(g, 2, 3);
		g.addEdge(g, 3, 3);

		// print the adjacency list representation of
		// the above graph
		BFS(2);
		printGraph(g);
	}
}
