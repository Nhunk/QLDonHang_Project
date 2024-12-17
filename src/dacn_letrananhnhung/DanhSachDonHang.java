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

    private String NewOrderID() throws SQLException {
        String sql = "SELECT MAX(CAST(maDH AS INT)) AS maxID\n"
                + //
                "FROM DSDonHang;";
        try (Connection conn = connect(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                int maxID = rs.getInt("maxID");
                return String.valueOf(maxID + 1);
            }
        }
        return "1";
    }

    public boolean themMoi(String tenKH, String diaChi, String tenSP, float donGia, int soLuong, Date ngayDat,
            String trangThai) throws SQLException {
        String maDH = NewOrderID();
        String sql = "INSERT INTO DSDONHANG (maDH, tenKH, diaChi, tenSP, donGia, soLuong, ngayDat, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = connect(); PreparedStatement pst = conn.prepareStatement(sql)) {

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
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean edit(String maDH, String tenKH, String diaChi, String tenSP, float donGia, int soLuong, Date ngayDat,
            String trangThai) throws SQLException {
        for (DonHang dh : dsdh) {
            if (dh.getMaDH().equalsIgnoreCase(maDH)) {
                String sql = "UPDATE DSDONHANG SET tenKH = ?, diaChi = ?, tenSP = ?, donGia = ?, soLuong = ?, ngayDat = ?, trangThai = ? WHERE maDH = ?";
                try (Connection conn = connect(); PreparedStatement pst = conn.prepareStatement(sql)) {

                    pst.setString(1, tenKH);
                    pst.setString(2, diaChi);
                    pst.setString(3, tenSP);
                    pst.setFloat(4, donGia);
                    pst.setInt(5, soLuong);
                    pst.setDate(6, new java.sql.Date(ngayDat.getTime()));
                    pst.setString(7, trangThai);
                    pst.setString(8, maDH);
                    pst.executeUpdate();

                    dh.setTenKH(tenKH);
                    dh.setDiaChi(diaChi);
                    dh.setTenSP(tenSP);
                    dh.setDonGia(donGia);
                    dh.setSoLuong(soLuong);
                    dh.setNgayDat(ngayDat);
                    dh.setTrangThai(trangThai);
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false; // Order ID not found
    }

    public boolean delete(String maDH) throws SQLException {
        for (int i = 0; i < dsdh.size(); i++) {
            if (dsdh.get(i).getMaDH().equalsIgnoreCase(maDH)) {
                dsdh.remove(i);
                String sql = "DELETE FROM DSDONHANG WHERE maDH = ?";
                try (Connection conn = connect(); PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setString(1, maDH);
                    pst.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    public List<DonHang> timKiemMaDH(String tim) {
        List<DonHang> result = new ArrayList<>();
        for (DonHang dh : dsdh) {
            if (dh.getMaDH().equalsIgnoreCase(tim)) {
                result.add(dh);
            }
        }
        return result;
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
