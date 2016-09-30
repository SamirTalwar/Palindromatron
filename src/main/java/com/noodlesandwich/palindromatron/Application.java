package com.noodlesandwich.palindromatron;

import com.noodlesandwich.palindromatron.controller.Console;
import com.noodlesandwich.palindromatron.model.CachedPalindromes;
import com.noodlesandwich.palindromatron.model.SimplePalindromes;
import com.noodlesandwich.palindromatron.view.ConsoleInput;
import com.noodlesandwich.palindromatron.view.ConsoleOutput;

public final class Application {
    public static void main(final String[] args) throws Exception {
        new Console(
                new ConsoleInput(System.in, System.out),
                new ConsoleOutput(System.out),
                new CachedPalindromes(new SimplePalindromes())
        ).run();
    }
}
