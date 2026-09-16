import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> m, int r) {
        int n = m.size(), p = m.get(0).size();

        for (int l = 0; l < Math.min(n, p) / 2; l++) {
            int top = l, left = l, bottom = n - 1 - l, right = p - 1 - l;
            List<Integer> a = new ArrayList<>();

            for (int j = left; j <= right; j++) a.add(m.get(top).get(j));
            for (int i = top + 1; i <= bottom; i++) a.add(m.get(i).get(right));
            for (int j = right - 1; j >= left; j--) a.add(m.get(bottom).get(j));
            for (int i = bottom - 1; i > top; i--) a.add(m.get(i).get(left));

            int k = r % a.size(), x = k;

            for (int j = left; j <= right; j++, x = (x + 1) % a.size())
                m.get(top).set(j, a.get(x));

            for (int i = top + 1; i <= bottom; i++, x = (x + 1) % a.size())
                m.get(i).set(right, a.get(x));

            for (int j = right - 1; j >= left; j--, x = (x + 1) % a.size())
                m.get(bottom).set(j, a.get(x));

            for (int i = bottom - 1; i > top; i--, x = (x + 1) % a.size())
                m.get(i).set(left, a.get(x));
        }

        for (List<Integer> row : m)
            System.out.println(String.join(" ",
                row.stream().map(String::valueOf).toArray(String[]::new)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt(), cols = sc.nextInt(), r = sc.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++)
                row.add(sc.nextInt());
            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }
}
