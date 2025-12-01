package estados;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class LeerFecha {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(leerFecha(s));
    }
    private static LocalDate leerFecha(Scanner s) throws DateTimeException {
        int year;
        int month;
        int day;
        String date = s.nextLine();
        if (date.length() != 10) {
            return null;
        }
        if (date.charAt(2) != '/' || date.charAt(5) != '/') {
            return null;
        }
        try {
            year = Integer.parseInt(date.substring(6, 10));
            month = Integer.parseInt(date.substring(3, 5));
            day = Integer.parseInt(date.substring(0, 2));
        } catch (Exception e) {
            return null;
        }
        return LocalDate.of(year, month, day);
    }
}
