// 2542. Maximum Subsequence Score
// Algorithm
// pick the biggest number in nums2 first so when multiplied gives the maximum score, although you need to pick minimum from the k subset
// we sort nums1 and nums2 in descending order based on nums2
// using priorityQueue, we keep track of the smallest element so in a sliding window approach we can remove the smallest element from the sum in nums1 so when added gives the biggest sum

class Solution {
	public long maxScore(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		Pair<Integer, Integer>[] p = new Pair[n];

		for (int i = 0; i < nums1.length; i++) {
			p[i] = new Pair(nums1[i], nums2[i]);
		}

		Comparator<Pair<Integer, Integer>> lambda = (a, b)-> b.getValue().compareTo(a.getValue());

		Arrays.sort(p, lambda);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		long kSum = 0;

		for (int i = 0; i <= k - 1; i++) {
			kSum += p[i].getKey();
			pq.add(p[i].getKey());
		}

		long result = kSum * p[k - 1].getValue();

		for (int i = k; i < n; i++) {

			kSum += p[i].getKey() - pq.poll();
			pq.add(p[i].getKey());

			result = Math.max(result, kSum * p[i].getValue());

		}
		return result;


	}
}
