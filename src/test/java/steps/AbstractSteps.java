package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractSteps {

    @Step("Open moodpanda.com/{urn}")
    protected void openPage(String urn, String pageIdSelector, Condition successCondition) {
        open(urn);
        $(pageIdSelector).shouldHave(successCondition);
    }

//    public boolean elementMatchesCondition(String pageIdSelector, Condition successCondition) {
//        try {
//            $(pageIdSelector).shouldHave(successCondition);
//        } catch (Exception ex) {
//            return false;
//        }
//        return true;
//    }

}
