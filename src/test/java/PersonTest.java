import PersonExercise.Gender;
import PersonExercise.Person;
import PersonExercise.exception.MalePersonCannotGiveBirthException;
import PersonExercise.exception.UnmarriedFemalePersonCannotGiveBirthException;
import org.junit.Test;

import java.util.List;

import static PersonExercise.ShanFamilyTreeBuilder.*;
import static org.junit.Assert.*;

public class PersonTest extends BaseTest {

    @Test
    public void verifySpouseAfterGettingMarried() {
        assertEquals(QUEEN_ANGA, KING_SHAN.getSpouse());
        assertEquals(KING_SHAN, QUEEN_ANGA.getSpouse());
    }

    @Test
    public void verifyPersonIsMarriedTo() {
        assertTrue(KING_SHAN.isMarriedTo(QUEEN_ANGA.getName()));
    }

    @Test(expected = MalePersonCannotGiveBirthException.class)
    public void verifyGiveBirthThrowsExceptionWhenPersonIsMale() throws Exception {
        Person khan = new Person("Khan", Gender.Male);
        KING_SHAN.giveBirthTo(khan);
    }

    @Test(expected = UnmarriedFemalePersonCannotGiveBirthException.class)
    public void verifyGiveBirthThrowsExceptionWhenPersonNotMarried() throws Exception {
        Person soha = new Person("Soha", Gender.Female);
        VILA.giveBirthTo(soha);
    }

    @Test
    public void verifyGiveBirthToAddsChildRelationshipAccordingly() throws Exception {
        assertEquals(1, DRITHA.getChildren().size());
        assertEquals(YODHAN, DRITHA.getChildren().get(0));

        Person soha = new Person("Soha", Gender.Female);
        DRITHA.giveBirthTo(soha);

        assertEquals(2, DRITHA.getChildren().size());
        assertEquals(YODHAN, DRITHA.getChildren().get(0));
        assertEquals(soha, DRITHA.getChildren().get(1));

        DRITHA.getChildren().remove(soha);
    }

    @Test
    public void verifyPersonIdentity() {
        assertEquals(KING_SHAN, new Person("King Shan", Gender.Male));
        assertNotEquals(ISH, new Person("Ish", Gender.Female));
    }

    @Test
    public void verifyGiveBirthSetsMotherRelationship() throws Exception {
        Person soha = new Person("Soha", Gender.Female);

        DRITHA.giveBirthTo(soha);
        assertEquals(DRITHA, soha.getMother());

        DRITHA.getChildren().remove(soha);
    }

    @Test
    public void findFatherGivenAPerson() {
        assertNull(KING_SHAN.getFather());
        assertEquals(ARAS, JNKI.getFather());
    }

    @Test
    public void findChildrenGivenAPerson() {
        List<Person> children = VICH.getChildren();
        assertEquals(2, children.size());
        assertEquals(VILA, children.get(0));
        assertEquals(CHIKA, children.get(1));
    }

    @Test
    public void findSonsGivenAPerson() {
        List<Person> sons = VYAN.getSons();
        assertEquals(2, sons.size());
        assertEquals(ASVA, sons.get(0));
        assertEquals(VYAS, sons.get(1));

        assertEquals(0, TRITHA.getSons().size());
    }

    @Test
    public void findDaughtersGivenAPerson() {
        List<Person> daughters = KRPI.getDaughters();
        assertEquals(1, daughters.size());
        assertEquals(KRITHI, daughters.get(0));

        assertEquals(0, AHIT.getDaughters().size());
    }

    @Test
    public void findBrothersGivenAPerson() {
        List<Person> brothers = CHIT.getBrothers();
        assertEquals(3, brothers.size());
        assertEquals(ISH, brothers.get(0));
        assertEquals(VICH, brothers.get(1));
        assertEquals(ARAS, brothers.get(2));

        assertEquals(0, VILA.getBrothers().size());
    }

    @Test
    public void findSistersGivenAPerson() {
        List<Person> sisters = ASVA.getSisters();
        assertEquals(1, sisters.size());
        assertEquals(ATYA, sisters.get(0));

        assertEquals(0, JNKI.getSisters().size());
    }

    @Test
    public void findBrotherInLawsGivenAPerson() {
        List<Person> brotherInLaws = CHITRA.getBrotherInLaws();
        assertEquals(3, brotherInLaws.size());
        assertEquals(CHIT, brotherInLaws.get(0));
        assertEquals(ISH, brotherInLaws.get(1));
        assertEquals(VICH, brotherInLaws.get(2));

        brotherInLaws = JAYA.getBrotherInLaws();
        assertEquals(1, brotherInLaws.size());
        assertEquals(VRITHA, brotherInLaws.get(0));
    }

    @Test
    public void findSisterInLawsGivenAPerson() {
        List<Person> sisterInLaws = SATYA.getSisterInLaws();
        assertEquals(3, sisterInLaws.size());
        assertEquals(AMBA, sisterInLaws.get(0));
        assertEquals(LIKA, sisterInLaws.get(1));
        assertEquals(CHITRA, sisterInLaws.get(2));

        sisterInLaws = JAYA.getSisterInLaws();
        assertEquals(1, sisterInLaws.size());
        assertEquals(TRITHA, sisterInLaws.get(0));
    }

    @Test
    public void findPaternalUnclesGivenAPerson() {
        List<Person> paternalUncles = DRITHA.getPaternalUncles();
        assertEquals(3, paternalUncles.size());
        assertEquals(ISH, paternalUncles.get(0));
        assertEquals(VICH, paternalUncles.get(1));
        assertEquals(ARAS, paternalUncles.get(2));
    }

    @Test
    public void findPaternalAuntsGivenAPerson() {
        List<Person> paternalAunts = DRITHA.getPaternalAunts();
        assertEquals(1, paternalAunts.size());
        assertEquals(SATYA, paternalAunts.get(0));
    }

    @Test
    public void findMaternalUnclesGivenAPerson() {
        List<Person> maternalUncles = ASVA.getMaternalUncles();
        assertEquals(4, maternalUncles.size());
        assertEquals(CHIT, maternalUncles.get(0));
        assertEquals(ISH, maternalUncles.get(1));
        assertEquals(VICH, maternalUncles.get(2));
        assertEquals(ARAS, maternalUncles.get(3));
    }

    @Test
    public void findMaternalAuntsGivenAPerson() {
        List<Person> maternalAunts = YODHAN.getMaternalAunts();
        assertEquals(1, maternalAunts.size());
        assertEquals(TRITHA, maternalAunts.get(0));
    }
}
