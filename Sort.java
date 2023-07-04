package algorithms.java;


public class Sort {

    public static void main(String[] args) {

        int [] array = new int[]{4, 2, 5, 8, 7 ,3 ,1, 9, 0};
        insertSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    //пузырьковая сортировка
    public static void bubleSort(int [] array){
        boolean finish = true;
        do {
            finish = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    finish = false;
                }
            }
        }while (!finish);

    }


    // сортировка выборки
    public static void directSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }



    public static void insertSort(int [] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j]=temp;
                }
            }
        }
    }

    //Сортировка вставками

    public static void insertSort2(int [] array){

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int left = i - 1;
            while (left >= 0 && value < array[left]){
                array[left+1] = array[left];
                left--;
            }
            if (left + 1 != i){
                array[left+1] = value;
            }
        }
    }

    // Быстрая сортировка

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    private static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (array[leftMarker] < pivot)
                leftMarker++;
            while (array[rightMarker] > pivot)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftBorder < rightMarker)
            quickSort(array, leftBorder, rightMarker);
        if (leftMarker < rightBorder)
            quickSort(array, leftMarker, rightBorder);
    }
}
