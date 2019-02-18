package testing.selenium.page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://google.com")
public class goDashboard extends PageObject {

    public goDashboard(WebDriver driver) {
        super(driver);
    }
}
