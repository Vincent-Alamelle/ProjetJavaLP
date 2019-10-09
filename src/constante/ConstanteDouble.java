package constante;

public enum ConstanteDouble {
    DROP_RATE_RANK1 (1.00),
    DROP_RATE_RANK2 (0.20),
    DROP_RATE_RANK3 (0.10),
    DROP_RATE_RANK4 (0.05),
    DROP_RATE_RANK5 (0.02);

    private double valeur;

    ConstanteDouble(double valeur){
        this.valeur = valeur;
    }

    public double getValeur() {
        return valeur;
    }

    public String toString(){
        return String.valueOf(valeur);
    }
}
