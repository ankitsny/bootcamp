package input.PersonExercise;

import org.junit.BeforeClass;

import static input.PersonExercise.ShanFamilyTreeBuilder.*;

public class BaseTest {

    @BeforeClass
    public static void setUp() throws Exception {
        if (KING_SHAN.isMarriedTo(QUEEN_ANGA.getName())) return;
        ShanFamilyTreeBuilder.build();
    }
}
