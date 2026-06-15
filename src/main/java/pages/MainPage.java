package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; // ДОБАВИЛИ ИМПОРТ
import org.openqa.selenium.JavascriptExecutor; // ДОБАВИЛИ ИМПОРТ

public class MainPage {

    private static final String selectedButtonClassName = "current";
    private final By buttonEnterAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By buttonBun = By.xpath(".//span[text()='Булки']/..");
    private final By buttonSauce = By.xpath(".//span[text()='Соусы']/..");
    private final By buttonIngredient = By.xpath(".//span[text()='Начинки']/..");
    private final By title = By.xpath(".//h1[text() = 'Соберите бургер']");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // ИЗМЕНИЛИ: Клик по кнопке «Войти в аккаунт» через JavaScript
    public void clickButtonEnterAccount() {
        WebElement element = driver.findElement(buttonEnterAccount);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // ИЗМЕНИЛИ: Клик по вкладке «Булки» через JavaScript
    public void clickButtonBun() {
        WebElement element = driver.findElement(buttonBun);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // ИЗМЕНИЛИ: Клик по вкладке «Соусы» через JavaScript
    public void clickButtonSauce() {
        WebElement element = driver.findElement(buttonSauce);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // ИЗМЕНИЛИ: Клик по вкладке «Начинки» через JavaScript
    public void clickButtonIngredient() {
        WebElement element = driver.findElement(buttonIngredient);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isTitleDisplayed() {
        // Ждем до 5 секунд, пока заголовок «Соберите бургер» физически появится на странице
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(title));

        return driver.findElement(title).isDisplayed();
    }

    public boolean isBunSelected() {
        return driver.findElement(buttonBun).getAttribute("class").contains(selectedButtonClassName);
    }

    public boolean isSauceSelected() {
        return driver.findElement(buttonSauce).getAttribute("class").contains(selectedButtonClassName);
    }

    public boolean isIngredientSelected() {
        return driver.findElement(buttonIngredient).getAttribute("class").contains(selectedButtonClassName);
    }
}