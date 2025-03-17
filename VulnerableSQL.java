import java.sql.*;
import java.util.Scanner;

public class VulnerableSQL {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "pass");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + user + "'");

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
