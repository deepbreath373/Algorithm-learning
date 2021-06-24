/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 */
public class 数组中的逆序对 {
    int count;

    public int reversePairs(int[] nums) {
        this.count = 0;
        merge(nums, 0, nums.length - 1);
        return count;
    }

    private void merge(int[] nums, int l, int r) {
        int mid = l + ((r - l) >> 1);
        if (l < r) {
            merge(nums, l, mid);
            merge(nums, mid + 1, r);
            mergeSort(nums, l, mid, r);
        }
    }

    private void mergeSort(int[] nums, int l, int mid, int r) {
        int[] tmpArr = new int[r - l + 1];
        int index = 0;
        int tmp1 = l, tmp2 = mid + 1;
        while (tmp1 <= mid && tmp2 <= r) {
            if(nums[tmp1] <= nums[tmp2]){
                tmpArr[index++] = nums[tmp1++];
            }else{
                count += (mid - tmp1 + 1);
                tmpArr[index++] = nums[tmp2++];
            }
        }
        while(tmp1<=mid){
            tmpArr[index++] = nums[tmp1++];
        }
        while(tmp2<=r){
            tmpArr[index++] = nums[tmp2++];
        }
        for (int i = 0; i < tmpArr.length; i++) {
            nums[i + l] = tmpArr[i];
        }
    }

    public static void main(String[] args) {
        数组中的逆序对 a = new 数组中的逆序对();
        a.reversePairs(new int[]{7,5,6,4});
    }
}
