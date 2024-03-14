package 滑动窗口;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数
 * 子数组是数组中元素的连续非空序列。
 */
public class 和为K的子数组 {
    public static void main(String[] args) {
        System.out.println(subarraySum2(new int[]{1, 1,1}, 3));
    }

    /**
     * 不能使用双指针，数组无序，并且还有正负数
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int left = 0;
        int res = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
                res++;
                int tempSum = sum;
                int tempLeft = left;
                while (tempSum == k) {
                    res++;
                    tempSum -= nums[tempLeft];
                    tempLeft++;
                }
            }
        }
        return res;
    }


    public static int subarraySum2(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int subarraySum3(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
