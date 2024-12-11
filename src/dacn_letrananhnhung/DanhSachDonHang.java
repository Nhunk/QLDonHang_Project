package dacn_letrananhnhung;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class DanhSachDonHang {
    ArrayList<DonHang> dsdh = new ArrayList<DonHang>();

    public ArrayList<DonHang> getDSDH() {
        return dsdh;
    }

    public void setDSDH(ArrayList<DonHang> dsdh) {
        this.dsdh = dsdh;
    }

    public Connection connect() {
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=donhang;user=sa;password=02042004;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ArrayList<DonHang> inData() throws SQLException {
        // ArrayList<DonHang> dsdh = new ArrayList<DonHang>();
        String sql = "SELECT * FROM DSDONHANG";
        Connection conn = connect();
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(sql);
        while (rs.next()) {
            String maDH = rs.getString("maDH");
            String tenKH = rs.getString("tenKH");
            String diaChi = rs.getString("diaChi");
            String tenSP = rs.getString("tenSP");
            float donGia = rs.getFloat("donGia");
            int soLuong = rs.getInt("soLuong");
            Date ngayDat = rs.getDate("ngayDat");
            String trangThai = rs.getString("trangThai");
            dsdh.add(new DonHang(maDH, tenKH, diaChi, tenSP, donGia, soLuong, ngayDat, trangThai));
        }

        return dsdh;
    }

    public boolean themMoi(String maDH, String tenKH, String diaChi, String tenSP, float donGia, int soLuong,
            Date ngayDat, String trangThai) throws SQLException {
        for (int i = 0; i < dsdh.size(); i++) {
            if (dsdh.get(i).getMaDH().equalsIgnoreCase(maDH)) {
                return false;
            }
        }
        String sql = "INSERT INTO DSDONHANG (maDH, tenKH, diaChi, tenSP, donGia, soLuong, ngayDat, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, maDH);
            pst.setString(2, tenKH);
            pst.setString(3, diaChi);
            pst.setString(4, tenSP);
            pst.setFloat(5, donGia);
            pst.setInt(6, soLuong);
            pst.setDate(7, new java.sql.Date(ngayDat.getTime()));
            pst.setString(8, trangThai);
            pst.executeUpdate();

            dsdh.add(new DonHang(maDH, tenKH, diaChi, tenSP, donGia, soLuong, ngayDat, trangThai));
            return true;
        }

    }

    public boolean edit(String maDH, String tenKH, String diaChi, String tenSP, float donGia, int soLuong,
            Date ngayDat, String trangThai) throws SQLException {
        for (DonHang dh : dsdh) {
            if (dh.getMaDH().equalsIgnoreCase(maDH)) {
                dh.setTenKH(tenKH);
                dh.setDiaChi(diaChi);
                dh.setTenSP(tenSP);
                dh.setDonGia(donGia);
                dh.setSoLuong(soLuong);
                dh.setNgayDat(ngayDat);
                dh.setTrangThai(trangThai);
                String sql = "UPDATE DSDONHANG SET tenKH = N'" + tenKH + "', diaChi = N'" + diaChi + "', tenSP = N'"
                        + tenSP + "', donGia = " + donGia + ", soLuong = " + soLuong + ", ngayDat = '"
                        + DonHang.chuyenNgayThanhChuoi(ngayDat)
                        + "', trangThai = N'" + trangThai + "' WHERE maDH = '" + maDH + "'";
                try (Connection conn = connect();
                        PreparedStatement pst = conn.prepareStatement(sql)) {

                    pst.setString(1, tenKH);
                    pst.setString(2, diaChi);
                    pst.setString(3, tenSP);
                    pst.setFloat(4, donGia);
                    pst.setInt(5, soLuong);
                    pst.setDate(6, new java.sql.Date(ngayDat.getTime()));
                    pst.setString(7, trangThai);
                    pst.setString(8, maDH);
                    pst.executeUpdate();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(String maDH) throws SQLException {
        for (int i = 0; i < dsdh.size(); i++) {
            if (dsdh.get(i).getMaDH().equalsIgnoreCase(maDH)) {
                dsdh.remove(i);
                String sql = "DELETE FROM DSDONHANG WHERE maDH = '" + maDH + "'";
                Connection conn = connect();
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                return true;
            }
        }
        return false;
    }

    public List<DonHang> timKiemMaDH(String tim) {
        List<DonHang> result = new ArrayList<>();
        for (DonHang dh : dsdh) {
            if (dh.getMaDH().toLowerCase().contains(tim.toLowerCase())) {
                result.add(dh);
            }
        }
        return result;
    }

    public boolean kiemTraTimKiem(String timKiem) {
        for (DonHang dh : dsdh) {
            if (dh.getMaDH().toLowerCase().contains(timKiem.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public List<DonHang> timKiemTheoTrangThai(String trangThai) {
        List<DonHang> result = new ArrayList<>();
        for (DonHang dh : dsdh) {
            if (dh.getTrangThai().toLowerCase().contains(trangThai.toLowerCase())) {
                result.add(dh);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DanhSachDonHang danhSach = new DanhSachDonHang();
        try {
            ArrayList<DonHang> dsdh = danhSach.inData();
            for (DonHang donHang : dsdh) {
                System.out.println(donHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
