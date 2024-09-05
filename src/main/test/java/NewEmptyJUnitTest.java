package edu.eci.arsw.springdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewEmptyJUnitTest {
    
    @BeforeAll
    public static void setUpClass() {
        // Este método se ejecuta una vez antes de todos los tests.
    }
    
    @AfterAll
    public static void tearDownClass() {
        // Este método se ejecuta una vez después de todos los tests.
    }
    
    @BeforeEach
    public void setUp() {
        // Este método se ejecuta antes de cada prueba.
    }
    
    @AfterEach
    public void tearDown() {
        // Este método se ejecuta después de cada prueba.
    }

    @Test
    public void testGrammarChecker() {
        // Aquí puedes probar tu clase GrammarChecker.
        GrammarChecker gc = new GrammarChecker();
        EnglishSpellChecker esc = new EnglishSpellChecker();
        gc.setSpellChecker(esc);
        
        String result = gc.check("la la la");
        assertEquals("Spell checking output: Checked with english checker:la la la Plagiarism checking output: Not available yet", result);
    }
}
