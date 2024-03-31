package pages.models;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EdgeTierSignInPage extends EdgeTierPage{
    public Locator agentSignInButton;
    public Locator fullAccessSignInButton;
    public Locator administratorSignInButton;
    public Locator leadSignInButton;

    public EdgeTierSignInPage(Page page) {
        super(page);
        this.fullAccessSignInButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in with Demo (Full"));
        this.administratorSignInButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in with Demo (Administrator)"));
        this.agentSignInButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in with Demo (Agent)"));
        this.leadSignInButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in with Demo (Team Lead)"));
    }

    public EdgeTierSignInPage signInAsFullAccess()
    {
        fullAccessSignInButton.click();
        waitForPageToLoad();
        return this;
    }
    public EdgeTierSignInPage signInAsAdministrator()
    {
        administratorSignInButton.click();
        waitForPageToLoad();
        return this;
    }
    public EdgeTierSignInPage signInAsAgent()
    {
        agentSignInButton.click();
        waitForPageToLoad();
        return this;
    }
    public EdgeTierSignInPage signInAsLead()
    {
        leadSignInButton.click();
        waitForPageToLoad();
        return this;
    }
}