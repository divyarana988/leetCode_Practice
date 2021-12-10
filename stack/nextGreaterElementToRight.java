import java.util.*;

public class nextGreaterElementToRight {
    public int[] sol(int[] arr) {
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = -1;
        }
        return res;
    }
}
