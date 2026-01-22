//Brute Force
class Solution {
    public String makeGood(String s) {
        boolean flag=true;
        while(flag){
            flag=false;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i+1<s.length() && Math.abs(s.charAt(i)-s.charAt(i+1))==32){
                    flag=true;
                    i++;
                }else sb.append(s.charAt(i));
            }
            s = sb.toString();
        }
        return s;
    }
}

//Optimal Approach
class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && Math.abs(c-st.peek())==32){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
