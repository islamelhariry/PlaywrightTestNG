package pages.models;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AgentHomePage extends EdgeTierPage{
    public Locator homeTab;
    public Locator newEmailTab;
    public Locator emailTab;
    public Locator chatTab;
    public Locator proactiveChatTab;
    public Locator deferredQueriesTab;
    public Locator templatesTab;
    public AgentHomePage(Page page) {
        super(page);
        this.homeTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home"));
        this.newEmailTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("New Email"));
        this.emailTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Email").setExact(true));
        this.chatTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Chat 3"));
        this.proactiveChatTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proactive Chat"));
        this.deferredQueriesTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Deferred Queries"));
        this.templatesTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Templates"));
    }

    public AgentHomePage pressHomeTab()
    {
        homeTab.click();
        waitForPageToLoad();
        return this;
    }
    public AgentHomePage pressNewEmailTab()
    {
        newEmailTab.click();
        waitForPageToLoad();
        return this;
    }
    public AgentHomePage pressEmailTab()
    {
        emailTab.click();
        waitForPageToLoad();
        return this;
    }
    public AgentHomePage pressChatTab()
    {
        chatTab.click();
        waitForPageToLoad();
        return this;
    }
    public AgentHomePage pressProactiveChatTab()
    {
        proactiveChatTab.click();
        waitForPageToLoad();
        return this;
    }
    public AgentHomePage pressDeferredQueriesTab()
    {
        deferredQueriesTab.click();
        waitForPageToLoad();
        return this;
    }
    public AgentHomePage pressTemplatesTab()
    {
        templatesTab.click();
        waitForPageToLoad();
        return this;
    }
}