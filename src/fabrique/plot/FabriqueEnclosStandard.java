package fabrique.plot;

import object.plot.Enclos;
import object.plot.EnclosStandard;

public class FabriqueEnclosStandard extends FabriqueEnclos {
    @Override
    protected Enclos createEnclos() {
        return new EnclosStandard();
    }
}
