// Brute Force 
class Solution {
    ArrayList<String> al = new ArrayList<>();
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        subSeq(s, 0, "",k);
        String ans = "";
        for(int i=0;i<al.size();i++){
            if(al.get(i).length()==k){
                if(valid(al.get(i),letter,repetition)){
                    if(ans.equals("")) ans += al.get(i);
                    else ans = check(ans,al.get(i));
                }
            }
        }
        return  ans;
    }
    public void subSeq(String s, int i , String curr , int k){
        if(i==s.length()){
            if(curr.length()==k) al.add(curr);
            return;
        }
        subSeq(s,i+1,curr,k);
        curr+=s.charAt(i);
        subSeq(s,i+1,curr,k);
    }
    public boolean valid(String s , char c, int r){
        int cnt = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==c){
                cnt++;
            }
        }
        return cnt>=r;
    }
    public String check(String s, String p){
        int i =0;
        while(i<s.length()){
            if(s.charAt(i)<p.charAt(i)) return s;
            else if(s.charAt(i)>p.charAt(i)) return p;
            i++;
        }
        return s;
    }
}

//Optimal Approach --> Stack+Greedy
class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int freq =  0;
        for(char c  : s.toCharArray()){
            if(c==letter){
                freq++;
            }
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            while(!st.isEmpty() &&
                    (st.peek()>c) &&
                    (s.length()-i+st.size()-1>=k) &&
                    (st.peek() != letter || freq>repetition)){
                        if(st.pop()== letter) repetition++;
            }
            if(st.size()<k){
                if(c==letter){
                    st.push(c);
                    repetition--;
                }else if (k-st.size()>repetition){
                    st.push(c);
                }

            }
            if(c==letter){
                freq--;
            }
                    
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
