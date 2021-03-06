package pages;

import initialization.Initialization;
import org.openqa.selenium.support.ui.Select;
import utility.Util;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Page extends Initialization {

    // TODO: create other pages, using subclass "Builder" to build a page, based different attributes(selectors selected, arguments passed, etc.)
    // https://stackoverflow.com/questions/1988016/named-parameter-idiom-in-java

    // TODO: Get credentials from file
    public void login(CharSequence login, CharSequence password) {
        $("input[id*='login'], input[name*='login'], input[class*='login']").sendKeys(login);
        $("input[id*='pass'], input[name*='pass'], input[class*='pass']").sendKeys(password);
        $("form[id*='login'], form[name*='login'], form[class*='login']").submit();
    }


    protected int getRandomOptionIndex(Select select, int minIndex) {
        int optionsCount = select.getOptions().size();
        int max = optionsCount - 1;
        return Util.getRandomInt(minIndex, max);
    }

    public Select selectRandom(Select select) {
        int min = 0;
        select.selectByIndex(getRandomOptionIndex(select, min));

        return select;
    }

    public Select selectRandom(Select select, int minIndex) {
        int optionsCount = select.getOptions().size();
        int max = optionsCount - 1;
        select.selectByIndex(Util.getRandomInt(minIndex, max));

        return select;
    }

    //TODO: adapt the methods below
    /*
    public void randomSelect(Select select) {
        int min = 0;
        if (select.getFirstSelectedOption().getAttribute("value").equals("0")) {
            min++;
        }
        select.selectByIndex(getRandomOptionIndex(select, min));
    }

    protected List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public void randomRadio(WebElement radio) {
        List<WebElement> radios = findElements("//input[@type='radio'][@name='" + radio.getAttribute("name") + "']");
        radios.get(getRandomInt(0, radios.size() - 1)).click();
    }

    protected void alert_accept() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }
    */
}
