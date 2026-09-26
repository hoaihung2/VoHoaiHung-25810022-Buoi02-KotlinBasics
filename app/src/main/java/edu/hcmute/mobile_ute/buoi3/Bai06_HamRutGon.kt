package edu.hcmute.mobile_ute.buoi3

fun binhPhuongDayDu(soCanTinh: Int): Int {
    return soCanTinh * soCanTinh
}

fun chuViHinhVuongDayDu(canhHinhVuong: Double): Double {
    return canhHinhVuong * 4
}

fun kiemTraSoChanDayDu(soCanKiemTra: Int): Boolean {
    return soCanKiemTra % 2 == 0
}

fun binhPhuongRutGon(soCanTinh: Int): Int = soCanTinh * soCanTinh

fun chuViHinhVuongRutGon(canhHinhVuong: Double): Double = canhHinhVuong * 4

fun kiemTraSoChanRutGon(soCanKiemTra: Int): Boolean = soCanKiemTra % 2 == 0

fun main() {
    println("Bình phương đầy đủ: ${binhPhuongDayDu(5)}, rút gọn: ${binhPhuongRutGon(5)}")
    println("Chu vi hình vuông đầy đủ: ${chuViHinhVuongDayDu(3.0)}, rút gọn: ${chuViHinhVuongRutGon(3.0)}")
    println("Kiểm tra số chẵn đầy đủ: ${kiemTraSoChanDayDu(8)}, rút gọn: ${kiemTraSoChanRutGon(8)}")
}
