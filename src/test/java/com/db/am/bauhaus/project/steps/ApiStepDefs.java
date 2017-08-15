package com.db.am.bauhaus.project.steps;


import com.db.am.bauhaus.project.API_PATH;
import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.steplib.ApiActions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.util.List;

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

    @When("^Peter make the (.*) api call$")
    public void heMakeSearchTheApiCall(String apiName) throws Throwable {
        if(apiName.contains(API_PATH.SEARCH.name().toLowerCase())) {
            apiActions
                    .requestSearchResponse();
        }

        if(apiName.contains(API_PATH.CATEGORIES.name().toLowerCase())) {
            apiActions
                    .requestNavigationCategoriesResponse();
        }

    }

    @Then("^he should see the results in response$")
    public void heShouldSeeTheResults() throws Throwable {
        assertTrue(
                apiActions
                        .doesResponseContainsResults()
        );
    }

    @Then("^he should see the categories in response$")
    public void heShouldSeeTheCategoriesInResponse(DataTable criteria) throws Throwable {
        List<String> expectedCategories = criteria.asList(String.class);

        List<String> actualCategories = apiActions
                .doesResponseContainsCategories();

        for(String category: expectedCategories) {
            assertTrue(actualCategories.contains(category));
        }
    }

    @Then("^he should see the response status code (\\d+)$")
    public void heShouldSeeTheResponseStatusCode(int arg0) throws Throwable {
        assertTrue(
                apiActions.getStatusCode() == arg0
        );
    }
}
