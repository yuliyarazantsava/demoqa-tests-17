package magento.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ShippingPage {
    public SelenideElement email = $("#customer-email");
    public SelenideElement firstName = $("[name='firstname']");
    public SelenideElement lastName = $("[name='lastname']");
    public SelenideElement street = $("[name='street[0]']");
    public SelenideElement city = $("[name='city']");
    public SelenideElement region = $("[name='region_id']");
    public SelenideElement postcode =  $("[name='postcode']");
    public SelenideElement country =   $("[name='country_id']");
    public SelenideElement telephone =    $("[name='telephone']");
    public SelenideElement btnPrice =    $(".price");
    public SelenideElement btnPrimary =     $("[class='button action continue primary']");

}
