package section01.statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;

public class Application1 {

    public static void main(String[] args) {

        Connection con = getConnection();
        /* query 문을 저장하고 실행하는 기능을 하는 용도의 인터페이스 */
        Statement stmt = null;
        /* select 결과 집합을 받아올 용도의 인터페이스 */
        ResultSet rset = null;

        try{
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");


        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

    }

}
