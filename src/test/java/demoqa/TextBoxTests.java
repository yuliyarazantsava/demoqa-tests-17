package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("[id=\"userName\"]").setValue("Julia");
        $("[id=\"userEmail\"]").setValue("juliett@mail.ru");
        $("[id=\"currentAddress\"]").setValue("warsaw");
        $("[id=\"permanentAddress\"]").setValue("minsk");
        $("[id=\"submit\"]").click();
        $("[id=\"output\"]").shouldBe(visible);
        sleep(5000);
    }
}
