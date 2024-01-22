import dao.BankDAO;
import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // http://bank.com/account GET
        // http://bank.com/account/10 GET
        // http://bank.com/account POST -> 값이 필요함
        // http://bank.com/account/1 DELETE
        // http://bank.com/account/1 PUT

        // /account
        // /account/1
        // /account
        // /account/1
        // /account/1

        System.out.println("http 메서드를 입력하세요.");
        String method = sc.nextLine();

        System.out.println("식별자를 입력하세요.");
        String action = sc.nextLine();

        String body = ""; // post, put 만

        // 특정 숫자 적용 코드
        Pattern pattern = Pattern.compile("/account/(\\d+)");
        Matcher matcher = pattern.matcher(action);

        BankDAO bankDAO = new BankDAO();
        //GET
        if (method.equals("GET")) {
            if (action.equals("/account")) {
                List<Account> accountList = bankDAO.selectAll();
                System.out.println(accountList);
            } else if (action.equals("/account/1"))/*(matcher.matches())*/ { // 숫자 적용 코드
                Account account = bankDAO.selectByNumber(1);
                System.out.println(account);
//                String numberStr = matcher.group(1);
//                int accountNumber = Integer.parseInt(numberStr);
//                Account account = bankDAO.selectByNumber(accountNumber);
//                System.out.println(account);
            }


        // POST
        } else if (method.equals("POST")){
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            // password=1234&balance=1000
            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance = Integer.parseInt(st1[1].split("=")[1]);

            if (action.equals("/account")) {
                bankDAO.insert(password, balance);
            }


        // PUT
        } else if (method.equals("PUT")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            if (action.equals("/account/1")) {
                bankDAO.updateByNumber(Integer.parseInt(body), 1);
            }


        // DELETE
        } else if (method.equals("DELETE")) {
             if (action.equals("/account/1")) {
                bankDAO.deleteByNumber(1);
            }
        }
    }
}