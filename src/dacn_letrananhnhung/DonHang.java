package dacn_letrananhnhung;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DonHang implements IDonHang {

    String maDH, tenKH, diaChi,tenSP, trangThai;
    float donGia;
    int soLuong;
    Date ngayDat;

    public DonHang() {
    }

    public DonHang(String maDH, String tenKH, String diaChi, String tenSP , float donGia, int soLuong, Date ngayDat,String trangThai) {
        this.maDH = maDH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ngayDat = ngayDat;
        this.trangThai = trangThai;
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
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public static Date chuyenChuoiThanhNgay(String str) throws ParseException{
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
    public static String dinhDangSo(float n){
       DecimalFormat df=new DecimalFormat("###,###.0");
        return df.format(n); 
    }
    @Override
    public float thanhTien(){
        return donGia*soLuong;
    }

    @Override
    public String toString(){
        return maDH + ", "+tenKH + ", "+diaChi+", "+tenSP+", "+donGia+", "+soLuong+", "+chuyenNgayThanhChuoi(ngayDat)+", "+trangThai+", "+dinhDangSo(thanhTien());
    }
}
