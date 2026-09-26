package edu.hcmute.mobile_ute.buoi2

fun main() {
    val soLuong: Int = 5
    val donGia: Double = 25000.0
    val thueSuat = 0.08

    val tienHang = soLuong.toDouble() * donGia
    val tienThue = tienHang * thueSuat
    val tongTien = tienHang + tienThue

    println("Số lượng: $soLuong sản phẩm, đơn giá: $donGia đồng")
    println("Tiền hàng: $tienHang đồng")
    println("Tiền thuế (8%): $tienThue đồng")
    println("Tổng tiền phải trả: $tongTien đồng")
}
