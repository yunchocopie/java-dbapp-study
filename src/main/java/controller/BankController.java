package controller;

import dao.BankDAO;
import lombok.AllArgsConstructor;

/**
 * 책임 : 유효성검사 (바디데이터), 파싱 (바디데이터), 적절한 DAO 찾기
 */

@AllArgsConstructor
public class BankController {

    private BankDAO dao; // 한 번만 new 하면 되게

    @RequestMapping(uri="/insert")
    public void insert() {
        System.out.println("Controller : insert");
        dao.insert("1234", 1000);
    }

    @RequestMapping(uri="/delete")
    public void delete() {
        System.out.println("Controller : delete");
        dao.deleteByNumber(1);
    }

    @RequestMapping(uri="/update")
    public void update() {
        System.out.println("Controller : update");
        dao.updateByNumber(1000, 1);
    }

    @RequestMapping(uri="/selectOne")
    public void selectOne() {
        System.out.println("Controller : selectOne");
        dao.selectByNumber(1);
    }

    @RequestMapping(uri="/selectAll")
    public void selectAll() {
        System.out.println("Controller : selectAll");
        dao.selectAll();
    }
}
