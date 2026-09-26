package edu.hcmute.mobile_ute.buoi2

fun main() {
    val soDuBanDau: Double = 5_000_000.0
    var soDuHienTai: Double = soDuBanDau

    println("Số dư ban đầu: $soDuBanDau đồng")

    soDuHienTai += 2_000_000.0
    println("Số dư sau khi gửi thêm: $soDuHienTai đồng")

    soDuHienTai -= 1_500_000.0
    println("Số dư sau khi rút tiền: $soDuHienTai đồng")
    println("Số dư ban đầu để đối chiếu (không đổi): $soDuBanDau đồng")
}
