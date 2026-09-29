package edu.hcmute.mobile_ute.buoi4

fun String.demNguyenAm(): Int {
    var dem = 0
    for (kyTu in this.lowercase()) {
        if (kyTu in "aeiou") {
            dem++
        }
    }
    return dem
}

fun Int.laSoNguyenTo(): Boolean {
    if (this < 2) return false
    var i = 2
    while (i * i <= this) {
        if (this % i == 0) return false
        i++
    }
    return true
}

fun main() {
    val cacChuoi = listOf("Kotlin", "Android Studio", "XYZ")
    for (chuoi in cacChuoi) {
        println("\"$chuoi\" co ${chuoi.demNguyenAm()} nguyen am")
    }

    val cacSo = listOf(7, 12, 29, 1)
    for (so in cacSo) {
        println("$so la so nguyen to: ${so.laSoNguyenTo()}")
    }
}