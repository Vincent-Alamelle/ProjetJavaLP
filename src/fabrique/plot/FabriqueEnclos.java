package fabrique.plot;

import object.plot.Enclos;

public abstract class FabriqueEnclos {
    public Enclos getEnclos(){
        return createEnclos();
    }

    protected abstract Enclos createEnclos();
}
