package test.pivot_table;

import org.testng.annotations.Test;
import test.base.BaseTest;

import static constants.Constant.Urls.LOG_IN_URL;


public class AddNewUserTests extends BaseTest {
    //TK 280  4.2. Содержание дровера создания локального пользователя
    @Test
    public void AddNewUserTest(){
        basePage.open(LOG_IN_URL);
        sutHomePage.logIn();
        addNewUserPage.goTooNewUserDrover();
        addNewUserPage.getFIOFieldName();
        addNewUserPage.getOuterFieldPlaceholder();
        addNewUserPage.goToTabProject();
        addNewUserPage.addProjectButton();





    }



}
