public class Array3 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public int maxSpan(int[] nums) {
        int maxSpan = 0;
        for (int i = 0; i < nums.length; i++) {
            int span = 0;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    span = j - i + 1;
                    break;
                }
            }
            if (span > maxSpan) {
                maxSpan = span;
            }
        }
        return maxSpan;
    }

    public int[] fix34(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 3) i++;
        int j = i + 1;
        while (j < nums.length && nums[j] != 4) j++;
        while (i < nums.length) {
            if(nums[i] == 3) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
                while (j < nums.length && nums[j] != 4) j++;
            }
            i++;
        }
        return nums;
    }

    public int[] fix45(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length && nums[j] != 5) j++;
        while (i < nums.length) {
            if(nums[i] == 4) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
                while ((j < nums.length && nums[j] != 5) || j == i + 1) j++;
            }
            i++;
        }
        return nums;
    }

    public boolean canBalance(int[] nums) {
        int sum = 0;
        for (int k : nums) {
            sum += k;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int halfSum = sum / 2;
        int tempSum = 0;
        for (int num : nums) {
            tempSum += num;
            if (tempSum == halfSum) {
                return true;
            }
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int index = 0;
        for (int num : inner) {
            boolean found = false;
            for (int j = index; j < outer.length; j++) {
                if (num == outer[j]) {
                    found = true;
                    index = j;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public int[] squareUp(int n) {
        int[] result = new int[n * n];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {
                if (j <= i) {
                    result[index] = j;
                } else {
                    result[index] = 0;
                }
                index++;
            }
        }
        return result;
    }

    public int[] seriesUp(int n) {
        int[] result = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                result[index] = j;
                index++;
            }
        }
        return result;
    }

    public int maxMirror(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
                if (nums[i + count] == nums[j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int countClumps(int[] nums) {
        int count = 0;
        boolean inClump = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1] && !inClump) {
                inClump = true;
                count++;
            } else if (nums[i] != nums[i+1]) {
                inClump = false;
            }
        }
        return count;
    }
}