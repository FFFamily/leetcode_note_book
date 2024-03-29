package 数组;

public class 轮转数组 {
    public static void main(String[] args) {

    }

    public  void rotate(int[] nums, int k) {
        // 不可能旋转k次遍历，所以应该找规律
        // 因为当 k 为 nums.length 时，就会复原到原来的位置
        k = k % nums.length;
        int n = nums.length;
        swap(0,n-1,nums);
        swap(0,k,nums);
        swap(k+1,n-1,nums);

    }

    public void swap(int start ,int end ,int[] arrs){
        while(start < end){
            int item = arrs[start];
            arrs[start] = arrs[end];
            arrs[end] = item;
            start++;
            end--;
        }
    }
}
