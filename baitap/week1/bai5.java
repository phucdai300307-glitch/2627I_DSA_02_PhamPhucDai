/*
khi thực hiện union(0, 5), cây chứa 0 có kích thước là 7, cây chứa 5 có
kích thước là 3 nên khi nối 0 và 5, đáng lẽ 0 phải trở thành cha của 5.
Tuy nhiên trong bài ta có parent[0] = 5 tức 0 đã trở thành con của 5.
Điều này bị sai so với quy tắc của weighted quink union. Nên parend-link
kia là không hợp lệ đối với weighted quick union.
 */