class Solution {
    public String maximumTime(String times) {
        char [] time = times.toCharArray();
        
        time[0] = time[0] != '?' ? time[0] : (time[1] =='?' || time[1] <='3') ? '2' : '1';
        time[1] = time[1] != '?' ? time[1] : time[0] == '2' ? '3' : '9';
        time[3] = time[3] != '?' ? time[3]: '5';
        time[4] = time[4] != '?' ? time[4] : '9';
        
        return new String(time);
    }
}


