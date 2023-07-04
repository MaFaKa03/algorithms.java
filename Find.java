package algorithms.java;

public class Find {

    public static void main(String[] args) {
        int array [] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binFind(array, 5, 0, array.length-1));
    }


    //Простой перебор
    public static int find(int array[], int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }


    //Бинарный поиск
    public static int binFind(int array[], int value, int min, int max){
        int midPoint;
        if(max < min)
            return -1;
        else
            midPoint = (max-min)/2+min;
        if(array[midPoint] < value)
            return binFind(array, value, min+1, max);
        else
            if (array[midPoint] > value) {
                return binFind(array, value, min, midPoint - 1);
        }
            else return midPoint;

    }
}
