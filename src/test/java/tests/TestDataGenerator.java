package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDataGenerator {
    private final Faker faker = new Faker(new Locale("en-US"));
    private String state = "";

    String getFirstName () {
        return faker.name().firstName();
    }

    String getLastName() {
        return faker.name().lastName();
    }

    String getEmail() {
       return faker.internet().emailAddress();
    }

    String getGender() {
        return faker.demographic().sex();
    }

    String getPhone() {
        int phoneLength = 10;
        return faker.phoneNumber().subscriberNumber(phoneLength);
    }

    String getSubject() {
        String[] subjects = {"Maths", "Accounting", "Physics"};
        return faker.options().nextElement(subjects);
    }

    String getUploadPicture() {
        return "samia.jpg";
    }

    String getAddress() {
        return faker.address().fullAddress();
    }

    String getState() {
        String[] states = { "NCR", "Uttar Pradesh", "Haryana", "Rajasthan" };
        state = faker.options().nextElement(states);
        return state;
    }

    String getCity() {
        switch (state) {
            case "NCR" -> {
                String[] cities = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().nextElement(cities);
            }
            case "Uttar Pradesh" -> {
                String[] cities = {"Agra", "Lucknow", "Merrut"};
                return faker.options().nextElement(cities);
            }
            case "Haryana" -> {
                String[] cities = {"Karnal", "Panipat"};
                return faker.options().nextElement(cities);
            }
            case "Rajasthan" -> {
                String[] cities = {"Jaipur", "Jaiselmer"};
                return faker.options().nextElement(cities);
            }
        }
        return "NONE";
    }

    String getDay() {
        Date date = faker.date().birthday(20, 35);
        return new SimpleDateFormat("dd").format(date);
    }

    String getMonth() {
        Date date = faker.date().birthday(20, 35);
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(date);
    }

    String getYear() {
        Date date = faker.date().birthday(20, 35);
        return new SimpleDateFormat("yyyy").format(date);
    }

    String getCurrentDay() {
        Date date = new Date();
        return new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH).format(date);
    }

    String getHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().nextElement(hobbies);
    }
}
