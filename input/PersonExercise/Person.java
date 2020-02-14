package input.PersonExercise;

import input.PersonExercise.exception.MalePersonCannotGiveBirthException;
import input.PersonExercise.exception.UnmarriedFemalePersonCannotGiveBirthException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

public class Person {

    private String name;
    private Gender gender;
    private Person mother;
    private Person spouse;
    private List<Person> children = new ArrayList<>();

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return isOrphan() ? null : mother.spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void registerMarriageWith(Person person) {
        if (person == null) return;
        this.spouse = person;
        person.spouse = this;
    }

    public void giveBirthTo(Person child) throws Exception {
        if (child == null) return;
        if (gender == Gender.Male) throw new MalePersonCannotGiveBirthException();
        if (isNotMarried()) throw new UnmarriedFemalePersonCannotGiveBirthException();
        child.mother = this;
        children.add(child);
        spouse.children.add(child);
    }

    public boolean isMarriedTo(String name) {
        return spouse != null && spouse.name.equalsIgnoreCase(name);
    }

    public List<Person> getSons() {
        List<Person> children = getChildren();
        List<Person> brothers = children.stream().filter(p -> p.gender.equals(Gender.Male)).collect(toList());
        return brothers;
    }

    public List<Person> getDaughters() {
        return getChildren().stream().filter(p -> p.gender.equals(Gender.Female)).collect(toList());
    }

    public List<Person> getBrothers() {
        if (isOrphan()) return emptyList();
        Person mother = getMother();
        List<Person> sons = mother.getSons();
        List<Person> brothers = sons.stream().filter(p -> !p.equals(this)).collect(toList());
        return brothers;
    }

    public List<Person> getSisters() {
        if (isOrphan()) return emptyList();
        return getMother().getDaughters().stream().filter(p -> !p.equals(this)).collect(toList());
    }

    public List<Person> getSiblings() {
        if (isOrphan()) return emptyList();
        return concat(getBrothers().stream(), getSisters().stream()).collect(toList());
    }

    public List<Person> getBrotherInLaws() {
        List<Person> husbandsOfSiblings = getSisters().stream().filter(p -> p.spouse != null).map(p -> p.spouse).collect(toList());
        List<Person> brothersOfSpouse = isNotMarried() ? emptyList() : spouse.getBrothers();
        return concat(husbandsOfSiblings.stream(), brothersOfSpouse.stream()).collect(toList());
    }

    public List<Person> getSisterInLaws() {
        List<Person> wivesOfSiblings = getBrothers().stream().filter(p -> p.spouse != null).map(p -> p.spouse).collect(toList());
        List<Person> sistersOfSpouse = isNotMarried() ? emptyList() : spouse.getSisters();
        return concat(wivesOfSiblings.stream(), sistersOfSpouse.stream()).collect(toList());
    }

    public List<Person> getPaternalUncles() {
        if (isOrphan()) return emptyList();
        return getFather().getBrothers();
    }

    public List<Person> getPaternalAunts() {
        if (isOrphan()) return emptyList();
        return getFather().getSisters();
    }

    public List<Person> getMaternalUncles() {
        if (isOrphan()) return emptyList();
        return getMother().getBrothers();
    }

    public List<Person> getMaternalAunts() {
        if (isOrphan()) return emptyList();
        return getMother().getSisters();
    }

    private boolean isOrphan() {
        return mother == null;
    }

    private boolean isNotMarried() {
        return spouse == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
