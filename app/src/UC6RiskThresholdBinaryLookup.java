class UC6RiskThresholdBinaryLookup {

    public static void main(String[] args) {

        int[] arr = {10, 25, 50, 100};
        int target = 30;

        linearSearch(arr, target);

        binarySearch(arr, target);
    }

    // Linear Search
    static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                found = true;
                break;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("Found: " + found);
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search + Floor + Ceiling
    static void binarySearch(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                System.out.println("\nBinary Search:");
                System.out.println("Found: true");
                System.out.println("Floor: " + arr[mid]);
                System.out.println("Ceiling: " + arr[mid]);
                System.out.println("Comparisons: " + comparisons);
                return;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int floor = (high >= 0) ? arr[high] : -1;
        int ceil = (low < arr.length) ? arr[low] : -1;

        System.out.println("\nBinary Search:");
        System.out.println("Found: false");
        System.out.println("Floor: " + floor);
        System.out.println("Ceiling: " + ceil);
        System.out.println("Comparisons: " + comparisons);
    }
}