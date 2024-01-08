public class FindWord {
    public static boolean findWord(String s, String target) {
        if (s.length() < target.length()) return false;
        if (s.startsWith(target)) return true;
        return findWord(s.substring(1), target);
    }

    public static void main(String[] args) {
        System.out.println(findWord("Mississippi", "sip"));
    }
}
