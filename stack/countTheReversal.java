import java.util.*;

public class countTheReversal {
    public int sol(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || st.size() == 0) {
                st.push(ch);
            } else if (st.peek() == '(') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        if (st.size() % 2 != 0) {
            return -1;
        }

        int op = 0;
        int cl = 0;

        while (st.size() > 0) {
            char ch = st.pop();
            if (ch == '(') {
                op++;
            } else {
                cl++;
            }
        }
        return (int) (Math.ceil(op / 2.0) + Math.ceil(cl / 2.0));
    }
}
