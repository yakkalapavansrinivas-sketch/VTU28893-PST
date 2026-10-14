
import java.util.*;

class Printer {
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        Printer myPrinter = new Printer();
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }
}
