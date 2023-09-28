package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SelenideRepositorySearch {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){

        //открыть гл стр
        open ("https://github.com/");
        // ввести в поле поиска селениде и нажать энтер
        $ ("[placeholder=\"Search or jump to...\"]").click();
        $ ("[id=\"query-builder-test\"]").setValue("selenide").pressEnter();
        //выбрать первый репозиторий из списка найденных
        $ ("[href=\"/selenide/selenide\"]").click();
        //проверка : заголовок selenide/selenide
        $("[id=\"repository-container-header\"]").shouldHave(Condition.text("selenide"));
        sleep(5000);
    }
}
