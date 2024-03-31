package pages.models;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ChatPage extends EdgeTierPage{

    public final Locator chatTextBox;
    public final Locator sendButton;
    public final Locator endChatButton;
    public final Locator dispositionCategoryDropBox;
    public final Locator dispositionCodeDropBox;
    public final Locator noteTextBox;
    public final Locator submitButton;
    private final Locator complaintReason;
    private final Locator unknownChargeDisposition;
    private final Locator successMessage;
    public Locator message;


    public ChatPage(Page page) {
        super(page);
        this.chatTextBox = page.getByRole(AriaRole.TEXTBOX);
        this.sendButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit message"));
        this.endChatButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("End Chat"));
        this.dispositionCategoryDropBox = page.getByText("Reason for contact category...");
        this.dispositionCodeDropBox = page.getByText("Disposition CodeReason for");
        this.noteTextBox = page.getByPlaceholder("Any additional relevant");
        this.submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit as Complete"));
        this.complaintReason = page.getByText("Complaint", new Page.GetByTextOptions().setExact(true));
        this.unknownChargeDisposition = page.getByText("Unknown charge/I don't understand my invoice", new Page.GetByTextOptions().setExact(true));
        this.successMessage = page.getByText("Successfully finished chat");
    }

    public ChatPage sendMessageInChat(String text) {
        chatTextBox.fill(text);
        chatTextBox.press("Enter");
        return setMessage(text);
    }
    private ChatPage setMessage(String message)
    {
        this.message = page.getByText(message, new Page.GetByTextOptions().setExact(true));
        return this;
    }

    public ChatPage checkMessageIsSent(String txt)
    {
        assertThat(message).containsText(txt);
        return this;
    }

    public ChatPage pressEndChatButton()
    {
        endChatButton.click();
        return this;
    }

    public ChatPage selectADispositionCategory()
    {
        dispositionCategoryDropBox.click();
        complaintReason.click();
        return this;
    }

    public ChatPage selectADispositionCode()
    {
        dispositionCodeDropBox.click();
        unknownChargeDisposition.click();
        return this;
    }

    public ChatPage writeANoteForDisposition()
    {
        noteTextBox.click();
        noteTextBox.fill("NA");
        return this;
    }

    public ChatPage pressSubmitAsComplete()
    {
        submitButton.click();
        return this;
    }

    public ChatPage checkEndChatMessageIsDisplayed()
    {
        successMessage.isVisible();
        return this;
    }

}