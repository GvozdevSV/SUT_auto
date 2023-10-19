package pages.create_project_drawer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

import java.util.concurrent.TimeUnit;

public class CreateProjectPage extends BasePage {

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    //Таб проекты в тулбаре
    private final By tabProjects = By.cssSelector("div[id=\"projects\"]");
    private final By tabCreateProject = By.cssSelector("a[href=\"/admin/projects?displayOnlyMyProjects=false&create=true\"]");
    private final By tabAllProject = By.cssSelector("a[href=\"/admin/projects?displayOnlyMyProjects=false&create=false\"]");
    //Поля в дровере создания проекта
    private final By nameField = By.cssSelector("input[name=\"name\"]");
    private final By codeField = By.cssSelector("input[name=\"code\"]");
    private final By beginDataField = By.xpath("//label[text()='Дата начала']//following::input[1]");
    private final By recourseInputField = By.xpath("//div[@name=\"resources\"]//following::input[1]");
    private final By choseResources = By.xpath("//p[text()='Александр Морозов']");
    private final By submitButton = By.cssSelector("button[type=\"submit\"]");
    //Кнопки на странице все проекты
    private final By projectActionButton = By.xpath("//div[text()='AutoTestProject']//ancestor::div[contains(@class,\"ag-row-even\")]//button");
    private final By projectDeleteButton = By.xpath("//span[text()='Удалить']");

    //Переход на дровер создания проекта
    public void goToCreateProjectDrawer(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tabProjects)).build().perform();
        driver.findElement(tabCreateProject).click();
    }
    //Создание проекта ля автотестов
    public void createProject() throws InterruptedException {
        waitElementIsVisible(driver.findElement(nameField)).sendKeys("AutoTestProject");
        waitElementIsVisible(driver.findElement(codeField)).sendKeys("ATP");
        waitElementIsVisible(driver.findElement(beginDataField)).click();
        waitElementIsVisible(driver.findElement(beginDataField)).sendKeys(Keys.CONTROL +"a");
        waitElementIsVisible(driver.findElement(beginDataField)).sendKeys(Keys.BACK_SPACE);
        waitElementIsVisible(driver.findElement(beginDataField)).sendKeys("01.10.2023");
        waitElementIsVisible(driver.findElement(recourseInputField)).sendKeys("Александр Морозов");
        waitElementIsVisible(driver.findElement(choseResources)).click();
        waitElementIsVisible(driver.findElement(submitButton)).click();
    }
    //Переход в таблицу все проекты
    public void goToAllProjectPage() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tabProjects)).build().perform();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(tabAllProject).click();
    }
    //Удаление проекта для автотестов
    public void  deleteProject(){
        driver.findElement(projectActionButton).click();
        waitElementIsVisible(driver.findElement(projectDeleteButton)).click();
        waitElementIsVisible(driver.findElement(submitButton)).click();

    }

}
