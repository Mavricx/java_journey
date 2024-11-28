package Common_java_problems;
public class SearchingFunctions {
    public static int recBinarySearch(int[] arr, int key, int low, int high) {
        int middle = low + (high - low) / 2;
        System.out.println("Middle: " + middle);
        int value = arr[middle];

        if (value == key) {
            return middle;
        } else if (value < key) {
            return recBinarySearch(arr, key, middle + 1, high);
        } else if (value > key) {
            return recBinarySearch(arr, key, low, middle - 1);
        }
        return -1;
    }

    public static int binarySearch(int[] num, int key) {
        int low = 0;
        int high = num.length;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = num[middle];
            System.out.println("Middle: " + middle);
            if (value < key)
                low = middle + 1;
            else if (value > key)
                high = middle - 1;

            else
                return middle;// target found

        }
        return -1;// target not found
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }

        }
        return -1;
    }

    public static int recLinearSearch(int[] arr, int key, int low) {
        if (low >= arr.length)
            return -1;
        else if (arr[low] == key) {
            return low;
        } else
            return recLinearSearch(arr, key, ++low);
    }

    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(recLinearSearch(arr, 77, 0));
    }
}
