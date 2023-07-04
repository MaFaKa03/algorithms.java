package algorithms.java;

public class Main {
    public static void main(String[] args) {
        int [] array = new int[]{4, 2, 5, 8, 7 ,3 ,1, 9, 0};
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array){


        for (int i = array.length / 2 - 1; i >= 0 ; i--) {
            heapSort(array, array.length, i);
        }


        for (int i = array.length- 1; i >= 0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;


            heapSort(array, i, 0);
        }

    }

    private static void heapSort(int [] array, int heapSize, int rootIndex){
        int larjest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[larjest])
            larjest = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[larjest])
            larjest = rightChild;
        if (larjest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[larjest];
            array[larjest] = temp;


            heapSort(array, heapSize, larjest);
        }
    }
}
