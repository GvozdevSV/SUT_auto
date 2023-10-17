package test.pivot_table;

import org.testng.annotations.Test;
import test.base.BaseTest;

import static constants.Constant.Urls.PIVOT_TABLE_PROJECT_URL;

public class DropdownFilterPivotPageTests extends BaseTest {
    //TK 1187  3.2.2.15.1. Фильтрация в сводной таблице на табе по проектам
    @Test
    public void CheckDropdownFilterTest() throws InterruptedException {
        basePage.open(PIVOT_TABLE_PROJECT_URL);
        sutHomePage.logIn();
        dropdownFilterPivotPage.openPivotDropdown();
        dropdownFilterPivotPage.checkBlockTitle();
        dropdownFilterPivotPage.getCheckboxText();
        dropdownFilterPivotPage.getAllRadiobuttonText();
        dropdownFilterPivotPage.getCheckedRadiobuttonText();
        dropdownFilterPivotPage.dropdownFilialIsDisplayed();
        dropdownFilterPivotPage.getIntegrationList();
        dropdownFilterPivotPage.haveSubmitAndBrakeButtons();


    }
}
