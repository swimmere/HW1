import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int len = array.length;
        if (len == 0) {
            return array;
        }
        int shift = move % len;
        if (shift == 0 || (direction != 'L' && direction != 'R')) {
            return array;
        }
        

        if (direction == 'R') {
            shift = -shift;
        }
    
        int[] tmp = new int[shift < 0 ? -shift : shift];

        if (shift < 0) {
            for (int i = 0; i < -shift; i++) {
                tmp[i] = array[len + shift + i];
            }
            for (int i = len - 1; i >= -shift; i--) {
                array[i] = array[i + shift];
            }
            for (int i = 0; i < -shift; i++) {
                array[i] = tmp[i];
            }
        } else if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                tmp[i] = array[i];
            }
            for (int i = 0; i < len - shift; i++) {
                array[i] = array[i + shift];
            }
            for (int i = 0; i < shift; i++) {
                array[len - shift + i] = tmp[i];
            }
        }

        return array;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}