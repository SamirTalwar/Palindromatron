package com.noodlesandwich.palindromatron;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.noodlesandwich.palindromatron.controller.Console;
import com.noodlesandwich.palindromatron.controller.Controller;
import com.noodlesandwich.palindromatron.view.ConsoleInput;
import com.noodlesandwich.palindromatron.view.ConsoleOutput;
import com.noodlesandwich.palindromatron.view.Input;
import com.noodlesandwich.palindromatron.view.Output;

public final class Configuration extends AbstractModule {
    @Override
    protected void configure() {
        bind(Controller.class).to(Console.class);
        bind(Input.class).toProvider(new Provider<Input>() {
            @Override public Input get() {
                return new ConsoleInput(System.in, System.out);
            }
        });
        bind(Output.class).toProvider(new Provider<Output>() {
            @Override public Output get() {
                return new ConsoleOutput(System.out);
            }
        });
    }
}
