package edu.hcmute.mobile_ute.buoi4

class NhanVien(maNhanVien: String, val ten: String, var luongThang: Double) {
    constructor(ten: String) : this("TAM", ten, 0.0)
}

fun main() {
    val nv1 = NhanVien("NV001", "An", 12000000.0)
    val nv2 = NhanVien("Binh")

    println("Ten: ${nv1.ten}, luong thang: ${nv1.luongThang}")
    println("Ten: ${nv2.ten}, luong thang: ${nv2.luongThang}")
}