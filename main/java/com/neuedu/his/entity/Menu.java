package com.neuedu.his.entity;

import java.util.List;

public class Menu {
    private String name;
    private String title;
    private String icon;
    private String path;
    private String component;
    private List<Menu> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(String name, String title, String icon, String path, String component, List<Menu> children) {
        this.name = name;
        this.title = title;
        this.icon = icon;
        this.path = path;
        this.component = component;
        this.children = children;
    }

    public Menu() {
    }
}
