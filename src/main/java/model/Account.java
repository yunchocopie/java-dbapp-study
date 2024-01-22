package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * DB에 Select 한 데이터를 담기 위한 오브젝트
 */

@ToString
@AllArgsConstructor
@Getter
public class Account {
    private int number;
    private String password;
    private int balance;

    // java.sql
    // 카멜 표기법 사용
    private Timestamp createdAt;
}
