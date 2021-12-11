import java.util.* ;

public class validateStackSequence {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int j = 0;
            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < pushed.length; i++) {
                st.push(pushed[i]);
                while (st.size() > 0 && st.peek() == popped[j]) {
                    st.pop();
                    j++;
                }
            }
            return st.size() == 0;
        }
    }
}
