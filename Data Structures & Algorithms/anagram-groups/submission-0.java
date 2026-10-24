class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String current = (str == null) ? "" : str;
            int[] count = new int[26];

            for (char c : current.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int freq : count) {
                sb.append("#").append(freq);
            }

            String key = sb.toString();
            map.computeIfAbsent(key, h -> new ArrayList<String>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
