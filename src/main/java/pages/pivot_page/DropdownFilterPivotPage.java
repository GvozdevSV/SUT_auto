package pages.pivot_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownFilterPivotPage extends BasePage {
    public DropdownFilterPivotPage(WebDriver driver) {
        super(driver);
    }
    private final By pivotDropdownButton = By.cssSelector("button[class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeSmall MuiButton-textSizeSmall MuiButton-disableElevation MuiButtonBase-root css-1v7gybn']");
    //Заголовки блоков
    private final By blockTitle = By.xpath("//h6[contains(@class,\"MuiTypography-root MuiTypography-subtitle2 css-c7dfze\")]");
    //Заголовки чекбоксов
    private final By checkboxTitle = By.cssSelector("p[class=\"MuiTypography-root MuiTypography-body2 css-2yn56w\"]");
    //Радиокнопки
    private final By allRadiobutton = By.xpath("//span[contains(@class,\"MuiRadio-root MuiRadio-colorPrimary\")]");
    private final By allRadiobuttonText = By.xpath("//span[contains(@class,\"MuiRadio-root MuiRadio-colorPrimary\")]//following-sibling::*//child::p");
    private final By checkedRadiobuttonText = By.xpath("//span[contains(@class,\"MuiRadio-root MuiRadio-colorPrimary MuiButtonBase-root MuiRadio-root MuiRadio-colorPrimary PrivateSwitchBase-root Mui-checked \")]//following-sibling::*//child::p");
    //дропдаун филиал
    private final By filialDropdown = By.cssSelector("div[class='MuiAutocomplete-root MuiAutocomplete-hasClearIcon MuiAutocomplete-hasPopupIcon css-en443m']");
    //Список интеграций
    private final By integrationList = By.cssSelector("h6[class=\"MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1sbxkv6\"]");

    //Кнопки применить и отменить
    private final By submitButton = By.xpath("//button[contains(@type,\"submit\")]");
    private final By breakButton  = By.xpath("//button[text()='Отменить']");



    public void openPivotDropdown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        waitElementIsVisible(driver.findElement(pivotDropdownButton)).click();

    }
    public void checkBlockTitle(){
        List<WebElement> checkedElements = driver.findElements(blockTitle);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("outerText");
            data.append(f + ' ');
        }
        //System.out.println(data);
        Assert.assertEquals(data.toString(), "Таблица Роль в проекте Форма трудоустройства Филиалы Интеграции При наведении ", "Один или несколько блоков отсутствует");
    }
    public void getCheckboxText(){
        List<WebElement> checkedElements = driver.findElements(checkboxTitle);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("outerText");
            data.append(f + ' ');
        }
        //System.out.println(data);
        Assert.assertEquals(data.toString(), "Неактивные пользователи Неактивные проекты Почасовая оплата По окладу Пользователи без филиалов Активности по интеграциям ", "Один или несколько чекбоксов отсутствует");
    }
    public void getAllRadiobuttonText(){
        List<WebElement> checkedElements = driver.findElements(allRadiobuttonText);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("outerText");
            data.append(f + ' ');
        }
        //System.out.println(data);
        Assert.assertEquals(data.toString(), "Bсе проекты Участник Руководитель проекта Мои проекты Показывать причины списания Показывать активность пользователя ", "Одна или несколько радиокнопок отсутствует");
    }

    public void dropdownFilialIsDisplayed(){
        WebElement filialDropdownText = driver.findElement(filialDropdown);
        Assert.assertTrue(filialDropdownText.isDisplayed(), "Дропдаун филиал отсутствует");
    }
    public void getIntegrationList(){
        String integrationListText = waitElementIsVisible(driver.findElement(integrationList)).getText();
        //System.out.println(integrationListText);
        String outputIntegrationText = "Задача создана (Jira), Добавлен комментарий (Jira), Задача изменила статус (Jira), Задача отредактирована (Jira), Commits (Bitbucket), Pull requests (Bitbucket), Code review (Bitbucket), Страница (Confluence), Вложение (Confluence), Комментарий (Confluence), Страница-блог (Confluence), Пространство (Confluence), Не определено (Confluence), Создание (Test IT), Прохождение тест кейсов (Test IT), Code review (Gitlab), Commits (Gitlab), Закрыто issue (Gitlab), Количество комментариев issue (Gitlab), Открыто issue (Gitlab), Merge requests (Gitlab), Задач закрыто (Gitlab), Задач открыто (Gitlab)";
        Assert.assertEquals(integrationListText, outputIntegrationText, "Выбраны не все интеграции");
    }
    public void haveSubmitAndBrakeButtons(){
        String submitName = waitElementIsVisible(driver.findElement(submitButton)).getAttribute("innerText");
        String breakButtonName = waitElementIsVisible(driver.findElement(breakButton)).getAttribute("innerText");

        Assert.assertEquals(submitName,"ПРИМЕНИТЬ", "Отсутствует кнопка применить");
        Assert.assertEquals(breakButtonName,"ОТМЕНИТЬ", "Отсутствует кнопка отменить");
    }
    public void getCheckedRadiobuttonText(){
        List<WebElement> checkedElements = driver.findElements(checkedRadiobuttonText);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("outerText");
            data.append(f + ' ');
        }
        //System.out.println(data);
        Assert.assertEquals(data.toString(), "Bсе проекты Показывать активность пользователя ", "Не корректные радиокнопки активны по умолчанию");
    }
}


