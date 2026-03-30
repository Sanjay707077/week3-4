class UC2ClientRiskRanking {

    static class Client {
        String name;
        int riskScore;
        double balance;

        Client(String name, int riskScore, double balance) {
            this.name = name;
            this.riskScore = riskScore;
            this.balance = balance;
        }
    }

    public static void main(String[] args) {

        Client[] arr = {
                new Client("C", 80, 2000),
                new Client("A", 20, 5000),
                new Client("B", 50, 3000)
        };

        bubbleSort(arr);
        insertionSort(arr);
        topClients(arr);
    }

    // Bubble Sort (Ascending)
    static void bubbleSort(Client[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Bubble Sort (Ascending Risk):");
        for (Client c : arr)
            System.out.println(c.name + ":" + c.riskScore);
    }

    // Insertion Sort (Descending + Balance)
    static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {

            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].balance < key.balance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending Risk):");
        for (Client c : arr)
            System.out.println(c.name + ":" + c.riskScore);
    }

    // Top Clients
    static void topClients(Client[] arr) {

        System.out.println("\nTop Risk Clients:");

        for (int i = 0; i < Math.min(10, arr.length); i++) {
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
        }
    }
}