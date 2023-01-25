// 2359. Find Closest Node to Given Two Nodes

class Solution {

	public int closestMeetingNode(int[] edges, int node1, int node2) {		int[] distance1 = new int[edges.length];

		int[] distance2 = new int[edges.length];

		boolean[] visited1 = new boolean[edges.length];

		boolean[] visited2 = new boolean[edges.length];

		int min = edges.length;

		int max = Integer.MIN_VALUE;

		int result = -1;

		//initially all the nodes have distance -1, assuming they didnt visit any node

		Arrays.fill(distance1, -1);

		Arrays.fill(distance2, -1);

		dfs(edges, node1, visited1, 0, distance1);

		dfs(edges, node2, visited2, 0, distance2);

		for (int i = 0; i < edges.length; i++) {

			//to check if both nodes did not faile to visit a node

			//if they are -1, it means it didnt find any path to the node

			if (distance1[i] != -1 && distance2[i] != -1) {

				max = Math.max(distance1[i], distance2[i]);

				if (max < min) {

					// minimum of the maximum distance as per the question

					min = max;

				    //return the node value with minimum of maximum distance

					result = i;

				}

			}

		}

		return result;

	}

	public void dfs(int[] edges, int node, boolean[] visited, int distance, int[] distance1) {

        //if -1 there is no path to be visited

		if (node != -1 && visited[node] != true) {

			visited[node] = true;

			distance1[node] = distance;

			dfs(edges, edges[node], visited, distance + 1, distance1);

		}

	}

}
