import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;
}

public class BinarySearchCheck {

    // Hàm chính theo yêu cầu đề bài
    boolean checkBST(Node root) {
        List<Integer> treeValues = new ArrayList<>();
        
        // Bước 1: Nạp toàn bộ cây vào mảng theo thứ tự Trái - Gốc - Phải
        inOrder(root, treeValues);
        
        // Bước 2: Kiểm tra mảng có tăng dần nghiêm ngặt không
        for (int i = 1; i < treeValues.size(); i++) {
            // Nếu phần tử đứng sau nhỏ hơn hoặc bằng phần tử đứng trước -> Sai
            if (treeValues.get(i) <= treeValues.get(i - 1)) {
                return false;
            }
        }
        
        return true; // Nếu mảng tăng dần hoàn hảo, nó là BST
    }

    // Hàm phụ: Duyệt đệ quy In-order
    void inOrder(Node node, List<Integer> list) {
        if (node == null) {
            return; // Rơi vào chỗ trống thì dừng lại
        }
        
        inOrder(node.left, list);       // 1. Duyệt hết nhánh trái
        list.add(node.data);            // 2. Thêm giá trị node hiện tại vào mảng
        inOrder(node.right, list);      // 3. Duyệt hết nhánh phải
    }
}
