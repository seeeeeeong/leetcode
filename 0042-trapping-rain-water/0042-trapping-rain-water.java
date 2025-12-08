class Solution {
    public int trap(int[] height) {
       int n = height.length;

       int maxIdx = 0;
       for (int i = 1; i < n; i++) {
        if (height[i] > height[maxIdx]) {
            maxIdx = i;
        }
       } 

        int water = 0;

        int leftMax = height[0];
        for (int i = 1; i < maxIdx; i++) {
            if (height[i] < leftMax) {
                water += leftMax - height[i];
            } else {
                leftMax = height[i];
            }
        }

        int rightMax = height[n - 1];
        for (int i = n - 2; i > maxIdx; i--) {
            if (height[i] < rightMax) {
                water += rightMax - height[i];
            } else {
                rightMax = height[i];
            }
        }

        return water;
    }
}