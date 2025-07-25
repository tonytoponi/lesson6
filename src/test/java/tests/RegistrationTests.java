package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static com.codeborne.selenide.Condition.*;

public class RegistrationTests {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataGenerator testData = new TestDataGenerator();
    String firstName = testData.getFirstName(),
            lastName = testData.getLastName(),
            userEmail = testData.getEmail(),
            gender = testData.getGender(),
            phone = testData.getPhone(),
            day = testData.getDay(),
            month = testData.getMonth(),
            year = testData.getYear(),
            subject = testData.getSubject(),
            hobby = testData.getHobby(),
            uploadPicture = testData.getUploadPicture(),
            address = testData.getAddress(),
            state = testData.getState(),
            city = testData.getCity(),
            defaultBirthDate = testData.getCurrentDay();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        //Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest() {
       registrationPage.openPage()
               .removeBanners()
               .setFirstName(firstName)
               .setLastName(lastName)
               .setEmail(userEmail)
               .setGender(gender)
               .setPhone(phone)
               .setDateOfBirth(day, month, year)
               .setSubjects(subject)
               .setHobbies(hobby)
               .uploadPicture(uploadPicture)
               .setAddress(address)
               .setState(state)
               .setCity(city)
               .submitForm();

        SelenideElement result = registrationPage.getResultTable();
        result.shouldHave(text(firstName + " " + lastName));
        result.shouldHave(text(userEmail));
        result.shouldHave(text(gender));
        result.shouldHave(text(phone));
        result.shouldHave(text(day + " " + month + "," + year));
        result.shouldHave(text(subject));
        result.shouldHave(text(hobby));
        result.shouldHave(text(uploadPicture));
        result.shouldHave(text(address));
        result.shouldHave(text(state + " " + city));
    }

    @Test
    void fillMinimalDataTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhone(phone)
                .submitForm();

        SelenideElement result = registrationPage.getResultTable();
        result.shouldHave(text(firstName + " " + lastName));
        result.shouldHave(text(gender));
        result.shouldHave(text(phone));
        result.shouldHave(text(defaultBirthDate));
    }

    @Test
    void negativeTest () {
        registrationPage.openPage()
                .removeBanners()
                .submitForm();

        String property = "border-color",
                expectedValue = "rgb(220, 53, 69)";

        registrationPage.getFirstNameInput().shouldHave(cssValue(property, expectedValue));
        registrationPage.getLastNameInput().shouldHave(cssValue(property, expectedValue));
        registrationPage.getUserNumberInput().shouldHave(cssValue(property, expectedValue));
    }
}
