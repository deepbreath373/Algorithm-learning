import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        arr[index++] = deque.peekFirst();
        for(int i = k; i < nums.length; i++){
            if(deque.peekFirst() == nums[i-k]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            arr[index++] = deque.peekFirst();
        }
        return arr;
    }
}
