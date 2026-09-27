import java.util.Scanner;
import java.util.Stack;

public class Parentheses {

    // Hàm kiểm tra tính hợp lệ của chuỗi dấu ngoặc
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        // Duyệt qua từng ký tự trong chuỗi
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Nếu là dấu mở ngoặc -> Đẩy vào ngăn xếp
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // Nếu là dấu đóng ngoặc
            else if (c == ')' || c == ']' || c == '}') {
                // Kiểm tra edge case: Nếu stack rỗng mà lại có dấu đóng ngoặc -> Sai
                if (stack.isEmpty()) {
                    return false;
                }

                // Lấy dấu mở ngoặc ở trên cùng ra để so sánh
                char top = stack.pop();

                // Kiểm tra xem có khớp cặp không
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        // Kết thúc chuỗi, nếu stack rỗng là true (đã bắt cặp hết), ngược lại là false
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi dấu ngoặc cần kiểm tra:");
        
        if (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(isBalanced(input));
        }
        
        scanner.close();
    }
}