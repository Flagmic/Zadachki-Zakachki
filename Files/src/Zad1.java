import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Zad1 {

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
        File matrix = new File("matrix.txt");
        diagonalSums(matrix);



        writer.close();
        scanner.close();
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
        Scanner scanner = new Scanner(file);
        int n = 0;
        try {
            while(true) {
                scanner.nextLine();
                n++;
            }
        } catch (NoSuchElementException e) {
            scanner.close();
        }
        Scanner scanner2 = new Scanner(file);
        File outputFile = new File("matrix.txt");
        FileWriter writer = new FileWriter(outputFile);
        String nextLine = "";
        try {
            while(true) {
                nextLine = scanner2.nextLine();
                String[] numStrings = nextLine.split(" ");
                int neshto = numStrings.length;
                for(int i = 0; i < numStrings.length; i++) {
                    writer.write(numStrings[i] + " ");
                }
                while(neshto < n) {
                    writer.write("0 ");
                    neshto++;
                }
                writer.write("\n");
                
                writer.flush();
            }
        } catch (NoSuchElementException e) {
            scanner2.close();
            writer.close();
            writer.close();
            return;
        }

    }

    public static void diagonalSums(File file) throws FileNotFoundException, IOException{
        Scanner scanner = new Scanner(file);
        int n = 0;
        try {
            while(true) {
                scanner.nextLine();
                n++;
            }
        } catch (NoSuchElementException e) {
            scanner.close();
        }
        Scanner scanner2 = new Scanner(file);
        double[][] arr = new double[n][n];
        for(int x = 0; x < arr.length; x++) {
            String[] nextLine = scanner2.nextLine().replaceAll(",", ".").split(" ");
            for(int y = 0; y < arr.length; y++) {
                arr[x][y] = Double.parseDouble(nextLine[y]);
            }
        }
        scanner2.close();

        // for(int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        double main_down = 0;
        double main_up = 0;
        double sec_down = 0;
        double sec_up = 0;
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if(y < x) main_down += arr[x][y];
                if(y > x) main_up += arr[x][y];
                if(x + y > n-1) sec_down += arr[x][y];
                if(x + y < n-1) sec_up += arr[x][y];
            }
        }

        System.out.println(String.format("Under main diagonal: %.2f", main_down));
        System.out.println(String.format("Above main diagonal: %.2f", main_up));
        System.out.println(String.format("Under secondary diagonal: %.2f", sec_down));
        System.out.println(String.format("Above secondary diagonal: %.2f", sec_up));
    }
}
