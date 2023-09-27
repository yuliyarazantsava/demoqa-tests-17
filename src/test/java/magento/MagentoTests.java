package magento;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import magento.Pages.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.impl.Html.text;

public class MagentoTests {
    @BeforeAll
     static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://magento.softwaretestingboard.com/";
        Configuration.timeout = 10000;
    }
    @Test
    void magentoTestCell(){
        open ("https://magento.softwaretestingboard.com/");
        SearchPage searchPage = new SearchPage();
        searchPage.search.setValue("Primo Endurance Tank").pressEnter();
        //$("[id=\"search\"]").setValue("Primo Endurance Tank").pressEnter();

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.getElementByText("Primo Endurance Tank").shouldHave(Condition.visible);
        catalogPage.size.click();
        catalogPage.color.click();
        catalogPage.btnCatalog.click();
        catalogPage.showCart.scrollTo().shouldHave(text("1")).click();
        catalogPage.viewCart.click();
        //$(byText("Primo Endurance Tank")).should(Condition.visible);
        //$("[id=\"option-label-size-143-item-170\"]").click();
        //$("[id=\"option-label-color-93-item-60\"]").click();
        //$("[class=\"action tocart primary\"]").click();
        //$("[class='action showcart']").scrollTo().shouldHave(text("1")).click();
        //$("[class=\"action viewcart\"]").click();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.itemName.shouldHave(text("Primo Endurance Tank"));
        shoppingCartPage.itemOptions.shouldHave(text("XL"),text("Yellow"));
        shoppingCartPage.btnCheckout.click();
        //$(".item-info [class=\"product-item-name\"] a").shouldHave(text("Primo Endurance Tank"));
        //$(".item-info [class=\"item-options\"]").shouldHave(text("XL"),text("Yellow"));
        //$("[data-role=\"proceed-to-checkout\"]").click();

        ShippingPage shippingPage = new ShippingPage();
        shippingPage.email.setValue("juliett@mail.ru");
        shippingPage.firstName.setValue("Julia");
        shippingPage.lastName.setValue("Lon");
        shippingPage.street.setValue("Fredry");
        shippingPage.city.setValue("Miami");
        sleep(5000);
        shippingPage.region.selectOption("Florida");
        shippingPage.postcode.setValue("12345");
        shippingPage.country.selectOption("United States");
        shippingPage.telephone.setValue("555555555");
        shippingPage.btnPrice.click();
        sleep(5000);
        shippingPage.btnPrimary.click();
        sleep(5000);
        //$("[id=\"customer-email\"]").setValue("juliett@mail.ru");
        //$("[name=\"firstname\"]").setValue("Julia");
        //$("[name=\"lastname\"]").setValue("Lon");
        //$("[name=\"street[0]\"]").setValue("Fredry");
        //$("[name=\"city\"]").setValue("Miami");
        //sleep(5000);
        //$("[name=\"region_id\"]").selectOption("Florida");
        //$("[name=\"postcode\"]").setValue("12345");
        //$("[name=\"country_id\"]").selectOption("United States");
        //$("[name=\"telephone\"]").setValue("555555555");
        //$("[class=\"price\"]").click();
        //sleep(5000);
        //$("[class=\"button action continue primary\"]").click();
        //sleep(5000);

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.btnPlaceOrder.should(Condition.visible).click();
        sleep(10000);
        //$("[class=\"primary\"] button[title='Place Order']").should(Condition.visible);
        //$("[class=\"primary\"] button[title='Place Order']").click();
        //sleep(10000);

        FinishPage finishPage = new FinishPage();
        finishPage.titleFinishPage.shouldHave(text("Thank you for your purchase!"));
        //$("[class=\"page-title-wrapper\"]").shouldHave(text("Thank you for your purchase!"));

    }
}

