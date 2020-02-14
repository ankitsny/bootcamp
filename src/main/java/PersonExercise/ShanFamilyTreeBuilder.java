package PersonExercise;

public class ShanFamilyTreeBuilder {

    public static Person KING_SHAN = new Person("King Shan", Gender.Male);
    public static Person QUEEN_ANGA = new Person("Queen Anga", Gender.Female);
    public static Person CHIT = new Person("Chit", Gender.Male);
    public static Person AMBA = new Person("Amba", Gender.Female);
    public static Person ISH = new Person("Ish", Gender.Male);
    public static Person VICH = new Person("Vich", Gender.Male);
    public static Person LIKA = new Person("Lika", Gender.Female);
    public static Person ARAS = new Person("Aras", Gender.Male);
    public static Person CHITRA = new Person("Chitra", Gender.Female);
    public static Person SATYA = new Person("Satya", Gender.Female);
    public static Person VYAN = new Person("Vyan", Gender.Male);
    public static Person DRITHA = new Person("Dritha", Gender.Female);
    public static Person JAYA = new Person("Jaya", Gender.Male);
    public static Person TRITHA = new Person("Tritha", Gender.Female);
    public static Person VRITHA = new Person("Vritha", Gender.Male);
    public static Person VILA = new Person("Vila", Gender.Female);
    public static Person CHIKA = new Person("Chika", Gender.Female);
    public static Person ARIT = new Person("Arit", Gender.Male);
    public static Person JNKI = new Person("Jnki", Gender.Female);
    public static Person AHIT = new Person("Ahit", Gender.Male);
    public static Person SATVY = new Person("Satvy", Gender.Female);
    public static Person ASVA = new Person("Asva", Gender.Male);
    public static Person KRPI = new Person("Krpi", Gender.Female);
    public static Person VYAS = new Person("Vyas", Gender.Male);
    public static Person ATYA = new Person("Atya", Gender.Female);
    public static Person YODHAN = new Person("Yodhan", Gender.Male);
    public static Person LAKI = new Person("Laki", Gender.Male);
    public static Person LAVNYA = new Person("Lavnya", Gender.Female);
    public static Person VASA = new Person("Vasa", Gender.Male);
    public static Person KRIYA = new Person("Kriya", Gender.Male);
    public static Person KRITHI = new Person("Krithi", Gender.Female);

    public static void  build() throws Exception {
        KING_SHAN.registerMarriageWith(QUEEN_ANGA);
        QUEEN_ANGA.giveBirthTo(CHIT);
        QUEEN_ANGA.giveBirthTo(ISH);
        QUEEN_ANGA.giveBirthTo(VICH);
        QUEEN_ANGA.giveBirthTo(ARAS);
        QUEEN_ANGA.giveBirthTo(SATYA);
        CHIT.registerMarriageWith(AMBA);
        VICH.registerMarriageWith(LIKA);
        ARAS.registerMarriageWith(CHITRA);
        SATYA.registerMarriageWith(VYAN);

        AMBA.giveBirthTo(DRITHA);
        AMBA.giveBirthTo(TRITHA);
        AMBA.giveBirthTo(VRITHA);
        DRITHA.registerMarriageWith(JAYA);

        LIKA.giveBirthTo(VILA);
        LIKA.giveBirthTo(CHIKA);

        CHITRA.giveBirthTo(JNKI);
        CHITRA.giveBirthTo(AHIT);
        ARIT.registerMarriageWith(JNKI);

        SATYA.giveBirthTo(ASVA);
        SATYA.giveBirthTo(VYAS);
        SATYA.giveBirthTo(ATYA);
        SATVY.registerMarriageWith(ASVA);
        KRPI.registerMarriageWith(VYAS);

        DRITHA.giveBirthTo(YODHAN);

        JNKI.giveBirthTo(LAKI);
        JNKI.giveBirthTo(LAVNYA);

        SATVY.giveBirthTo(VASA);

        KRPI.giveBirthTo(KRIYA);
        KRPI.giveBirthTo(KRITHI);
    }
}
