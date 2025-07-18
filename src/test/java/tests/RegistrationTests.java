package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;

public class RegistrationTests {

    RegistrationPage registrationPage = new RegistrationPage();


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
       String firstName = "Tony",
            lastName = "Soprano",
            userEmail = "test@test.com",
            phone = "1234567890",
            gender = "Male",
            day = "14",
               month = "January",
               year = "1991",
               subject = "Accounting",
               uploadPicture = "samia.jpg",
               address = "Some street 1",
               state = "NCR",
               city = "Delhi";

       String[] hobbies = {"Sports", "Reading"};

       registrationPage.openPage()
               .removeBanners()
               .setFirstName(firstName)
               .setLastName(lastName)
               .setEmail(userEmail)
               .setGender(gender)
               .setPhone(phone)
               .setDateOfBirth(day, month, year)
               .setSubjects(subject)
               .setHobbies(hobbies[0])
               .setHobbies(hobbies[1])
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
        result.shouldHave(text(hobbies[0] + ", " + hobbies[1]));
        result.shouldHave(text(uploadPicture));
        result.shouldHave(text(address));
        result.shouldHave(text(state + " " + city));
    }

    @Test
    void fillMinimalDataTest() {
        String firstName = "Tony",
                lastName = "Soprano",
                gender = "Male",
                phone = "1234567890",
                birthDate = "17 July,2025";

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
        result.shouldHave(text(birthDate));
    }

    @Test
    void negativeTest () {
        registrationPage.openPage()
                .removeBanners()
                .submitForm();

        registrationPage.getFirstNameInput().shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        registrationPage.getLastNameInput().shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        registrationPage.getUserNumberInput().shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
