package edu.hcmute.mobile_ute.buoi2

fun main() {
    var soTruoc = 0
    var soSau = 1
    var chiSo = 0

    println("Dãy số Fibonacci nhỏ hơn 100:")

    for (i in 0..100) {
        if (soTruoc >= 100) {
            break
        }
        println("Vị trí $chiSo: $soTruoc")

        val soTiepTheo = soTruoc + soSau
        soTruoc = soSau
        soSau = soTiepTheo
        chiSo++
    }
}
