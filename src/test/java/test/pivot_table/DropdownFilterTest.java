package test.pivot_table;

import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.pivot_page.PivotPage;
import test.base.BaseTest;

import static constants.Constant.Urls.PIVOT_TABLE_PROJECT_URL;

public class DropdownFilterTest extends BaseTest {
    @Test
    public void DropdownFilter(){
        basePage.open(PIVOT_TABLE_PROJECT_URL);
        sutHomePage.logIn();
        pivotPage.openFilter();
        //pivotPage.checkDropdown();

    }

}
