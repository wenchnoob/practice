import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SortingPractice {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) sb.append("-");

        System.out.println("Bubble Sort");
        Integer[] arr = new Integer[10];
        Utility.fillArr(arr, () -> ThreadLocalRandom.current().nextInt(10));
        System.out.println("Before sort: " + Arrays.toString(arr));
        BubbleSort.sort(arr);
        System.out.println("After sort: " + Arrays.toString(arr));
        System.out.println(sb);

        System.out.println("Insertion Sort");
        Integer[] arr1 = new Integer[10];
        Utility.fillArr(arr1, () -> ThreadLocalRandom.current().nextInt(10));
        System.out.println("Before sort: " + Arrays.toString(arr1));
        InsertionSort.sort(arr1);
        System.out.println("After sort: " + Arrays.toString(arr1));
        System.out.println(sb);

        System.out.println("Selection Sort");
        Integer[] arr2 = new Integer[10];
        Utility.fillArr(arr2, () -> ThreadLocalRandom.current().nextInt(10));
        System.out.println("Before sort: " + Arrays.toString(arr2));
        SelectionSort.sort(arr2);
        System.out.println("After sort: " + Arrays.toString(arr2));
        System.out.println(sb);


        System.out.println("Mergesort");
        Integer[] arr3 = new Integer[10];
        Utility.fillArr(arr3, () -> ThreadLocalRandom.current().nextInt(10));
        System.out.println("Before sort: " + Arrays.toString(arr3));
        Mergesort.sort(arr3);
        System.out.println("After sort: " + Arrays.toString(arr3));
        System.out.println(sb);

        System.out.println("Quicksort");
        Integer[] arr4 = new Integer[10];
        Utility.fillArr(arr4, () -> ThreadLocalRandom.current().nextInt(10));
        System.out.println("Before sort: " + Arrays.toString(arr4));
        Quicksort.sort(arr4);
        System.out.println("After sort: " + Arrays.toString(arr4));
        System.out.println(sb);

        System.out.println("Shell Sort");
        Integer[] arr5 = new Integer[10];
        Utility.fillArr(arr5, () -> ThreadLocalRandom.current().nextInt(10));
        System.out.println("Before sort: " + Arrays.toString(arr5));
        Quicksort.sort(arr5);
        System.out.println("After sort: " + Arrays.toString(arr5));
        System.out.println(sb);


    }

}

interface Sort {
    <T extends Comparable<T>> void sort(T[] arr);
}

class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++)
                if (Utility.lessThan(arr[j+1], arr[j])) Utility.swap(arr, j, j+1);
        }
    }
}

class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Utility.lessThan(arr[i], arr[j])) {
                    while(j < i) Utility.swap(arr, i, j++);
                }
            }
        }
    }
}

class SelectionSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallestIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (Utility.lessThan(arr[j], arr[smallestIdx])) smallestIdx = j;
            }
            Utility.swap(arr, smallestIdx, i);
        }
    }
}

class Mergesort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        mergesort(arr, 0, arr.length);
    }

    public static <T extends Comparable<T>> void mergesort(T[] arr, int start, int end) {
        if (end - start <= 1) return;
        int m = start + (end - start) / 2;
        mergesort(arr, start, m);
        mergesort(arr, m, end);
        merge(arr, start, m, end);
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int start, int m, int end) {
        int i = 0;
        Object[]  narr = new Object[end-start];

        int j = start;
        int k = m;
        while (j < m && k < end) {
            if (Utility.lessThan(arr[j], arr[k])) {
                narr[i++] = arr[j++];
            } else {
                narr[i++] = arr[k++];
            }
        }

        while (j < m) narr[i++] = arr[j++];
        while (k < end) narr[i++] = arr[k++];

        System.arraycopy(narr, 0, arr, start, narr.length);
    }

}

class Quicksort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        quicksort(arr, 0, arr.length);
    }

    public static <T extends Comparable<T>> void quicksort(T[] arr, int start, int end) {
        if (end <= start) return;
        int p = partition(arr, start, end);
        quicksort(arr, start, p);
        quicksort(arr, p + 1, end);
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int start, int end) {
        int p = end - 2;

        while (start <= p) {
            // System.out.println("start= " + start + ", p= " + p + "\t" + Arrays.toString(arr));
            // System.out.println("              \t " + Utility.renderArrow(start * 3) + Utility.renderArrow((p - start) * 3));
            if (Utility.lessThan(arr[end-1], arr[start])) {
                Utility.swap(arr, start, p--);
            } else {
                start++;
            }
        }
        // System.out.println("start= " + start + ", p= " + p + "\t" + Arrays.toString(arr));
        // System.out.println("              \t " + Utility.renderArrow(start * 3) + Utility.renderArrow((p - start) * 3));
        Utility.swap(arr, start, end-1);
        return start;
    }
}

// Probably is not shellsort, not sure.
class ShellSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {

        int gap = arr.length/3;

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++)
                for (int j = i; j < arr.length - gap; j += gap)
                    if (Utility.lessThan(arr[j], arr[j + gap])) {
                        while(j < i) Utility.swap(arr, j, j+gap);
                    }
            gap = (gap/3) - 1;
        }
    }
}

class Utility {

    public static void fillArr(Integer[] arr, Supplier<Integer> supplier) {
        for (int i = 0; i < arr.length; i++) arr[i] = supplier.get();
    }

    public static <T extends Comparable<T>> boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public static <T extends Comparable<T>> boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static String renderArrow(int sp) {
        StringBuilder sb = new StringBuilder();
        for (; sp > 0; sp--) sb.append(" ");
        sb.append("↑");
        return sb.toString();
    }
}
