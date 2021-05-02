import java.util.Arrays;
import java.util.HashMap;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class 找出数组中重复的数字 {
    public static int findNum(int[] arr){
        if(arr == null || arr.length<=0){
            return -1;
        }
        int len = arr.length;
        HashMap hashMap = new HashMap();
        for (int i = 0; i < len; i++) {
            if(hashMap.get(arr[i]) != null){
                return arr[i];
            }
            hashMap.put(arr[i],1);
        }
        return -1;
    }
    public static int findNum2(int[] nums){
        if(nums == null || nums.length<=0){
            return -1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
    public static int findNum3(int[] nums){
        if(nums == null || nums.length<=0){
            return -1;
        }
        int len = nums.length;
        int[] nums2 = new int[len];
        Arrays.fill(nums2,-1);
        for (int i = 0; i < len; i++) {
            if(nums2[nums[i]] != -1){
                return nums[i];
            }
            nums2[nums[i]] = nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        int num = findNum3(arr);
        System.out.println(num);
    }
}
