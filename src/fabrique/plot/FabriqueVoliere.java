package fabrique.plot;

import object.plot.Plot;
import object.plot.Voliere;

public class FabriqueVoliere extends FabriqueEnclos {
    @Override
    protected Plot createEnclos() {
        return new Voliere();
    }
}
