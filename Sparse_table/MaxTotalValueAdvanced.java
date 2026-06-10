package Sparse_table;

/*
Problem: Maximum Total Value of K Subarrays
Approach:
1. Sparse Table for O(1) Range Max/Min Query
2. Priority Queue (Max Heap)
3. Greedy extraction of best subarray values

Time Complexity:
Build Sparse Table -> O(n log n)
Each Query          -> O(1)
Heap Operations     -> O(k log n)

Overall:
O(n log n + k log n)
*/

import java.util.*;

public class MaxTotalValueAdvanced {

    /*
    Sparse Table for Range Max and Min Queries
    */
    static class SparseTableRMQ {

        private final int[][] fMax;
        private final int[][] fMin;
        private final int[] lg;

        public SparseTableRMQ(int[] nums) {

            int n = nums.length;

            // Precompute logs
            lg = new int[n + 1];

            for(int i = 2; i <= n; i++) {
                lg[i] = lg[i / 2] + 1;
            }

            int k = lg[n] + 1;

            fMax = new int[n][k];
            fMin = new int[n][k];

            // Base case
            for(int i = 0; i < n; i++) {

                fMax[i][0] = nums[i];
                fMin[i][0] = nums[i];
            }

            // Build sparse table
            for(int j = 1; j < k; j++) {

                for(int i = 0;
                    i + (1 << j) <= n;
                    i++) {

                    fMax[i][j] =
                            Math.max(
                                    fMax[i][j - 1],
                                    fMax[i + (1 << (j - 1))][j - 1]
                            );

                    fMin[i][j] =
                            Math.min(
                                    fMin[i][j - 1],
                                    fMin[i + (1 << (j - 1))][j - 1]
                            );
                }
            }
        }

        public int queryMax(int l, int r) {

            int j = lg[r - l + 1];

            return Math.max(
                    fMax[l][j],
                    fMax[r - (1 << j) + 1][j]
            );
        }

        public int queryMin(int l, int r) {

            int j = lg[r - l + 1];

            return Math.min(
                    fMin[l][j],
                    fMin[r - (1 << j) + 1][j]
            );
        }
    }

    /*
    Represents a subarray candidate
    */
    static class SubarrayState
            implements Comparable<SubarrayState> {

        long value;
        int l;
        int r;

        public SubarrayState(
                long value,
                int l,
                int r) {

            this.value = value;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(SubarrayState other) {

            // Max Heap
            return Long.compare(
                    other.value,
                    this.value
            );
        }
    }

    public long maxTotalValue(
            int[] nums,
            int k) {

        int n = nums.length;

        SparseTableRMQ st =
                new SparseTableRMQ(nums);

        PriorityQueue<SubarrayState> pq =
                new PriorityQueue<>();

        /*
        Initially:
        For every left index,
        use maximum possible right index
        */

        for(int l = 0; l < n; l++) {

            long value =
                    (long)
                    st.queryMax(l, n - 1)
                    -
                    st.queryMin(l, n - 1);

            pq.offer(
                    new SubarrayState(
                            value,
                            l,
                            n - 1
                    )
            );
        }

        long totalValue = 0;

        // Extract top-k values
        for(int i = 0; i < k; i++) {

            if(pq.isEmpty()) {
                break;
            }

            SubarrayState current =
                    pq.poll();

            totalValue += current.value;

            // Try smaller right boundary
            if(current.r > current.l) {

                int nextR = current.r - 1;

                long nextValue =
                        (long)
                        st.queryMax(current.l, nextR)
                        -
                        st.queryMin(current.l, nextR);

                pq.offer(
                        new SubarrayState(
                                nextValue,
                                current.l,
                                nextR
                        )
                );
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {

        MaxTotalValueAdvanced solution =
                new MaxTotalValueAdvanced();

        int[] nums = {1, 3, 6, 2};

        int k = 3;

        long result =
                solution.maxTotalValue(nums, k);

        System.out.println(
                "Maximum Total Value: "
                + result
        );
    }
}
