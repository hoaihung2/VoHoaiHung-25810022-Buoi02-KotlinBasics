package edu.hcmute.mobile_ute.buoi3

fun main() {
    val kiemTraDoDai: (String) -> Boolean = { matKhau -> matKhau.length >= 8 }

    val matKhauThuNhat = "abc123"
    val matKhauThuHai = "matKhau2024"
    val matKhauThuBa = "12345678"

    println("$matKhauThuNhat -> ${kiemTraDoDai(matKhauThuNhat)}")
    println("$matKhauThuHai -> ${kiemTraDoDai(matKhauThuHai)}")
    println("$matKhauThuBa -> ${kiemTraDoDai(matKhauThuBa)}")
}
