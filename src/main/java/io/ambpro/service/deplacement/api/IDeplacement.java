package io.ambpro.service.deplacement.api;

import io.ambpro.service.machine.api.Machine;
import io.ambpro.service.machine.data.Surface;

public interface IDeplacement {
    void avancer(Surface gazon, Machine machine);

    void tournerAGauche(Machine machine);

    void tournerADroite(Machine machine);
}
