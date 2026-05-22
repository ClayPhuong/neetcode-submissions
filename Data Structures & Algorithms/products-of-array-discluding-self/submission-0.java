class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //tao prefix
        ans[0] = 1;
        //duyet tu trai sang phai
        for (int i = 1; i<n; i++) {
            ans[i]=ans[i-1]*nums[i-1];
        }  

        //tao suffix
        int suf=1;
        for (int i=n-1; i>=0; i--) {
            ans[i]=ans[i]*suf;
            suf=nums[i]*suf;
        }
        return ans;
    }
}  
