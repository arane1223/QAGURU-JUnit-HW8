package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BoxResultsComponent {
    private SelenideElement
            nameCheck = $("#output #name"),
            emailCheck = $("#output #email"),
            currentAddressCheck = $("#output #currentAddress"),
            permanentAddressCheck = $("#output #permanentAddress");

    public BoxResultsComponent checkResults(String name, String email,
                                            List<String> address) {
        nameCheck.shouldHave(text(name));
        emailCheck.shouldHave(text(email));
        currentAddressCheck.shouldHave(text(address.get(0)));
        permanentAddressCheck.shouldHave(text(address.get(1)));
        return this;
    }
}