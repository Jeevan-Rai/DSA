public class temp {
    public static int fun(int n) {
        if (n >= 0 && n <= 9) {
            return 1;
        } else {
            return (1 + fun(n / 10));
        }
    }
    
    
    public static void main(String[] args) {
        // System.out.println(fun(8096));
        int n1 = 17;
        int d = 2 ^ 12;
        boolean c = false;
        if (2 > n1 && d < 8192) {
            c = true;

        }
        else {
            c = false;
        }

        System.out.println(d);
    }
}
