import java.util.Scanner;

public class B_Blank_Space_1829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[]arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int mxcnt = 0;
            int cnt =0;
            for(int i:arr){
                if(i==0){
                    cnt++;
                    mxcnt=Math.max(cnt,mxcnt);
                }else{
                    cnt=0;
                }
            }
            System.out.println(mxcnt);
        }
    }
}
