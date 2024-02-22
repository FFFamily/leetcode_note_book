package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {

    }

    /**
     * 首先的想法是排序后利用双指针找匹配值
     * 不能有重复三元，也就是说当指针遇到有重复项时就前移/后移
     * 然后用 map 存第三个值
     * 这样是不行的，我不知道左右节点什么时候移动（想了想左右节点可以直接暴力遍历就好）
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int left = 0; left < nums.length; left++) {
            // 左侧指针 left
            if (left > 0 && nums[left] == nums[left-1]){
                // 不能有重复
                continue;
            }
            // 右侧指针
            int right = nums.length -1;
            for (int mid = left+1 ; mid < nums.length ; mid++){
                if (mid > 0 && nums[mid] == nums[mid-1]){
                    // 不能有重复
                    continue;
                }
                if (nums[left] + nums[mid] + nums[right] < 0){
                    // 相加如果小于0，证明已经没办法能加到0了
                    continue;
                }

            }

        }
    }


}
