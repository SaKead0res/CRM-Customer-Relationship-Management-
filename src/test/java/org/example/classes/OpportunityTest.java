package org.example.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpportunityTest {


    Lead test1 = new Lead("Julia Roberts", "+34 56436546", "julia.r@hotmail.com",
            "Movistar");

    @Test
    @DisplayName("")
    void validate_inputCheck() {
        Scanner keyboard = mock(Scanner.class);
        when(keyboard.nextLine()).thenReturn("Jose", "");

//        assertEquals()
    }

    @Test
    @DisplayName("")
    void jhgfj(){}
}
