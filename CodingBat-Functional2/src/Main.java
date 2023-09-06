import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<Integer> noNeg(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num >= 0) list.add(num);
        }
        return list;
    }

    public List<Integer> no9(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num % 10 != 9) list.add(num);
        }
        return list;
    }

    public List<Integer> noTeen(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num < 13 || num > 19) list.add(num);
        }
        return list;
    }
}