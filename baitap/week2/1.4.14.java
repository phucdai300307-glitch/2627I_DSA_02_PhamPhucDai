import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int m = j + 1;
                int n = len - 1;

                while (m < n) {
                    // Ép kiểu (long) để tránh lỗi tràn số khi cộng 4 số int lớn
                    long sum = (long) nums[i] + nums[j] + nums[m] + nums[n];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));

                        // Bỏ qua các giá trị m và n trùng lặp để tránh bộ số giống nhau
                        while (m < n && nums[m] == nums[m + 1]) m++;
                        while (m < n && nums[n] == nums[n - 1]) n--;
                        m++;
                        n--;
                    } 
                    else if (sum < target) {
                        m++;
                    } 
                    else {
                        n--;
                    }
                }
            }
        }
        return result;
    }
}
// độ phức tạp: O(N^3)


// Solution 2
public class FourSumPairApproach {

    static class Pair {
        long sum;
        int index1;
        int index2;

        public Pair(long sum, int index1, int index2) {
            this.sum = sum;
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> uniqueQuadruplets = new HashSet<>();
        int n = nums.length;

        if (n < 4) return new ArrayList<>();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                pairs.add(new Pair((long) nums[i] + nums[j], i, j));
            }
        }

        pairs.sort(Comparator.comparingLong(p -> p.sum));

        int left = 0;
        int right = pairs.size() - 1;

        while (left < right) {
            Pair pLeft = pairs.get(left);
            Pair pRight = pairs.get(right);
            long currentSum = pLeft.sum + pRight.sum;

            if (currentSum == target) {
                if (pLeft.sum == pRight.sum) {
                    for (int k1 = left; k1 <= right; k1++) {
                        for (int k2 = k1 + 1; k2 <= right; k2++) {
                            checkAndAdd(pairs.get(k1), pairs.get(k2), nums, uniqueQuadruplets);
                        }
                    }
                    break;
                } 
                else {
                    int leftBlockEnd = left;
                    while (leftBlockEnd + 1 < right && pairs.get(leftBlockEnd + 1).sum == pLeft.sum) {
                        leftBlockEnd++;
                    }

                    int rightBlockStart = right;
                    while (rightBlockStart - 1 > left && pairs.get(rightBlockStart - 1).sum == pRight.sum) {
                        rightBlockStart--;
                    }

                    for (int k1 = left; k1 <= leftBlockEnd; k1++) {
                        for (int k2 = right; k2 >= rightBlockStart; k2--) {
                            checkAndAdd(pairs.get(k1), pairs.get(k2), nums, uniqueQuadruplets);
                        }
                    }

                    // Nhảy qua toàn bộ khối trùng lặp
                    left = leftBlockEnd + 1;
                    right = rightBlockStart - 1;
                }
            } 
            else if (currentSum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        return new ArrayList<>(uniqueQuadruplets);
    }

    // Hàm phụ trợ để kiểm tra trùng chỉ số và thêm vào kết quả
    private void checkAndAdd(Pair p1, Pair p2, int[] nums, Set<List<Integer>> uniqueQuadruplets) {
        // Đảm bảo 4 số đến từ 4 vị trí gốc khác nhau (Không được trùng chỉ số i, j)
        if (p1.index1 != p2.index1 && p1.index1 != p2.index2 && 
            p1.index2 != p2.index1 && p1.index2 != p2.index2) {
            
            // Lấy giá trị gốc
            List<Integer> quad = Arrays.asList(
                nums[p1.index1], nums[p1.index2], nums[p2.index1], nums[p2.index2]
            );
            
            // Phải sắp xếp 4 giá trị này để HashSet có thể nhận diện các bộ trùng nhau
            // (Ví dụ: [1, 2, 3, 4] sẽ giống với [2, 1, 4, 3])
            Collections.sort(quad);
            uniqueQuadruplets.add(quad);
        }
    }
}
// độ phức tạp trung bình là O(N^2logN), độ phức tạp xấu nhất: O(N^4)
