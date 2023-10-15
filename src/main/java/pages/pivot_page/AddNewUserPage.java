package pages.pivot_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.List;

public class AddNewUserPage extends BasePage {
    public AddNewUserPage(WebDriver driver) {
        super(driver);
    }

    //локаторы перехода на дровер создания пользователя
    private final By settingButton = By.cssSelector("button[id=\"settings\"]");
    private final By toSystemRole = By.cssSelector("a[href=\"/admin/system-roles/users\"]");
    private final By addUserButton = By.xpath("//button[text()='Пользователь']");
    //локатор полей логин и ФИО
    private final By fioAndLoginElements = By.xpath("//input[contains(@class, 'MuiOutlinedInput-input MuiInputBase-input css-u4lv5a')]");
    //локатор 6 оставшихся полей
    private final By outerField = By.xpath("//input[contains(@class, 'MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputAdornedEnd')]");
    //вкладка проект
    private final By toProjectTabButton = By.xpath("//button[text()='ПРОЕКТЫ']");
    private final By addProjectButton = By.xpath("//button[text()='Добавить проект']");
    private final By projectTabFields = By.xpath("//label[contains(@class, 'MuiInputLabel-root MuiInputLabel-formControl MuiInputLabel-animated')]");


    //вкладка контакты
    private final By toContactTabButton = By.xpath("//button[text()='КОНТАКТЫ']");
    private final By contactTabFields = By.xpath("//input[contains(@class, 'MuiOutlinedInput-input MuiInputBase-input')]");


    //переходим на дровер
    public void goTooNewUserDrover(){
        waitElementIsVisible(driver.findElement(settingButton)).click();
        waitElementIsVisible(driver.findElement(toSystemRole)).click();
        waitElementIsVisible(driver.findElement(addUserButton)).click();
    }
    //берем значение имя с первых 4 полей, чем подтверждаем наличие этих полей)
    public void getFIOFieldName (){
        List<WebElement> checkedElements = driver.findElements(fioAndLoginElements);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("name");
            data.append(f + ' ');
        }
        Assert.assertEquals(data.toString(), "username secondName name thirdName ", "одно из полей отсутствует в дровере");

    }
    //берем значение плейсхолдер из оставшихся 6 полей, чем подтверждаем наличие этих полей)
    public void getOuterFieldPlaceholder (){
        List<WebElement> checkedElements = driver.findElements(outerField);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("placeholder");
            data.append(f + ' ');
        }
        String mustData = "ДД.MM.ГГГГ ДД.MM.ГГГГ Начните вводить проектную роль Начните вводить подразделение Начните вводить должность Начните вводить Филиал ";
        Assert.assertEquals(data.toString(), mustData, "одно из полей отсутствует в дровере");

    }
    //Переходим на таб проект
    public void goToTabProject(){
        waitElementIsVisible(driver.findElement(toProjectTabButton)).click();
    }
    public void addProjectButton(){
        waitElementIsVisible(driver.findElement(addProjectButton)).click();
    }
    //берем значение плейсхолдеров с 2 полей на вкладке проекты)
    public void getProjectTabFieldName (){
        List<WebElement> checkedElements = driver.findElements(contactTabFields);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("innerText");
            data.append(f + ' ');
        }
        //Так как мы можем несколько раз нажать на кнопку добавить проект, и у нас будет не 2 а 4 или 6 полей на странице, нам нужно проверить что конечная строка собержит тексты плейсхолдеров
        Assert.assertTrue(data.toString().contains(написать текст когда будет работать сайт), "Одно из полей отсутствует");
    }


    //Переходим на таб контакты
    public void goToTabContacts(){
        waitElementIsVisible(driver.findElement(toContactTabButton)).click();
    }
    public void getContactFieldName (){
        List<WebElement> checkedElements = driver.findElements(contactTabFields);
        StringBuffer data = new StringBuffer();
        for (WebElement checkedElement : checkedElements) {
            String f = checkedElement.getAttribute("name");
            data.append(f + ' ');
        }
        Assert.assertEquals(data.toString(), "username secondName name thirdName ", "одно из полей отсутствует в дровере");
}

