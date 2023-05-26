package com.section02.javaconfig;

import com.section02..javaconfig.MenuDTO;
import com.section02.javaconfig.MenuService;
import com.section02.javaconfig.PrintResult;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult;

    private final MenuService menuService;

    public MenuController(){
        printResult = new PrintResult();
        menuService = new MenuService();
    }
    // 1. 전체 메뉴 조회하기
    public void selectAllMenu(){

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null){
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }
    // 2. 메뉴 코드로 메뉴 조회하기
    public void selectMenuByCode(Map<String, String> parameter){

        int code = Integer.parseInt(parameter.get("code"));
        com.section02.javaconfig.MenuDTO menu = menuService.selectMenuByCode(code);

        if (menu != null){
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    // 3. 메뉴 등록하기
    public void registMenu(Map<String, String> parameter){
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        com.section01.xmlconfig.MenuDTO menu = new com.section01.xmlconfig.MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if(menuService.registMenu(menu)){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }
    // 4. 메뉴 수정하기
    public void modifyMenu(Map<String, String> parameter){
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if(menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }
    // 5. 메뉴 삭제하기
    public void deleteMenu(Map<String, String> parameter){

        int code = Integer.parseInt(parameter.get("cdoe"));

        if(menuService.deleteMenu(code)){
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
