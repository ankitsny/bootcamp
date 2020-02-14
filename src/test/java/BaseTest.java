import PersonExercise.ShanFamilyTreeBuilder;
import org.junit.BeforeClass;

import static PersonExercise.ShanFamilyTreeBuilder.KING_SHAN;
import static PersonExercise.ShanFamilyTreeBuilder.QUEEN_ANGA;


public class BaseTest {

    @BeforeClass
    public static void setUp() throws Exception {
        if (KING_SHAN.isMarriedTo(QUEEN_ANGA.getName())) return;
        ShanFamilyTreeBuilder.build();
    }
}
