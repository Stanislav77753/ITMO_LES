import java.util.Arrays;

public class arrayLection {
    public static void main(String[] args) {
            int arr1 [] = new int[10];
            String [] arr2 = new String[8];
            //System.out.println(Arrays.toString(arr1));
           // System.out.println(Arrays.toString(arr2));

            int [] arr3 = {1,4,5,6,1,6,7,8,5};
            //System.out.println(Arrays.toString(arr3));
            //System.out.println(arr3.length);

            // достпу к элементам массива
        int arr3Elem = arr3[2];

        //заполнить массив
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = i + 10;
        }
        //System.out.println(Arrays.toString(arr1));

        for(int i = 0; i < arr3.length; i++){
            //System.out.println("number " + i + " = " + arr3[i]);
        }

        // перебор элементов массива без доступа к элментам (по коллекции)
        for(int i : arr3){
           // System.out.println(i);
        }
        // делаем копию массива
        int [] newArr3 = arr3.clone();
        //----------------------------------------
/*
        System.arraycopy(
                //массив  - источник
                //позиция - начало нового массива
                // массив назначения
                // начальная позиция целевого массива
                //количество опируемых элементов
        );
*/
        int [] newArr4 = new int[3];
        System.arraycopy(arr3, 0, newArr4, 0, 3);
        //System.out.println(Arrays.toString(arr3));
        //System.out.println(Arrays.toString(newArr4));

        //-----------------------------------------------

       // Arrays.copyOf(//исходный массив, длина нового массива)
        int [] newArr5 = Arrays.copyOf(arr3, 2);
        //System.out.println(Arrays.toString(newArr5));

        //---------------------
        //Arrays.copyOfRange(arr3,start_index,end)
        int [] newArr6 = Arrays.copyOfRange(arr3,2,6);
        //System.out.println(Arrays.toString(newArr6));


        // Сравнение массивов
        //System.out.println(Arrays.equals(arr1,arr3));

        //заполнение массивов
        Arrays.fill(arr1, 2);
        //System.out.println(Arrays.toString(arr1));

        //поиск в массиве (двоичный поиск)

        //Arrays.binarySearch(array,key) - массив должен быть отсортирован!!!!!!!!!!!!

        //Arrays.binarySearch(array, start_pos,end_pos, key);


        // сортировка массива

        //Arrays.sort();
        //Arrays.parallelSort();
        //System.out.println(Arrays.toString(arr3));
        Arrays.parallelSort(arr3);
        //System.out.println(Arrays.toString(arr3));
        int c = Arrays.binarySearch(arr3,-99); //возвращает индекс найденного элемента
        //System.out.println(c);


        // Многомерные массивы

        int [][] arr2D;

        int [][][] arr3D;

        int[][] arr2d = new int[10][];
        for(int i = 0; i < arr2d.length; i++){
            arr2d[i] = new int [i];
            System.out.println(Arrays.deepToString(arr2d));
        }

    }
}
