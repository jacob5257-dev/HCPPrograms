public class Main {
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
}