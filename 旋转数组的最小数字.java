/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 */
public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers == null){
            throw new NullPointerException();
        }
        int l = 0;
        int r = numbers.length - 1;
        int mid = l;

        while (numbers[l]>=numbers[r]) {
            if(r-l == 1){
                mid = r;
                break;
            }
            mid = (l + r) / 2;
            //特例：[1,0,1,1,1]
            if (numbers[l] == numbers[r] && numbers[l] == numbers[mid]) {
                return findMin(numbers,l,r);
            }
            if (numbers[mid] >= numbers[l]) {
                l = mid;
            } else if (numbers[mid] <= numbers[r]) {
                r = mid;
            }
        }
        return numbers[mid];
    }

    public int findMin(int[] numbers, int l, int r) {
        int res = numbers[l];
        for (int i = l + 1; i <= r; ++i) {
            if (res > numbers[i]) {
                res = numbers[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        旋转数组的最小数字 xz = new 旋转数组的最小数字();
        System.out.println(xz.minArray(nums));
//        System.out.println(minArray(nums));
    }
}
