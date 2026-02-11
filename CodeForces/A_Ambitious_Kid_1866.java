import java.util.Scanner;

public class A_Ambitious_Kid_1866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n = sc.nextInt();
            long min = Long.MAX_VALUE;
            for(int i =0;i<n;i++){
                long var = sc.nextLong();
                min = Math.min(min,Math.abs(var));
            }
            System.out.println(min);
        
    }
}
