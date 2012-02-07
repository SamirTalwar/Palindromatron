package com.noodlesandwich.palindromatron.model;

public class SimplePalindromes implements Palindromes {
    @Override
    public boolean verify(final String string) {
        final String strippedString = string.replaceAll("\\W", "");
        final String reversed = new StringBuffer(strippedString).reverse().toString();
        return strippedString.equals(reversed);
    }
}
