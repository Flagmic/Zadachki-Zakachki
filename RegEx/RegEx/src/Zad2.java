import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        System.out.println(matcher.find());

    }
}
