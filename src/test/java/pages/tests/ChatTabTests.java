package pages.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.models.AgentHomePage;
import pages.models.ChatPage;
import pages.models.EdgeTierSignInPage;

public class ChatTabTests extends EdgeTierPageTestBase {
    EdgeTierSignInPage signInPage;
    AgentHomePage agentHomePage;
    ChatPage chatPage;

    @BeforeClass
    public void setup()
    {
        super.setup();
        signInPage = new EdgeTierSignInPage(page);
        agentHomePage = new AgentHomePage(page);
        chatPage = new ChatPage(page);
    }
    @BeforeMethod
    public void createContextAndPage() {
        signInPage.navigateToEdgeTer();
        signInPage.signInAsAgent();
        agentHomePage.pressChatTab();

    }

    @AfterMethod
    void closeContext() {
        super.closeBrowser();
    }

    @Test
    void sendMessageInChatTest() {
        String message = "Hi";
        chatPage.sendMessageInChat(message)
                .checkMessageIsSent(message);
    }

    @Test
    void selectMessageInChatTest() {
        chatPage.pressEndChatButton()
                .selectADispositionCategory()
                .selectADispositionCode()
                .writeANoteForDisposition()
                .pressSubmitAsComplete()
                .checkEndChatMessageIsDisplayed();
    }

}