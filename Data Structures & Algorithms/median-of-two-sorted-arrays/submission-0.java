class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = m;
        int middle;
        int take1, take2;

        while (left <= right) {
            take1 = (left + right) / 2;
            take2 = (m + n + 1) / 2 - take1;

            int nums1Left  = (take1 == 0) ? Integer.MIN_VALUE : nums1[take1 - 1];
            int nums1Right = (take1 == m) ? Integer.MAX_VALUE : nums1[take1];

            int nums2Left  = (take2 == 0) ? Integer.MIN_VALUE : nums2[take2 - 1];
            int nums2Right = (take2 == n) ? Integer.MAX_VALUE : nums2[take2];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                right = take1 - 1;
            } else {
                left = take1 + 1;
            }
        }

        return 0.0;
    }
}
