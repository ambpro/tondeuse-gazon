package io.ambpro.service.deplacement.impl;

import io.ambpro.service.deplacement.api.IDeplacement;
import io.ambpro.service.machine.api.Machine;
import io.ambpro.service.machine.data.Position;
import io.ambpro.service.machine.data.Surface;
import io.ambpro.utils.commande.Orientation;

import lombok.NonNull;


/**
 * Gestion des mouvements
 */
public class MouvementImp implements IDeplacement{

    public void avancer(Surface surface, Machine machine) {
        Orientation orientation = machine.getPosition().getOrientation();
        int x = machine.getPosition().getX();
        int y = machine.getPosition().getY();

        switch (orientation){
            case  N:
                y += machine.getVitesse();
                break;
            case  S:
                y -= machine.getVitesse();
                break;
            case  E:
                x += machine.getVitesse();
                break;
            case  W:
                x -= machine.getVitesse();
                break;
             default:
                 x = y = -1;
        }

        Position newPosition = new Position(x,y,orientation);
        surface.changerPosition(machine, newPosition);
    }

    public void tournerAGauche(@NonNull Machine machine){
       Position position = machine.getPosition();
       if (position != null && position.getOrientation()!=null) {
           position.setOrientation(position.getOrientation().plusAGauche());
       }
    }

    public void tournerADroite(Machine machine){
        Position position = machine.getPosition();
        if (position != null && position.getOrientation()!=null) {
            position.setOrientation(position.getOrientation().plusADroite());
        }
    }
}
