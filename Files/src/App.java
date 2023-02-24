import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        File file = new File("text.txt");
        FileWriter writer = new FileWriter(file);
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Random rand = new Random();
        
        for(int j = 0; j < n; j++) {
            for(int i = rand.nextInt(n); i < n; i++) {
                writer.write(String.format("%.2f ", (rand.nextDouble()*(n*n+2*n+1))-(2*n)));
            }
            writer.write("\n");
        }
        writer.flush();

        findSmallestAndLargest(file);
        squareMatrix(file);



        writer.close();
    }
    public static void findSmallestAndLargest(File file) throws FileNotFoundException, IOException {
        File outputFile = new File("small_large.txt");
        FileWriter writer = new FileWriter(outputFile);
        Scanner scanner = new Scanner(file);
        String nextLine = "";
        try {
            while(true) {
                nextLine = scanner.nextLine();
                nextLine = nextLine.replaceAll(",", ".");
                String[] numStrings = nextLine.split(" ");
                double[] nums = new double[numStrings.length];
                for(int i = 0; i < nums.length; i++) {
                    nums[i] = Double.parseDouble(numStrings[i]);
                }
                for(int i = 0; i < nums.length; i++) {
                    for(int j = 0; j < nums.length-i-1; j++) {
                        if(nums[j] > nums[j+1]) {
                            double temp = nums[j];
                            nums[j] = nums[j+1];
                            nums[j+1] = temp;
                        }
                    }
                }
                
                writer.write(String.format("%.2f   %.2f \n", nums[0], nums[nums.length-1]));
                writer.flush();
            }
        } catch (NoSuchElementException e) {
            scanner.close();
            writer.close();
            return;
        }
        
    }

    public static void squareMatrix(File file) throws IOException, FileNotFoundException{
        File outputFile = new File("small_large.txt");
        FileWriter writer = new FileWriter(outputFile);
        Scanner scanner = new Scanner(file);
        int n = 0;
        try {
            while(true) {
                String nextLine = scanner.nextLine();
                n++;
            }
        } catch (NoSuchElementException e) {

        }
        writer = new FileWriter(outputFile);
        String nextLine = "";
        File outputfile = new File("matrix.txt");
        FileWriter writer_output = new FileWriter(outputfile);
        try {
            while(true) {
                nextLine = scanner.nextLine();
                String[] numStrings = nextLine.split(" ");
                int neshto = numStrings.length;
                writer_output.write(Arrays.toString(numStrings));
                while(neshto < n) {
                    writer_output.write(" 0");
                }
                writer_output.write("\n");
                
                writer_output.flush();
            }
        } catch (NoSuchElementException e) {
            scanner.close();
            writer.close();
            writer_output.close();
            return;
        }

    }
}
