import java.util.Objects;

public class String1 {
    public String helloName(String name) {
        return "Hello " + name + "!";
    }

    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    public String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }

    public String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }

    public String extraEnd(String str) {
        String substring = str.substring(str.length() - 2);
        return substring + substring + substring;
    }

    public String firstTwo(String str) {
        if (str.length() >= 2) return str.substring(0, 2);
        else return str;
    }

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    public String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);
    }

    public String comboString(String a, String b) {
        if (a.length() > b.length()) return b + a + b;
        else return a + b + a;
    }

    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }
    public String left2(String str) {
        String x = str.substring(0, 2);
        return str.substring(2) + x;
    }
    public String right2(String str) {
        String x = str.substring(str.length() - 2);
        return x + str.substring(0, str.length() - 2);
    }
    public String theEnd(String str, boolean front) {
        if (front) return str.substring(0, 1);
        else return str.substring(str.length() - 1);
    }
    public String withoutEnd2(String str) {
        if (str.length() < 2) return "";
        return str.substring(1, str.length() - 1);
    }
    public String middleTwo(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
    }
    public boolean endsLy(String str) {
        if (str.length() < 2) return false;
        //Must be Objects.equals(), == doesn't work because object-oriented programming lol
        return Objects.equals(str.substring(str.length() - 2), "ly");
    }
    public String nTwice(String str, int n) {
        return str.substring(0, n) + str.substring(str.length() - n);
    }
    public String twoChar(String str, int index) {
        if (index + 2 > str.length() || index - 2 < -1 * str.length() || index < 0) return str.substring(0, 2);
        else return str.substring(index, index + 2);
    }
    public String middleThree(String str) {
        while (str.length() > 3) str = str.substring(1, str.length() - 1);
        return str;
    }
    public boolean hasBad(String str) {
        return str.contains("bad") && (str.indexOf("bad") == 1 || str.indexOf("bad") == 0);
    }
    public String atFirst(String str) {
        if (str.length() >= 2) return str.substring(0, 2);
        else if (str.length() == 1) return str + "@";
        else return "@@";
    }
    public String lastChars(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) return "@@";
        if (b.isEmpty()) return a.charAt(0) + "@";
        String substring = b.substring(b.length() - 1);
        if (a.isEmpty()) return "@" + substring;
        return a.charAt(0) + substring;
    }
    public String conCat(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) return a + b;
        if (a.charAt(a.length() - 1) == b.charAt(0)) return a + b.substring(1);
        else return a + b;
    }
    public String lastTwo(String str) {
        if (str.length() >= 2) return str.substring(0, str.length() - 2) + str.charAt(str.length() - 1) + str.charAt(str.length() - 2);
        else return str;
    }
    public String seeColor(String str) {
        int redLoc = str.indexOf("red");
        int blueLoc = str.indexOf("blue");
        if (redLoc == 0) return "red";
        if (blueLoc == 0) return "blue";
        else return "";
    }
    public boolean frontAgain(String str) {
        if (str.length() < 2) return false;
        return Objects.equals(str.substring(0, 2), str.substring(str.length() - 2));
    }
    public String minCat(String a, String b) {
        while (a.length() > b.length()) a = a.substring(1);
        while (b.length() > a.length()) b = b.substring(1);
        return a + b;
    }
    public String extraFront(String str) {
        if (str.length() < 2) return str + str + str;
        String substr = str.substring(0, 2);
        return substr + substr + substr;
    }
    public String without2(String str) {
        if (str.length() < 2) return str;
        if (Objects.equals(str.substring(0, 2), str.substring(str.length() - 2))) return str.substring(2);
        else return str;
    }

    public String deFront(String str) {
        if (str.isEmpty()) return "";
        if (str.length() == 1) {
            if (str == "a") return str;
            return "";
        }
        String string = "";
        if (str.charAt(0) == 'a') string += "a";
        if (str.charAt(1) == 'b') string += "b";
        string += str.substring(2);
        return string;
    }

    public String startWord(String str, String word) {
        if (str.isEmpty()) return "";
        if (word.length() == 1) return str.substring(0, 1);
        String word2 = word.substring(1);
        if (str.substring(1).startsWith(word2)) return str.substring(0, word.length());
        return "";
    }

    public String withoutX(String str) {
        if (str.isEmpty()) return str;
        if (str.length() == 1) {
            if (str != "x") return str;
            return "";
        }
        String string = "";
        if (str.charAt(0) != 'x') string += str.substring(0, 1);
        string += str.substring(1, str.length() - 1);
        if (str.charAt(str.length() - 1) != 'x') string += str.substring(str.length() - 1);

        return string;
    }

    public String withoutX2(String str) {
        if (str.isEmpty()) return str;
        if (str.length() == 1) {
            if (str != "x") return str;
            return "";
        }
        String string = "";
        if (str.charAt(0) != 'x') string += str.substring(0, 1);
        if (str.charAt(1) != 'x') string += str.substring(1, 2);
        string += str.substring(2);
        return string;
    }


}