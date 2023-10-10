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

    public List<String> noZ(List<String> strings) {
        List<String> a = new ArrayList<String>();
        for (String string : strings) {
            if (!string.contains("z")) a.add(string);
        }
        return a;
    }

    public List<String> noLong(List<String> strings) {
        List<String> a = new ArrayList<>();
        for (String string : strings) {
            if (string.length() < 4) a.add(string);
        }
        return a;
    }

    public List<String> no34(List<String> strings) {
        List<String> a = new ArrayList<>();
        for (String string : strings) {
            if (string.length() != 4 && string.length() != 3) a.add(string);
        }
        return a;
    }

    public List<String> noYY(List<String> strings) {
        strings.removeIf(s -> s.contains("yy"));
        List<String> a = new ArrayList<>();
        for (String string : strings) {
            if (!string.endsWith("y")) a.add(string + "y");
        }
        return a;
    }

    public List<Integer> two2(List<Integer> nums) {
        nums.removeIf(n -> n * 2 % 10 == 2);
        nums.replaceAll(n -> n * 2);
        return nums;
    }

    public List<Integer> square56(List<Integer> nums) {
        nums.replaceAll(n -> n * n + 10);
        nums.removeIf(n -> n % 10 == 5 || n % 10 == 6);
        return nums;
    }
}