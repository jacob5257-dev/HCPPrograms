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

    public String withoutString(String base, String remove) {
        String result = "";
        for (int i = 0; i < base.length(); i++) {
            if (i >= base.length() - remove.length() + 1) result += base.substring(i, i + 1);
            else if (base.substring(i, i + remove.length()).equalsIgnoreCase(remove)) i += remove.length() - 1;
            else result += base.substring(i, i + 1);
        }
        return result;
    }

    public boolean equalIsNot(String str) {
        int is = 0, not = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith("is", i)) is++;
            if (str.startsWith("not", i)) not++;
        }
        return is == not;
    }

    public boolean gHappy(String str) {
        if (str.length() < 2) return !(str.equals("g"));
        if (str.length() == 2) return str.charAt(0) == str.charAt(1);
        if (str.charAt(0) != str.charAt(1) && str.charAt(0) == 'g') return false;
        if (str.charAt(str.length() - 2) != str.charAt(str.length() - 1) && str.charAt(str.length() - 1) == 'g') return false;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'g') {
                if (str.charAt(i - 1) != str.charAt(i) && str.charAt(i + 1) != str.charAt(i)) return false;
            }
        }
        return true;
    }

    public int countTriple(String str) {
        if (str.length() < 3) return 0;
        if (str.length() == 3) return (str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)) ? 1 : 0;
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i + 1) == str.charAt(i + 2)) count++;
        }
        return count;
    }

    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) sum += Integer.parseInt(str.substring(i, i + 1));
        }
        return sum;
    }

    public String sameEnds(String string) {
        String result = "";
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.substring(0, i + 1).equals(string.substring(string.length() - i - 1))) result = string.substring(0, i + 1);
        }
        return result;
    }

    public String mirrorEnds(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(string.length() - i - 1)) result += string.charAt(i);
            else break;
        }
        return result;
    }

    public int maxBlock(String str) {
        int longest = 1;
        int count = 0;
        if (str.length() < 2) return str.length();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                if (count == 0) count += 2;
                else count++;
            }
            else {
                if (count > 0) {
                    if (count > longest) longest = count;
                    count = 0;
                }
            }
        }
        return (Math.max(count, longest));
    }

    public int sumNumbers(String str) {
        int sum = 0;
        String num = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) num += str.charAt(i);
            else {
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                    num = "";
                }
            }
        }
        if (!num.isEmpty()) sum += Integer.parseInt(num);
        return sum;
    }

    public String notReplace(String str) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && Character.isLetter(str.charAt(i - 1)) || i < str.length() - 2 && Character.isLetter(str.charAt(i + 2))) string += str.charAt(i);
            else if (i < str.length() - 1 && str.startsWith("is", i)) {
                string += "is not";
                i++;
            }
            else string += str.charAt(i);
        }
        return string;
    }

}