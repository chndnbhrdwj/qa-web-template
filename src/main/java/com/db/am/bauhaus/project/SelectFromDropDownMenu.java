package com.db.am.bauhaus.project;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by chandan on 13/08/2017.
 */
public class SelectFromDropDownMenu implements Task {

    private String selectText;
    private String navigationMenuOption;

    @Step("{0} selects #selectText under #navigationMenuOption")
    public <T extends Actor> void performAs(T theUser) {
        theUser.should(
                seeThat("the navigation menu", the(SelectFromDropDownTarget.NAVIGATION_MENU), isVisible())
        );

        theUser.attemptsTo(
                Click.on(By.xpath("//li[@class='catnav-primary-item list-inline-item']/a[text()='"+navigationMenuOption+"']")),
                Click.on(By.xpath("//*[text()='"+selectText+"']"))
        );
        Serenity.setSessionVariable(SessionVar.SELECT_TEXT).to(selectText);
    }

    public static SelectFromDropDownMenu textCalled(String navigationMenu, String selectText) {
        return Instrumented.instanceOf(SelectFromDropDownMenu.class)
                .withProperties(navigationMenu, selectText);
    }

    public SelectFromDropDownMenu(String navigationMenuOption, String selectText) {
        this.navigationMenuOption = navigationMenuOption;
        this.selectText = selectText;
    }

}
