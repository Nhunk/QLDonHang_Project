package dacn_letrananhnhung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        try (Connection conn = connect();
                Statement stt = conn.createStatement();
                ResultSet rs = stt.executeQuery(sql)) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsdh;
    }

    public boolean themMoi(String maDH, String tenKH, String diaChi, String tenSP, float donGia, int soLuong,
            Date ngayDat, String trangThai) {
        for (int i = 0; i < dsdh.size(); i++) {
            if (dsdh.get(i).getMaDH().equalsIgnoreCase(maDH)) {
                return false;
            }
        }
        String sql = "INSERT INTO DSDONHANG VALUES ('" + maDH + "', N'" + tenKH + "', N'" + diaChi + "', N'" + tenSP
                + "', " + donGia + ", " + soLuong + ", '" + ngayDat + "', N'" + trangThai + "')";
        Connection conn = connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            dsdh.add(new DonHang(maDH, tenKH, diaChi, tenSP, donGia, soLuong, ngayDat, trangThai));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean capNhatDH(String maDH, String tenKH, String diaChi, String tenSP, float donGia, int soLuong,
            Date ngayDat, String trangThai) {
        for (int i = 0; i < dsdh.size(); i++) {
            if (dsdh.get(i).getMaDH().equalsIgnoreCase(maDH)) {
                dsdh.get(i).setTenKH(tenKH);
                dsdh.get(i).setDiaChi(diaChi);
                dsdh.get(i).setTenSP(tenSP);
                dsdh.get(i).setDonGia(donGia);
                dsdh.get(i).setSoLuong(soLuong);
                dsdh.get(i).setNgayDat(ngayDat);
                dsdh.get(i).setTrangThai(trangThai);
                String sql = "UPDATE DSDONHANG SET tenKH = N'" + tenKH + "', diaChi = N'" + diaChi + "', tenSP = N'"
                        + tenSP + "', donGia = " + donGia + ", soLuong = " + soLuong + ", ngayDat = '" + ngayDat
                        + "', trangThai = N'" + trangThai + "' WHERE maDH = '" + maDH + "'";
                Connection conn = connect();
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }
    public boolean xoaDH(String maDH) {
        for (int i = 0; i < dsdh.size(); i++) {
            if (dsdh.get(i).getMaDH().equalsIgnoreCase(maDH)) {
                dsdh.remove(i);
                String sql = "DELETE FROM DSDONHANG WHERE maDH = '" + maDH + "'";
                Connection conn = connect();
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }
    
    public String timKiemMaDH(String tim) {
        String x = null;
        for (DonHang dh : dsdh) {
            if (dh.getMaDH().equalsIgnoreCase(tim)) {
                x = dh.toString();
            }
        }
        return x;
    }

    public boolean kiemTraTimKiem(String timKiem) {
        for (DonHang dh : dsdh) {
            if (dh.getMaDH().equalsIgnoreCase(timKiem)) {
                return true;
            }
        }
        return false;
    }

    public List<DonHang> timKiemTheoTrangThai(String trangThai) {
        List<DonHang> result = new ArrayList<>();
        for (DonHang dh : dsdh) {
            if (dh.getTrangThai().equalsIgnoreCase(trangThai)) {
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
