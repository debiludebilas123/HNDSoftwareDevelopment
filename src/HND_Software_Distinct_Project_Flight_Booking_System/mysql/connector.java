package HND_Software_Distinct_Project_Flight_Booking_System.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class connector {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/flight";
        String user = "root";
        String password = "9809";
        Connection conn = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "insert into route values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, "32");
            ps.setString(2, "Aza");
            ps.setString(3, "asd");
            ps.setString(4, "asd");
            ps.setString(5, "asd");

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}