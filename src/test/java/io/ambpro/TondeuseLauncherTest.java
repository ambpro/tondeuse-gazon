package io.ambpro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.ambpro.service.machine.api.IMachine;
import io.ambpro.service.machine.data.Position;
import io.ambpro.service.machine.data.Surface;
import io.ambpro.service.machine.impl.Tondeuse;
import io.ambpro.utils.commande.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.ambpro.TondeuseLauncher;

public class TondeuseLauncherTest 
{
	private static String regexGazon;
    private static String regexPositionTondeuse;
    private static String regexInstructions;
    private static int vitesse;

    @BeforeEach
    public void setUp() throws Exception {
        regexGazon = "[0-9]*\\h[0-9]*";
        regexPositionTondeuse = "[0-9]*\\h[0-9]*\\h[NEWS]";
        regexInstructions = "[AGD]*";
        vitesse = 1;
    }


    @Test
    void initTondeuse() {
        String postion = null;
        String instruction = null;
        IMachine machine = TondeuseLauncher.initTondeuse(postion,instruction,regexPositionTondeuse,regexInstructions,vitesse);
        assertNull(machine);

        postion = "1 N";
        instruction = "A";
        machine = TondeuseLauncher.initTondeuse(postion,instruction,regexPositionTondeuse,regexInstructions,vitesse);
        assertNull(machine);

        postion = "10 10 Z";
        instruction = "AAG";
        machine = TondeuseLauncher.initTondeuse(postion,instruction,regexPositionTondeuse,regexInstructions,vitesse);
        assertNull(machine);

        postion = "10 10 N";
        instruction = "ZAG";
        machine = TondeuseLauncher.initTondeuse(postion,instruction,regexPositionTondeuse,regexInstructions,vitesse);
        assertNull(machine);

        postion = "10 10 S";
        Position pos = new Position(10,10, Orientation.S);
        instruction = "AAGDDA";
        char[] instructionTab = new char[]{'A','A','G','D','D','A'};
        machine = TondeuseLauncher.initTondeuse(postion,instruction,regexPositionTondeuse,regexInstructions,vitesse);
        IMachine machineResultatAttendu = new Tondeuse(pos,vitesse,instructionTab);
        assertEquals(machineResultatAttendu, machine);

    }

    @Test
    void initSurface() {
        String dimension = null;

        Surface surface = TondeuseLauncher.initSurface(dimension, regexGazon);
        assertNull(surface);
        assertNotEquals(surface, Surface.getSurface());

        dimension = "5 A";

        surface = TondeuseLauncher.initSurface(dimension, regexGazon);
        assertNull(surface);
        assertNotEquals(surface, Surface.getSurface());

        dimension = "5 5";

        surface = TondeuseLauncher.initSurface(dimension, regexGazon);
        assertNotNull(surface);
        assertEquals(surface, Surface.getSurface());
    }
}
