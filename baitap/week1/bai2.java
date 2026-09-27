/*
a. do 0 đã liên kết với mọi vị trí nên chỉ có 1 thành phần liên thông duy nhất
b. union(0,1): nối ko 0 với 1 có 1 lần cập nhật mảng
   union(0,2): 0,1 là con của 2 nên cập nhật 2 lần
   ...... 
   union(0, n-1): cập nhật n-1 lần
   tổng số lần cập nhật là: 1 + 2 + ... + n-1 = n(n-1)/2
c. ta có 1 là cha của 0, 2 là cha của 1,... nên khi tìm find(0) sẽ chạy từ 1 đến 2.... đến n-1
   ta phải đi n-1 để tìm lên vị trí gốc nên độ phức tạp là O(n)
d. union(0, 1): tạo 1 cây có gốc là 1 lá là 0
   union(0, 2), union(0, 3),..., union(0n n-1): ở mỗi lần thực hiện các thao tác này
   cây có gốc 1 sẽ nối với 1 gốc rời gốc đó sẽ nối thảng vào gốc 1
   khi ta find(0), lúc này độ sâu cây chỉ là 2 nên chỉ mất O(1)  tìm lên gốc 
 */
