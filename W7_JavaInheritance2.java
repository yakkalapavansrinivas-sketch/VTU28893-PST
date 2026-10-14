
import java.io.*;

class Arithmetic {
    int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Arithmetic {
}

public class Solution {
    public static void main(String[] args) {
        Adder adder = new Adder();

        System.out.println("My superclass is: " +
            adder.getClass().getSuperclass().getName());

        System.out.print(adder.add(42, 13) + " ");
        System.out.print(adder.add(13, 20) + " ");
        System.out.println(adder.add(7, 13));
    }
}
