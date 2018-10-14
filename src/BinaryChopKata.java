import java.util.Arrays;

public class BinaryChopKata {
    public static void main (String [] args) {
        int [] array = {14, 6, 23, 18, 9, 2, 10};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int numToFind = 6;
        int iterative = binarySearchWithIterative(numToFind, array);
        System.out.println("Iterative approach: " + numToFind + " is at " + iterative + " index");

        numToFind = 10;
        int recursive = binarySearchWithRecursion(numToFind, array, 0, array.length-1);
        System.out.println("Recursive approach: " + numToFind + " is at " + recursive + " index");
    }
    public static int binarySearchWithIterative(int x, int [] array){
        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            int middle = (high+low) / 2;

            if(array[middle] == x){
                return middle;
            }
            else if(array[middle] < x){
                low = middle + 1;
            }
            else{
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int binarySearchWithRecursion(int x, int [] array, int low, int high){

        while(low <= high){
            int middle = (high +low) / 2;

            if(array[middle] == x){
                return middle;
            }
            else if(array[middle] < x){
                low = middle + 1;
                return binarySearchWithRecursion(x, array, low, high);
            }
            else{
                high = middle - 1;
                binarySearchWithRecursion(x, array, low, high);
            }
        }
        return -1;
    }
}