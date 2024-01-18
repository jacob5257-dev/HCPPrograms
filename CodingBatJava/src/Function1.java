import java.util.List;
import java.util.ArrayList;

public class Function1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<Integer> doubling(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            list.add(i, nums.get(i) * 2);
        }
        return list;
    }

    public List<Integer> square(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            list.add(i, nums.get(i) * nums.get(i));
        }
        return list;
    }

    public List<String> addStar(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            list.add(i, strings.get(i) + "*");
        }
        return list;
    }

    public List<String> copies3(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            list.add(i, strings.get(i) + strings.get(i) + strings.get(i));
        }
        return list;
    }

    public List<String> moreY(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            list.add(i, "y" + strings.get(i) + "y");
        }
        return list;
    }

    public List<Integer> math1(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            list.add(i, (1 + nums.get(i)) * 10);
        }
        return list;
    }

    public List<Integer> rightDigit(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int number = nums.get(i);
            while (number > 9) {
                number %= 10;
            }
            list.add(i, number);
        }
        return list;
    }

    public List<String> lower(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            list.add(i, strings.get(i).toLowerCase());
        }
        return list;
    }

    public List<String> noX(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String original = strings.get(i);
            String answer = "";
            for (int j = 0; j < original.length(); j++) {
                if (original.charAt(j) != 'x') answer += original.charAt(j);
            }
            list.add(i, answer);
        }
        return list;
    }
}