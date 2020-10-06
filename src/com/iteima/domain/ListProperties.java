package com.iteima.domain;

import java.util.List;

public class ListProperties {
	private String key;
    private List<ReplayUser> valueList;
 
    public void setKey(String key) {
        this.key = key;
    }
 
    public String getKey() {
        return key;
    }
 
    public void setValueList(List<ReplayUser> valueList) {
        this.valueList = valueList;
    }
 
    public List<ReplayUser> getValueList() {
        return valueList;
    }
}
