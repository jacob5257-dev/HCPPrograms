public class Main {
    public int countYZ(String str) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) == 'y' || str.charAt(i) == 'z') && !Character.isLetter(str.charAt(i + 1))) count++;
        }
        if (str.charAt(str.length() - 1) == 'y' || str.charAt(str.length() - 1) == 'z') count++;
        return count;
    }

}