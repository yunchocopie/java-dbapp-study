package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // 소켓 객체를 만들어주는 것
    public static Connection getInstance(){
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        // 프로토몰이 적용된 소켓
        // 예외 발생 가능
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("db connection success");
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
