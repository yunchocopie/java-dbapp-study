package db;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    // 리턴타입 적을 수 없다
    // 매개 변수를 적을 수 없다
    // @Test 룰 붙이면 메서드 별로 실행 가능
    @Test
    public void getInstance_test() {
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        // 프로토몰이 적용된 소켓
        // 예외 발생 가능
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
