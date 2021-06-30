import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 */
public class 在排序数组中查找数字 {
    //HashMap
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++count);
        }
        return map.getOrDefault(target, 0);
    }

    //二分
    public int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        //寻找左右边界的区别在于当 mid 和 target 相等的时候谁要移动
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        int right = i;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    public int search3(int[] nums, int target) {
        return find(nums, target) - find(nums, target - 1);
    }

    private int find(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
