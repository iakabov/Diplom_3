package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; // ДОБАВИЛИ ИМПОРТ
import org.openqa.selenium.JavascriptExecutor; // ДОБАВИЛИ ИМПОРТ

public class NavigationPanel {
    private final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By buttonLogo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");
    private final WebDriver driver;

    public NavigationPanel(WebDriver driver) { this.driver = driver; }

    public void clickButtonPersonalAccount() {
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        WebElement element = driver.findElement(buttonPersonalAccount);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickButtonConstructor() {
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        WebElement element = driver.findElement(buttonConstructor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickButtonLogo() {
        try {
            Thread.sleep(500); // Даём сайту полсекунды скрыться оверлею
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Используем стандартный клик Selenium вместо JavaScript
        driver.findElement(buttonLogo).click();
    }
}