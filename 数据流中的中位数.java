import java.util.PriorityQueue;
/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 *
 *     void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *     double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 */
public class 数据流中的中位数 {
    PriorityQueue<Integer> left_big;
    PriorityQueue<Integer> right_small;

    public 数据流中的中位数() {
        left_big = new PriorityQueue<>((n1, n2) -> n2 - n1);
        right_small = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left_big.add(num);
        right_small.add(left_big.poll());
        if (left_big.size() + 1 < right_small.size()) {
            left_big.add(right_small.poll());
        }
    }

    public double findMedian() {
        if (left_big.size() < right_small.size()) {
            return right_small.peek();
        }
        return (double)(left_big.peek() + right_small.peek()) / 2;
    }
}
