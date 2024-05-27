package com.trendyol.trainingapi.infrastracture.common.utils;

public class ToStringBuilder {
    private StringBuilder stringBuilder;
    private boolean isFirstTime = true;

    public ToStringBuilder init(String className) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(className);
        stringBuilder.append("[");
        return this;
    }

    public ToStringBuilder append(String name, Object value) {
        if (!isFirstTime) {
            stringBuilder.append(",");
        }
        stringBuilder.append(name);
        stringBuilder.append("=");
        stringBuilder.append(value);
        isFirstTime = false;
        return this;
    }

    @Override
    public String toString() {
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
