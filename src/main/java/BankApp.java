import controller.BankController;
import controller.RequestMapping;
import dao.BankDAO;

import java.lang.reflect.Method;

public class BankApp {
    public static void main(String[] args) {
        String url = "/selectOne";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con);
        dis.route(url);

    }
}
