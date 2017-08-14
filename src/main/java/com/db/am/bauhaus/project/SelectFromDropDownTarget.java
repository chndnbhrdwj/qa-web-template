package com.db.am.bauhaus.project;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by chandan on 13/08/2017.
 */
public class SelectFromDropDownTarget {
    public final static Target NAVIGATION_MENU = Target.the("the navigation menu bar")
            .located(By.cssSelector("nav.catnav-primary"));

    public final static Target MENU_PATH_HEADER = Target.the("the menu path header")
            .located(By.xpath("//*[@class='mt-xs-2 pl-xs-1 pl-md-4 pl-lg-6 pr-xs-1 pr-md-4 pr-lg-6']"));

    public final static Target PAGE_HEADER = Target.the("the page header")
            .located(By.xpath("//div[@class='float-left']/h1"));

    public final static Target ALL_CATEGORIES_HEADER = Target.the("the all categories header")
            .located(By.xpath("//div[@class='mb-xs-3 pb-xs-3 bb-xs-1 filter-chrome']//li[@class='pl-xs-2']"));
}
