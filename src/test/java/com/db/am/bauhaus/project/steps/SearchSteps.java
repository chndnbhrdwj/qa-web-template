package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.*;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.steplib.SearchUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchSteps {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    SearchUser user;

    MainSearchPage mainSearchPage;

    @Given("^John is viewing the Etsy landing page$")
    public void goto_landing_page() {
        mainSearchPage.open();
    }

    @Given("^([^\\s]+) is viewing the Etsy landing page \\(screenplay\\)$")
    public void goto_landing_page_screenplay(String theUser) {
        theActorCalled(theUser).attemptsTo(Open.browserOn().the(mainSearchPage));
    }

    @When("^he searches for a product from the input box$")
    public void search_from_input_box() {
        user.search_from_input_box();
    }

    @When("^he searches for a product from the input box \\(screenplay\\)$")
    public void search_from_input_box_screenplay() {
        theActorInTheSpotlight().attemptsTo(SearchFor.randomText());
    }

    @Then("^the result should be displayed$")
    public void verify_search_result() {
        user.verify_result_for_top_categories();
        user.verify_result_for_all_categories();
    }

    @Then("^the result should be displayed \\(screenplay\\)$")
    public void verify_search_result_screenplay() {
        String searchText = Serenity.sessionVariableCalled(SessionVar.SEARCH_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the top categories header ", the(SearchTarget.TOP_CATEGORIES_HEADER), containsText(searchText)),
                seeThat("the all categories header ", the(SearchTarget.ALL_CATEGORIES_HEADER), containsText(searchText))
        );
    }

    @When("^s?he selects (.*) under navigation menu (.*)$")
    public void heSelectsPoetryUnderNavigationMenuEntertainmentScreenplay(String selectText, String navigationMenu) throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                SelectFromDropDownMenu
                        .textCalled(navigationMenu, selectText)
        );
    }

    @Then("^the result should be displayed for selected option$")
    public void theResultShouldBeDisplayedForSelectedOptionScreenplay() throws Throwable {
        String selectedText = Serenity.sessionVariableCalled(SessionVar.SELECT_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the menu path header ", the(SelectFromDropDownTarget.MENU_PATH_HEADER), containsText(selectedText)),
                seeThat("the page header ", the(SelectFromDropDownTarget.PAGE_HEADER), containsText(selectedText)),
                seeThat("the all categories header ", the(SelectFromDropDownTarget.ALL_CATEGORIES_HEADER), containsText(selectedText))
        );
    }

    @When("^s?he selects (.*) icon$")
    public void heSelectsClothingIcon(String selectIconText) throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                SelectFromIcons
                        .textCalled(selectIconText)
        );
    }

    @And("^he should see the sorting option$")
    public void heShouldSeeTheSortingOption() throws Throwable {
        theActorInTheSpotlight().should(
                seeThat("the sort by section", the(SearchTarget.SORT_BY), isVisible())
        );
    }
}
