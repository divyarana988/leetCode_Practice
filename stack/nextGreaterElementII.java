import java.util.*;
public class nextGreaterElementII {
    
    public static int[] nextGreaterElement(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * arr.length; i++) {
            int idx = i % arr.length;
            while (st.size() > 0 && arr[st.peek()] < arr[idx]) {
                res[st.pop()] = arr[idx];
            }
            st.push(idx);
        }

        return res;
    }
}
