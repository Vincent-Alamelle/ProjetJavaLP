package constante;

public enum ConstanteString {
    DEMON ("Demon"),
    SATYR ("Satyr"),
    CABIRE ("Cabire"),
    SUCCUBUS ("Succubus"),
    BEAST ("Beast"),
    SLIME ("Slime"),
    DRAKE ("Drake"),
    DRAGONET ("Dragonet");

    private String valeur;

    ConstanteString(String valeur){
        this.valeur = valeur;
    }


    public String toString(){
        return valeur;
    }
}
