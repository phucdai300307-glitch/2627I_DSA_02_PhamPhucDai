import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class LowestCommonAncestor {

    // Hàm chèn node vào BST (bạn đã làm ở bài trước)
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Hàm tìm Tổ tiên chung gần nhất (LCA)
    public static Node lca(Node root, int v1, int v2) {
        while (root != null) {
            if (v1 < root.data && v2 < root.data) {
                // Cả 2 giá trị đều nhỏ hơn node gốc -> Rẽ trái
                root = root.left;
            } else if (v1 > root.data && v2 > root.data) {
                // Cả 2 giá trị đều lớn hơn node gốc -> Rẽ phải
                root = root.right;
            } else {
                // Chẻ nhánh (nằm giữa) hoặc trùng giá trị -> Đây chính là LCA
                break;
            }
        }
        return root;
    }

    // Hàm main để chạy chương trình trên máy cá nhân
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc số lượng node
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Node root = null;
            
            // Đọc các giá trị và xây dựng cây BST
            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                root = insert(root, data);
            }
            
            // Đọc 2 giá trị cần tìm LCA
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            
            // Gọi hàm và in kết quả
            Node ans = lca(root, v1, v2);
            if (ans != null) {
                System.out.println(ans.data);
            }
        }
        
        scanner.close();
    }
}
