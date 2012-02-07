package com.noodlesandwich.palindromatron.controller;

import javax.inject.Inject;

import com.noodlesandwich.palindromatron.view.Input;
import com.noodlesandwich.palindromatron.view.Output;

public final class Console implements Controller {
    private final Input input;
    private final Output output;

    @Inject
    public Console(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() throws Exception {
        final String palindrome = input.read("Enter a palindrome: ");
        output.write("Yes, \"" + palindrome + "\" is most certainly a palindrome.");
    }
}
