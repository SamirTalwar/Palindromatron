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
        while (true) {
            final String palindrome = input.read("Enter a palindrome: ");
            if (palindrome.length() == 0) {
                break;
            }

            if (palindromes.verify(palindrome)) {
                output.write("Yes, \"" + palindrome + "\" is most certainly a palindrome.");
            } else {
                output.write("Don't be ridiculous. \"" + palindrome + "\" is definitely not a palindrome.");
            }
        }

        output.write("\nWe're done? Alrighty then. Ta ta!");
    }
}
