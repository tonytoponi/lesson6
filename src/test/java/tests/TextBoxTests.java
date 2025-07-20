package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;

public class TextBoxTests {

    TestDataGenerator testData = new TestDataGenerator();
    String fullName = testData.getFirstName() + " " + testData.getLastName(),
            email = testData.getEmail(),
            currentAddress = testData.getAddress(),
            permanentAddress = testData.getAddress();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillTextBoxTest() {
        TextBoxPage textBoxPage = new TextBoxPage();

        textBoxPage.openPage()
                .removeBanners()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitData();

        textBoxPage.getFullNameField().shouldHave(text(fullName));
        textBoxPage.getEmailField().shouldHave(text(email));
        textBoxPage.getCurrentAddressField().shouldHave(text(currentAddress));
        textBoxPage.getPermanentAddressField().shouldHave(text(permanentAddress));
    }
}
