package constante;

public enum ConstanteInt {
    DRAGONET_HEALTHMAX (900),
    DRAGONET_ATTACK (70),
    DRAGONET_DEFENSE (60),
    DRAGONET_SPEED (30),
    DRAGONET_LEVEL (1),
    DRAGONET_EXPERIENCE (0),
    DRAGONET_RANK (4),

    SUCCUBUS_HEALTHMAX (500),
    SUCCUBUS_ATTACK (130),
    SUCCUBUS_DEFENSE (15),
    SUCCUBUS_SPEED (70),
    SUCCUBUS_LEVEL (1),
    SUCCUBUS_EXPERIENCE (0),
    SUCCUBUS_RANK (2),

    CABIRE_HEALTHMAX (700),
    CABIRE_ATTACK (110),
    CABIRE_DEFENSE (45),
    CABIRE_SPEED (45),
    CABIRE_LEVEL (1),
    CABIRE_EXPERIENCE (0),
    CABIRE_RANK (3),

    SATYR_HEALTHMAX (850),
    SATYR_ATTACK (150),
    SATYR_DEFENSE (35),
    SATYR_SPEED (60),
    SATYR_LEVEL (1),
    SATYR_EXPERIENCE (0),
    SATYR_RANK (5),

    SLIME_HEALTHMAX (500),
    SLIME_ATTACK (90),
    SLIME_DEFENSE (30),
    SLIME_SPEED (30),
    SLIME_LEVEL (1),
    SLIME_EXPERIENCE (0),
    SLIME_RANK (1),

    SUMMON_COST (5),
    MAX_SPEED (100),

    MAX_XP_LVL (100),
    MAX_LVL_RANK1 (10);


    private int valeur = 0;

    ConstanteInt(int valeur){
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public String toString(){
        return String.valueOf(valeur);
    }
}
