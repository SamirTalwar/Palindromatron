package com.noodlesandwich.palindromatron.model;

public class SimplePalindromes implements Palindromes {
    @Override
    public boolean verify(final String string) {
        final String reversed = new StringBuffer(string).reverse().toString();
        return string.equals(reversed);
    }
}
