package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private final SelenideElement fullNameInput = $("#userName"),
                            emailInput = $("#userEmail"),
                            currentAddressInput = $("#currentAddress"),
                            permanentAddressInput = $("#permanentAddress"),
                            submitButton = $("#submit"),
                            fullNameField = $("#output").$("#name"),
                            emailField = $("#output").$("#email"),
                            currentAddressField = $("#output").$("#currentAddress"),
                            permanentAddressField = $("#output").$("#permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public SelenideElement getFullNameField () {
        return fullNameField;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public SelenideElement getEmailField () {
        return emailField;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public SelenideElement getCurrentAddressField() {
        return currentAddressField;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }
    public SelenideElement getPermanentAddressField () {
        return permanentAddressField;
    }

    public void submitData() {
        submitButton.click();
    }


}
