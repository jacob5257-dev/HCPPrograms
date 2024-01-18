import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AP1 {
    public boolean scoresIncreasing(int[] scores) {
        if (scores.length < 2) return true;
        if (scores.length == 2) {
            return scores[1] > scores[0];
        }
        int previous = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < previous) return false;
            previous = scores[i];
        }
        return true;
    }

    public boolean scores100(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100 && scores[i] == scores[i + 1]) return true;
        }
        return false;
    }

    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String word : words) {
            if (word.length() == len) count++;
        }
        return count;
    }

    public String[] wordsFront(String[] words, int n) {
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = words[i];
        }
        return list;
    }

    public List wordsWithoutList(String[] words, int len) {
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.length() != len) list.add(word);
        }
        return list;
    }

    public boolean hasOne(int n) {
        if (n < 10) return n == 1;
        return (n % 10 == 1 || hasOne(n / 10));
    }

    public int[] copyEvens(int[] nums, int count) {
        int[] evens = new int[count];
        int evenCounter = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num != 0 && evenCounter < count) {
                evens[evenCounter] = num;
                evenCounter++;
            }
        }
        return evens;
    }

    public int[] copyEndy(int[] nums, int count) {
        int[] endy = new int[count];
        int endyCount = 0;
        for (int num : nums) {
            if (isEndy(num) && endyCount < count) {
                endy[endyCount] = num;
                endyCount++;
            }
        }
        return endy;
    }

    // Used in copyEndy
    public boolean isEndy(int n) {
        return ((n >= 0 && n <= 10) || (n >= 90 && n <= 100));
    }

    public int matchUp(String[] a, String[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].isEmpty() && !b[i].isEmpty() && a[i].charAt(0) == b[i].charAt(0)) count++;
        }
        return count;
    }


    public int scoreUp(String[] key, String[] answers) {
        int score = 0;
        for (int i = 0; i < key.length; i++) {
            if (answers[i].equals("?")) continue;
            else if (answers[i].equals(key[i])) score += 4;
            else score -= 1;
        }
        return score;
    }

    public String[] wordsWithout(String[] words, String target) {
        List<String> wordArray = new ArrayList<>();
        for (String i : words) {
            if (i.equals(target)) continue;
            else wordArray.add(i);
        }
        String[] wordList = new String[wordArray.size()];
        for (int i = 0; i < wordList.length; i++) {
            wordList[i] = wordArray.get(i);
        }
        return wordList;
    }

    public int scoresSpecial(int[] a, int[] b) {
        return largestSpecial(a) + largestSpecial(b);

    }
    // Used for scoresSpecial
    public int largestSpecial(int[] a) {
        int highest = 0;
        for (int i : a) {
            if (i % 10 == 0 && i > highest) highest = i;
        }
        return highest;
    }

    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += Math.abs(heights[i + 1] - heights[i]);
        }
        return sum;
    }

    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += heights[i + 1] > heights[i] ? (heights[i + 1] - heights[i]) * 2 : heights[i] - heights[i + 1];
        }
        return sum;
    }

    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            count += Math.abs(heights[i + 1] - heights[i]) >= 5 ? 1 : 0;
        }
        return count;
    }

    public boolean scoresClump(int[] scores) {
        if (scores.length < 3) return true;
        for (int i = 1; i < scores.length - 1; i++) {
            if ((scores[i + 1] - scores[i - 1]) <= 2) return true;
        }
        return false;
    }

    public boolean dividesSelf(int n) {
        String number = Integer.toString(n);
        int[] nDigits = new int[number.length()]; // skipcq: JAVA-W0243
        for (int i = 0; i < number.length(); i++) {
            nDigits[i] = Integer.parseInt(Character.toString(number.charAt(i)));
        }
        for (int i : nDigits) {
            if (i == 0 || n % i != 0) return false;
        }
        return true;
    }

    public int userCompare(String aName, int aId, String bName, int bId) {
        if (aName.compareTo(bName) < 0) return -1;
        if (aName.compareTo(bName) > 0) return 1;
        return Integer.compare(aId, bId);
    }

    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] merged = new String[n];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < n; i++) {
            if (a[aIndex].compareTo(b[bIndex]) < 0) {
                merged[i] = a[aIndex];
                aIndex++;
            }
            else if (a[aIndex].compareTo(b[bIndex]) > 0) {
                merged[i] = b[bIndex];
                bIndex++;
            }
            else {
                merged[i] = a[aIndex];
                aIndex++;
                bIndex++;
            }
        }
        return merged;
    }

    public int commonTwo(String[] a, String[] b) {
        a = removeDuplicates(a);
        b = removeDuplicates(b);
        int count = 0;
        List<String> aList = new ArrayList<>(Arrays.asList(a));
        List<String> bList = new ArrayList<>(Arrays.asList(b));
        for (String i : aList) {
            if (bList.contains(i)) count++;
        }
        return count;
    }

    public String[] removeDuplicates(String[] nums) {
        List<String> list = new ArrayList<>();
        for (String i : nums) {
            if (!list.contains(i)) list.add(i);
        }
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;
    }

    public int scoresAverage(int[] scores) {
        return (Math.max(average(scores, 0, scores.length / 2), average(scores, scores.length / 2, scores.length)));
    }

    public int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += scores[i];
        }
        return sum / (end - start);
    }
}