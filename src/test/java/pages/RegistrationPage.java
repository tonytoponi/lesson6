package pages;

import com.codeborne.selenide.SelenideElement;
import pages.Components.CalendarComponent;
import pages.Components.ResultTable;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
                            emailInput = $("#userEmail"),
                            lastNameInput = $("#lastName"),
                            genderWrapper = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            dateOfBirthInput = $("#dateOfBirthInput"),
                            subjectInput = $("#subjectsInput"),
                            hobbyInput = $("#hobbiesWrapper"),
                            pictureUpload = $("#uploadPicture"),
                            addressInput = $("#currentAddress"),
                            submitButton = $("#submit");

    private final CalendarComponent calendarComponent= new CalendarComponent();



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public SelenideElement getFirstNameInput() {
        return firstNameInput;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public SelenideElement getLastNameInput() {
        return lastNameInput;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        userNumberInput.setValue(phone);
        return this;
    }

    public SelenideElement getUserNumberInput () {
        return userNumberInput;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies (String hobby) {
        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture (String picture) {
        pictureUpload.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }
    
    public void submitForm () {
        submitButton.click();
    }

    public SelenideElement getResultTable() {
        return new ResultTable().getTableElement();
    }
}
