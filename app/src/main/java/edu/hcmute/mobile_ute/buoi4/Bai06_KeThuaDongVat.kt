package edu.hcmute.mobile_ute.buoi4

open class DongVat(val ten: String) {
    open fun keu(): String {
        return "Dong vat keu"
    }
}

class Cho(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Gau gau"
    }
}

class Meo(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Meo meo"
    }
}

fun main() {
    val danhSach = listOf(Cho("Vang"), Meo("Mun"), Cho("Lu"))

    for (dongVat in danhSach) {
        println("${dongVat.ten}: ${dongVat.keu()}")
    }
}