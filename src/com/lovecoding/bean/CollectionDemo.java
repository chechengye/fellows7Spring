package com.lovecoding.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollectionDemo {

    private List list;
    private Object[] arr;

    private Map map;
    private Properties properties;


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Object[] getArr() {
        return arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CollectionDemo{" +
                "list=" + list +
                ", arr=" + Arrays.toString(arr) +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
