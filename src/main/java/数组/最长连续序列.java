package 数组;

import java.util.HashMap;
import java.util.HashSet;
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
     * 这个也有问题
     * 处理右侧的数据不能是直接获取，而是需要while循环向上获取，不然达不到连接左右侧的要求
     * 那如果 map 里 存的是这个节点可达到的最大值
     *      * 但是如果遇到重复数据了怎么办，不能无脑的直接+1
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

    /**
     * 还是用 while 的方式求一下，但是就是不满足题目的 n 的 时间复杂度
     * 如果是这样的话 其实都不用存储 key 对应的长度 只用关系有没有这个key 就好了
     * @param nums
     * @return
     */
    public static int longestConsecutive3(int[] nums) {
        int res = 0;

        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            map.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.contains(num - 1)){
                // set 中 不存在比自己小的，向前遍历
                int currentNum = num;
                int currentStreak = 1;

                while (map.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                res  = Math.max(res, currentStreak);
            }
        }
        return res;
    }


}
