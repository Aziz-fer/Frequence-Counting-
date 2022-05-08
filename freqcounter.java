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

    public static int[] count(int[] data, int min, int max) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            if (hmap.containsKey(data[i])) {
                hmap.put(data[i], hmap.get(data[i]) + 1);
            } else {
                hmap.put(data[i], 1);
            }
        }
       /* for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
          }
        int[] keys = new int[mp.size()]; */
        int[] values = new int[hmap.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> mapEntry : hmap.entrySet()) {
            // keys[index] = mapEntry.getKey();
            values[k] = mapEntry.getValue();
            k++;
        }
        return values;
    }

    public static void main(String args[]) {
        // int arr[] = {1,2,3,4,5,6,7,1,2,3,4};
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
