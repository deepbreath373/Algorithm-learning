/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (!isOdd(nums[l]) && isOdd(nums[r])) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (isOdd(nums[l])) {
                l++;
            }
            if (!isOdd(nums[r])) {
                r--;
            }
        }
        return nums;
    }

    public static boolean isOdd(int n) {
        return n % 2 == 0 ? false : true;
    }

    public static int[] exchange2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            while(l<r && isOdd(nums[l])){
                l++;
            }
            while(l<r && !isOdd(nums[r])){
                r--;
            }
            if(l<r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] exchange = exchange(arr);
    }
}
