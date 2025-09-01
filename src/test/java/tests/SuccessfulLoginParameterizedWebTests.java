package tests;

import data.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.LoginPage;
import pages.ProfilePage;

@DisplayName("Тесты на успешную авторизацию на DEMOQA")
public class SuccessfulLoginParameterizedWebTests extends TastBase {

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @DisplayName("Тесты на авторизацию с использованием @CsvSource")
    @CsvSource(value = {
            "AlexTerrible, Qwer!1234",
            "arane1223, Arane@1223"})
    @ParameterizedTest(name = "Залогиниться на DEMOQA по логину {0} и паролю {1}")
    void successfulLoginOnDemoqaWithCsvSourceTest(String userName, String password) {
        loginPage
                .openPage()
                .deleteAdd().setUserNameAndPassword(userName, password);

        profilePage
                .chekTableVisible()
                .checkUsernameValue(userName)
                .logOut();
    }

    @DisplayName("Тесты на авторизацию с использованием @CsvFileSource")
    @CsvFileSource(resources = "/LoginAndPassword.csv")
    @ParameterizedTest(name = "Залогиниться на DEMOQA по логину {0} и паролю {1}")
    void successfulLoginOnDemoqaWithCsvFileSourceTest(String userName, String password) {
        loginPage
                .openPage()
                .deleteAdd().setUserNameAndPassword(userName, password);

        profilePage
                .chekTableVisible()
                .checkUsernameValue(userName)
                .logOut();
    }

    @DisplayName("Тесты на авторизацию с использованием @EnumSource")
    @EnumSource(Users.class)
    @ParameterizedTest(name = "Залогиниться на DEMOQA по логину {0} и паролю {1}")
    void successfulLoginOnDemoqaWithEnumTest(Users users) {
        loginPage
                .openPage()
                .deleteAdd().setUserNameAndPassword(users.userName, users.password);

        profilePage
                .chekTableVisible()
                .checkUsernameValue(users.userName)
                .logOut();
    }
}