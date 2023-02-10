import java.util.List;

public class StringComparer {
    private List<String> list;
    private String longest;
    private String shortest;

    public StringComparer(List<String> list) {
        this.list = list;
    }

    public void addString(String string) {
        list.add(string);
    }

    public String getLongest() {
        if (list.size() == 0) {
            return null;
        }
        longest = list.get(0);
        for (String string : list) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }
        return longest;
    }

    public String getShortest() {
        if (list.size() == 0) {
            return null;
        }
        shortest = list.get(0);
        for (String string : list) {
            if (string.length() < shortest.length()) {
                shortest = string;
            }
        }
        return shortest;
    }
}