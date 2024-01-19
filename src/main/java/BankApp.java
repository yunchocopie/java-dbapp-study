import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        try {
            String insert = "insert into account_tb(password, balance, created_at) values(?, ?, now())";
            String update = "update account_tb set balance = balance + ? where number = ?";
            String delete = "delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(delete);
            pstmt.setString(1, "2");
//            pstmt.setInt(2, 1);
            int num = pstmt.executeUpdate();
            System.out.println(num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}