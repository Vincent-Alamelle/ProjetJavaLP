package constante;

public enum ConstanteInt {
    DRAGONET_HEALTHMAX (500),
    DRAGONET_ATTACK (120),
    DRAGONET_DEFENSE (50),
    DRAGONET_SPEED (55),
    DRAGONET_LEVEL (1),
    DRAGONET_EXPERIENCE (0),
    DRAGONET_RANK (4),

    SUCCUBUS_HEALTHMAX (200),
    SUCCUBUS_ATTACK (80),
    SUCCUBUS_DEFENSE (30),
    SUCCUBUS_SPEED (70),
    SUCCUBUS_LEVEL (1),
    SUCCUBUS_EXPERIENCE (0),
    SUCCUBUS_RANK (2),

    CABIRE_HEALTHMAX (350),
    CABIRE_ATTACK (95),
    CABIRE_DEFENSE (45),
    CABIRE_SPEED (65),
    CABIRE_LEVEL (1),
    CABIRE_EXPERIENCE (0),
    CABIRE_RANK (3),

    SATYR_HEALTHMAX (650),
    SATYR_ATTACK (140),
    SATYR_DEFENSE (60),
    SATYR_SPEED (80),
    SATYR_LEVEL (1),
    SATYR_EXPERIENCE (0),
    SATYR_RANK (5),

    SLIME_HEALTHMAX (100),
    SLIME_ATTACK (50),
    SLIME_DEFENSE (15),
    SLIME_SPEED (30),
    SLIME_LEVEL (1),
    SLIME_EXPERIENCE (0),
    SLIME_RANK (1),

    SUMMON_COST (5),
    MAX_SPEED (100),

    MAX_XP_LVL (100);

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
