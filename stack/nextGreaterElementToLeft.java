import java.util.*;
public class nextGreaterElementToLeft {
    public int[] sol(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while (st.size()>0) {
            res[st.pop()] = -1;
        }
        return res;
    }
}
