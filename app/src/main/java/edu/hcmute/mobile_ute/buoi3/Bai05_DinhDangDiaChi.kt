package edu.hcmute.mobile_ute.buoi3

fun dinhDangDiaChi(
    hoTen: String,
    soDienThoai: String,
    soNha: String = "chưa rõ",
    tenDuong: String = "chưa rõ",
    thanhPho: String = "chưa rõ"
): String {
    return "$hoTen - $soDienThoai - $soNha, $tenDuong, $thanhPho"
}

fun main() {
    val diaChiThuNhat = dinhDangDiaChi(
        "Phạm Thị Dung",
        "0901234567",
        soNha = "12A",
        tenDuong = "Nguyễn Trãi",
        thanhPho = "Tây Ninh"
    )

    val diaChiThuHai = dinhDangDiaChi(
        hoTen = "Hoàng Văn Em",
        soDienThoai = "0912345678",
        thanhPho = "Hồ Chí Minh"
    )

    println(diaChiThuNhat)
    println(diaChiThuHai)
}
