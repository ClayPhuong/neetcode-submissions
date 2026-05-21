public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //cach 1: sort | Time: O(m*nlogn | Space: O(m*n))
        /*
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArrays();
            Arrays.sort(c);
            String snew = new String(c);
            if (!map.containsKey(key)){
                map.put(snew, new ArrayList<>());
            }
            map.get(snew).add(s);
        }
        return new ArrayList<>(map.values());
        */


        // cach 2: hash table | Time: O(m*n) | Space: O(m) or O(m*n)
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                //can giai thich cach nay
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!res.containsKey(key)){
                res.put(key, new ArrayList<>());
            }
            //res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}