import org.example.ZooAnimal;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class ZooAnimalTest {

    private final InputStream originalInput = System.in;
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
        System.setIn(originalInput);
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
 public   void testAgeVerificationWithValidInput() {
        // Simulate user typing "5" and pressing Enter
        String simulatedInput = "5\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


        int result = animal.ageVerification();

        assertEquals(5, result);

        // Restore original System.in
        System.setIn(originalIn);
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
    public void testAgeVerificationWithInvalidThenValidInput() {
        // Simulate user typing "abc", then "-2", then "7"
        String simulatedInput = "abc\n-2\n7\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


        int result = animal.ageVerification();

        assertEquals(7, result);

        System.setIn(originalIn);
    }

    @Test
    public void testToString(){
        // Provide valid inputs for all four verifications in order
        // name
        // age
        // species
        // habitat
        // name
        // age
        // species
        // habitat
        String inputs = STR."""
\{String.join(
                "\n",
                "Zara",      // name
                "4",         // age
                "Gorilla",   // species
                "Jungle"     // habitat
        )}
""";
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







