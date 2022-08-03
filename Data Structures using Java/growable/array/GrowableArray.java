package growable.array;

import java.util.Arrays;

public class GrowableArray {

    private int[] arr;
    private int index;

    public GrowableArray() {
        arr = new int[3];
    }

    public GrowableArray(int capacity) {
        arr = new int[capacity];
    }

    public void add(int value) {
        try {
            arr[index] = value;
            index++;
        } catch (Exception e) {
            arr = Arrays.copyOf(arr, arr.length * 2);
            arr[index] = value;
            index++;

        }

    }

    public int remove(int index) {
        if (index > this.index - 1 || index < 0) {
            return -1;
        } else {
            int temp = arr[index];
            transferElements(index);
            return temp;
        }
    }

    private void transferElements(int index) {
        int[] brr = Arrays.copyOfRange(arr, index + 1, this.index);
        System.arraycopy(brr, 0, arr, index, brr.length);
        this.index--;
    }

    public int remove(Integer item) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == item) {
                transferElements(i);
                return i;

            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < index; i++) {
            if (i == 0) {
                s += arr[i];
            } else {
                s += ", " + arr[i];
            }

        }
        s += "]";
        return s;
    }

    public void add(int index, int item) {
        int[] brr = Arrays.copyOfRange(arr, index, this.index);

        try {
            System.arraycopy(brr, 0, arr, index + 1, brr.length);
            arr[index] = item;
            this.index++;
        } catch (Exception e) {
            arr = new int[arr.length * 2];
            System.arraycopy(brr, 0, arr, index + 1, brr.length);
            arr[index] = item;
            this.index++;

        }
    }

    public int size() {
        return index;
    }

    public int get(int index) {
        return arr[index];
    }

    public int capacity() {
        return arr.length;
    }
}
