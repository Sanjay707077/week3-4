import java.util.Arrays;

class UC5AccountIDSearch {

    public static void main(String[] args) {

        String[] arr = {"accB", "accA", "accB", "accC"};
        String target = "accB";

        linearSearch(arr, target);

        Arrays.sort(arr);
        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));

        binarySearch(arr, target);
    }

    // Linear Search
    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First Index: " + first);
        System.out.println("Last Index: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search + Count
    static void binarySearch(String[] arr, String target) {

        int low = 0, high = arr.length - 1;
        int index = -1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                index = mid;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int count = 0;
        if (index != -1) {
            count = 1;

            int left = index - 1;
            while (left >= 0 && arr[left].equals(target)) {
                count++;
                left--;
            }

            int right = index + 1;
            while (right < arr.length && arr[right].equals(target)) {
                count++;
                right++;
            }
        }

        System.out.println("\nBinary Search:");
        System.out.println("Index: " + index);
        System.out.println("Count: " + count);
        System.out.println("Comparisons: " + comparisons);
    }
}