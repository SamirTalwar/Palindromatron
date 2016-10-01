package com.noodlesandwich.palindromatron.model;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class CachedPalindromesTest {
    @Rule public final JUnitRuleMockery context = new JUnitRuleMockery();

    private final Palindromes palindromes = context.mock(Palindromes.class);
    private final CachedPalindromes cachedPalindromes = new CachedPalindromes(palindromes);

    @Test public void
    delegates_to_the_provided_Palindromes_service() {
        context.checking(new Expectations() {{
            oneOf(palindromes).verify("Murder for a jar of red rum"); will(returnValue(true));
            oneOf(palindromes).verify("Murder for a jar of yellow custard"); will(returnValue(false));
        }});

        assertThat(cachedPalindromes.verify("Murder for a jar of red rum"), is(true));
        assertThat(cachedPalindromes.verify("Murder for a jar of yellow custard"), is(false));
    }

    @Test public void
    remembers_verified_results() {
        context.checking(new Expectations() {{
            oneOf(palindromes).verify("a Toyota"); will(returnValue(true));
        }});

        assertThat(cachedPalindromes.verify("a Toyota"), is(true));
        assertThat(cachedPalindromes.verify("a Toyota"), is(true));
    }

    @Test public void
    remembers_rejected_results() {
        context.checking(new Expectations() {{
            oneOf(palindromes).verify("a Hyundai"); will(returnValue(false));
        }});

        assertThat(cachedPalindromes.verify("a Hyundai"), is(false));
        assertThat(cachedPalindromes.verify("a Hyundai"), is(false));
    }
}
