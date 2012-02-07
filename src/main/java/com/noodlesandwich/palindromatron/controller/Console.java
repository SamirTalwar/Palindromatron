package com.noodlesandwich.palindromatron.controller;

import javax.inject.Inject;

import com.noodlesandwich.palindromatron.model.Palindromes;
import com.noodlesandwich.palindromatron.view.Input;
import com.noodlesandwich.palindromatron.view.Output;

public final class Console implements Controller {
    private final Input input;
    private final Output output;
    private final Palindromes palindromes;

    @Inject
    public Console(final Input input, final Output output, final Palindromes palindromes) {
        this.input = input;
        this.output = output;
        this.palindromes = palindromes;
    }

    @Override
    public void run() throws Exception {
        final String palindrome = input.read("Enter a palindrome: ");
        palindromes.verify(palindrome);
        output.write("Yes, \"" + palindrome + "\" is most certainly a palindrome.");
    }
}
