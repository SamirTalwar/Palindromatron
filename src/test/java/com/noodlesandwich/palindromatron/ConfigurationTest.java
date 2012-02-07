package com.noodlesandwich.palindromatron;

import org.junit.Test;

import com.google.inject.Guice;

public class ConfigurationTest {
    @Test public void
    configuration_is_successful() {
        Guice.createInjector(new Configuration());
    }
}
