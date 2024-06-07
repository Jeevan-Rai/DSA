import java.util.*;

public class GoodArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minRemovalsToMakeGoodArray(n, arr));
    }

    public static int minRemovalsToMakeGoodArray(int n, int[] arr) {
        int[] count = new int[7];

        for (int num : arr) {
            count[num]++;
        }

        int completeSequences = Math.min(count[1],
                Math.min(count[2], Math.min(count[3], Math.min(count[4], Math.min(count[5], count[6])))));

        int elementsInSequences = completeSequences * 6;

        int minRemovals = n - elementsInSequences;

        return minRemovals;
    }
}
