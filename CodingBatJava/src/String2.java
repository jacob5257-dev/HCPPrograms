public class String2 {
    public String doubleChar(String str) {
        String return_str = "";
        for (int i = 0; i < str.length(); i++) {
            return_str += str.charAt(i);
            return_str += str.charAt(i);
        }
        return return_str;
    }

    public int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.startsWith("co", i) && str.charAt(i + 3) == 'e') count++;
        }
        return count;
    }

    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.startsWith("hi", i)) count++;
        }
        return count;
    }

    public boolean catDog(String str) {
        int cat_count = 0;
        int dog_count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.startsWith("cat", i)) cat_count++;
            if (str.startsWith("dog", i)) dog_count++;
        }
        return cat_count == dog_count;
    }

    public int countCodeAlternateSolution(String str) {
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.startsWith("co", i) && str.charAt(i + 3) == 'e') return 1 + countCodeAlternateSolution(str.substring(i + 4));
        }
        return 0;
    }

    public boolean endOther(String a, String b) {
        if (a.length() > b.length()) return a.toLowerCase().endsWith(b.toLowerCase());
        else return b.toLowerCase().endsWith(a.toLowerCase());
    }

    public boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') return true;
        }
        return false;
    }

    public boolean xyBalance(String str) {
        boolean x = false;
        if (str.isEmpty()) return true;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'y' && !x) return true;
            if (str.charAt(i) == 'x') x = true;
        }
        return !x;
    }

    public String mixString(String a, String b) {
        String str = "";
        if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                str += String.valueOf(a.charAt(i));
                str += String.valueOf(b.charAt(i));
            }
            str += a.substring(b.length());
        }
        else if (b.length() > a.length()) {
            for (int i = 0; i < a.length(); i++) {
                str += String.valueOf(a.charAt(i));
                str += String.valueOf(b.charAt(i));
            }
            str += b.substring(a.length());
        }
        else {
            for (int i = 0; i < b.length(); i++) {
                str += String.valueOf(a.charAt(i));
                str += String.valueOf(b.charAt(i));
            }
        }
        return str;
    }

    public String repeatEnd(String str, int n) {
        String string = "";
        for (int i = 0; i < n; i++) {
            string += str.substring(str.length() - n);
        }
        return string;
    }

    public String repeatFront(String str, int n) {
        String string = "";
        for (int i = n; i > 0; i--) {
            string += str.substring(0, i);
        }
        return string;
    }

    public String repeatSeparator(String word, String sep, int count) {
        String string = "";
        if (count == 0) return string;
        for (int i = 0; i < count - 1; i++) {
            string += word;
            string += sep;
        }
        string += word;
        return string;
    }

    public String getSandwich(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith("bread", i)) {
                for (int j = str.length() - 1; j > i; j--) {
                    if (str.startsWith("bread", j)) {
                        return str.substring(i + 5, j);
                    }
                }
            }
        }
        return "";
    }

    public String plusOut(String str, String word) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith(word, i)) {
                string += word;
                i += word.length() - 1;
            } else {
                string += "+";
            }
        }
        return string;
    }

    public boolean xyzThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.startsWith("xyz", i)) {
                if (i == 0) return true;
                if (str.charAt(i - 1) != '.') return true;
            }
        }
        return false;
    }

    public boolean prefixAgain(String str, int n) {
        String substring = str.substring(0, n);
        if (str.length() == 2 && n == 1 && str.charAt(0) == str.charAt(1)) return true;
        for (int i = 1; i < str.length() - substring.length(); i++) {
            String abc = str.substring(i, i + substring.length());
            if (abc.equals(substring)) return true;
        }
        return false;
    }

    public boolean xyzMiddle(String str) {
        int len = str.length();
        if (len < 3) return false;
        boolean xyz = str.substring(len / 2 - 1, len / 2 + 2).equals("xyz");
        if (len % 2 == 0) return str.substring(len / 2 - 2, len / 2 + 1).equals("xyz") || xyz;
        return xyz;
    }

    public boolean sameStarChar(String str) {
        if (str.length() < 3) return true;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1)) return false;
        }
        return true;
    }

    public String oneTwo(String str) {
        String result = "";
        for (int i = 0; i < str.length() - 2; i += 3) {
            result += str.substring(i + 1, i + 3) + str.charAt(i);
        }
        return result;
    }

    public String zipZap(String str) {
        if (str.length() < 3) return str;
        String string = "";
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                string += "zp";
                i += 2;
            }
            else if (i == str.length() - 3) string += str.substring(str.length() - 3);
            else string += str.substring(i, i + 1);
        }
        return string;
    }

    public String starOut(String str) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && str.charAt(i - 1) == '*') continue;
            if (str.charAt(i) == '*') continue;
            if (i < str.length() - 1 && str.charAt(i + 1) == '*') continue;
            string += str.charAt(i);
        }
        return string;
    }

    public String wordEnds(String str, String word) {
        String result = "";
        int i = 0;
        while (i < str.length()) {
            int start = str.indexOf(word, i);
            if (start == -1) break;
            if (start > 0) result += str.charAt(start - 1);
            if (start + word.length() < str.length()) result += str.charAt(start + word.length());
            i = start + 1;
        }
        return result;
    }
}