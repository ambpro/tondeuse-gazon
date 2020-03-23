package org.ambpro.service.machine.api;

import org.ambpro.service.deplacement.api.TypeDeplacement;
import org.ambpro.service.machine.data.Position;

public interface Machine {

    void execute(TypeDeplacement typeDeplacement);

    Position getPosition();

    void setPosition(Position position);

    int getVitesse();

    void setVitesse(int vitesse);

    char[] getInstructions();
}
