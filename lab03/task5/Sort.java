public class Sort {

    // Generic swap
    static <E> void swap(E[] array, int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // Bubble Sort
    static <E extends Comparable<E>> void bubbleSort(E[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    swap(array, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) break; // early exit if already sorted
        }
    }

    // Merge Sort
    static <E extends Comparable<E>> void mergeSort(E[] array) {
        if (array.length <= 1) return;
        mergeSortHelper(array, 0, array.length - 1);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable<E>> void mergeSortHelper(E[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        mergeSortHelper(a, lo, mid);
        mergeSortHelper(a, mid+1, hi);

        E[] tmp = (E[]) new Comparable[hi - lo + 1];
        int i = lo, j = mid+1, k = 0;
        while (i <= mid && j <= hi)
            tmp[k++] = (a[i].compareTo(a[j]) <= 0) ? a[i++] : a[j++];
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= hi)  tmp[k++] = a[j++];
        System.arraycopy(tmp, 0, a, lo, tmp.length);
    }
}