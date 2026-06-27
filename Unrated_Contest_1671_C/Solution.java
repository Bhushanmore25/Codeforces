import java.util.*;

public class DolceVita {
	// Function to check if the cost of the ith packet is less than or equal to x for that day
	// If true, it means we can buy it
	static boolean pf(long val, int ind, int x, int mid) {
		return val + (1L * (ind + 1) * (mid - 1)) <= x;
	}

	// Function to perform binary search to find the maximum number of days we can buy the packet
	static int binSearch(long val, int ind, int x) {
		int low = 1, high = 1000000005;
		int ans = 0;

		while (low <= high) {
			int mid = (low + high) / 2;

			// Check if we can buy the packet on the mid-th day
			if (pf(val, ind, x, mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		} //? O(32)

		return ans;
	} //? O(32)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int x = sc.nextInt();

			int[] cost = new int[n]; //! a
			for (int i = 0; i < n; i++) //? O(N)
				cost[i] = sc.nextInt();

			// Sort the costs to buy cheaper packets first
			Arrays.sort(cost); //! b
			//? O(N log N)

			// Create a prefix sum array to store cumulative costs
			long[] presum = new long[n];

			presum[0] = cost[0];
			for (int i = 1; i < n; i++) {
				presum[i] = presum[i - 1] + cost[i];
			} //? O(N)

			long ans = 0;
			for (int i = 0; i < n; i++) {
				// Calculate the total number of days we can buy packets
				ans += binSearch(presum[i], i, x); //? O(32)
			} //? O(N * 32)

			System.out.println(ans);
		}

		sc.close();
	}

	//! Total Time Complexity (TC): O(N * 32 + N log N)
	//! Total Space Complexity (SC): O(N)
}
