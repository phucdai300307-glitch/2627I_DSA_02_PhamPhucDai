/*  1 testcase ví dụ: n = 3; union(0, 1); union(0, 2) 
    ở bước union(0,2) chỉ có 0 và 2 là liên thông
    lỗi xảy ra vì khi chạy vòng i giá trị leader[p] có thể thay đổi mà không được lưu lại
    lúc này ở các vòng tiếp theo, giá trị leader[p] đã thay đổi nên khi so sánh có thể xảy ra sai lệch
    để fix bug chỉ cần lưu lại giá trị leader[p] trước khi chạy vòng lặp so sánh */

// trước khi fix
public void union(int p, int q) {
    for (int i = 0; i < leader.length; i++) {
        if (leader[i] == leaderP) {
            leader[i] = leader[q];
        }
    }
}
// sau khi fix
public void union_fix(int p, int q) {
    for (int i = 0; i < leader.length; i++) {
        leaderP = leader[p]; // đã lưu giá trị leader[p] ban đầu
        if (leader[i] == leaderP) {
            leader[i] = leader[q];
        }
    }
}