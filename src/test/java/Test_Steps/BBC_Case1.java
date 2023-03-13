package Test_Steps;

import Pages.BBCLandingPage;
import Utilities.MobileDriver;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BBC_Case1{
    /***
     * 1. Tap on Video Tab and validate “BBC News Channel” text then scroll down and
     * validate “Copyright © 2018 BBC”
     * 2. Click on Search icon then search for “England” or select from the More Topics.
     * Verify the Navigation bar text
     * 3. Navigate back to the home page and Verify the Home page text
     */
    BBCLandingPage bbcLandingPage=new BBCLandingPage();
    WebDriverWait wait=new WebDriverWait(MobileDriver.getAndroidDriver(),10);

    @Given("user successfully logs in to BBC News app")
    public void userSuccessfullyLogsInToBBCNewsApp() {
        wait.until(ExpectedConditions.elementToBeClickable(bbcLandingPage.signInButton));
        bbcLandingPage.signInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(bbcLandingPage.continueSignInButton));
        bbcLandingPage.continueSignInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(bbcLandingPage.notificationsOKButton));
        bbcLandingPage.notificationsOKButton.click();
//        MobileDriver.getAndroidDriver().findElementByAndroidUIAutomator()
        wait.until(ExpectedConditions.elementToBeClickable(bbcLandingPage.accessibilityNoThanksButton));
        bbcLandingPage.accessibilityNoThanksButton.click();
    }


    @Given("user is on the Open the BBC News app and navigate to the Video Tab.")
    public void user_is_on_the_Open_the_BBC_News_app_and_navigate_to_the_Video_Tab() {
        wait.until(ExpectedConditions.elementToBeSelected(bbcLandingPage.headerMenuTopStories));
        bbcLandingPage.videoTab.click();
    }

    @Then("user validates {string} text at landing page and {string} at the footer is displayed.")
    public void user_validates_text_at_landing_page_and_at_the_footer_is_displayed(String bbcHeadBanner, String footerTitle) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(bbcLandingPage.bbcNewsBanner));
        Assert.assertTrue(bbcLandingPage.bbcNewsBanner.getText().contains(bbcHeadBanner));
        MobileDriver.getAndroidDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
        wait.until(ExpectedConditions.visibilityOf(bbcLandingPage.footerBanner));
        Assert.assertTrue(bbcLandingPage.footerBanner.getText().equals(footerTitle));
    }

    

    @Given("user wants to search for a certain category and clicks on search icon and should see options")
    public void userWantsToSearchForACertainCategoryAndClicksOnSearchIconAndShouldSeeOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(bbcLandingPage.searchIcon));
        bbcLandingPage.searchIcon.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(bbcLandingPage.searchTopics));
    }

    @Then("user clicks on option {string} to filter and should see selected category at the top nav text:")
    public void userClicksOnOptionOptionsToFilterAndShouldSeeSelectedCategoryAtTheTopNavText(String topics) {

        for(int i=0;i<bbcLandingPage.searchTopics.size();i++){
            if (bbcLandingPage.searchTopics.get(i).getText().equalsIgnoreCase(topics)){
                bbcLandingPage.searchTopics.get(i).click();
                wait.until(ExpectedConditions.visibilityOf(bbcLandingPage.navHeaderAfterSearchCategory));
                Assert.assertEquals(topics, bbcLandingPage.navHeaderAfterSearchCategory.getText());}
            }
        }

    @Given("user successfully lands on the selected {string}")
    public void userSuccessfullyLandsOnTheSelected(String selectedVideoCategory) {
        wait.until(ExpectedConditions.elementToBeClickable(bbcLandingPage.searchIcon));
        bbcLandingPage.searchIcon.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(bbcLandingPage.searchTopics));
        bbcLandingPage.searchTopics.get(2).click();
        wait.until(ExpectedConditions.visibilityOf(bbcLandingPage.navHeaderAfterSearchCategory));
        Assert.assertEquals(selectedVideoCategory, bbcLandingPage.navHeaderAfterSearchCategory.getText());
    }
    @Then("user should be able to navigate back to the Homepage and verify the HomePage text {string}")
    public void userShouldBeAbleToNavigateBackToTheHomepageAndVerifyTheHomePageText(String topStories) {
        bbcLandingPage.navigateBackButton.click();
        wait.until(ExpectedConditions.visibilityOf(bbcLandingPage.searchBar));


        do{
            bbcLandingPage.navigateBackFromSearch.click();
        }
        while(!wait.until(ExpectedConditions.visibilityOf(bbcLandingPage.headerMenuTopStories)).isDisplayed());


        System.out.println("Verified");
    }



}

