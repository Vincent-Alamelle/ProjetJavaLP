package fabrique.plot;

import object.plot.Aquarium;
import object.plot.Plot;

public class FabriqueAquarium extends FabriqueEnclos {
    @Override
    protected Plot createEnclos() {
        return new Aquarium();
    }
}
