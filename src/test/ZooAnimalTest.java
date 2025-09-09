
import org.example.ZooAnimal;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ZooAnimalTest {

    private final InputStream originalIn = System.in;
    private ZooAnimal animal;

    /**
     * Helper to simulate user typing into the console.
     * Each line in 'data' represents one Enter‐terminated input.
     */
    private void setInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @BeforeEach
    public void createNewAnimalObject() {
        // Create a new ZooAnimal object before each test
        animal = new ZooAnimal();
    }

    @AfterEach
    public void cleanup() {
        // Restore the original System.in after each test
        System.setIn(originalIn);
    }

    @Test
    public void testNameVerification_RejectEmpty() {
        // First input is empty (""), then "Lion"
        setInput("\nLion\n");

        String result = animal.nameVerification();

        // Verify returned name and internal field
        assertEquals("Lion", result);
        assertEquals("Lion", animal.getName());
    }

    @Test
    public void testNameVerification_RejectDigits() {
        // "Li0n" is invalid, then "Leo" is valid
        setInput("Li0n\nLeo\n");

        String result = animal.nameVerification();

        assertEquals("Leo", result);
        assertEquals("Leo", animal.getName());
    }

    @Test
    public void testAgeVerification_rejectNonIntegerAndNegative_thenAcceptValid() {
        // "abc" fails (not a number), "-5" fails, then "3" succeeds
        setInput("abc\n-5\n3\n");

        int age = animal.ageVerification();

        assertEquals(3, age);
        assertEquals(3, animal.getAge());
    }

    @Test
    public void testSpeciesVerification_rejectEmptyAndShort_thenAcceptValid() {
        // Empty input and too short ("Cat") are rejected; "Tiger" accepted
        setInput("\nCat\nTiger\n");

        String species = animal.speciesVerification();

        assertEquals("Tiger", species);
        assertEquals("Tiger", animal.getSpecies());
    }

    @Test
    public void testSpeciesVerification_rejectWithDigits_thenAcceptValid() {
        // "Ti63er" is invalid, then "Panthera" is valid
        setInput("Ti63er\nPanthera\n");

        String species = animal.speciesVerification();

        assertEquals("Panthera", species);
        assertEquals("Panthera", animal.getSpecies());
    }

    @Test
    public void testHabitatVerification() {
        // Rejects "Savannah1" and "Sa@vannah", then accepts "Grassland"
        setInput("Savannah1\nSa@vannah\nGrassland\n");

        String habitat = animal.habitatVerification();

        assertEquals("Grassland", habitat);
        assertEquals("Grassland", animal.getHabitat());
    }

    @Test
    public void testToString(){
        // Provide valid inputs for all four verifications in order
        // name
        // age
        // species
        // habitat
        String inputs = String.join(
                "\n",
                "Zara",      // name
                "4",         // age
                "Gorilla",   // species
                "Jungle"     // habitat
        ) + "\n";
        setInput(inputs);

        animal.nameVerification();
        animal.ageVerification();
        animal.speciesVerification();
        animal.habitatVerification();

        String output = animal.toString();

        // Check that toString() mentions every field and ends with the stars
        assertTrue(output.contains("Zara"));
        assertTrue(output.contains("4"));
        assertTrue(output.contains("Gorilla"));
        assertTrue(output.contains("Jungle"));
        assertTrue(output.endsWith("***************************"));
    }
}





