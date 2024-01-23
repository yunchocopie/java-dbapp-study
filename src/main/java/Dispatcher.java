import controller.BankController;
import controller.RequestMapping;
import lombok.AllArgsConstructor;

import java.lang.reflect.Method;

/**
 * 책임 : 라우팅
 */
public class Dispatcher {

    private BankController con;

    public Dispatcher(BankController con) {
        this.con = con;
    }

    public void route(String path) {
        Method[] methods = con.getClass().getDeclaredMethods(); // 메서드 다 들고오기

        for (Method method : methods) {
            //System.out.println(method.getName());
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;
            if (rm.uri().equals(path)) { // 글자 같으면
                try {
                    method.invoke(con); // con.login();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        // 라우터, 디스패쳐
//        if (url.equals("insert")) {
//            con.insert();
//        } else if (url.equals("delete")) {
//            con.delete();
//        } else if (url.equals("update")) {
//            con.update();
//        } else if (url.equals("selectOne")) {
//            con.selectOne();
//        } else if (url.equals("selectAll")) {
//            con.selectAll();
//        }
    }
}
