package com.section03.remix;

import java.util.List;

public interface MenuMapper {

    List<>
    MenuDTO selectMenuByCode(int code);

    int insertMenu(MenuDTO menu);

    int deleteMenu(int code);

    int updateMenu(MenuDTO menu);
}
