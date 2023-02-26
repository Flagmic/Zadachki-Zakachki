import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad5 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[\\d]{10}", Pattern.CASE_INSENSITIVE);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] lines = new String[n];
        for(int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
        }
        for(int i = 0; i < n; i++) {
            Matcher matcher = pattern.matcher(lines[i]);
            if(matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
