package baitap.week5;

import java.util.Arrays;

public class NaturalMergeSort {

    /**
     * Hàm sắp xếp Natural Merge Sort chuẩn
     */
    public static void naturalMergeSort(int[] a) {
        if (a == null || a.length <= 1) return;

        int n = a.length;
        int[] temp = new int[n]; // Mảng phụ để trộn dữ liệu

        while (true) {
            int left = 0;
            int runCount = 0;

            while (left < n) {
                // 1. Quét tìm run thứ nhất (đang tăng dần: a[i] <= a[i+1])
                int mid = findNaturalRun(a, left, n);
                runCount++;

                // Nếu run thứ nhất đã chạm cuối mảng -> Không còn run thứ hai để trộn trong lượt này
                if (mid >= n - 1) {
                    break;
                }

                // 2. Quét tìm run thứ hai kế tiếp
                int right = findNaturalRun(a, mid + 1, n);
                runCount++;

                // 3. Trộn hai run: [left...mid] và [mid+1...right]
                merge(a, temp, left, mid, right);

                // Dịch chuyển con trỏ sang phần tử tiếp theo sau run 2
                left = right + 1;
            }

            // Nếu trong cả lượt duyệt toàn mảng mà chỉ có duy nhất 1 run -> Mảng đã sắp xếp xong!
            if (runCount <= 1) {
                break;
            }
        }
    }

    /**
     * Tìm vị trí kết thúc của một đoạn tăng dần tự nhiên bắt đầu từ 'start'.
     * Điều kiện tăng: a[i] <= a[i + 1]
     */
    private static int findNaturalRun(int[] a, int start, int n) {
        int curr = start;
        while (curr + 1 < n && a[curr] <= a[curr + 1]) {
            curr++;
        }
        return curr;
    }

    /**
     * Trộn hai đoạn con đã có thứ tự a[left...mid] và a[mid+1...right]
     */
    private static void merge(int[] a, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        // Trộn các phần tử theo thứ tự tăng dần vào mảng temp
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // Chép phần còn lại của run 1 (nếu còn)
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        // Chép phần còn lại của run 2 (nếu còn)
        while (j <= right) {
            temp[k++] = a[j++];
        }

        // Sao chép kết quả từ temp trở lại mảng chính a
        for (k = left; k <= right; k++) {
            a[k] = temp[k];
        }
    }

    // --- Hàm main kiểm thử ---
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 2, 5, 8, 1, 3, 6};

        System.out.println("Mảng ban đầu:      " + Arrays.toString(arr));
        naturalMergeSort(arr);
        System.out.println("Sau khi sắp xếp:   " + Arrays.toString(arr));
    }
}