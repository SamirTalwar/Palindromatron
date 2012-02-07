package com.noodlesandwich.palindromatron.model;

public class SimplePalindromes implements Palindromes {
    @Override
    public boolean verify(final String string) {
        final String normalisedString = string.toLowerCase().replaceAll("\\W", "");
        final String reversed = new StringBuffer(normalisedString).reverse().toString();
        return normalisedString.equals(reversed);
    }
}
