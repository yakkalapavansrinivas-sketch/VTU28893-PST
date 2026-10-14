
import java.util.*;

class Student {}
class Rockstar {}
class Hacker {}

public class Solution {
    static String count(ArrayList<Object> mylist) {
        int a = 0, b = 0, c = 0;

        for (Object element : mylist) {
            if (element instanceof Student) a++;
            if (element instanceof Rockstar) b++;
            if (element instanceof Hacker) c++;
        }

        return a + " " + b + " " + c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Object> mylist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("Student")) mylist.add(new Student());
            else if (s.equals("Rockstar")) mylist.add(new Rockstar());
            else if (s.equals("Hacker")) mylist.add(new Hacker());
        }

        System.out.println(count(mylist));
        sc.close();
    }
}
