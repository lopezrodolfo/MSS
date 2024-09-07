/* 
Uses four algorithms with varying time complexities to return the maximum subsequence sum given an array. 

Author names: Rodolfo Lopez and Russell Gokemeijer

Last modified: 3/24/21
*/

import java.io.*;
import java.util.*;



public class mssTime {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            program(sc);
            System.out.println();
            System.out.println("Do you want to run the program again [y/n]?:");
            if (!sc.nextLine().equalsIgnoreCase("y")) {
                break;
            }
        }
        sc.close();
    }

    public static void program(Scanner sc){
        ArrayList<int[]> inputs = getInputs(sc);
        String whichFunction;
        long time;
        while (true){
            System.out.println();
            System.out.println("Would you like to run mss function 1. O(n^3), 2. O(n^2), 3. O(n*log(n)), 4. O(n), or all. [1/2/3/4/all]");
            whichFunction = sc.nextLine();
            if (whichFunction.equals("1")){
                System.out.println("MSS O(n^3)");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_cubic(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                break;
            }
            else if (whichFunction.equals("2")){
                System.out.println("MSS O(n^2)");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_quadratic(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                break;            }
            else if (whichFunction.equals("3")){
                System.out.println("MSS O(n*log(n))");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_log_linear(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                break;
            }
            else if (whichFunction.equals("4")){
                System.out.println("MSS O(n)");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_linear(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                break;
            }
            else if (whichFunction.equalsIgnoreCase("all")){
                System.out.println("MSS O(n^3)");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_cubic(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                System.out.println("MSS O(n^2)");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_quadratic(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                System.out.println("MSS O(n*log(n))");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_log_linear(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                System.out.println("MSS O(n)");
                for (int i=0;i < inputs.size();i++){
                    int [] array =inputs.get(i);
                    time = System.nanoTime();
                    mss_linear(array);
                    time = System.nanoTime() - time;
                    System.out.println("Input " +String.valueOf(i+1)+ ". " + time);
                }
                break;
            }
            System.out.println();
            System.out.println("Input invalid, try again.");
        }
    }

    public static ArrayList<int[]> getInputs(Scanner sc) {
        BufferedReader reader;
        String userInput;
        ArrayList<int[]> inputs = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("Enter an input file you would like to use, type an integer to create a random array of that length" +
            ", or type done if you have no more inputs to add.");
            userInput = sc.nextLine();
            try {
                reader = new BufferedReader(new FileReader(userInput));
                inputs.add(getFileArray(reader));
            }
            catch (FileNotFoundException e) {
                try {
                    int arrayLength = Integer.parseInt(userInput);
                    if (arrayLength > 0) {
                        inputs.add(getRandomArray(arrayLength));
                        break;  // Exit the loop after successfully creating a random array
                    }
                    else {
                        System.out.println("Your entry was invalid, try again");
                    }
                }
                catch (NumberFormatException e1) {
                    if (userInput.equalsIgnoreCase("done")) {
                        break;
                    }
                    else {
                        System.out.println("Your entry was invalid, try again.");
                    }
                }
            }
        }
        return inputs;
    }

    public static int[] getFileArray(BufferedReader reader){
        String fileLine = "";
        String[] stringArray;
        int[] intArray;

        try{
            fileLine = reader.readLine();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

        stringArray = fileLine.split(",");
        intArray = new int[stringArray.length];
        for (int i = 0; i<stringArray.length; i++){
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;    
    }

    public static int[] getRandomArray(int length){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((Math.random()-0.5)*21);
        }
        return arr;
    }

    public static int mss_cubic(int[] arr) {
        int n = arr.length;
        int max_sum = 0;
  
        for (int i=0; i < n; i++) {
            for(int j=i; j < n; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum += arr[k];
                }
                if (sum > max_sum){
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }
   
    public static int mss_quadratic(int[] arr) {
        int n = arr.length;
        int max_sum = 0;
  
        for (int i=0; i < n; i++) {
            int sum = 0;
            for (int j=i; j < n; j++) {
                sum += arr[j];
                if (sum > max_sum){
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }
  
    public static int crossing_max_sum(int[] arr, int low, int mid, int high ) {
        int max_left_sum = 0;
        int sum = 0;
        for (int i=mid; i >= low; i--) {
            sum += arr[i];
            if (sum > max_left_sum){
                max_left_sum = sum;
            }
        }
  
        int max_right_sum = 0;
        sum = 0;
  
        for(int i=mid+1; i<=high; i++) {
            sum += arr[i];
            if (sum > max_right_sum){
                max_right_sum = sum;
            }
        }
        return (max_left_sum + max_right_sum);
    }
  
    public static int partion_max_sum(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }
        int mid = (low + high) / 2;
  
        int max_left_sum = partion_max_sum(arr, low, mid);
        int max_right_sum = partion_max_sum(arr, mid+1, high);
        int max_crossing_sum = crossing_max_sum(arr, low, mid, high);
  
        return Math.max(Math.max(max_left_sum, max_right_sum), max_crossing_sum);
    }
  
    public static int mss_log_linear(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        return partion_max_sum(arr, low, high);
    }
  
    public static int mss_linear(int[] arr) {
        int n = arr.length;
        int max_sum = 0;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];
            if (sum > max_sum) {
                max_sum = sum;
            }
            else if (sum < 0) {
                sum = 0;
            }
        }
        return max_sum;
    }
}

