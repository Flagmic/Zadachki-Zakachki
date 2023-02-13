import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad4 {
    public static boolean checkFor(String regex, String text) {
        Pattern p = Pattern.compile(regex, Pattern.UNICODE_CASE);
        Matcher m = p.matcher(text);
        return m.find();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        boolean check = true;
        for(int i = 0; i < 4; i++) {
            if(!checkFor("[a-z]", pass)) check = false;
        }
        for(int i = 0; i < 2; i++) {
            if(check && !checkFor("[A-Z]", pass)) check = false;
        }
        if(check && !checkFor("[0-9]", pass)) check = false;
        System.out.println(check);

    }
}
