package edu.hcmute.mobile_ute.buoi3

fun main() {
    val danhSachNhacCu = listOf("guitar", "trong", "piano", "kèn", "violin", "kẻng", "sáo")
    val chuCaiCanLoc = "k"
    val ketQuaEager = danhSachNhacCu.filter { it.startsWith(chuCaiCanLoc) }
    val ketQuaLazy = danhSachNhacCu.asSequence().filter { it.startsWith(chuCaiCanLoc) }.toList()

    println("Kết quả lọc thông thường: $ketQuaEager")
    println("Kết quả lọc qua Sequence: $ketQuaLazy")
}
