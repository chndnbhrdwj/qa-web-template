package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.API_PATH;
import com.db.am.bauhaus.project.SessionVar;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chandan on 14/08/2017.
 */
public class ApiActions {

    String BASE_URL = "https://www.etsy.com/";
    HashMap<String, String> param;

    @Step
    public void requestSearchResponse() {
        param =  new HashMap<>();
        param.put("q", Serenity.sessionVariableCalled(SessionVar.SEARCH_TEXT));
        callApi(API_PATH.SEARCH, param);
    }

    @Step
    public void requestNavigationCategoriesResponse() {
        param =  new HashMap<>();
        callApi(API_PATH.CATEGORIES, param);
    }

    @Step
    public boolean doesResponseContainsResults() {
        return ((int)SerenityRest.then().extract().body().jsonPath().get("total_results_count") > 0);
    }

    @Step
    public boolean doesResponseContainsCategories() {
        return false;
    }

    private void callApi(API_PATH path, Map<String, ?> params) {
        String url = BASE_URL+path.toString();
        SerenityRest.given().contentType("application/json")
                .when()
                .queryParameters(params)
                .get(url);
    }
}
