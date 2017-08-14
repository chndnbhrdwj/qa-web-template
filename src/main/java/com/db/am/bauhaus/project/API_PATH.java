package com.db.am.bauhaus.project;

/**
 * Created by chandan on 14/08/2017.
 */
public enum API_PATH {
    SEARCH("shop_name_search_service"),
    CATEGORIES("api/v3/ajax/public/category-nav/view/subnav");

    private String s;

    API_PATH(String s){
        this.s = s;
    }

    @Override
    public String toString(){
        return s;
    }
}
