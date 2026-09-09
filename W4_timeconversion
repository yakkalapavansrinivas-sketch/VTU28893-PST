import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String period = s.substring(8, 10); // AM or PM
        int hour = Integer.parseInt(s.substring(0, 2));

        String minutesSeconds = s.substring(2, 8);

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // PM
            if (hour != 12) {
                hour += 12;
            }
        }

        System.out.printf("%02d%s%n", hour, minutesSeconds);

        sc.close();
    }
}
