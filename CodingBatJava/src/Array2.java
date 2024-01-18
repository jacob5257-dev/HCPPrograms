import java.util.ArrayList;
import java.util.List;

public class Array2 {
    public int countEvens(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) count++;
        }
        return count;
    }

    public int bigDiff(int[] nums) {
        if (nums.length < 2) return 0;
        int largest = nums[0];
        int smallest = nums[0];
        for (int i : nums) {
            if (i > largest) largest = i;
            if (i < smallest) smallest = i;
        }
        return largest - smallest;
    }

    public int centeredAverage(int[] nums) {
        int largest = nums[0]; int smallest = nums[0];
        int sum = 0;
        for (int i : nums) {
            if (i > largest) largest = i;
            if (i < smallest) smallest = i;
            sum += i;
        }
        sum -= largest;
        sum -= smallest;
        return sum / (nums.length - 2);

    }

    public int sum13(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) { // skipcq: JAVA-W1089
            if (nums[i] != 13) sum += nums[i];
            else i++;
        }
        return sum;
    }

    public int sum67(int[] nums) {
        int sum = 0;
        boolean six = false;
        for (int num : nums) {
            if (num == 6) six = true;
            else if (num == 7 && six) six = false;
            else if (six) continue;
            else sum += num;
        }
        return sum;
    }

    public boolean has22(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) return true;
        }
        return false;
    }

    public boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) return false;
        }
        return true;
    }

    public boolean sum28(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (i == 2) count++;
        }
        return count * 2 == 8;
    }

    public boolean more14(int[] nums) {
        int ones = 0;
        int fours = 0;
        for (int i : nums) {
            if (i == 1) ones++;
            if (i == 4) fours++;
        }
        return ones > fours;
    }

    public int[] fizzArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    public boolean only14(int[] nums) {
        for (int i : nums) {
            if (i != 1 && i != 4) return false;
        }
        return true;
    }

    public String[] fizzArray2(int n) {
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = String.valueOf(i);
        }
        return list;
    }

    public boolean no14(int[] nums) {
        boolean ones = false;
        boolean fours = false;
        for (int i : nums) {
            if (i == 1) ones = true;
            if (i == 4) fours = true;
        }
        return !(ones && fours);
    }

    public boolean isEverywhere(int[] nums, int val) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i + 1] != val) return false;
        }
        return true;
    }

    public boolean either24(int[] nums) {
        boolean two = false;
        boolean four = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) two = true;
            if (nums[i] == 4 && nums[i + 1] == 4) four = true;
        }
        return two != four;
    }

    public int matchUp(int[] nums1, int[] nums2) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            int num2 = nums2[i];
            int diff = Math.abs(num1 - num2);
            if ((diff > 0) && (diff < 3)) count++;
        }
        return count;
    }

    public boolean has77(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] == 7 && nums[i + 1] == 7) || (i < nums.length - 2 && nums[i] == 7 && nums[i + 2] == 7)) return true;
        }
        return false;
    }

    public boolean has12(int[] nums) {
        int one = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one = i;
                break;
            }
        }
        if (one == -1) return false;
        for (int i = one; i < nums.length; i++) {
            if (nums[i] == 2) return true;
        }
        return false;
    }

    public boolean modThree(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) return true;
            if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0 && nums[i + 2] % 2 != 0) return true;
        }
        return false;
    }

    public boolean haveThree(int[] nums) {
        if (nums.length < 3) return false;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3 && nums[i + 1] == 3) return false;
            if (nums[i] == 3) count++;
        }
        if (nums[nums.length - 1] == 3) count++;
        return count == 3;
    }

    public boolean twoTwo(int[] nums) {
        if (nums.length == 1 && nums[0] == 2) return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                if (i == 0) {
                    if (nums[i + 1] != 2) return false;
                }
                else if (i == nums.length - 1) {
                    if (nums[i - 1] != 2) return false;
                }
                else {
                    if (nums[i - 1] != 2 && nums[i + 1] != 2) return false;
                }
            }
        }
        return true;
    }

    public boolean sameEnds(int[] nums, int len) {
        int[] beginning = new int[len];
        int[] ending = new int[len];
        for (int i = 0; i < len; i++) {
            beginning[i] = nums[i];
            ending[i] = nums[nums.length - 1 - i];
        }
        for (int i = 0; i < beginning.length; i++) {
            if (beginning[i] != ending[ending.length - 1 - i]) return false;
        }
        return true;
    }

    public boolean tripleUp(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] - 1 && nums[i + 1] == nums[i + 2] - 1) return true;
        }
        return false;
    }

    public int[] fizzArray3(int start, int end) {
        int[] list = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            list[i] = start + i;
        }
        return list;
    }

    public int[] shiftLeft(int[] nums) {
        int[] list = new int[nums.length];
        if (list.length == 0) return nums;
        for (int i = 1; i < nums.length; i++) {
            list[i - 1] = nums[i];
        }
        list[nums.length - 1] = nums[0];
        return list;
    }

    public int[] tenRun(int[] nums) {
        int tens = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) tens = nums[i];
            else if (tens % 10 == 0) nums[i] = tens;
            else continue;
        }
        return nums;
    }

    public int[] pre4(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (i % 4 == 0) break;
            list.add(i);
        }
        int[] numbers = new int[list.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] =list.get(i);
        }
        return numbers;
    }

    public int[] post4(int[] nums) {
        boolean four = false;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 4) break;
            list.add(nums[i]);
        }
        int[] numbers = new int[list.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = list.get(numbers.length - 1 - i);
        }
        return numbers;
    }

    public int[] notAlone(int[] nums, int val) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == val && nums[i - 1] != val && nums[i + 1] != val) nums[i] = Math.max(nums[i - 1], nums[i + 1]);
        }
        return nums;
    }

    public int[] zeroFront(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num == 0) list.add(0);
        }
        for (int num : nums) {
            if (num != 0) list.add(num);
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) list.get(i);
        }
        return array;
    }

    public int[] withoutTen(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int tens = 0;
        for (int i : nums) {
            if (i == 10) tens++;
            else list.add(i);
        }
        int[] array = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        for (int i = nums.length - tens; i < nums.length; i++) {
            array[i] = 0;
        }
        return array;
    }

    public int[] zeroMax(int[] nums) {
        int[] list = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int max = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] % 2 != 0 && nums[j] > max) max = nums[j];
                }
                list[i] = max;
            }
            else list[i] = nums[i];
        }
        return list;
    }

    public int[] evenOdd(int[] nums) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i : nums) {
            if (i % 2 == 0) evens.add(i);
            else odds.add(i);
        }
        for (int i = 0; i < evens.size(); i++) {
            nums[i] = evens.get(i);
        }
        for (int i = 0; i < odds.size(); i++) {
            nums[i + evens.size()] = odds.get(i);
        }
        return nums;
    }

    public List<String> fizzBuzz(int start, int end) {
        List<String> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (i % 15 == 0) list.add("FizzBuzz");
            else if (i % 5 == 0) list.add("Buzz");
            else if (i % 3 == 0) list.add("Fizz");
            else list.add(String.valueOf(i));
        }
        return list;
    }

}