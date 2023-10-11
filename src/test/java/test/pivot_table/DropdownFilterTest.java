package test.pivot_table;

import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.pivot_page.PivotPage;
import test.base.BaseTest;

import java.util.concurrent.TimeUnit;

import static constants.Constant.Urls.PIVOT_TABLE_PROJECT_URL;

public class DropdownFilterTest extends BaseTest {
    @Test
    public void DropdownFilter() throws InterruptedException {
        basePage.open(PIVOT_TABLE_PROJECT_URL);
        sutHomePage.logIn();
        TimeUnit.SECONDS.sleep(5);
        pivotPage.openFilter();
        pivotPage.checkDropdown();

    }

}
