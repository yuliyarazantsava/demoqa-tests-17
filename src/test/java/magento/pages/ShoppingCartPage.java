package magento.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {
    public SelenideElement itemName = $(".item-info .product-item-name a");
    public SelenideElement itemOptions =  $(".item-info .item-options");
    public SelenideElement btnCheckout = $("[data-role='proceed-to-checkout']");


}
