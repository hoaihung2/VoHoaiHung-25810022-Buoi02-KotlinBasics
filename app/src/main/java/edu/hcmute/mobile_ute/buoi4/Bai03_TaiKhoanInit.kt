package edu.hcmute.mobile_ute.buoi4

class TaiKhoanNganHang(val soTaiKhoan: String, soDuBanDau: Double) {
    var soDu: Double = soDuBanDau

    init {
        if (soDuBanDau < 0) {
            println("So du khong hop le")
        } else {
            println("Tao tai khoan thanh cong, so du ban dau: $soDuBanDau")
        }
    }
}

fun main() {
    val taiKhoan1 = TaiKhoanNganHang("001", 500000.0)
    val taiKhoan2 = TaiKhoanNganHang("002", -100.0)
}