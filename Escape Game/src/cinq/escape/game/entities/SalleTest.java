package cinq.escape.game.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SalleTest {

    private Salle salle;

    @BeforeEach
    void setUp() throws Exception {
        salle = new Salle("C11", 5);
        salle.ajouterEnigme(new Enigme("A","B","C"));
    }

    @Test
    void testAjouterEnigme(){
        int nb = salle.getEnigmes().size();
        assertEquals(1, nb);
        salle.ajouterEnigme(new Enigme("x","y","z"));
        assertEquals(nb + 1, salle.getEnigmes().size());

        salle.ajouterEnigme(null);

        salle.resoudreEnigme(salle.getEnigmes().size(), -1, "");

        assertEquals(nb + 1, salle.getEnigmes().size());
    }

    @Test
    void testResoudreEnigme(){
        fail("Not yet implemented");
    }
}
