import java.util.Arrays;

public class BinaryChopKata {
    public static void main (String [] args) {
        int [] array = {0,1,2};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int numToFind = 2;
        int iterative = binarySearchWithIterative(numToFind, array);
        System.out.println("Iterative approach: " + numToFind + " is at " + iterative + " index");

        numToFind = 3;
        int recursive = binarySearchWithRecursion(numToFind, array, 0, array.length-1);
        System.out.println("Recursive approach: " + numToFind + " is at " + recursive + " index");

//        numToFind = 2;
//        int arraySlicing = binarySearchWithArraySlicing(numToFind, array);
//        System.out.println("Array Slicing approach: " + numToFind + " is at " + arraySlicing + " index");


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

//    public static int binarySearchWithArraySlicing(int x,int [] array){
//        int low = 0;
//        int high = array.length -1;
//
//        while(low<=high){
//            int middle = (high+low) / 2;
//
//            if(array[middle] == x){
//                return middle;
//            }
//            else if(array[middle] < x){
//                low = middle + 1;
//                array = Arrays.copyOfRange(array, low, high);
//                return binarySearchWithArraySlicing(x,array);
//            }
//            else{
//                high = middle - 1;
//                array = Arrays.copyOfRange(array, low, high);
//                return binarySearchWithArraySlicing(x, array);
//            }
//        }
//        return -1;
//    }
}