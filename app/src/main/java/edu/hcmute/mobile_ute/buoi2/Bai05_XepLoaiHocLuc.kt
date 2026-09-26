package edu.hcmute.mobile_ute.buoi2
fun main() {
    val diemTrungBinh = 7.8
    val xepLoai = when (diemTrungBinh) {
        in 8.5..10.0 -> "Xuất sắc"
        in 7.0..8.4 -> "Giỏi"
        in 5.5..6.9 -> "Khá"
        in 4.0..5.4 -> "Trung bình"
        else -> "Yếu"
    }

    println("Điểm trung bình: $diemTrungBinh")
    println("Xếp loại: $xepLoai")
}
