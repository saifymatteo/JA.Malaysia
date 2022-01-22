import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crypto {
    public static void main(String[] args) {
        System.out.println();
        String message = "This is some \\\"really\\\" great. (Text)!?";
        System.out.println("Sample Message: " + message);

        Scanner input = new Scanner(System.in);
        System.out.print("New Message: ");
        message = input.nextLine();
        System.out.print("Caesar Key: ");
        int shift = input.nextInt();
        System.out.print("Group Size: ");
        int group = input.nextInt();

        String encrypt = encryptString(message, shift, group);
        String decrypt = decryptString(encrypt, shift);

        System.out.println("Encrypt: " + encrypt);
        System.out.println("Decrypt: " + decrypt);
    }

    public static String normalizeText(String text) {
        System.out.println("Normalize Text Method");
        System.out.println("Input: " + text);
        // From Android Regex Pattern: https://developer.android.com/reference/java/util/regex/Pattern.html
        Pattern pattern = Pattern.compile("[^a-z A-Z]");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll("");
        //
        text = text.replaceAll("\s", "");
        text = text.toUpperCase();

        System.out.println("Result: " + text);
        System.out.println();
        return text;
    }

    public static String obify(String text) {
        System.out.println("Obfuscation Method");
        System.out.println("Input: " + text);

        // Replace each vowels to include OB
        text = text.replaceAll("A", "OBA");
        text = text.replaceAll("E", "OBE");
        text = text.replaceAll("I", "OBI");
        text = text.replaceAll("O", "OBO");
        text = text.replaceAll("U", "OBU");
        text = text.replaceAll("Y", "OBY");

        System.out.println("Result: " + text);
        System.out.println();
        return text;
    }

    public static String unobify(String text) {
        System.out.println("Unobfuscation Method");
        System.out.println("Input: " + text);

        // Remove OB only
        text = text.replaceAll("OB", "");

        System.out.println("Result: " + text);
        System.out.println();
        return text;
    }

    // Fuck this
    // Taken from https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/
    public static StringBuffer caesarify(String text, int shift) {
        System.out.println("Caesar Cipher Method");
        System.out.println("Input: " + text);

        StringBuffer newText = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
            newText.append(ch);
        }

        System.out.println("Result: " + newText);
        System.out.println();
        return newText;
    }

    // Fuck this
    // Taken from https://stackoverflow.com/a/46019814
    public static StringBuilder groupify(String text, int group) {
        System.out.println("Codegroups Method");
        System.out.println("Input: " + text);

        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i != 0 && i % group == 0) {
                newText.append(" ");
            }
            newText.append(text.charAt(i));
        }
        int pad = text.length() % group;
        for (int i = 0; i < pad; i++) {
            newText.append("x");
        }

        System.out.println("Result: " + newText);
        System.out.println();
        return newText;
    }

    public static String encryptString(String text, int shift, int group) {
        text = normalizeText(text);
        text = obify(text);
        text = String.valueOf(caesarify(text, shift));
        text = String.valueOf(groupify(text, group));
        return text;
    }

    public static StringBuilder ungroupify(String text) {
        System.out.println("UnCodegroups Method");
        System.out.println("Input: " + text);

        text = text.replaceAll("\s", "");
        StringBuilder newText = new StringBuilder(text);
        newText.deleteCharAt(newText.length() - 1);

        System.out.println("Result: " + newText);
        System.out.println();
        return newText;
    }

    public static String decryptString(String text, int shift) {
        text = String.valueOf(ungroupify(text));
        text = String.valueOf(caesarify(text, 26 - (shift % 26)));
        text = unobify(text);
        return text;
    }
}
