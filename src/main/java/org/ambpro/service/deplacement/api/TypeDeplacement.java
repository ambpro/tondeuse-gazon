package org.ambpro.service.deplacement.api;

import org.ambpro.service.machine.api.Machine;
import org.ambpro.service.machine.data.Surface;

public interface TypeDeplacement {
    void avancer(Surface gazon, Machine machine);

    void tournerAGauche(Machine machine);

    void tournerADroite(Machine machine);
}
