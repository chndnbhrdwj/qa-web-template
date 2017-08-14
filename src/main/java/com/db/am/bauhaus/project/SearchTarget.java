package com.db.am.bauhaus.project;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by ongshir on 06/04/2017.
 */
public class SearchTarget {
    //Updated few locators as they were no longer valid on web page

    public final static Target INPUT_BOX = Target.the("the search input box").located(By.id("search-query"));
    //public final static Target INPUT_BOX_BUTTON = Target.the("the search input button").located(By.cssSelector(".btn.btn-orange.btn-append"));
    public final static Target INPUT_BOX_BUTTON = Target.the("the search input button").located(By.cssSelector("button.btn.btn-primary"));
    //public final static Target TOP_CATEGORIES_HEADER = Target.the("the top categories header").located(By.cssSelector("h4.pb-xs-1-5"));
    public final static Target TOP_CATEGORIES_HEADER = Target.the("the top categories header").located(By.cssSelector(".pb-xs-1-5"));
    //public final static Target ALL_CATEGORIES_HEADER = Target.the("the all categories header").located(By.cssSelector("h1.conform-heading.display-inline"));
    public final static Target ALL_CATEGORIES_HEADER = Target.the("the all categories header").located(By.cssSelector("h1.display-inline"));
    public final static Target SORT_BY = Target.the("the sorting ").located(By.cssSelector("div#sortby"));
}
