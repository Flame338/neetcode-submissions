class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] count = new int[len];
        Arrays.fill(count, 1);

        int prefix = 1;
        for (int i = 0; i < len; i++) {
            count[i] *= prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = len - 1; i >= 0; i--) {
            count[i] *= suffix;
            suffix *= nums[i];
        }
        return count;
    }
}  
