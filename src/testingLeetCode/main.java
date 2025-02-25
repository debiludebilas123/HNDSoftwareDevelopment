package testingLeetCode;

public class main {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o' };

        reverseString(s);
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i <= s.length; i--) {
            int j = s.length - i - 1;

        }

        for (char ch : s) {
            System.out.print(ch);
        }
    }
}
