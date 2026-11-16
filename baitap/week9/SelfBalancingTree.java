
class Node {
    int val;
    Node left;
    Node right;
    int ht;
}

public class SelfBalancingTree {

    // 1. Hàm phụ trợ lấy chiều cao của node
    static int height(Node n) {
        if (n == null) {
            return -1; // Theo đề bài: chiều cao của Null node là -1
        }
        return n.ht;
    }

    // 2. Hàm phụ trợ tính hệ số cân bằng (Balance Factor)
    static int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    // 3. Phép xoay phải (Right Rotate) dùng cho trường hợp lệch trái
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Thực hiện xoay
        x.right = y;
        y.left = T2;

        // Cập nhật lại chiều cao của y và x (cập nhật y trước)
        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;

        // Trả về gốc mới của nhánh này
        return x;
    }

    // 4. Phép xoay trái (Left Rotate) dùng cho trường hợp lệch phải
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Thực hiện xoay
        y.left = x;
        x.right = T2;

        // Cập nhật lại chiều cao của x và y
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        // Trả về gốc mới của nhánh này
        return y;
    }

    // ==============================================================
    // HÀM CHÍNH ĐỂ HOÀN THIỆN THEO YÊU CẦU ĐỀ BÀI
    // ==============================================================
    static Node insert(Node root, int val) {
        // Bước 1: Chèn node đệ quy như BST thông thường
        if (root == null) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.left = null;
            newNode.right = null;
            newNode.ht = 0; // Đề bài: chiều cao của node lá là 0
            return newNode;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            // Cây AVL không chứa giá trị trùng lặp
            return root;
        }

        // Bước 2: Cập nhật lại chiều cao của node tổ tiên hiện tại
        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        // Bước 3: Lấy hệ số cân bằng để kiểm tra xem node này có bị lệch không
        int balance = getBalance(root);

        // Bước 4: Xử lý 4 trường hợp mất cân bằng (nếu có)

        // Trường hợp 1: Left-Left (Lệch trái hoàn toàn)
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        // Trường hợp 2: Right-Right (Lệch phải hoàn toàn)
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        // Trường hợp 3: Left-Right (Lệch trái - phải)
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Trường hợp 4: Right-Left (Lệch phải - trái)
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // Trả về gốc (không thay đổi nếu cây đã cân bằng)
        return root;
    }
}