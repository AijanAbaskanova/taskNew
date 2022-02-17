package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Yandex;
import utilities.Driver;

import java.util.Set;

public class YandexStep {
    Yandex yandex = new Yandex();

    @Given("user navigates to www.yandex.ru")
    public void user_navigates_to_www_yandex_ru() {
        Driver.getDriver().get("https://yandex.ru/");
        Driver.getDriver().manage().window().maximize();
    }

    @Given("user clicks the inbox")
    public void user_clicks_the_inbox() {
   yandex.inbox.click();

        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        System.out.println(mainWindowHandle);

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                System.out.println(handle);

            }
        }

    }

    @Then("user should see the login page")
    public void user_should_see_the_login_page() {

        WebElement inboxPage = Driver.getDriver().findElement(By.xpath("//span[@class=\"passp-add-account-page-title\"]"));
        String expected = "Войдите с Яндекс ID";
        String actual = inboxPage.getText();
        System.out.println(actual);

        Assert.assertEquals(expected, actual);

        Driver.getDriver().quit();
    }
}
