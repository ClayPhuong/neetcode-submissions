class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int i : nums) {
            int curr = i, streak=0;
            while(set.contains(curr)){
                streak++;
                curr++;
            }
            res=Math.max(streak,res);
        }
        return res;
    }
}
