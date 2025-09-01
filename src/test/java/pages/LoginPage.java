package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement
            userName = $("#userName"),
            userPassword = $("#password");

    public LoginPage openPage() {
        open("/login");
        return this;
    }

    public LoginPage deleteAdd() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public LoginPage setUserNameAndPassword(String username, String password) {
        userName.setValue(username);
        userPassword.setValue(password).pressEnter();
        return this;
    }
}
