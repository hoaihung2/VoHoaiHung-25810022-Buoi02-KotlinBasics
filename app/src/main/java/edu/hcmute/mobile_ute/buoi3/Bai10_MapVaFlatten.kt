package edu.hcmute.mobile_ute.buoi3

fun main() {
    val danhSachSoNguyen = listOf(1, 2, 3, 4, 5)
    val danhSachNhanDoi = danhSachSoNguyen.map { it * 2 }

    println("--- Phần map ---")
    println("Danh sách gốc: $danhSachSoNguyen")
    println("Danh sách sau khi nhân đôi: $danhSachNhanDoi")

    val danhSachLongNhau = listOf(
        listOf(1, 2, 3),
        listOf(4, 5),
        listOf(6, 7, 8, 9)
    )
    val danhSachPhang = danhSachLongNhau.flatten()

    println("--- Phần flatten ---")
    println("Danh sách lồng nhau: $danhSachLongNhau")
    println("Danh sách phẳng sau khi gộp: $danhSachPhang")
}
