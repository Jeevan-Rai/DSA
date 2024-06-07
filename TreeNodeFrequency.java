import java.util.Scanner;

public class TreeNodeFrequency {
    static long[] freq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        freq = new long[N + 1];

        traverse(N);

        for (int i = 1; i <= N; i++) {
            System.out.println(freq[i]);
        }

        sc.close();
    }

    private static void traverse(int node) {
        if (node < 1)
            return;
        freq[node]++;
        traverse(node - 1);
        traverse(node - 2);
    }
}
