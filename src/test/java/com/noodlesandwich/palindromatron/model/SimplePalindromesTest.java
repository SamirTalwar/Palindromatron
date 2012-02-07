package com.noodlesandwich.palindromatron.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public final class SimplePalindromesTest {
    @Test public void
    verifies_palindromes() {
        assertThat(new SimplePalindromes().verify("tenet"), is(true));
    }
}
