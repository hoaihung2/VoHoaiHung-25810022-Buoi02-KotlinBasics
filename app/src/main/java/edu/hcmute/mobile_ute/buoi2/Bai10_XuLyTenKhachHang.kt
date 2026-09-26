package edu.hcmute.mobile_ute.buoi2
fun tinhDoDaiTen(tenKhachHang: String?): Int? {
    return tenKhachHang?.length
}

fun layTenHienThi(tenKhachHang: String?): String {
    return tenKhachHang ?: "khách vãng lai"
}

fun main() {
    val tenCoGiaTri: String? = "Trần Thị Hoa"
    val tenBiRong: String? = null

    println("Độ dài tên (safe call), có giá trị: ${tinhDoDaiTen(tenCoGiaTri)}")
    println("Độ dài tên (safe call), bị rỗng: ${tinhDoDaiTen(tenBiRong)}")

    println("Tên hiển thị (Elvis), có giá trị: ${layTenHienThi(tenCoGiaTri)}")
    println("Tên hiển thị (Elvis), bị rỗng: ${layTenHienThi(tenBiRong)}")

    val doDaiChacChan: Int = tenCoGiaTri!!.length
    println("Độ dài tên (dùng !!, chắc chắn không rỗng): $doDaiChacChan")
}
