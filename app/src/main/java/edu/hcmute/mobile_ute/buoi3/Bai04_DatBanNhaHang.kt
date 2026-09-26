package edu.hcmute.mobile_ute.buoi3

fun datBan(tenKhachHang: String, soLuongKhach: Int, loaiBan: String = "bàn thường") {
    println("Khách hàng $tenKhachHang đặt $soLuongKhach chỗ, loại bàn: $loaiBan")
}

fun main() {
    datBan("Vo Hoai Hung", 4)
    datBan("Vo Hoai Hung 2", 2, "bàn VIP")
    datBan(soLuongKhach = 6, tenKhachHang = "Vo Hoai Hung 9", loaiBan = "bàn ngoài trời")
}
