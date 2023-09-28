package magento.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    public SelenideElement btnPlaceOrder =  $(".primary button[title='Place Order']");

}
