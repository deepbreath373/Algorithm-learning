import java.util.Arrays;

public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length / 2];
        return res;
    }

    public int majorityElement2(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums[nums.length >> 1];
    }

    public void partition(int[] nums, int start, int end) {
        int num = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (i < end && nums[++i] < num) ;
            while (j > start && nums[--j] > num) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        int mid = nums.length >> 1;
        if (j == mid) return;
        if (j > mid) partition(nums, start, j - 1);
        else partition(nums, j + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //摩尔投票,超过半数的数字总个数一定的大于剩下的数字个数
    public int majorityElement3(int[] nums) {
        int len = nums.length;
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < len; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (result == nums[i]) {
                times++;
            } else {
                times--;
            }
        }
        return result;
    }
}
