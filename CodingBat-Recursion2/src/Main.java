public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean groupSum(int start, int[] nums, int target) {
        int sum = 0;
        if (start >= nums.length) return (target == 0);
        if (groupSum(start + 1, nums, target - nums[start])) return true;
        return groupSum(start + 1, nums, target);
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);
        if (nums[start] == 6) return groupSum6(start + 1, nums, target - nums[start]);
        if (groupSum6(start + 1, nums, target - nums[start])) return true;
        return groupSum6(start + 1, nums, target);
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);
        if (groupNoAdj(start + 2, nums, target - nums[start])) return true;
        return groupNoAdj(start + 1, nums, target);
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);
        if (nums[start] % 5 == 0) {
            if (start < nums.length - 1 && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            return groupSum5(start + 1, nums, target - nums[start]);
        }
        if (groupSum5(start + 1, nums, target - nums[start])) return true;
        return groupSum5(start + 1, nums, target);
    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);
        int sum = nums[start];
        int count = 1;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == nums[start]) {
                sum += nums[i];
                count++;
            }
        }
        if (groupSumClump(start + count, nums, target - sum)) return true;
        return groupSumClump(start + count, nums, target);
    }

    public boolean splitArray(int[] nums) {
        return splitArrayHelper(0, nums, 0, 0);
    }

    public boolean splitArrayHelper(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return (sum1 == sum2);
        if (splitArrayHelper(start + 1, nums, sum1 + nums[start], sum2)) return true;
        return splitArrayHelper(start + 1, nums, sum1, sum2 + nums[start]);
    }

    public boolean splitOdd10(int[] nums) {
        return splitOdd10Helper(0, nums, 0, 0);
    }

    public boolean splitOdd10Helper(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return (sum1 % 10 == 0 && sum2 % 2 != 0 || sum1 % 2 != 0 && sum2 % 10 == 0);
        if (splitOdd10Helper(start + 1, nums, sum1 + nums[start], sum2)) return true;
        return splitOdd10Helper(start + 1, nums, sum1, sum2 + nums[start]);
    }

    public boolean split53(int[] nums) {
        return split53Helper(0, nums, 0, 0);
    }

    public boolean split53Helper(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return (sum1 == sum2);
        if (nums[start] % 5 == 0) {
            return split53Helper(start + 1, nums, sum1 + nums[start], sum2);
        } else if (nums[start] % 3 == 0) {
            return split53Helper(start + 1, nums, sum1, sum2 + nums[start]);
        } else {
            if (split53Helper(start + 1, nums, sum1 + nums[start], sum2)) return true;
            return split53Helper(start + 1, nums, sum1, sum2 + nums[start]);
        }
    }
}