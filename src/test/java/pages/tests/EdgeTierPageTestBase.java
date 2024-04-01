package pages.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class EdgeTierPageTestBase {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeClass
    protected void setBrowserAndCreateContext() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setTimeout(120000)
                .setSlowMo(2000));
        context = browser.newContext(new Browser.NewContextOptions()
                .setIgnoreHTTPSErrors(true)
                .setHttpCredentials("demo","DemoArthurPassword"));
        page = context.newPage();
    }

    @AfterMethod
    protected void closeBrowser() {
        playwright.close();
    }
}