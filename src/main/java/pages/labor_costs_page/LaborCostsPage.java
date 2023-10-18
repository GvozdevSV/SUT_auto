package pages.labor_costs_page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

public class LaborCostsPage extends BasePage {
    public LaborCostsPage(WebDriver driver) {
        super(driver);
    }

    //Переход на страницу трудозатрат
    private final By tabActivity = By.cssSelector("div[id='activity']");
    private final By tabLaborCostsTable = By.cssSelector("a[href=\"/\"]");
    //Изменение отображение таблици по неделям
    private final By periodSelectButton = By.cssSelector("div[class=\"MuiInput-root MuiInputBase-root MuiInputBase-colorPrimary onboaring__period-select css-1wjoqn2\"]");
    private final By weekPeriodSelect = By.cssSelector("li[data-value=\"week\"]");
    //все дни на проекте Аврора
    //private final By avroraString = By.xpath("//div[@aria-label=\"Avrora\"]//ancestor::div[@class=\"MuiBox-root css-j7qwjs\"]");
    private final By inputMonday = By.xpath("//div[@aria-label=\"Avrora\"]//ancestor::div[@class=\"MuiBox-root css-j7qwjs\"]//div[2]//input");
    private final By inputFriday = By.xpath("//div[@aria-label=\"Avrora\"]//ancestor::div[@class=\"MuiBox-root css-j7qwjs\"]//div[6]//input");
    private final By saveButton = By.cssSelector("button[type=\"submit\"]");
    // previous кнопки вперед назад
    private final By previousPeriodButton = By.cssSelector("button[class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium css-18wlvvu\"]");
    private final By nextPeriodButton = By.xpath("//button[contains(@class,\"onboarding__next-quarter\")]");


    public void goToLaborCostsPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tabActivity)).build().perform();
        driver.findElement(tabLaborCostsTable).click();
    }
    public void selectWeekPeriodOnLaborCost(){
        waitElementIsVisible(driver.findElement(periodSelectButton)).click();
        waitElementIsVisible(driver.findElement(weekPeriodSelect)).click();
    }
    //выбрать подходящий проеккт где списано 0 за неделю и запомнить его
    // Так как есть проекты где обязательно указывать причину списания и где не обязательно я просто изначально выбиру самый первый проект. Если этого проекта нет
    // алгоритм не будет работать
    public void inputTime(By element, String keyToSend){
        waitElementIsVisible(driver.findElement(element)).click();
        waitElementIsVisible(driver.findElement(element)).sendKeys(keyToSend);
        waitElementIsVisible(driver.findElement(element)).sendKeys(Keys.RETURN);
    }

    public int inputWorkHour(){
        String mondayWork = "3";
        String fridayWork = "6";
        String previousFridayWork = "7";
        String nextMondayWork = "9";
        inputTime(inputMonday, mondayWork);
        inputTime(inputFriday, fridayWork);
        waitElementIsVisible(driver.findElement(saveButton)).click();
        waitElementIsVisible(driver.findElement(previousPeriodButton)).click();
        inputTime(inputFriday, previousFridayWork);
        waitElementIsVisible(driver.findElement(saveButton)).click();
        waitElementIsVisible(driver.findElement(nextPeriodButton)).click();
        waitElementIsVisible(driver.findElement(nextPeriodButton)).click();
        inputTime(inputMonday, nextMondayWork);
        waitElementIsVisible(driver.findElement(saveButton)).click();
        int sumInWeek = Integer.parseInt(mondayWork) + Integer.parseInt(fridayWork);
        System.out.println(sumInWeek);
        return sumInWeek;
    }

    //списать на текущей недел в понедельник и в пятницу
    //перейти на предыдущюю неделю и списать в пятницу
    //перейти на сл

}
