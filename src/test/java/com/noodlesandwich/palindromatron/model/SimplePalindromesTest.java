package com.noodlesandwich.palindromatron.model;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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

    @Test public void
    ignores_white_space() {
        assertThat(palindromes.verify("never\nodd or\teven"), is(true));
    }

    @Test public void
    do_not_ignore_numbers() {
        assertThat(palindromes.verify("23 god dog 23"), is(false));
    }

    @Test public void
    ignore_case() {
        assertThat(palindromes.verify("Madam"), is(true));
    }

    @Test public void
    ignore_punctuation() {
        assertThat(palindromes.verify("Madam, I'm Adam."), is(true));
    }
}
