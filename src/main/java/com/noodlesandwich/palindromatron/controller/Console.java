package com.noodlesandwich.palindromatron.controller;

import javax.inject.Inject;

import com.noodlesandwich.palindromatron.view.Input;

public final class Console implements Controller {
    private final Input input;

    @Inject
    public Console(final Input input) {
        this.input = input;
    }

    @Override
    public void run() throws Exception {
        input.read("Enter a palindrome: ");
    }
}
