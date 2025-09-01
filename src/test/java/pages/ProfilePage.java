package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
    private SelenideElement
            userNameValue = $("#userName-value"),
            table = $(".rt-table"),
            submitButton = $("#submit");

    public ProfilePage chekTableVisible() {
        table.shouldBe(visible);
        return this;
    }

    public ProfilePage checkUsernameValue (String userName) {
        userNameValue.shouldHave(text(userName));
        return this;
    }

    public ProfilePage logOut () {
        submitButton.click();
        return this;
    }
}
