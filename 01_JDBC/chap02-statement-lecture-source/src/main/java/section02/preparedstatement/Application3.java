package section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application3 {
    public static void main(String[] args) {
        /* 1. Connection 생성 */
        Connection con = getConnection();

        /* 2. PreparedStatement, ResultSet 생성 */
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 3. Scanner를 활용하여 조회할 사번 입력받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번을 입력해주세요. : ");
        String empId = sc.nextLine();

        /* 4. 조회를 위한 쿼리 작성 (placeholder 사용) */
        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?";

        /* 5. prepareStatement 생성 및 쿼리 준비 */
        try {
            pstmt = con.prepareStatement(query);

            /* 6. 조건에 해당하는 사번 세팅 */
            pstmt.setString(1,empId);
            rset = pstmt.executeQuery();

            /* 7. ResultSet에 존재하는 결과값을 출력 */
            if(rset.next()) {
                System.out.println(rset.getString("EMP_ID") + " : " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            /* 8. 자원 반납 */
            close(con);
            close(pstmt);
            close(rset);
        }
    }
}