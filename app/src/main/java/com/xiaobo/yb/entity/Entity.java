package com.xiaobo.yb.entity;

public class Entity {
    private String text;
    private String hint;
    private String title;

    public Entity() {
    }

    public Entity(String text, String hint, String title) {
        this.text = text;
        this.hint = hint;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
