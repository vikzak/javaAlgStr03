import java.util.HashSet;
import java.util.Set;

public class Expression {
    private String exp;
    private final Set<Character> openChars = new HashSet<>(Set.of('{', '[', '('));
    private final Set<Character> closedChars = new HashSet<>(Set.of('}', ']', ')'));

    public Expression(String exp) {
        this.exp = exp;
    }

    public boolean checkBracket() {
        MyStack<Character> stack = new MyStack<>(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (openChars.contains(ch)) {
                stack.push(ch);
            } else if (closedChars.contains(ch)) {
                if (stack.isEmpty()) {
                    System.out.println("Error in " + i + " position");
                    return false;
                }
                char topChar = stack.pop();
                if (ch == ')' && topChar != '(' ||
                        ch == ']' && topChar != '[' ||
                        ch == '}' && topChar != '{') {
                    System.out.println("Error in " + i + " position: bracket doesn't match");
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: bracket doesn't match");
            return false;
        }
        return true;
    }
}

