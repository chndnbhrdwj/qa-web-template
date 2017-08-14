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
public class SelectFromIcons implements Task {

    private String selectIconText;

    @Step("{0} selects #selectIconText")
    public <T extends Actor> void performAs(T theUser) {
        theUser.should(
                seeThat("the navigation menu", the(SelectFromDropDownTarget.NAVIGATION_MENU), isVisible())
        );

        theUser.attemptsTo(
                Click.on(By.xpath("//span[@class='vesta-hp-category-default']//div[@class='card-meta']//*[text()='"+selectIconText+"']/ancestor::a"))
        );
        Serenity.setSessionVariable(SessionVar.SELECT_TEXT).to(selectIconText);
    }

    public static SelectFromIcons textCalled(String selectIconText) {
        return Instrumented.instanceOf(SelectFromIcons.class)
                .withProperties(selectIconText);
    }

    public SelectFromIcons(String selectIconText) {
        this.selectIconText = selectIconText;
    }

}
