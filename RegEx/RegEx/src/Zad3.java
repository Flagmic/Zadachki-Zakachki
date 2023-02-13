import java.util.Scanner;

public class Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String x = scanner.nextLine();

        text = text.replaceAll("x", x);
        text = text.replaceAll("\\-\\-", "");
        text = text.replaceAll("\\+\\-", "\\-");
        System.out.println(text);
        scanner.close();


    }
}
