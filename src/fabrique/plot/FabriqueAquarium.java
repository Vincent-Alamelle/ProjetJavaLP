package fabrique.plot;

import object.plot.Aquarium;
import object.plot.Enclos;

public class FabriqueAquarium extends FabriqueEnclos {
    @Override
    protected Enclos createEnclos() {
        return new Aquarium();
    }
}
