package io.ambpro.service.machine.api;

import io.ambpro.service.deplacement.api.IDeplacement;
import io.ambpro.service.machine.data.Position;

public interface IMachine {

    void execute(IDeplacement typeDeplacement);

    Position getPosition();

    void setPosition(Position position);

    int getVitesse();

    void setVitesse(int vitesse);

    char[] getInstructions();
}
