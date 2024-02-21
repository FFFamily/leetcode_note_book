package 双指针;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {

    }

    /**
     * 排序是不可能的
     * 单纯的找最大值也不行，还得考虑相乘后的结果（最大高度不一定是最大容积）
     * 可以联想到
     * 水的高度是由左右两侧最低的决定的，容纳的水是由：左右两边高度较小值 * 距离
     * 如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，后者「指针之间的距离」会减小，那么这个乘积会减小。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res  = Integer.MIN_VALUE;
        while (left < right){
            int temp = (right-left) * Math.min(height[left],height[right]);
            res = Math.max(res,temp);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

}
