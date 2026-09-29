package edu.hcmute.mobile_ute.buoi4.bai05

class TaiKhoanNganHang(val soTaiKhoan: String, soDuBanDau: Double) {
    var soDu: Double = soDuBanDau

    init {
        if (soDuBanDau < 0) {
            println("So du khong hop le")
        } else {
            println("Tao tai khoan thanh cong, so du ban dau: $soDuBanDau")
        }
    }

    fun napTien(soTien: Double) {
        soDu += soTien
    }

    fun rutTien(soTien: Double): Boolean {
        if (soDu >= soTien) {
            soDu -= soTien
            return true
        }
        return false
    }
}

fun main() {
    val taiKhoan = TaiKhoanNganHang("001", 1000000.0)

    taiKhoan.napTien(500000.0)
    println("Sau khi nap 500000: ${taiKhoan.soDu}")

    println("Rut 300000: ${taiKhoan.rutTien(300000.0)}")
    println("So du: ${taiKhoan.soDu}")

    println("Rut 5000000: ${taiKhoan.rutTien(5000000.0)}")
    println("So du: ${taiKhoan.soDu}")
}