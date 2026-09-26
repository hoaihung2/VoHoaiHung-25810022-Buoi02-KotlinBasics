package edu.hcmute.mobile_ute.buoi3

fun main() {
    val tuoiKhachHang = 36

    val loaiVe = if (tuoiKhachHang < 13) {
        "Vé trẻ em"
    } else if (tuoiKhachHang < 60) {
        "Vé người lớn"
    } else {
        "Vé cao tuổi"
    }

    println("Tuổi khách hàng: $tuoiKhachHang")
    println("Loại vé: $loaiVe")
}
