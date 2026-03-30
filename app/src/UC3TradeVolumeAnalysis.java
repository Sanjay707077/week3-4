class UC3TradeVolumeAnalysis {

    static class Trade {
        String id;
        int volume;

        Trade(String id, int volume) {
            this.id = id;
            this.volume = volume;
        }
    }

    public static void main(String[] args) {

        Trade[] arr = {
                new Trade("T3", 500),
                new Trade("T1", 100),
                new Trade("T2", 300)
        };

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge Sort (Ascending Volume):");
        print(arr);

        quickSort(arr, 0, arr.length - 1);
        System.out.println("\nQuick Sort (Descending Volume):");
        print(arr);

        int total = totalVolume(arr);
        System.out.println("\nTotal Volume: " + total);
    }

    // Merge Sort
    static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(Trade[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort (Descending)
    static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Trade[] arr, int low, int high) {

        int pivot = arr[high].volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].volume > pivot) { // DESC
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Total Volume
    static int totalVolume(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr)
            sum += t.volume;
        return sum;
    }

    static void print(Trade[] arr) {
        for (Trade t : arr)
            System.out.println(t.id + ":" + t.volume);
    }
}