package fabrique.plot;

import object.plot.Enclos;
import object.plot.Voliere;

public class FabriqueVoliere extends FabriqueEnclos {
    @Override
    protected Enclos createEnclos() {
        return new Voliere();
    }
}
