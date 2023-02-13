import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern p = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(scanner.nextLine());
        int sum = 0;
        while(m.find()) {
            sum += Integer.parseInt(m.group());
        }
        System.out.println(sum);
    }
}
