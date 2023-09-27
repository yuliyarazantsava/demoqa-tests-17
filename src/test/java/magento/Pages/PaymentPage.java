package magento.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

//public SelenideElement userEmail = $("#user-email");
//public SelenideElement userPassword = $(".password");
//public SelenideElement btnLogin = $("[name='login button']");
public class PaymentPage {
    public SelenideElement btnPlaceOrder =  $("[class=\"primary\"] button[title='Place Order']");

}
