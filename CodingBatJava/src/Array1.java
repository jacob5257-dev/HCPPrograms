import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array1 {
    public boolean firstLast6(int[] nums) {
        return (nums[0]  == 6 || nums[nums.length - 1] == 6);
    }

    public boolean sameFirstLast(int[] nums) {
        return (nums.length > 0 && nums[0] == nums[nums.length - 1]);
    }

    public int[] makePi() {
        return new int[]{3, 1, 4};
    }

    public boolean commonEnd(int[] a, int[] b) {
        return (a[0] == b[0] || a[a.length - 1] == b[b.length - 1]);
    }

    public int sum3(int[] nums) {
        return nums[0] + nums[1] + nums[2];
    }

    public int[] rotateLeft3(int[] nums) {
        return new int[]{nums[1], nums[2], nums[0]};
    }

    public int[] reverse3(int[] nums) {
        int[] reversed = new int[3];
        for (int i = 0; i < 3; i++) {
            reversed[i] = nums[2 - i];
        }
        return reversed;
    }

    public int[] maxEnd3(int[] nums) {
        int largest = Math.max(nums[0], nums[2]);
        Arrays.fill(nums, largest);
        return nums;
    }

    public int sum2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return nums[0] + nums[1];
    }

    public int[] middleWay(int[] a, int[] b) {
        return new int[]{a[1], b[1]};
    }

    public int[] makeEnds(int[] nums) {
        return new int[]{nums[0], nums[nums.length - 1]};
    }

    public boolean has23(int[] nums) {
        return (nums[0] == 2 || nums[0] == 3 || nums[1] == 2 || nums[1] == 3);
    }

    public boolean no23(int[] nums) {
        return !(nums[0] == 2 || nums[0] == 3 || nums[1] == 2 || nums[1] == 3);
    }

    public int[] makeLast(int[] nums) {
        int[] newList = new int[nums.length * 2];
        for (int i = 0; i < nums.length - 1; i++) {
            newList[i] = 0;
        }
        newList[newList.length - 1] = nums[nums.length - 1];
        return newList;
    }

    public boolean double23(int[] nums) {
        if (nums.length < 2) return false;
        return (nums[0] == 2 && nums[1] == 2 || nums[0] == 3 && nums[1] == 3);
    }

    public int[] fix23(int[] nums) {
        if (nums[0] == 2 && nums[1] == 3) nums[1] = 0;
        if (nums[1] == 2 && nums[2] == 3) nums[2] = 0;
        return nums;
    }

    public int start1(int[] a, int[] b) {
        int count = 0;
        if (a.length > 0 && a[0] == 1) count++;
        if (b.length > 0 && b[0] == 1) count++;
        return count;
    }

    public int[] biggerTwo(int[] a, int[] b) {
        return (b[0] + b[1] > (a[0] + a[1]) ? b : a);
    }

    public int[] makeMiddle(int[] nums) {
        return new int[]{nums[nums.length / 2 - 1], nums[nums.length / 2]};
    }

    public int[] plusTwo(int[] a, int[] b) {
        return new int[]{a[0], a[1], b[0], b[1]};
    }

    public int[] swapEnds(int[] nums) {
        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length; i++) reversed[i] = nums[i];
        reversed[0] = nums[nums.length - 1];
        reversed[nums.length - 1] = nums[0];
        return reversed;
    }

    public int[] midThree(int[] nums) {
        // 15 elements, 6 - 3 - 6 start from elem 6 -> 8
        // 9 elements, 3 - 3 - 3 start from elem 3 -> 5
        int leftBound = (nums.length - 3) / 2;
        return new int[]{nums[leftBound], nums[leftBound + 1], nums[leftBound + 2]};
    }

    public int maxTriple(int[] nums) {
        int largest = Math.max(nums[0], nums[nums.length - 1]);
        if (nums[nums.length / 2] > largest) return nums[nums.length / 2];
        return largest;
    }

    public int[] frontPiece(int[] nums) {
        if (nums.length < 2) return nums;
        return new int[]{nums[0], nums[1]};
    }

    public boolean unlucky1(int[] nums) {
        if (nums.length < 2) return false;
        if (nums.length == 2) return nums[0] == 1 && nums[1] == 3;
        return (nums[0] == 1 && nums[1] == 3) || (nums[1] == 1 && nums[2] == 3) || (nums[nums.length - 2] == 1 && nums[nums.length - 1] == 3);
    }

    public int[] make2(int[] a, int[] b) {
        int[] all = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            all[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            all[i + a.length] = b[i];
        }
        return new int[]{all[0], all[1]};
    }

    public int[] front11(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        if (a.length > 0) list.add(a[0]);
        if (b.length > 0) list.add(b[0]);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}