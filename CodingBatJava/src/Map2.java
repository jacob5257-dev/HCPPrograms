import java.util.HashMap;
import java.util.Map;

public class Map2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public Map<String, Integer> word0(String[] strings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.put(s, 0);
        }
        return map;
    }

    public Map<String, Integer> wordLen(String[] strings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.put(s, s.length());
        }
        return map;
    }

    public Map<String, String> pairs(String[] strings) {
        HashMap<String, String> map = new HashMap<>();
        for (String s : strings) {
            map.put(s.substring(0, 1), s.substring(s.length() - 1));
        }
        return map;
    }

    public Map<String, Integer> wordCount(String[] strings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        return map;
    }

    public Map<String, String> firstChar(String[] strings) {
        HashMap<String, String> map = new HashMap<>();
        for (String s : strings) {
            if (map.containsKey(s.substring(0, 1))) map.put(s.substring(0, 1), map.get(s.substring(0, 1)) + s);
            else map.put(s.substring(0, 1), s);
        }
        return map;
    }

    public String wordAppend(String[] strings) {
        String s = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
                if (map.get(str) % 2 == 0) s += str;
            }
            else map.put(str, 1);
        }
        return s;
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : strings) {
            if (!map.containsKey(s)) map.put(s, false);
            else map.put(s, true);
        }
        return map;
    }

    public String[] allSwap(String[] strings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i].substring(0, 1))) {
                String temp = strings[i];
                strings[i] = strings[map.get(strings[i].substring(0, 1))];
                strings[map.get(strings[i].substring(0, 1))] = temp;
                map.remove(strings[i].substring(0, 1));
            }
            else map.put(strings[i].substring(0, 1), i);
        }
        return strings;
    }

    public String[] firstSwap(String[] strings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i].substring(0, 1))) {
                if (map.get(strings[i].substring(0, 1)) == -1) continue;
                String temp = strings[i];
                strings[i] = strings[map.get(strings[i].substring(0, 1))];
                strings[map.get(strings[i].substring(0, 1))] = temp;
                map.put(strings[i].substring(0, 1), -1);
            }
            else map.put(strings[i].substring(0, 1), i);
        }
        return strings;
    }
}