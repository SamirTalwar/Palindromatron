package com.noodlesandwich.palindromatron.view;

import java.io.IOException;

public interface Input {
    String read(String prompt) throws IOException;
}
