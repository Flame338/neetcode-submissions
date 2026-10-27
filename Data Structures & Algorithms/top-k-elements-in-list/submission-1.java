class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (var entry : count.entrySet()) {
            int freq = entry.getValue();
            buckets.computeIfAbsent(freq, key -> new ArrayList<Integer>()).add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            List<Integer> bucket = buckets.get(i);
            if (bucket != null) {
                for (int num : bucket) {
                    result.add(num);
                    if (result.size() == k) break;
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
