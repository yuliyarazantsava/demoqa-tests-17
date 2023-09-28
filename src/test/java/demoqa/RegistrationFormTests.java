package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("[placeholder=\"First Name\"]").setValue("Julia");
        $("[placeholder=\"Last Name\"]").setValue("Lon");
        $("[id=\"userEmail\"]").setValue("juliett@mail.ru");
        $("[for='gender-radio-2']").click();
        $("[id=\"userNumber\"]").setValue("5555555555");
        $("[id=\"dateOfBirthInput\"]").click();
        $("[class=\"react-datepicker__month-select\"]").selectOption("October");
        $("[class=\"react-datepicker__year-select\"]").selectOption("1994");
        $("[class=\"react-datepicker__day react-datepicker__day--026\"]").click();


        $("#subjectsInput").setValue("I don't like to study");
        $("[for='hobbies-checkbox-3']").click();
        $("[id=\"uploadPicture\"]").uploadFile(new File("/Users/yryazantseva/javalearning/demoqa-tests-17/src/test/resources/1.png"));
        $("[id=\"currentAddress\"]").setValue("Warsaw");

        $("[id=\"state\"]").click();
        $(byText("Haryana")).click();
        $("[id=\"city\"]").click();
        $(byText("Karnal")).click();
        $("[id=\"submit\"]").click();
        $("[id=\"example-modal-sizes-title-lg\"]").shouldHave(text("Thanks for submitting the form"));
        $("[class=\"table table-dark table-striped table-bordered table-hover\"]")
                .shouldHave(text("Julia")
                        .text("Lon")
                        .text("juliett@mail.ru")
                        .text("female")
                        .text("5555555555")
                        .text("26 October,1994")
                        .text("Reading")
                        .text("Warsaw")
                        .text("Haryana")
                        .text("Karnal"));




        sleep(5000);
    }
}

