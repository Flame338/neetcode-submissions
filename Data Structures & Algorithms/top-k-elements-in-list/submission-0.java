class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        // Extract unique keys and sort them by frequency in descending order
        List<Integer> list = new ArrayList(count.keySet());
        list.sort((a, b) -> count.get(b) - count.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
