package com.db.am.bauhaus.project.steps;


import com.db.am.bauhaus.project.API_PATH;
import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.steplib.ApiActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

/**
 * Created by chandan on 14/08/2017.
 */
public class ApiStepDefs {

    @Steps
    ApiActions apiActions;

    @Given("^Peter want to call api to search for (.*)$")
    public void peterWantToCallApiToSearchForSearchText(String searchText) throws Throwable {
        Serenity.setSessionVariable(SessionVar.PATH).to(API_PATH.SEARCH);
        Serenity.setSessionVariable(SessionVar.SEARCH_TEXT).to(searchText);
    }

    @When("^he make the (.*) api call$")
    public void heMakeSearchTheApiCall(String api) throws Throwable {
        if(api.contains("search")) {
            apiActions.requestSearchResponse();
        }
        if(api.contains("categories")) {
            apiActions.requestNavigationCategoriesResponse();
        }

    }

    @Then("^he should see the results in response$")
    public void heShouldSeeTheResults() throws Throwable {
        assertTrue(apiActions.doesResponseContainsResults());
    }

    @Given("^Peter want to call api for navigation categories$")
    public void peterWantToCallApiForNavigationCategories() throws Throwable {
        Serenity.setSessionVariable(SessionVar.PATH).to(API_PATH.CATEGORIES);
    }

    @Then("^he should see the categories in response$")
    public void heShouldSeeTheCategoriesInResponse() throws Throwable {

    }
}
