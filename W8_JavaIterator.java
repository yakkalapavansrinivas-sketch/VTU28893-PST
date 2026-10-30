
import java.util.*;

public class Solution {

    static void func(ArrayList mylist) {
        Iterator it = mylist.iterator();

        boolean found = false;

        while (it.hasNext()) {
            Object element = it.next();

            if (element.equals("###")) {
                found = true;
                continue;
            }

            if (found) {
                System.out.println((String) element);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList mylist = new ArrayList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }

        mylist.add("###");

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            mylist.add(sc.next());
        }

        func(mylist);

        sc.close();
    }
}
