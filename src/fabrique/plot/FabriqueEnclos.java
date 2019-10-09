package fabrique.plot;

import object.plot.Plot;

public abstract class FabriqueEnclos {
    public Plot getEnclos(){
        return createEnclos();
    }

    protected abstract Plot createEnclos();
}
