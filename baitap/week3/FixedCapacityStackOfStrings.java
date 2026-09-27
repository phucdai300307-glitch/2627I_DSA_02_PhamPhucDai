public class FixedCapacityStackOfStrings {
    private String[] a; // Mảng chứa các phần tử của ngăn xếp
    private int N;      // Số lượng phần tử hiện có

    // Khởi tạo ngăn xếp với dung lượng cho trước
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
        N = 0;
    }

    // Kiểm tra ngăn xếp rỗng
    public boolean isEmpty() {
        return N == 0;
    }

    // Kiểm tra ngăn xếp đầy
    public boolean isFull() {
        return N == a.length;
    }

    // Trả về số lượng phần tử
    public int size() {
        return N;
    }

    // Thêm phần tử vào ngăn xếp
    public void push(String item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full"); 
        }
        a[N++] = item;
    }

    // Lấy phần tử ra khỏi ngăn xếp (xóa khỏi stack)
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return a[--N];
    }

    // Xem phần tử trên cùng (không xóa khỏi stack)
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return a[N - 1]; // Chỉ đọc giá trị ở vị trí trên cùng, giữ nguyên N
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(3);

        System.out.println("Ban dau rong: " + stack.isEmpty());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Sau khi them 3 phan tu, stack day: " + stack.isFull());

        // --- TEST HÀM PEEK ---
        System.out.println("\n--- Kiem tra thu ham peek() ---");
        System.out.println("Phan tu tren cung hien tai (dung peek): " + stack.peek());
        System.out.println("So luong phan tu sau khi peek: " + stack.size()); 
        // Số lượng vẫn là 3, chứng tỏ "C" chưa bị lấy ra
        
        System.out.println("Tien hanh pop: " + stack.pop()); 
        // Lúc này mới thực sự lấy "C" ra
        System.out.println("So luong phan tu sau khi pop: " + stack.size()); // Số lượng tụt xuống 2
        System.out.println("-------------------------------\n");

        try {
            stack.push("D");
            stack.push("E"); // Sẽ gây lỗi vì dung lượng tối đa là 3
        } catch (RuntimeException e) {
            System.out.println("Thu them khi day: " + e.getMessage());
        }

        System.out.println("Lay ra tiep theo thu tu: " + stack.pop() + ", " + stack.pop());
        System.out.println("Sau khi lay het, stack rong: " + stack.isEmpty());

        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println("Thu lay khi rong: " + e.getMessage());
        }
    }
}