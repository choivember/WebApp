package section02.update;

import model.dto.MenuDTO;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import static common.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {

//        1. 메뉴 수정 정보(메뉴명, 가격, 판매여부)를 사용자에게 입력받아 수정해야 합니다.
//        2. 사용자에게 받은 값을 dto 객체로 뭉쳐서 기능을 수행해야 합니다.
//        3. 메뉴 수정 성공과 실패 시 각각 결과 메시지를 출력합니다.

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        MenuDTO menuDTO = new MenuDTO();
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));
            String query = prop.getProperty("updateMenu");

            Scanner sc = new Scanner(System.in);
            System.out.print("변경할 메뉴의 이름를 입력하세요 : ");
            String menuName = sc.nextLine();
            System.out.print("변경할 메뉴의 가격를 입력하세요 : ");
            int menuPrice = sc.nextInt();
            sc.nextLine();
            System.out.print("판매 여부를 결정하세요(Y/N) : ");
            String orderableStatus = sc.nextLine().toUpperCase();

            menuDTO.setName(menuName);
            menuDTO.setPrice(menuPrice);
            menuDTO.setOrderableStatus(orderableStatus);

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, menuDTO.getPrice());
            pstmt.setString(2, menuDTO.getName());
            pstmt.setString(3, menuDTO.getOrderableStatus());
            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result >= 0) {
            System.out.println("메뉴 수정 성공");
            System.out.println("result = " + result);
        } else {
            System.out.println("메뉴 수정 실패");
            System.out.println("result = " + result);
        }
    }
}