package section01.insert;

import model.dto.MenuDTO;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application3 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();
        MenuDTO menu = null;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            menu = new MenuDTO();

            Scanner sc = new Scanner(System.in);
            System.out.print("메뉴의 이름을 입력하세요 : ");
            menu.setName(sc.nextLine());
            System.out.print("메뉴의 가격을 입력하세요 : ");
            menu.setPrice(sc.nextInt());
            System.out.print("카테고리 코드를 입력하세요 : ");
            menu.setCategoryCode(sc.nextInt());
            System.out.print("판매 여부를 결정하세요 (Y/N) : ");
            sc.nextLine();
            menu.setOrderableStatus(sc.nextLine());

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getName());
            pstmt.setInt(2, menu.getPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }
        if(result > 0) {
            System.out.println("메뉴 추가에 성공했습니다!!! :)");
        } else {
            System.out.println("메뉴 추가에 실패했습니다... :(");
        }



    }
}