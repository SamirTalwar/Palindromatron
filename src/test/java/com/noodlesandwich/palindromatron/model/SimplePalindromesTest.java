package com.noodlesandwich.palindromatron.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public final class SimplePalindromesTest {
    private final SimplePalindromes palindromes = new SimplePalindromes();

    @Test public void
    verifies_palindromes() {
        assertThat(palindromes.verify("tenet"), is(true));
    }

    @Test public void
    rejects_non_palindromes() {
        assertThat(palindromes.verify("tennis"), is(false));
    }
}
