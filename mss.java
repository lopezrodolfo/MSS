/* 
Uses four algorithms with varying time complexities to return the maximum subsequence sum given an array. 

Author names: Rodolfo Lopez and Russell Gokemeijer

Last modified: 3/24/21
*/

public class mss {
    public static void main(String[]args) {
        int[] my_arr = {5,-4,6,-12,15,1};

        int cubic_max_sum = mss_cubic(my_arr);
        int quadratic_max_sum = mss_quadratic(my_arr);
        int log_linear_max_sum = mss_log_linear(my_arr);
        int linear_max_sum = mss_linear(my_arr);
 
        System.out.println("Cubic Max Sum: " + cubic_max_sum);
        System.out.println("Quadratic Max Sum: " + quadratic_max_sum);
        System.out.println("Log Linear Max Sum: " + log_linear_max_sum);
        System.out.println("Linear Max Sum: " + linear_max_sum);
    }

    public static int max(int num1, int num2) {
        if (num1 >= num2) {
            return num1;
        }
        return num2;
    }

    public static int max(int num1, int num2, int num3) {
        if (num1>=num2 && num1>=num3) {
            return num1;
        }
        else if (num2>=num1 && num2>=num3) {
            return num2;
        }
        return num3;
    }

    public static int mss_cubic(int[] arr) {
        if (arr == null) {
            System.out.println("Read in empty array");
            System.exit(1);
        }

        int n = arr.length;
        int max_sum = 0;

        for (int i=0; i < n; i++) {
            for(int j=i; j < n; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum += arr[k];
                }
                max_sum = max(sum, max_sum);
            }
        }
        return max_sum;
    }
    
    public static int mss_quadratic(int[] arr) {
        if (arr == null) {
            System.out.println("Read in empty array");
            System.exit(1);
        }

        int n = arr.length;
        int max_sum = 0;

        for (int i=0; i < n; i++) {
            int sum = 0;
            for (int j=i; j < n; j++) {
                sum += arr[j];
                max_sum = max(sum, max_sum);
            }
        }
        return max_sum;
    }

    public static int crossing_max_sum(int[] arr, int low, int mid, int high ) {
        int max_left_sum = 0;
        int sum = 0;

        for (int i=mid; i >= low; i--) {
            sum += arr[i];
            max_left_sum = max(sum, max_left_sum);
        }

        int max_right_sum = 0;
        sum = 0;

        for(int i=mid+1; i<=high; i++) {
            sum += arr[i];
            max_right_sum = max(sum, max_right_sum);
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

        return max(max_left_sum, max_right_sum, max_crossing_sum);
    }

    public static int mss_log_linear(int[] arr) {
        if (arr == null) {
            System.out.println("Read in empty array");
            System.exit(1);
        }
        int low = 0;
        int high = arr.length - 1;
        return partion_max_sum(arr, low, high); 
    }

    public static int mss_linear(int[] arr) {
        if (arr == null) {
            System.out.println("Read in empty array");
            System.exit(1);
        }

        int n = arr.length;
        int max_sum = 0;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];
            if (sum == max(sum, max_sum)) {
                max_sum = sum;
            }
            else if (sum < 0) {
                sum = 0;
            }
        }
        return max_sum;
    }
}
