package pages.models;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public abstract class EdgeTierPage{

    protected Page page;

    protected EdgeTierPage(Page page) {
        this.page = page;
    }
    public void navigateToEdgeTer()
    {
        page.navigate("https://demo-testing.edgetier.com/");
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    protected void waitForPageToLoad()
    {
        page.waitForLoadState(LoadState.LOAD);
    }
}