import java.util.*;

public class minimumSwapsToMakeStringBalanced {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || st.size() == 0) {
                st.push(ch);
            } else if (st.peek() == '[') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        int pair = st.size() / 2;
        return (int) Math.ceil(pair / 2.0);
    }
}
