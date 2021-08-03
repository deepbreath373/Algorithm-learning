import java.util.ArrayList;
import java.util.List;

public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[1];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            }
            if (sum > target) {
                r--;
            }
            if (sum == target) {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[1];
    }

    public int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 2;
        if ((l + r) > target) {
            return new int[1][1];
        }
        List<int[]> ans = new ArrayList<>();
        int sum = l + r;
        while (l < r) {
            if(sum == target){
                int[] res = new int[r-l+1];
                for (int i = l,j = 0; i <= r; i++,j++){
                    res[j] = i;
                }
                ans.add(res);
            }
            if(sum >= target){
                sum-=l;
                l++;
            }else{
                r++;
                sum+=r;
            }
        }
        return ans.toArray(new int[0][]);
    }
}
