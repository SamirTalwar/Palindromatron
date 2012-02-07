package com.noodlesandwich.palindromatron.model;

public class SimplePalindromes implements Palindromes {
    @Override
    public boolean verify(final String string) {
        final String normalised = string.toLowerCase().replaceAll("\\W", "");
        final String reversed = new StringBuffer(normalised).reverse().toString();
        return normalised.equals(reversed);
    }
}
