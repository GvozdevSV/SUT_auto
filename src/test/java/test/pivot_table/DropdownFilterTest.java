package test.pivot_table;

import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.pivot_page.PivotPage;
import test.base.BaseTest;

import java.util.concurrent.TimeUnit;

import static constants.Constant.Urls.PIVOT_TABLE_PROJECT_URL;

public class DropdownFilterTest extends BaseTest {
    //TK 1187  3.2.2.15.1. Фильтрация в сводной таблице на табе по проектам
    @Test
    public void DropdownFilter() throws InterruptedException {
        basePage.open(PIVOT_TABLE_PROJECT_URL);
        sutHomePage.logIn();
        pivotPage.openFilter();
        pivotPage.checkDropdown();

    }

}
