package ru.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SourchMobilePage extends BaseTest {
    @Given("I browse to yandex.ru for mobile")
    public void i_browse_to_yandex_ru(){
        getDriver();
        driver.get("https://www.yandex.ru/");
    }

    @When("I click \"Market for Mobile\" link")
    public void i_click_market_link(){
        driver.findElement(By.xpath("//*[@data-id='market']")).click();
    }

    @When("I click \"Elektronika for Mobile\" link")
    public void i_click_elektronika_link(){
        driver.findElement(By.xpath("//span[contains(text(),'Электроника')]")).click();
    }

    @When("I click \"Mobile\" link")
    public void i_click_mobile_link(){
        driver.findElement(By.xpath("//a[contains(text(),'Мобильные телефоны')] ")).click();
    }

    @Then("I see \"48 mobile\" item")
    public void i_see_48_item(){
        int countItem = driver.findElements(By.xpath("//div[contains(@data-id,'model')]")).size();
        Assert.assertEquals(48,countItem);

    }
}
