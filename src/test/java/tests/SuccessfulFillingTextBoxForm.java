package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.TextBox;
import pages.components.BoxResultsComponent;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("Успешное заполнение формы на TextBox")
public class SuccessfulFillingTextBoxForm extends TastBase {

    TextBox textBox = new TextBox();
    BoxResultsComponent textBoxResults = new BoxResultsComponent();

    static Stream<Arguments>  fillingFormWithMethodSourceParametrizeTest(){
        return Stream.of(
                Arguments.of("Alex", "alex@egorov.com", List.of("Some street 1", "Another street 1")),
                Arguments.of("Bob", "Bob@gmail.com", List.of("London", "Baker street 231"))
        );
    }

    @DisplayName("Заполнение Text Box формы с помощью @MethodSource")
    @MethodSource
    @ParameterizedTest (name = "Заполнение формы с именем {0}, почтой {1}, адресами {2}")
    void fillingFormWithMethodSourceParametrizeTest(String userName, String userEmail,
                                 List<String> addresses) {
        textBox
                .openPage()
                .deleteAdds()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setAllAddresses(addresses)
                .clickOnSubmit();

        textBoxResults
                .checkResults(userName, userEmail,
                addresses);
    }
}