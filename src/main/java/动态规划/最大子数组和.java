package 动态规划;

import java.util.Arrays;

public class 最大子数组和 {
    public static void main(String[] args) {

    }

    /**
     * 直接就是dp了，dp[i] 代表以当前节点为尾部的最大连续和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1 ; i < n ; i ++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
