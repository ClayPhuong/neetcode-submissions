class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String snew = new String(c);
            if (!map.containsKey(snew)) {
                map.put(snew, new ArrayList<>());
            }
            map.get(snew).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
