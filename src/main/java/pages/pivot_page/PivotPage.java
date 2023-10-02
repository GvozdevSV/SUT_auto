package pages.pivot_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class PivotPage extends BasePage {

    public PivotPage(WebDriver driver) {
        super(driver);
    }

    private final By tabAnalytics = By.cssSelector("div[id='analytics']");
    private final By tabPivotTable = By.cssSelector("div[id=\"analytics\"]");
    private final By PivotDropdownButton = By.cssSelector("button[class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeSmall MuiButton-textSizeSmall MuiButton-disableElevation MuiButtonBase-root css-1v7gybn']");
    private final By AllFilterTab = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //блок "Таблица"
    private final By tabBlock = By.xpath("//h6[text()='Таблица']");
    //чекбокс для отображения неактивных пользователей
    private final By notActiveUserCheckbox = By.xpath("//p[text()='Неактивные пользователи']");
    //чекбокс для отображения неактивных проектов
    private final By notActiveProjectCheckbox = By.xpath("//p[text()='Неактивные проекты']");
    //блок "Роль в проекте"
    private final By projectRuleBlock = By.xpath("//h6[text()='Роль в проекте']");
    //радиобатон все проекты(выбран по умолчанию)
    private final By allProjectsRadiobutton = By.xpath("//p[text()='Bсе проекты']");
    //радиобатон мои проекты
    private final By myProjectsRadiobutton = By.xpath("//p[text()='Мои проекты']");
    //радиобатон участник
    private final By userRadiobutton = By.xpath("//p[text()='Участник']");
    //радиобатон руководитель проекта
    //private final By leadProjectRadiobutton = By.xpath("//h6[text()='Роль в проекте']");
    //блок "Форма трудоустройства"
    private final By formWorkBlock = By.xpath("//h6[text()='Форма трудоустройства']");
    //чекбокс для отображения пользователей с почасовой оплатой(выбран по умолчанию)
    private final By hourPayUsersCheckbox = By.xpath("//p[text()='Почасовая оплата']");
    //чекбокс для отображения пользователей на окладе(выбран по умолчанию)
    private final By monthPayUsersCheckbox = By.xpath("//p[text()='По окладу']");
    //блок "Филиалы"
    private final By filialBlock = By.xpath("//h6[text()='Филиалы']");
    //поле с текстовым фильтром и дропдауном с вариантами всех филиалов (данные подтягиваются из раздела филиалов)
    private final By filialDropdown = By.cssSelector("input[id=\"mui-326\"]");
    //значение "Все филиалы"(выбран по умолчанию)
    // значение "Пользователи без филиалов"

    public PivotPage openFilter(){
        driver.findElement(PivotDropdownButton).click();
        return this;

    }
    public PivotPage checkDropdown(){

        //System.out.println(allDropdownText);


        WebElement tabBlockText = driver.findElement(tabBlock);
        WebElement notActiveUserCheckboxText = driver.findElement(notActiveUserCheckbox);
        WebElement notActiveProjectCheckboxText = driver.findElement(notActiveProjectCheckbox);
        WebElement projectRuleBlockText = driver.findElement(projectRuleBlock);
        WebElement allProjectsRadiobuttonText = driver.findElement(allProjectsRadiobutton);
        WebElement myProjectsRadiobuttonText = driver.findElement(myProjectsRadiobutton);
        WebElement userRadiobuttonText = driver.findElement(userRadiobutton);
        //WebElement leadProjectRadiobuttonText = driver.findElement(leadProjectRadiobutton);
        WebElement formWorkBlockText = driver.findElement(formWorkBlock);
        WebElement hourPayUsersCheckboxText = driver.findElement(hourPayUsersCheckbox);
        WebElement monthPayUsersCheckboxText = driver.findElement(monthPayUsersCheckbox);
        WebElement filialBlockText = driver.findElement(filialBlock);
        WebElement filialDropdownText = driver.findElement(filialDropdown);


        Assert.assertTrue(tabBlockText.isDisplayed(), "Блок таблица отсутствует");
        Assert.assertTrue(notActiveUserCheckboxText.isDisplayed(), "Чек бокс активные пользователи отсутствует");
        Assert.assertTrue(notActiveProjectCheckboxText.isDisplayed(), "Чек бокс активные проекты отсутствует");
        Assert.assertTrue(projectRuleBlockText.isDisplayed(), "Блок проектные роли отсутствует");
        //Сделать ассерт на включенный радиобатон все проекты
        Assert.assertTrue(allProjectsRadiobuttonText.isDisplayed(), "Радиобаттон все проекты отсутствует");
        Assert.assertTrue(myProjectsRadiobuttonText.isDisplayed(), "Радиобаттон мои проекты отсутствует");
        Assert.assertTrue(userRadiobuttonText.isDisplayed(), "Радиобаттон участник отсутствует");
        //Assert.assertTrue(leadProjectRadiobuttonText.isDisplayed(), "Радиобаттон лидер отсутствует");
        Assert.assertTrue(formWorkBlockText.isDisplayed());
        Assert.assertTrue(hourPayUsersCheckboxText.isDisplayed());
        Assert.assertTrue(monthPayUsersCheckboxText.isDisplayed());
        Assert.assertTrue(filialBlockText.isDisplayed());
        Assert.assertTrue(filialDropdownText.isDisplayed());

        return this;


    }
}
