package edu.hcmute.mobile_ute.buoi3

fun tinhDienTich(chieuDai: Double, chieuRong: Double): Double {
    return chieuDai * chieuRong
}
val dienTichThuNhat = tinhDienTich(5.0, 3.0)
val dienTichThuHai = tinhDienTich(7.5, 2.0)

fun main() {
    println("Diện tích hình chữ nhật thứ nhất: $dienTichThuNhat")
    println("Diện tích hình chữ nhật thứ hai: $dienTichThuHai")
}
