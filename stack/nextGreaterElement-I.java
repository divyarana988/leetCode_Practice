   public static int[] nextGreaterElement(int[] nums, int[] query) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[query.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            while (st.size() > 0 && nums[st.peek()] < nums[i]) {
                map.put(nums[st.pop()], nums[i]);
            }
            st.push(i);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(query[i], -1);
        }
        return res;
    }
