import java.util.ArrayDeque;
import java.util.Deque;

public class week3_tailop_25020102 {

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static String convertToPostfix(String infix) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c == ' ') {
                continue;
            }

            // 1. Nếu là toán hạng (chữ số): Gom các chữ số liền nhau lại
            if (Character.isDigit(c)) {
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    result.append(infix.charAt(i));
                    i++;
                }
                result.append(" "); // Thêm dấu cách để phân tách các số
                i--; // Lùi lại 1 bước vì vòng lặp for sẽ tự động tăng i lên
            } 
            // 2. Nếu là dấu ngoặc mở
            else if (c == '(') {
                stack.push(c);
            } 
            // 3. Nếu là dấu ngoặc đóng
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } 
            // 4. Nếu là toán tử
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        // 5. Đổ nốt các toán tử còn lại trong Stack vào kết quả
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        // Xóa khoảng trắng thừa ở cuối chuỗi và trả về
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String infix = "20 - (5 + 2) * 1 * 3 - 2*(3+1)";
        System.out.println("Biểu thức trung tố: " + infix);
        System.out.println("Biểu thức hậu tố  : " + convertToPostfix(infix));
    }
}

