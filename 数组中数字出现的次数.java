import java.util.HashMap;
import java.util.Map;

public class 数组中数字出现的次数 {
    public int singleNumber(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.get(num) == null){
                map.put(num,1);
            }else{
                Integer count = map.get(num);
                map.put(num,count+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
