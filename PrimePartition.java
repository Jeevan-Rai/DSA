import java.util.*;

public class PrimePartition {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(numberOfPrimePartitions(N));
        sc.close();
    }

    public static int numberOfPrimePartitions(int N) {
        List<Integer> primes = sieveOfEratosthenes(N);

        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int prime : primes) {
            for (int i = prime; i <= N; i++) {
                dp[i] = (dp[i] + dp[i - prime]) % MOD;
            }
        }

        return dp[N];
    }

    private static List<Integer> sieveOfEratosthenes(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
