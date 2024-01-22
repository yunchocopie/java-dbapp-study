package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankDAOTest {

    @Test
    public void selectAll_test() {
        // given 필요없음

        // when
        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList);
    }

    @Test
    public void selectByNumber_test() {
        // given
        int number = 3;

        // when
        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);

        // then
        if (account == null) {
            System.out.println(number + "로 조회된 값이 없습니다.");
        } else {
            System.out.println(account);

//            System.out.println(account.getNumber());
//            System.out.println(account.getPassword());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCreatedAt());
        }
    }

    @Test
    public void deleteByNumber_test() {
        // given
        int number = 1;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(number);

        // then
        if (result == 1) {
            System.out.println("삭제 성공");
        } else if (result == 0) {
            System.out.println(number + "번호를 찾을 수 없습니다." );
        } else {
            System.out.println("삭제 실패");
        }
    }

    @Test
    public void insert() {
        // given
        String password = "0000";
        int balance = 1000;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password, balance);

        // then
        if (result == 1) {
            System.out.println("삽입 성공");
        } else if (result == 0) {
            System.out.println("번호를 찾을 수 없습니다." );
        } else {
            System.out.println("삽입 실패");
        }
    }

    @Test
    public void updateByNumber() {
        // given
        int balance = 10000;
        int number = 3;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.updateByNumber(balance, number);

        // then
        if (result == 1) {
            System.out.println("업데이트 성공");
        } else if (result == 0) {
            System.out.println("번호를 찾을 수 없습니다." );
        } else {
            System.out.println("업데이트 실패");
        }
    }
}
