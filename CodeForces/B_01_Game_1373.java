import java.util.Scanner;
import java.util.Stack;

public class B_01_Game_1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s= sc.next();
            int moves = 0;
            Stack<Character> st = new Stack<>();
            for(char c : s.toCharArray()){
                if(!st.isEmpty()&&st.peek()!=c){
                    moves++;
                    st.pop();
                }else{
                    st.push(c);
                }
            }
            if(moves%2==1){
                System.out.println("DA");
            }else{
                System.out.println("NET");
            }

        }
    }
}
