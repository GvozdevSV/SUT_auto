package test.labor_costs_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.BaseTest;

import java.util.concurrent.TimeUnit;

import static constants.Constant.Urls.LOG_IN_URL;

public class LaborCostsTests extends BaseTest {
    //Тест 3.2.2.1 Проверка правильности подсчета трудозатрат за неделю при отображении "Сводной таблицы" "За неделю".
    @Test
    public void checkSumOfReason() throws InterruptedException {
        basePage.open(LOG_IN_URL);
        sutHomePage.logIn();
        //создаем проект
        createProjectPage.goToCreateProjectDrawer();
        createProjectPage.createProject();
        //заполняем таблицу трудозатрат
        laborCostsPage.goToLaborCostsPage();
        laborCostsPage.selectWeekPeriodOnLaborCost();
        int sumInWeek = laborCostsPage.inputWorkHour();
        TimeUnit.SECONDS.sleep(1);
        //берем значение из сводной таблицы
        sutHomePage.goToPivotPage();
        TimeUnit.SECONDS.sleep(2);
        pivotPage.selectWeekPeriodOnLabor();
        int outputSum = pivotPage.geATPSum();
        //сравниваем значение суммы трудозатрат за неделю с значением сводной таблицы
        Assert.assertEquals(sumInWeek, outputSum);
        //очищаем таблицу трудозатрат
        laborCostsPage.goToLaborCostsPage();
        laborCostsPage.clearMonthWorkHour();
        //удаляем проект
        createProjectPage.goToAllProjectPage();
        createProjectPage.deleteProject();
    }

}
