package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2}));
    }
    /**
     * 一开始的想法是记录最大值 依次遍历时小于最大值的计数
     * 但是这样是没办法满足 数字连续 这个条件
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

        }
        return res;
    }

    /**
     * 想到在遍历的过程中可以记录已经遍历过的值，和当前值作比较是否能整连续
     */
    public static int longestConsecutive2(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer min = map.get(num - 1);
            if (min != null){
                // 说明左边有值
                map.put(num,min+1);
                res = min+1;
            }else {
                map.put(num,1);
            }
            Integer max = map.get(num + 1);
            if (max != null){
                // 右边有值
                map.put(num+1,map.get(num)+1);
                res = map.get(num)+1;
            }
//            map.put(num,res);
        }
        return res;
    }


}
