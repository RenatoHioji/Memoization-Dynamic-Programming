
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {
    private static final Map<Long, BigInteger> memo = new HashMap<>();
    private static final Map<String, BigInteger> memo2 = new HashMap<>();
    private static final Map<Long, Boolean> memo3 = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibo(100L));
        System.out.println(traveller(18L, 18L));
        System.out.println(canSum(1021L, List.of(139, 540, 321, 327, 102)));
    }

    public static BigInteger fibo(Long num){
        if(num == 1 || num == 2) return BigInteger.valueOf(1);
        if(memo.containsKey(num)) return memo.get(num);
        BigInteger result = fibo(num-1).add(fibo(num-2));
        memo.put(num, result);
        return result;
    }
    public static BigInteger traveller(Long row, Long height){
        String key = row + "," + height;
        if(row == 1 && height == 1) return BigInteger.valueOf(1);
        if(row == 0 || height == 0) return BigInteger.valueOf(0);
        if(memo2.containsKey(key)) return memo2.get(key);
        BigInteger result = traveller(row-1, height).add( traveller(row,height-1));
        memo2.put(key, result);
        return result;
    }
    public static Boolean canSum(Long target, List<Integer> numbers){
        if(target == 0) return true;
        if(target < 0) return false;
        if(memo3.containsKey(target)) return memo3.get(target);
        for(Integer number : numbers){
            Long reminder = target - number;
            if(canSum(reminder, numbers)){
                memo3.put(target, true);
                return true;
            }
        }
        memo3.put(target, false);
        return false;
    }



}