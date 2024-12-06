package dacn_letrananhnhung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DanhSachDonHang {

    public static void main(String[] args) {
        try {
            // Đảm bảo tên driver chính xác
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Chuỗi kết nối đúng cú pháp
            String url = "jdbc:sqlserver://localhost:1433;databaseName=donhang;user=sa;password=02042004;encrypt=true;trustServerCertificate=true;";

            // Kết nối
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Kết nối thành công");
            ResultSet rs = null;
            String sql = "SELECT * FROM DSDONHANG";
            Statement stt = conn.createStatement();
            rs = stt.executeQuery(sql);
            while(rs.next()){
                String maDH=rs.getString("maDH");
                System.out.println(maDH);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver không tìm thấy");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Kết nối không thành công");
            e.printStackTrace();
        }
    }
}
