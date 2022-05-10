import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class freqcounter {

    public static int getMin(int[] data) {
        int min = data[0];
        for (int j : data) {
            if (j < min)
                min = j;
        }
        return min;
    }
    public static int getMax(int[] data) {
        int max = data[0];
        for (int j : data) {
            if (j > max)
                max = j;
        }
        return max;
    }
    public static boolean check(int[] arr, int toCheckValue)
    {
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }
    public static int[] count(int[] data, int min, int max) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int[] values = new int[getMax(data) - getMin(data) + 1];
        for (int i = 0; i < data.length; i++) {
            if (hmap.containsKey(data[i])) {
                hmap.put(data[i], hmap.get(data[i]) + 1);
            } else {
                hmap.put(data[i], 1);
            }
        }
        int[] keys = new int[hmap.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> mapEntry : hmap.entrySet()) {
            keys[k] = mapEntry.getKey();
            values[k] = mapEntry.getValue();
            k++;
        }
        for (int i = getMin(data); i <= getMax(data); i++) {
            int y = i-getMin(data) ;
            if (!check(data, i)) {
                int tmp = values[y] ;
                values[y]= 0 ;
            }
            else { values[y] = hmap.get(i) ;
            }
        }
            return values;
        }


    public static void main(String args[]) {
         // int arr[] = {1,2,3,4,5,6,7,1,2,3,4};
        // int arr[] = {1,3,3,5,8,8,9,9,9,9,9,15,20,21,26,28,28};
        Scanner input = new Scanner(System.in);
        ArrayList data = new ArrayList<Integer>();
        try {
            while (input.hasNextLine()) {
                data.add(Integer.parseInt(input.nextLine()));
            }

            int[] arr = new int[data.size()];
            for (int i = 0; i < data.size(); i++) {
                arr[i] = (int) data.get(i);
            }
            System.out.println("The minimum value: " + getMin(arr));
            System.out.println("The maximum value: " + getMax(arr));
            System.out.println(java.util.Arrays.toString(count(arr, getMax(arr), getMin(arr))));

          } catch (NumberFormatException e) {

            System.out.println("Something went wrong");
         }

    }
}
