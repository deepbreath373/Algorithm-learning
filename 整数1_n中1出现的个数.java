public class 整数1_n中1出现的个数 {
    //暴力法，容易超时
    public int countDigitOne(int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numOfOne(i);
        }
        return count;
    }
    private int numOfOne(int i) {
        int number = 0;
        while(i!=0){
            if(i%10==1){
                number++;
            }
            i /= 10;
        }
        return number;
    }

}
