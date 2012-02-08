package com.noodlesandwich.palindromatron.model;

public final class CachedPalindromes implements Palindromes {
    private final Palindromes palindromes;

    public CachedPalindromes(final Palindromes palindromes) {
        this.palindromes = palindromes;
    }

    @Override
    public boolean verify(final String string) {
        return palindromes.verify(string);
    }
}
