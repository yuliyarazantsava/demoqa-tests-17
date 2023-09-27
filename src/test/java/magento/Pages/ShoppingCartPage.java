package magento.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

//public SelenideElement userEmail = $("#user-email");
//public SelenideElement userPassword = $(".password");
//public SelenideElement btnLogin = $("[name='login button']");
public class ShoppingCartPage {
    public SelenideElement itemName = $(".item-info [class=\"product-item-name\"] a");
    public SelenideElement itemOptions =  $(".item-info [class=\"item-options\"]");
    public SelenideElement btnCheckout = $("[data-role=\"proceed-to-checkout\"]");


}
