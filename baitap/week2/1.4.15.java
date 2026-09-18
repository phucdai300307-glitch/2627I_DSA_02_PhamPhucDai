import java.util.Arrays;

public class TwoSumFaster {
    
    public static int count(int[] a) {
        int count = 0;
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int sum = a[left] + a[right];
            
            if (sum == 0) {
                count++;    
                left++;       
                right--;       
            } 
            else if (sum < 0) {
                left++;
            } 
            else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 1, 3, 5, 10}; 
        System.out.println("Số cặp 2-sum: " + count(a)); // Kết quả: 2 (-10 & 10; -3 & 3)
    }
}

public class ThreeSumFaster {

    public static int count(int[] a) {
        Arrays.sort(a); 
        // hàm sắp xếp có độ phức tạp O(logN)
        int count = 0;
        int n = a.length;

        for (int i = 0; i < n - 2; i++) {
            
            int left = i + 1;
            int right = n - 1;
            int target = -a[i]; 

            while (left < right) {
                int sum = a[left] + a[right];
                
                if (sum == target) {
                    count++;       
                    left++;
                    right--;
                } 
                else if (sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {-4, -1, -1, 0, 1, 2, 5};
        System.out.println("Số bộ ba 3-sum: " + count(a)); 
    }
}