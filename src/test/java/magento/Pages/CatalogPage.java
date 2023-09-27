package magento.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    public SelenideElement getElementByText(String text){
        return $(byText(text));
    }
    public SelenideElement size =  $("[id=\"option-label-size-143-item-170\"]");
    public SelenideElement color =  $("[id=\"option-label-color-93-item-60\"]");
    public SelenideElement btnCatalog =  $("[class=\"action tocart primary\"]");
    public SelenideElement showCart = $("[class='action showcart']");
    public SelenideElement viewCart = $("[class=\"action viewcart\"]");

}
