import javax.swing.*;

public class CeaserCipher {
    public static void main(String[] args) {
        while (true) {
            String option = JOptionPane.showInputDialog("<html>Choose from the following:<br><ul><li>\"e\" to encode</li><li>\"d\" to decode</li><li>\"q\" to quit</li><ul></html>");
            if (null == option || option.isEmpty() || option.equals("q")) {
                System.exit(0);
            } else if (option.equals("e")) {
                encrypt();
            } else if (option.equals("d")) {
                String original = JOptionPane.showInputDialog("Encrypted message: ");
                int rotation = guessRotation(original, JOptionPane.showInputDialog("Known string: "));
                if (rotation == -1) JOptionPane.showMessageDialog(null, "Not a valid message/no available cipher.");
                else JOptionPane.showMessageDialog(null, "<html>The offset is " + rotation + "<br>The message is \"" + decrypt(original, rotation) + "\".</html>");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid");
            }
        }
    }

    public static void encrypt() {
        String original = JOptionPane.showInputDialog("Decrypted message: ");
        int n = Integer.parseInt(JOptionPane.showInputDialog("Offset: "));
        while (n > 26) {
            n -= 26;
        }
        while (n < 0) {
            n += 26;
        }
        char[] chars = original.toCharArray();
        String encrypted = "";
        for (char c : chars) {
            if (c >= 97 && c <= 122) {
                c += n;
                if (c > 122) c -= 26;
            }
            encrypted += c;
        }
        System.out.println(encrypted);
        JOptionPane.showMessageDialog(null, encrypted);
    }

    public static String decrypt(String original, int n) {
        char[] chars = original.toCharArray();
        String encrypted = "";
        for (char c : chars) {
            if (c >= 97 && c <= 122) {
                c -= n;
                if (c < 97) c += 26;
            }
            encrypted += c;
        }
        return encrypted;
    }

    public static int guessRotation(String encrypted, String known) {
        for (int i = 0; i < 26; i++) {
            String potentialDecode = decrypt(encrypted, i);
            if (potentialDecode.contains(known)) return i;
        }
        return -1;
    }
}
