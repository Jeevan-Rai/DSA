import java.util.*;

public class CompetitiveProgrammersGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        System.out.println(findWinner(s));
    }

    public static String findWinner(String s) {
        List<Integer> zeroSegments = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                int length = 0;
                while (i < s.length() && s.charAt(i) == '0') {
                    length++;
                    i++;
                }
                zeroSegments.add(length);
            } else {
                i++;
            }
        }

        List<Integer> divisors = new ArrayList<>();
        for (int length : zeroSegments) {
            divisors.add(countDivisors(length));
        }

        Collections.sort(divisors, Collections.reverseOrder());

        int marcScore = 0, rexScore = 0;
        for (int j = 0; j < divisors.size(); j++) {
            if (j % 2 == 0) {
                marcScore += divisors.get(j);
            } else {
                rexScore += divisors.get(j);
            }
        }

        return marcScore > rexScore ? "MARC" : "REX";
    }

    private static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }
}
