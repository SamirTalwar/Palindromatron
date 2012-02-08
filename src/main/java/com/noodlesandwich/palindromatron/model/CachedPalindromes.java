package com.noodlesandwich.palindromatron.model;

import java.util.HashSet;
import java.util.Set;

public final class CachedPalindromes implements Palindromes {
    private final Palindromes palindromes;
    private final Set<String> trueCache = new HashSet<String>();
    private final Set<String> falseCache = new HashSet<String>();

    public CachedPalindromes(final Palindromes palindromes) {
        this.palindromes = palindromes;
    }

    @Override
    public boolean verify(final String string) {
        if (trueCache.contains(string)) {
            return true;
        }

        if (falseCache.contains(string)) {
            return false;
        }

        final boolean result = palindromes.verify(string);
        cache(string, result);
        return result;
    }

    private void cache(final String string, final boolean result) {
        (result ? trueCache : falseCache).add(string);
    }
}
