package magento;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import magento.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class MagentoTests {
    private static final Logger logger = LogManager.getLogger(MagentoTests.class);


    @BeforeEach
    void beforeEach() {
        Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://magento.softwaretestingboard.com/";
        Configuration.timeout = 15000;
    }
    @Test
    void magentoTestCell(){
        logger.info("Product search on the website");
        open ("https://magento.softwaretestingboard.com/");
        SearchPage searchPage = new SearchPage();
        searchPage.search.setValue("Primo Endurance Tank").pressEnter();

        logger.info("Find product in catalog");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.getElementByText("Primo Endurance Tank").shouldHave(Condition.visible);
        logger.info("Choose size, color and add product to basket");
        catalogPage.size.click();
        catalogPage.color.click();
        catalogPage.btnCatalog.click();
        catalogPage.showCart.scrollTo().shouldHave(text("1")).click();
        catalogPage.viewCart.click();

        logger.info("Check parameters of the added product to the basket");
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.itemName.shouldHave(text("Primo Endurance Tank"));
        shoppingCartPage.itemOptions.shouldHave(text("XL"),text("Yellow"));
        shoppingCartPage.btnCheckout.click();

        logger.info("Filling out personal information for ordering");
        ShippingPage shippingPage = new ShippingPage();
        shippingPage.email.setValue(TestData.USER_EMAIL);
        shippingPage.firstName.setValue(TestData.FIRST_NAME);
        shippingPage.lastName.setValue(TestData.LAST_NAME);
        shippingPage.street.setValue(TestData.STREET);
        shippingPage.city.setValue(TestData.CITY);
        shippingPage.region.selectOption(TestData.REGION);
        shippingPage.postcode.setValue(TestData.POSTCODE);
        shippingPage.country.selectOption(TestData.COUNTRY);
        shippingPage.telephone.setValue(TestData.TELEPHONE);
        shippingPage.btnPrice.click();
        shippingPage.btnPrimary.click();

        logger.info("Check that the information has been right");
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.btnPlaceOrder.should(Condition.visible).click();

        logger.info("Check that the order has been placed successfully");
        FinishPage finishPage = new FinishPage();
        finishPage.titleFinishPage.shouldHave(text("Thank you for your purchase!"));

    }

        //@Test
        //void noPageObjectExample(){
        //$("[id=\"search\"]").setValue("Primo Endurance Tank").pressEnter();

        //$(byText("Primo Endurance Tank")).should(Condition.visible);
        //$("[id=\"option-label-size-143-item-170\"]").click();
        //$("[id=\"option-label-color-93-item-60\"]").click();
        //$("[class=\"action tocart primary\"]").click();
        //$("[class='action showcart']").scrollTo().shouldHave(text("1")).click();
        //$("[class=\"action viewcart\"]").click();

        //$(".item-info [class=\"product-item-name\"] a").shouldHave(text("Primo Endurance Tank"));
        //$(".item-info [class=\"item-options\"]").shouldHave(text("XL"),text("Yellow"));
        //$("[data-role=\"proceed-to-checkout\"]").click();

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

        //$("[class=\"primary\"] button[title='Place Order']").should(Condition.visible);
        //$("[class=\"primary\"] button[title='Place Order']").click();
        //sleep(10000);

        //$("[class=\"page-title-wrapper\"]").shouldHave(text("Thank you for your purchase!"));
    }

