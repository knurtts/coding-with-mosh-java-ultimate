package com.codewithmosh;

public class CheckBox extends UIControl {
    public CheckBox(boolean isEnabled) {
        super(isEnabled);
    }

    @Override
    public void render() {
        System.out.println("Render CheckBox");
    }
}
