package 双指针;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class 移动零 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] == 0){
                right++;
            }else {
                swap(left,right,nums);
                left++;
                right++;
            }
        }
    }

    private static void swap(int i,int j,int[] nums){
        int num = nums[j];
        nums[j] = nums[i];
        nums[i] = num;
    }
}
