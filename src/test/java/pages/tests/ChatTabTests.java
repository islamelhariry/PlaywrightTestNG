package pages.tests;

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
    public void createContextAndSetupPages()
    {
        super.setBrowserAndCreateContext();
        signInPage = new EdgeTierSignInPage(page);
        agentHomePage = new AgentHomePage(page);
        chatPage = new ChatPage(page);
    }
    @BeforeMethod
    public void navigateToChatTab() {
        signInPage.navigateToEdgeTer();
        signInPage.signInAsAgent();
        agentHomePage.pressChatTab();

    }

    @Test
    void sendMessageInChatTest() {
        String message = "Hi";
        chatPage.sendMessageInChat(message)
                .checkMessageIsSent(message);
    }

    @Test
    void EndChatTest() {
        chatPage.pressEndChatButton()
                .selectADispositionCategory()
                .selectADispositionCode()
                .writeANoteForDisposition()
                .pressSubmitAsComplete()
                .checkEndChatMessageIsDisplayed();
    }

}