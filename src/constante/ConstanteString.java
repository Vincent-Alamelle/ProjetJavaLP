package constante;

public enum ConstanteString {
    DEMON ("Demon"),
    BEAST ("Beast"),
    SLIME ("Slime"),
    DRAKE ("Drake");

    private String valeur = "";

    ConstanteString(String valeur){
        this.valeur = valeur;
    }


    public String toString(){
        return valeur;
    }
}
