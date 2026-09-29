package edu.hcmute.mobile_ute.buoi4


data class SinhVien(val mssv: String, val hoTen: String, val diemTrungBinh: Double)

fun main() {
    val sinhVien1 = SinhVien("SV001", "Nguyen Van An", 8.0)
    val sinhVien2 = SinhVien("SV001", "Nguyen Van An", 8.0)

    println(sinhVien1)
    println("sinhVien1 == sinhVien2: ${sinhVien1 == sinhVien2}")

    val sinhVien3 = sinhVien1.copy(diemTrungBinh = 9.0)
    println(sinhVien3)
}