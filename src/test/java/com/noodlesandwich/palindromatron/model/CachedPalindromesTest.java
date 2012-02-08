package com.noodlesandwich.palindromatron.model;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public final class CachedPalindromesTest {
    private final Mockery context = new Mockery();

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
}
