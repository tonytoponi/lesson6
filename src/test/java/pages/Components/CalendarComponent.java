package pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    private final SelenideElement monthInput = $(".react-datepicker__month-select"),
                        yearInput = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        String yearValueSelector = String.format("option[value='%s']", year);
        String dayValueSelector = String.format(".react-datepicker__day--0%s", day);

        monthInput.$(byText(month)).click();
        yearInput.find(yearValueSelector).click();
        $(dayValueSelector).click();
    }
}
