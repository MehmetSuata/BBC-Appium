package Pages;

import Utilities.MobileDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BBCLandingPage{

    public BBCLandingPage() {
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver.getAndroidDriver()), this);
    }

    @FindBy (xpath = "//android.widget.Button[@content-desc=\"Sign in to a BBC Account\"]")
    public WebElement signInButton;

    @FindBy (xpath = "//android.widget.Button[@content-desc=\"Continue\"]")
    public WebElement continueSignInButton;

    @FindBy (id= "android:id/button1")
    public WebElement notificationsOKButton;

    @FindBy (xpath = "//*[contains(@text, 'NO, THANKS.')]")
    public WebElement accessibilityNoThanksButton;


    @FindBy (xpath = "//android.widget.LinearLayout[@content-desc=\"Top Stories\"]/android.widget.TextView")
    public WebElement headerMenuTopStories;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Video\"]/android.widget.TextView")
    public WebElement videoTab;

    @FindBy(id = "bbc.mobile.news.uk:id/content_card_title")
    public WebElement bbcNewsBanner;


    @FindBy(id = "bbc.mobile.news.uk:id/copyright_item_title")
    public WebElement footerBanner;


    @FindBy (xpath = "//android.widget.TextView[@content-desc=\"Search\"]")
    public WebElement searchIcon;


    @FindBy(id = "bbc.mobile.news.uk:id/search")
    public WebElement searchBar;

    @FindBy (id = "bbc.mobile.news.uk:id/chip_item")
    public List<WebElement> searchTopics;


    @FindBy (id = "bbc.mobile.news.uk:id/activity_news_index_title")
    public WebElement navHeaderAfterSearchCategory;


    @FindBy (xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement navigateBackButton;

    @FindBy (xpath = "//android.widget.ImageButton[@content-desc=\"Back\"]")
    public WebElement navigateBackFromSearch;

    @FindBy (xpath = "//android.widget.LinearLayout[@content-desc=\"Top Stories\"]/android.widget.TextView")
    public WebElement topStoriesHeader;

}
