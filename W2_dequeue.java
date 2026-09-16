import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> freq = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        int maxUnique = 0;

        // First window
        for (int i = 0; i < M; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            deque.addLast(arr[i]);
        }

        maxUnique = freq.size();

        // Slide the window
        for (int i = M; i < N; i++) {

            // Remove element from the front
            int removed = deque.removeFirst();
            freq.put(removed, freq.get(removed) - 1);

            if (freq.get(removed) == 0) {
                freq.remove(removed);
            }

            // Add new element at the back
            deque.addLast(arr[i]);
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

            // Update maximum unique count
            maxUnique = Math.max(maxUnique, freq.size());
        }

        System.out.println(maxUnique);

        sc.close();
    }
}
