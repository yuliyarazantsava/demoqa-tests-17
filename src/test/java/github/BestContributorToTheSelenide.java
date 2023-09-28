package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToTheSelenide {
    @Test
    void solntsevShouldBeTheTopContributor(){
        open("https://github.com/selenide/selenide");

        $(".BorderGrid").$(byText ("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        $$(".Popover .Popover-message").findBy(Condition.visible).shouldHave(Condition.text("Andrei Solntsev"));
        sleep(5000);
    }
}
