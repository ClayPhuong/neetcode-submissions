class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
         int longest = 0;

        for(int n : set){

            // chỉ bắt đầu nếu là đầu chuỗi
            if(!set.contains(n - 1)){

                int length = 1;

                while(set.contains(n + length)){
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
