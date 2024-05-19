import java.util.*;
public class sunOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int res = sumOfDigits(num);
        while (res>=10) {
            res = (sumOfDigits(res));
        }
        System.err.println(res);
        scanner.close();
    }
    
    public static int sumOfDigits(int num) {
        int temp = num;
        if (temp < 10) {
            return temp;
        }
        else {
            // System.err.println(temp/10);
            return (temp % 10) + sumOfDigits(temp / 10);
        }
    }
}
