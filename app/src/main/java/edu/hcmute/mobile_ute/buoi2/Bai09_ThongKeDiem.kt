package edu.hcmute.mobile_ute.buoi2
fun main() {
    val mangDiem = arrayOf(7.5, 8.0, 6.5, 9.0, 5.5, 7.0, 8.5, 6.0, 9.5, 7.0)
    var tongDiem = 0.0
    for (diem in mangDiem) {
        tongDiem += diem
    }
    val diemTrungBinh = tongDiem / mangDiem.size

    var diemCaoNhat = mangDiem[0]
    var diemThapNhat = mangDiem[0]
    for (diem in mangDiem) {
        if (diem > diemCaoNhat) {
            diemCaoNhat = diem
        }
        if (diem < diemThapNhat) {
            diemThapNhat = diem
        }
    }

    println("Điểm trung bình cả lớp: $diemTrungBinh")
    println("Điểm cao nhất: $diemCaoNhat")
    println("Điểm thấp nhất: $diemThapNhat")
}
