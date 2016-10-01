package com.noodlesandwich.palindromatron;

import com.google.inject.Guice;
import com.noodlesandwich.palindromatron.configuration.Configuration;
import org.junit.Test;

public class ConfigurationTest {
    @Test public void
    configuration_is_successful() {
        Guice.createInjector(new Configuration());
    }
}
