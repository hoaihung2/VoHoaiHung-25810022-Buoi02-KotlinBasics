package edu.hcmute.mobile_ute.buoi4

class KhachHang(var ho: String, var ten: String) {
    var hoTen: String
        get() = "$ho $ten"
        set(value) {
            val chuoi = value.trim()
            val viTri = chuoi.lastIndexOf(' ')
            if (viTri == -1) {
                ho = ""
                ten = chuoi
            } else {
                ho = chuoi.substring(0, viTri)
                ten = chuoi.substring(viTri + 1)
            }
        }
}

fun main() {
    val khachHang = KhachHang("Nguyen Van", "An")
    println("Ho ten: ${khachHang.hoTen}")

    khachHang.ten = "Binh"
    println("Ho ten sau khi doi ten: ${khachHang.hoTen}")

    khachHang.hoTen = "Tran Thi Mai"
    println("Ho: ${khachHang.ho}")
    println("Ten: ${khachHang.ten}")
}