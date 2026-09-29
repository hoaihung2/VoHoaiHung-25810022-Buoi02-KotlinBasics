package edu.hcmute.mobile_ute.buoi4

class SanPham(
    val tenSanPham: String,
    val gia: Double,
    val soLuongTonKho: Int = 0
)

fun main() {
    val sanPham1 = SanPham("Laptop", 15000000.0, 10)
    val sanPham2 = SanPham(tenSanPham = "Chuot", gia = 250000.0)

    println("Ten san pham: ${sanPham1.tenSanPham}")
    println("Gia: ${sanPham1.gia}")
    println("So luong ton kho: ${sanPham1.soLuongTonKho}")

    println("Ten san pham: ${sanPham2.tenSanPham}")
    println("Gia: ${sanPham2.gia}")
    println("So luong ton kho: ${sanPham2.soLuongTonKho}")
}