import java.util.*;

public class MaxTrackLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] barriers = new int[N];
        for (int i = 0; i < N; i++) {
            barriers[i] = sc.nextInt();
        }

        List<Integer> result = getMaxLengths(K, barriers);
        for (int length : result) {
            System.out.println(length);
        }
        sc.close();
    }

    public static List<Integer> getMaxLengths(int K, int[] barriers) {
        TreeSet<Integer> barrierSet = new TreeSet<>();
        List<Integer> result = new ArrayList<>();

        barrierSet.add(0);
        barrierSet.add(K);

        for (int barrier : barriers) {
            barrierSet.add(barrier);

            int lower = barrierSet.lower(barrier);
            int higher = barrierSet.higher(barrier);

            int maxLength = 0;
            Integer prev = null;
            for (int pos : barrierSet) {
                if (prev != null) {
                    maxLength = Math.max(maxLength, pos - prev);
                }
                prev = pos;
            }

            result.add(maxLength);
        }

        return result;
    }
}
