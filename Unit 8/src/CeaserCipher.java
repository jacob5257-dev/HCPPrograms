import javax.swing.*;

public class CeaserCipher {
	public static void main(String[] args) {
		String original = JOptionPane.showInputDialog("Decrypted message: ").toUpperCase();
		int n = Integer.parseInt(JOptionPane.showInputDialog("Offset: "));
		char[] chars = original.toCharArray();
		String encrypted = "";
		for (char c : chars) {
			c += n;
			if (c > 90) c -= 26;
			encrypted += c;
		}
		JOptionPane.showMessageDialog(null, encrypted);
	}
}