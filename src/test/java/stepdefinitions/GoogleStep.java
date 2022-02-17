package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.GoogleSearch;
import utilities.Driver;

import java.util.List;

public class GoogleStep {
    GoogleSearch google = new GoogleSearch();

    @Given("user navigates to www.google.com")
    public void user_navigates_to_www_google_com() {
        Driver.getDriver().get("https://www.google.com/");
        Driver.getDriver().manage().window().maximize();
//iUh30 qLRx3b tjvcx
    }

    @Given("user inserts the name of coffee machine in search line")
    public void user_inserts_the_name_of_coffee_machine_in_search_line() {
        google.search.sendKeys("купить кофемашину bork c804");
    }


    @Given("user clicks the search button")
    public void user_clicks_the_search_button() {
        google.search.sendKeys(Keys.ENTER);
    }

    @And("user should see more than ten results regarding the related search")
    public void userShouldSeeMoreThanTenResultsRegardingTheRelatedSearch() {
        List<WebElement>list = Driver.getDriver().findElements(By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]"));
        for(WebElement element: list){
            System.out.println(element.getText());

        }
        int size = list.size();
        System.out.println("size = " + size);

        boolean tenRestults= false;
        if(size >= 10){
            tenRestults=true;
            System.out.println("tenRestults = " + tenRestults);
        }else{
            System.out.println("tenRestults = " + tenRestults);
        }

    }

    @Then("user should see MVideo.ru in the search result page")
    public void user_should_see_MVideo_ru_in_the_search_result_page() {
        String wantedResult = "М.Видео";
        List<WebElement>list = Driver.getDriver().findElements(By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]"));
        for(WebElement element: list){
            String text = element.getText();
            boolean contains = text.contains(wantedResult);
        }
        Assert.assertTrue(wantedResult,true);
    }



}
