package constante;

public enum ConstanteInt {
    DRAGONNET_HEALTHMAX (500),
    DRAGONNET_ATTACK (120),
    DRAGONNET_DEFENSE (50),
    DRAGONNET_SPEED (55),
    DRAGONNET_LEVEL (1),
    DRAGONNET_EXPERIENCE (0),
    DRAGONNET_RANK (4),

    SUCCUBUS_HEALTHMAX (200),
    SUCCUBUS_ATTACK (80),
    SUCCUBUS_DEFENSE (30),
    SUCCUBUS_SPEED (70),
    SUCCUBUS_LEVEL (1),
    SUCCUBUS_EXPERIENCE (0),
    SUCCUBUS_RANK (2),

    SLIME_HEALTHMAX (100),
    SLIME_ATTACK (50),
    SLIME_DEFENSE (15),
    SLIME_SPEED (30),
    SLIME_LEVEL (1),
    SLIME_EXPERIENCE (0),
    SLIME_RANK (1);

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
