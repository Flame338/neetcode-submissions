class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>(strs.length);
        StringBuilder sb = new StringBuilder(64);

        for (String str : strs) {
            String current = (str == null) ? "" : str;
            int[] count = new int[26];

            for (char c : current.toCharArray()) {
                count[c - 'a']++;
            }

            sb.setLength(0);
            for (int freq : count) {
                sb.append("#").append(freq);
            }

            String key = sb.toString();
            map.computeIfAbsent(key, h -> new ArrayList<String>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
