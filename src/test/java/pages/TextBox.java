package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TextBox {
    private SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");

    public TextBox openPage() {
        open("/text-box");
        return this;
    }

    public TextBox deleteAdds(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBox setUserName (String name){
        userNameInput.setValue(name);
        return this;
    }

    public TextBox setUserEmail (String email){
        userEmailInput.setValue(email);
        return this;
    }

    public TextBox setAllAddresses (List<String> address){
        currentAddressInput.setValue(address.get(0));
        permanentAddressInput.setValue(address.get(1));
        return this;
    }

    public TextBox clickOnSubmit(){
        submitInput.click();
        return this;
    }
}
