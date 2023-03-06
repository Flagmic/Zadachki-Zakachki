import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pendulum {
    
    public static void main(String[] args) throws IOException {
        File file = new File("pendulum.txt");
        FileWriter writer = new FileWriter(file);
        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            writer.write(String.format("%.2f %d %.2f", Double.parseDouble(scanner.next()), Integer.parseInt(scanner.next()), Double.parseDouble(scanner.next())));
            line = scanner.nextLine();
            writer.flush();
        } while (!line.equals("krai"));
        scanner.close();
        writer.close();
    }
}