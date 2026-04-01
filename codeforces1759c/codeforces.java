import java.util.*;

public class codeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long x = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            if (a == b) {
                System.out.println(0);
            } 
            else if (Math.abs(a - b) >= x) {
                System.out.println(1);
            } 
            else {
                boolean two = false;
                
                if (Math.abs(a - l) >= x && Math.abs(l - b) >= x)
                    two = true;
                if (Math.abs(a - r) >= x && Math.abs(r - b) >= x)
                    two = true;
                
                if (two) {
                    System.out.println(2);
                } 
                else {
                    boolean three = false;
                    
                    if (Math.abs(a - l) >= x && 
                        Math.abs(l - r) >= x && 
                        Math.abs(r - b) >= x)
                        three = true;
                    
                    if (Math.abs(a - r) >= x && 
                        Math.abs(r - l) >= x && 
                        Math.abs(l - b) >= x)
                        three = true;
                    
                    if (three)
                        System.out.println(3);
                    else
                        System.out.println(-1);
                }
            }
        }
    }
}
