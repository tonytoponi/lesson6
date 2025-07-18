package pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ResultTable {
    public SelenideElement getTableElement() {
        return $(".table-responsive");
    }
}
