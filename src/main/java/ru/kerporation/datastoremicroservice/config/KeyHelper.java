package ru.kerporation.datastoremicroservice.config;

import lombok.Setter;

import java.util.Objects;

public class KeyHelper {

    private static final String DEFAULT_PREFIX = "app";

    @Setter
    private static String prefix = null;

    public static String getKey(final String key) {
        return getPrefix() + ":" + key;
    }

    public static String getPrefix() {
        return Objects.requireNonNullElse(prefix, DEFAULT_PREFIX);
    }
}