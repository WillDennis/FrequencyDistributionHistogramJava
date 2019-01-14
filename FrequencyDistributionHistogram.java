/**
 * Will Dennis - 100157542
 * Date: 21/11/18
 * Version: 1.0
 */
//import packages
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FrequencyDistributionHistogram {

    //function to generate a random array of  size n
    public static List<Integer> generateRandomArray(int n) {
        //initialise ArrayList list 
        ArrayList<Integer> list = new ArrayList<>(n);
        //random number generation
        Random randomNums = new Random();
        //ensure random integers are between 0-100 inclusively
        for (int i = 0; i < n; i++) {
            list.add(randomNums.nextInt(100));
        }
        //return the arraylist
        return list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //scanner to read in size n
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n = input.nextInt();

        //print nanotimings to file
        PrintWriter pw = new PrintWriter(new File("timingExperiment.csv"));

        //will run each test 100 times of each array length
        while (n <= 1000) {
            //printwriter size of array
            pw.println(n);
            int runs = 0;       //reset runs to 0
            while (runs < 10) {
                // initialise number count
                int count = 1;

                //method to generate arraylist of size n
                List<Integer> list = generateRandomArray(n);
                //timing experiment start
                long nano_startTime = System.nanoTime();
                //increasing the number brackets

                for (int i = 10; i <= 100; i += 10) {
                    System.out.print("\n" + count + " - " + i + " | ");

                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) <= i && list.get(j) >= count) {
                            System.out.print("*");
                        }
                    }
                    //increase number bracket by 10.
                    count += 10;
                }
                //end time for timing experiment 
                long nano_endTime = System.nanoTime();
                //long nanoTime = (nano_endTime - nano_startTime);
                // Print the time taken by subtracting the end-time from the start-time 
                System.out.println("\nTime taken in nano seconds: "
                        + (nano_endTime - nano_startTime));

                //pw.println(nano_endTime - nano_startTime);
                //increment runs +1 each loop
                runs++;
            }
            //increment array size n by 100
            n += 100;
        }
        //close print writer
        pw.close();

        // test by outputting array
        /*for (Integer i : list) {
            System.out.println("\n" + i);
        }*/
    }
}
