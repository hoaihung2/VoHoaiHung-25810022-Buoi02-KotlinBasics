package edu.hcmute.mobile_ute.buoi2

fun main() {
    val canNang = 65.0
    val chieuCao = 1.8
    val chiSoBMI = canNang / (chieuCao * chieuCao)
    val nhanPhanLoai: String

    if (chiSoBMI < 18.5) {
        nhanPhanLoai = "Gầy"
    } else if (chiSoBMI < 25.0) {
        nhanPhanLoai = "Bình thường"
    } else if (chiSoBMI < 30.0) {
        nhanPhanLoai = "Thừa cân"
    } else {
        nhanPhanLoai = "Béo phì"
    }
    println("Chỉ số BMI tính được: $chiSoBMI")
    println("Phân loại: $nhanPhanLoai")
}
