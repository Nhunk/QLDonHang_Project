package dacn_letrananhnhung;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DonHang implements IDonHang {

    String maDH, tenKH, diaChi,tenSP, trangThai;
    float donGia;
    int soLuong;
    Date ngayDat;

    public DonHang() {
    }

    public DonHang(String maDH, String tenKH, String diaChi, String tenSP,String trangThai , float donGia, int soLuong, Date ngayDat) {
        this.maDH = maDH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ngayDat = ngayDat;
    }

    

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public static Date chuyenChuoiThanhNgay(String str) {
        try {
            return new SimpleDateFormat("đ/MM/yyyy").parse(str);

        } catch (Exception e) {
            System.out.println("Loi dinh dang ngay! " + e.getMessage());
        }
        return null;
    }

    public static String chuyenNgayThanhChuoi(Date ngay) {
        return new SimpleDateFormat("dd/MM/yyyy").format(ngay);
    }
    public static String dinhDangSo(double n){
       DecimalFormat df=new DecimalFormat("###,###.0");
        return df.format(n); 
    }
    @Override
    public double thanhTien(){
        return donGia*soLuong;
    }

    @Override
    public String toString(){
        return maDH + ", "+tenKH + ", "+diaChi+", "+tenSP+","+donGia+", "+soLuong+", "+chuyenNgayThanhChuoi(ngayDat)+", "+trangThai+", "+dinhDangSo(thanhTien());
    }
}
