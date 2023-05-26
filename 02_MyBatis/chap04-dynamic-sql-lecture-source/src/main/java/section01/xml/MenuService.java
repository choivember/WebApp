package section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

public class MenuService {

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO>
    }
}
