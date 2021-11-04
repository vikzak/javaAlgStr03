public class MyReverseString {
    private final String str;
    private String reverseString;

    public MyReverseString(String str) {
        this.str = str;
        reverse();
    }

    public String getString() {
        return str;
    }

    public String getReverseString() {
        return reverseString;
    }

    private void reverse() {
        MyStack<Character> strChars = new MyStack<>();
        for (int i = 0; i < str.length(); i++) {
            strChars.push(str.charAt(i));
        }
        StringBuilder reverseStringBuilder = new StringBuilder();
        while (strChars.size() != 0) {
            reverseStringBuilder.append(strChars.pop());
        }
        this.reverseString = reverseStringBuilder.toString();
    }
}
