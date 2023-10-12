package pages.pivot_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.concurrent.TimeUnit;

public class PivotPage extends BasePage {

    public PivotPage(WebDriver driver) {
        super(driver);
    }


    private final By PivotDropdownButton = By.cssSelector("button[class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeSmall MuiButton-textSizeSmall MuiButton-disableElevation MuiButtonBase-root css-1v7gybn']");
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
    private final By allProjectsRadiobuttonChecked = By.xpath("//span[contains(@class, 'Mui-checked')]//following::p[text()='Bсе проекты']");
    //радиобатон мои проекты
    private final By myProjectsRadiobutton = By.xpath("//p[text()='Мои проекты']");
    //радиобатон участник
    private final By userRadiobutton = By.xpath("//p[text()='Участник']");
    //радиобатон руководитель проекта
    private final By leadProjectRadiobutton = By.xpath("//h6[text()='Роль в проекте']");
    //блок "Форма трудоустройства"
    private final By formWorkBlock = By.xpath("//h6[text()='Форма трудоустройства']");
    //чекбокс для отображения пользователей с почасовой оплатой(выбран по умолчанию)
    private final By hourPayUsersCheckbox = By.xpath("//p[text()='Почасовая оплата']");
    private final By hourPayUsersCheckboxChecked = By.xpath("//span[contains(@class, 'Mui-checked')]//following::p[text()='Почасовая оплата']");
    //чекбокс для отображения пользователей на окладе(выбран по умолчанию)
    private final By monthPayUsersCheckbox = By.xpath("//p[text()='По окладу']");
    private final By monthPayUsersCheckboxChecked = By.xpath("//span[contains(@class, 'Mui-checked')]//following::p[text()='По окладу']");
    //блок "Филиалы"
    private final By filialBlock = By.xpath("//h6[text()='Филиалы']");
    //поле с текстовым фильтром и дропдауном с вариантами всех филиалов (данные подтягиваются из раздела филиалов)
    private final By filialDropdown = By.cssSelector("div[class='MuiAutocomplete-root MuiAutocomplete-hasClearIcon MuiAutocomplete-hasPopupIcon css-en443m']");
    //значение "Все филиалы"(выбран по умолчанию)
    private final By noFilialUsers = By.xpath("//p[text()='Пользователи без филиалов']");
    // значение "Пользователи без филиалов"
    private final By noFilialUsersChecked = By.xpath("//span[contains(@class, 'Mui-checked')]//following::p[text()='Пользователи без филиалов']");
    private final By integrationBlock = By.xpath("//h6[text()='Интеграции']");
    private final By integrationList = By.cssSelector("h6[class=\"MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1sbxkv6\"]");
    private final By actionOfIntegration = By.xpath("//p[text()='Активности по интеграциям']");
    private final By onHoverBlock = By.xpath("//h6[text()='При наведении']");
    private final By seeLaborReason = By.xpath("//p[text()='Показывать причины списания']");
    private final By seeUserAction = By.xpath("//p[text()='Показывать активность пользователя']");
    //кнопку сброса выбранных параметров
    private final By abortButton = By.xpath("//button[text()='Отменить']");
    //кнопку применения
    private final By submitButton = By.xpath("//button[text()='Применить']");


    public void openFilter(){
        waitElementIsVisible(driver.findElement(PivotDropdownButton)).click();
    }
    public void checkDropdown() throws InterruptedException {

        //Блок таблица
        WebElement tabBlockText = waitElementIsVisible(driver.findElement(tabBlock));
        Assert.assertTrue(tabBlockText.isDisplayed(), "Блок таблица отсутствует");


        WebElement notActiveUserCheckboxText = waitElementIsVisible(driver.findElement(notActiveUserCheckbox));
        Assert.assertTrue(notActiveUserCheckboxText.isDisplayed(), "Чек-бокс активные пользователи отсутствует");
        WebElement notActiveProjectCheckboxText = waitElementIsVisible(driver.findElement(notActiveProjectCheckbox));
        Assert.assertTrue(notActiveProjectCheckboxText.isDisplayed(), "Чек-бокс активные проекты отсутствует");
        //Блок проектные роли
        WebElement projectRuleBlockText = waitElementIsVisible(driver.findElement(projectRuleBlock));
        Assert.assertTrue(projectRuleBlockText.isDisplayed(), "Блок проектные роли отсутствует");


        WebElement allProjectsRadiobuttonText = waitElementIsVisible(driver.findElement(allProjectsRadiobutton));
        Assert.assertTrue(allProjectsRadiobuttonText.isDisplayed(), "Радиокнопка все проекты отсутствует");
        WebElement allProjectsRadiobuttonCheck = waitElementIsVisible(driver.findElement(allProjectsRadiobuttonChecked));
        Assert.assertTrue(allProjectsRadiobuttonCheck.isDisplayed(), "Радиокнопка все проекты не выбрана по умолчанию");


        WebElement myProjectsRadiobuttonText = waitElementIsVisible(driver.findElement(myProjectsRadiobutton));
        Assert.assertTrue(myProjectsRadiobuttonText.isDisplayed(), "Радиокнопка мои проекты отсутствует");
        WebElement userRadiobuttonText = waitElementIsVisible(driver.findElement(userRadiobutton));
        Assert.assertTrue(userRadiobuttonText.isDisplayed(), "Радиокнопка пользоваетель отсутствует");
        WebElement leadProjectRadiobuttonText = waitElementIsVisible(driver.findElement(leadProjectRadiobutton));
        Assert.assertTrue(leadProjectRadiobuttonText.isDisplayed(), "Радиокнопка руководитель отсутствует");

        //Блок форма трудоустройства
        WebElement formWorkBlockText = waitElementIsVisible(driver.findElement(formWorkBlock));
        Assert.assertTrue(formWorkBlockText.isDisplayed(), "Блок форма трудоустройства отсутствует");

        WebElement hourPayUsersCheckboxText = waitElementIsVisible(driver.findElement(hourPayUsersCheckbox));
        Assert.assertTrue(hourPayUsersCheckboxText.isDisplayed(), "Чек-бокс почасовая оплата отсутствует");
        WebElement hourPayUsersCheckboxTextChecked = waitElementIsVisible(driver.findElement(hourPayUsersCheckboxChecked));
        Assert.assertTrue(hourPayUsersCheckboxTextChecked.isDisplayed(), "Чек-бокс почасовая оплата не выбран по умолчанию");


        WebElement monthPayUsersCheckboxText = waitElementIsVisible(driver.findElement(monthPayUsersCheckbox));
        Assert.assertTrue(monthPayUsersCheckboxText.isDisplayed(), "Чек-бокс оклад отсутствует");
        WebElement monthPayUsersCheckboxTextChecked = waitElementIsVisible(driver.findElement(monthPayUsersCheckboxChecked));
        Assert.assertTrue(monthPayUsersCheckboxTextChecked.isDisplayed(), "Чек-бокс оклад не выбран по умолчанию");

        //Блок филиал
        WebElement filialBlockText = waitElementIsVisible(driver.findElement(filialBlock));
        Assert.assertTrue(filialBlockText.isDisplayed(), "Блок филиал отсутствует");
        WebElement filialDropdownText = driver.findElement(filialDropdown);
        Assert.assertTrue(filialDropdownText.isDisplayed(), "Дропдаун филиал отсутствует");

        WebElement noFilialUsersText = waitElementIsVisible(driver.findElement(noFilialUsers));
        Assert.assertTrue(noFilialUsersText.isDisplayed(), "Чек-бокс пользователи без филиала отсутствует");
        WebElement noFilialUsersTextChecked = waitElementIsVisible(driver.findElement(noFilialUsersChecked));
        Assert.assertTrue(noFilialUsersTextChecked.isDisplayed(), "Чек-бокс пользователи без филиала выбран по умолчанию");
        //Блок интеграции
        WebElement integrationBlockText = waitElementIsVisible(driver.findElement(integrationBlock));
        Assert.assertTrue(integrationBlockText.isDisplayed(), "Блок интеграции отсутствует");

        WebElement actionOfIntegrationText = waitElementIsVisible(driver.findElement(actionOfIntegration));
        Assert.assertTrue(actionOfIntegrationText.isDisplayed(), "Чек-бокс действия по интеграциям отсутствует");

        String integrationListText = waitElementIsVisible(driver.findElement(integrationList)).getText();
        String outputIntegrationText = "Задача создана (Jira), Добавлен комментарий (Jira), Задача изменила статус (Jira), Задача отредактирована (Jira), Commits (Bitbucket), Pull requests (Bitbucket), Code review (Bitbucket), Страница (Confluence), Вложение (Confluence), Комментарий (Confluence), Страница-блог (Confluence), Пространство (Confluence), Не определено (Confluence), Создание (Test IT), Прохождение тест кейсов (Test IT), Code review (Gitlab), Commits (Gitlab), Закрыто issue (Gitlab), Количество комментариев issue (Gitlab), Открыто issue (Gitlab), Merge requests (Gitlab), Задач закрыто (Gitlab), Задач открыто (Gitlab)";
        Assert.assertEquals(integrationListText, outputIntegrationText, "Выбраны не все интеграции");
        //Блок при наведении
        WebElement onHoverBlockText = waitElementIsVisible(driver.findElement(onHoverBlock));
        Assert.assertTrue(onHoverBlockText.isDisplayed(), "Блок при наведении отсутствует");

        WebElement seeLaborReasonText = waitElementIsVisible(driver.findElement(seeLaborReason));
        Assert.assertTrue(seeLaborReasonText.isDisplayed(), "Чек-бокс показать причины списания отсутствует");
        WebElement seeUserActionText = waitElementIsVisible(driver.findElement(seeUserAction));
        Assert.assertTrue(seeUserActionText.isDisplayed(), "Чек-бокс показать активность пользователя отсутствует");
        //Кнопки
        WebElement submitButtonText = waitElementIsVisible(driver.findElement(submitButton));
        Assert.assertTrue(submitButtonText.isDisplayed(), "Кнопка применить отсутствует");

        WebElement abortButtonText = waitElementIsVisible(driver.findElement(abortButton));
        Assert.assertTrue(abortButtonText.isDisplayed(), "Кнопка отменить отсутствует");
    }
}
