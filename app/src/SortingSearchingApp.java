import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }
}

public class SortingSearchingApp {

    public static void main(String[] args) {

        ArrayList<Transaction> list = new ArrayList<>();

        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(list);
        insertionSort(list);
        findOutliers(list);
    }

    static void bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {

                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Fee Asc):");
        for (Transaction t : list)
            System.out.println(t.id + ":" + t.fee);
    }

    static void insertionSort(ArrayList<Transaction> list) {

        for (int i = 1; i < list.size(); i++) {

            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0))) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("\nInsertion Sort (Fee + Timestamp):");
        for (Transaction t : list)
            System.out.println(t.id + ":" + t.fee + "@" + t.timestamp);
    }

    static void findOutliers(ArrayList<Transaction> list) {

        System.out.println("\nHigh Fee Outliers:");

        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t.id + ":" + t.fee);
                found = true;
            }
        }

        if (!found)
            System.out.println("None");
    }
}