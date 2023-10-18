package test.labor_costs_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;
import test.base.BaseTest;

import java.util.concurrent.TimeUnit;

import static constants.Constant.Urls.LOG_IN_URL;

public class LaborCostsTests extends BaseTest {
    @Test
    public void checkSumOfReason() throws InterruptedException {
        basePage.open(LOG_IN_URL);
        sutHomePage.logIn();
        laborCostsPage.selectWeekPeriodOnLaborCost();
        int sumInWeek = laborCostsPage.inputWorkHour();
        TimeUnit.SECONDS.sleep(3);
        sutHomePage.goToPivotPage();
        TimeUnit.SECONDS.sleep(5);
        pivotPage.selectWeekPeriodOnLabor();
        int outputSum = pivotPage.getAvroraSum();
        Assert.assertEquals(sumInWeek, outputSum);


    }

}
