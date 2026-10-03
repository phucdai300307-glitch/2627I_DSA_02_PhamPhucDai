import java.util.Scanner;

public class CountingSort1 {

    // Hàm thực hiện Counting Sort 1 theo phạm vi giá trị thực tế của mảng
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int min = arr[0];
        int max = arr[0];

        // Tìm khoảng giá trị nhỏ nhất và lớn nhất trong mảng
        for (int value : arr) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        // Dịch chuyển các giá trị về không âm để tránh index âm
        int offset = -min;
        int[] counts = new int[max - min + 1];

        // Đếm số lần xuất hiện của từng phần tử
        for (int value : arr) {
            counts[value + offset]++;
        }

        // In kết quả tần số theo khoảng giá trị từ min đến max
        for (int i = 0; i < counts.length; i++) {
            System.out.print(counts[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println();
                scanner.close();
                return;
            }

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            countingSort(arr);
        }

        scanner.close();
    }
}