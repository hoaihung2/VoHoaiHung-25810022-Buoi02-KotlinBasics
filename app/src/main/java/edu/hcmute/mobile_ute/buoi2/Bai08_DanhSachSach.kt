package edu.hcmute.mobile_ute.buoi2
fun main() {
    val danhSachSach = mutableListOf(
        "Nhà Giả Kim",
        "Đắc Nhân Tâm",
        "Tôi Thấy Hoa Vàng Trên Cỏ Xanh",
        "Sapiens",
        "Bố Già"
    )
    println("Danh sách ban đầu: $danhSachSach")

    danhSachSach.add("Nhà Việt Nam Học")
    danhSachSach.add("Chiến Binh Cầu Vồng")
    danhSachSach.remove("Bố Già")
    danhSachSach.sort()

    println("Danh sách sau khi thêm, xoá, sắp xếp: $danhSachSach")
}
