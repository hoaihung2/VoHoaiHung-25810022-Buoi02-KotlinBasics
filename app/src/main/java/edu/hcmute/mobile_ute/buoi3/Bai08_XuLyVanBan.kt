package edu.hcmute.mobile_ute.buoi3

fun xuLyVanBan(chuoiGoc: String, hamXuLy: (String) -> String): String {
    return hamXuLy(chuoiGoc)
}

fun vietHoaChuCai(chuoi: String): String {
    return chuoi.uppercase()
}

fun main() {
    val vanBanGoc = "chao mung ban den voi kotlin"
    val ketQuaThuNhat = xuLyVanBan(vanBanGoc, { chuoi -> chuoi.trim() })
    val ketQuaThuHai = xuLyVanBan(vanBanGoc, ::vietHoaChuCai)
    val ketQuaThuBa = xuLyVanBan(vanBanGoc) { chuoi -> chuoi.replace(" ", "_") }

    println("Kết quả cách 1: $ketQuaThuNhat")
    println("Kết quả cách 2: $ketQuaThuHai")
    println("Kết quả cách 3: $ketQuaThuBa")
}
