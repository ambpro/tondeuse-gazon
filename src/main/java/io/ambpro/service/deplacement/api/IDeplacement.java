package io.ambpro.service.deplacement.api;

import io.ambpro.service.machine.api.IMachine;
import io.ambpro.service.machine.data.Surface;

public interface IDeplacement {
    void avancer(Surface gazon, IMachine machine);

    void tournerAGauche(IMachine machine);

    void tournerADroite(IMachine machine);
}
