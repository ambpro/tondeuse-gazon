package org.ambpro.service.machine.impl;

import org.ambpro.service.deplacement.api.TypeDeplacement;
import org.ambpro.service.machine.api.Machine;
import org.ambpro.service.machine.data.Position;
import org.ambpro.service.machine.data.Surface;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Tondeuse implements Machine{
    private Position position;
    private int vitesse;
    private char[] instructions;

    /**
     * Execute les instructions donnees à la tondeuse
     */
    public void execute(TypeDeplacement typeDeplacement) {
        Surface gazon = Surface.getSurface();
        for(int i=0; i<instructions.length;i++){
            switch (instructions[i]){
                case 'A' :
                    typeDeplacement.avancer(gazon, this);
                    break;
                case 'G' :
                    typeDeplacement.tournerAGauche(this);
                    break;
                case 'D' :
                    typeDeplacement.tournerADroite(this);
                    break;
            }
        }
    }
}
