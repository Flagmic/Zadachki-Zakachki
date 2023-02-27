import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Zad2 {
    
    public static void main(String[] args) throws IOException {
        File file = new File("products.txt");
        FileWriter writer = new FileWriter(file);

        Product qica_m = new Product("Qica", "M", 2.89, 24);
        Product qica_l = new Product("Qica", "L", 3.05, 52);
        Product mlqko_32 = new Product("Mlqko", "3.2%", 2.49, 37);
        Product mlqko_24 = new Product("Mlqko", "2.4%", 2.79, 13);
        Product hlqb = new Product("Hlqb", "Gotin", 2, 66);

        writer.write(qica_m.toString() + "\n");
        writer.write(qica_l.toString() + "\n");
        writer.write(mlqko_32.toString() + "\n");
        writer.write(mlqko_24.toString() + "\n");
        writer.write(hlqb.toString() + "\n");
        writer.flush();

        Scanner scanner = new Scanner(file);
        int n = 0;
        try {
            while(true) {
            String product = scanner.nextLine();
            n++;
            }
        } catch (NoSuchElementException e) {
            scanner.close();
        }

        String[] names = new String[n];
        String[] desc = new String[n];
        double[] prices = new double[n];
        int[] sales = new int[n];
        Scanner scanner2 = new Scanner(file);
        for(int i = 0; i < n; i++) {
            String[] product = scanner2.nextLine().split(" ");
            names[i] = product[0];
            desc[i] = product[1];
            prices[i] = Double.parseDouble(product[2]);
            sales[i] = Integer.parseInt(product[3]);
        }

        double sum = 0;
        for(int i = 0; i < n; i++) {
            sum += prices[i]*sales[i];
        }

        System.out.println("Obshto mangizi: " + sum);

        String name = "";
        int max_count = 0;

        String temp;
        int cur_count;

        for(int i = 0; i < n; i++) {
            cur_count = sales[i];
            for(int j = i+1; j < n; j++) {
                if(names[j].equals(names[i])) {
                    cur_count += sales[j];
                    if(cur_count > max_count) {
                        max_count = cur_count;
                        name = names[i];
                    }
                }
            }
        }

        sum = 0;
        for(int i = 0; i < n; i++) {
            if(names[i].equals(name)) {
                sum += prices[i]*sales[i];
            }
        }
        System.out.println(name + " sa prodavani nai-mnogo za: " + sum);


        int max = 0;
        int index = -1;
        for(int i = 0; i < n; i++) {
            if(sales[i] > max) {
                max = sales[i];
                index = i;
            }
        }
        File outputFile = new File("Gross profit.txt");
        writer = new FileWriter(outputFile);
        writer.write(names[index] + " " + desc[index] + " e prodavan nai-mnogo za: " + sales[index]*prices[index]);
        writer.close();
        scanner2.close();




    }
}
