package fabrique.plot;

import object.plot.Plot;
import object.plot.EnclosStandard;

public class FabriqueEnclosStandard extends FabriqueEnclos {
    @Override
    protected Plot createEnclos() {
        return new EnclosStandard();
    }
}
