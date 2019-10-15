package constante;

public enum ConstanteInt {
    DRAGONET_HEALTHMAX (710),
    DRAGONET_ATTACK (20),
    DRAGONET_DEFENSE (23),
    DRAGONET_SPEED (30),
    DRAGONET_LEVEL (1),
    DRAGONET_EXPERIENCE (0),
    DRAGONET_RANK (4),

    SUCCUBUS_HEALTHMAX (390),
    SUCCUBUS_ATTACK (50),
    SUCCUBUS_DEFENSE (-6),
    SUCCUBUS_SPEED (70),
    SUCCUBUS_LEVEL (1),
    SUCCUBUS_EXPERIENCE (0),
    SUCCUBUS_RANK (2),

    CABIRE_HEALTHMAX (550),
    CABIRE_ATTACK (70),
    CABIRE_DEFENSE (16),
    CABIRE_SPEED (45),
    CABIRE_LEVEL (1),
    CABIRE_EXPERIENCE (0),
    CABIRE_RANK (3),

    SATYR_HEALTHMAX (620),
    SATYR_ATTACK (90),
    SATYR_DEFENSE (-10),
    SATYR_SPEED (60),
    SATYR_LEVEL (1),
    SATYR_EXPERIENCE (0),
    SATYR_RANK (5),

    SLIME_HEALTHMAX (430),
    SLIME_ATTACK (70),
    SLIME_DEFENSE (17),
    SLIME_SPEED (30),
    SLIME_LEVEL (1),
    SLIME_EXPERIENCE (0),
    SLIME_RANK (1),

    MONSTER_ATTACK_PER_LVL(10),
    MONSTER_HEALTH_PER_LVL(30),
    MONSTER_DEFENSE_PER_LVL(5),

    MONSTER_ATTACK_PER_RANK(10),
    MONSTER_HEALTH_PER_RANK(40),
    MONSTER_DEFENSE_PER_RANK(8),

    SUMMON_COST (5),
    MAX_SPEED (100),

    MAX_XP_LVL (100),
    MAX_LVL_RANK1 (10),

    ITEM_ATTACK_UP (5),
    ITEM_HEALTH_UP (10),
    ITEM_DEFENSE_UP (3),
    ITEM_SPEED_UP (1),
    ITEM_CRIT_UP (2),
    ITEM_MAX_LVL (10),
    ITEM_PRICE_UP (150),

    GOLD_IN_CHEST (50),
    INVOCATIONSHARD_IN_CHEST (1);


    private int valeur;

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
