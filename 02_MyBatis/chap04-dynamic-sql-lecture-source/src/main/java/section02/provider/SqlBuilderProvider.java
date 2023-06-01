package section02.provider;

import common.MenuDTO;
import common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilderProvider {

    public String registMenu(MenuDTO menu){
    SQL sql = new SQL();

    sql.INSERT_INTO("TBL_MENU")
            .VALUES("MENU_NAME", "#{ name }")
            .VALUES("MENU_PRICE", "#{ price }")
            .VALUES("CATEGORY_CODE", "#{ categoryCode }")
            .VALUES("ORDERABLE_STATUS", "#{ orderableStatus }");

    return sql.toString();
    }

    public String modifyMenu(MenuDTO menu){
        SQL sql = new SQL();
        sql.UPDATE("TBL_MENU")
                .SET("MENU_NAME = #{ name }")
                .SET("MENU_PRICE = #{ price }")
                .SET("CATEGORY_CODE = #{ categoryCode }")
                .SET("ORDERABLE_STATUS")
    }
}