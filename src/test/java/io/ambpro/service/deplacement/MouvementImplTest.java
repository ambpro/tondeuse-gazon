package io.ambpro.service.deplacement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import io.ambpro.service.deplacement.impl.MouvementImp;
import io.ambpro.service.machine.api.IMachine;
import io.ambpro.service.machine.data.Position;
import io.ambpro.service.machine.data.Surface;
import io.ambpro.service.machine.impl.Tondeuse;
import io.ambpro.utils.commande.Orientation;

class MouvementImplTest {

    private static Position positionDepart;
    private static Position positionArrivee;
    private static Position positionC;
    private static Position positionD;
    private static Surface surface;
    private static IMachine machineT;
    private static MouvementImp explorer;
    private static int vitesse;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        machineT = Mockito.mock(Tondeuse.class);
        Mockito.doCallRealMethod().when(machineT).setPosition(Mockito.any(Position.class));
        Mockito.when(machineT.getPosition()).thenCallRealMethod();
        Mockito.doCallRealMethod().when(machineT).setVitesse(Mockito.anyInt());
        Mockito.when(machineT.getVitesse()).thenCallRealMethod();

        positionC = new Position(10,1, Orientation.W);
        positionD = new Position(1,10, Orientation.E);
        surface = Surface.getSurface();
        surface.setAbscisseMax(6);
        surface.setOrdonneeMax(6);
        surface.setMachines(new IMachine[surface.getAbscisseMax()][surface.getOrdonneeMax()]);
        explorer = new MouvementImp();


    }

    @AfterEach
    public void tearDown()throws Exception {

    }

    @Test
    void avancer() {
        positionDepart = new Position(1,4, Orientation.N);
        positionArrivee = new Position(1,5, Orientation.N);
        vitesse = 1;
        machineT.setVitesse(vitesse);
        machineT.setPosition(positionDepart);
        surface.addMachine(machineT);
        explorer.avancer(surface, machineT);

        assertNull(surface.getMachines()[positionDepart.getX()][positionDepart.getY()]);
        assertEquals(surface.getMachines()[positionArrivee.getX()][positionArrivee.getY()], machineT);
    }

    @Test
    void tournerAGauche() {

        positionDepart = new Position(1,4, Orientation.N);
        positionArrivee = new Position(1,4, Orientation.W);

        machineT.setPosition(positionDepart);
        explorer.tournerAGauche(machineT);
        assertEquals(positionArrivee, machineT.getPosition());

        positionArrivee = new Position(1,4, Orientation.S);
        explorer.tournerAGauche(machineT);
        assertEquals(positionArrivee, machineT.getPosition());

        positionArrivee = new Position(1,4, Orientation.E);
        explorer.tournerAGauche(machineT);
        assertEquals(positionArrivee, machineT.getPosition());

        explorer.tournerAGauche(machineT);
        assertEquals(positionDepart, machineT.getPosition());

    }

    @Test
    void tournerADroite() {

        positionDepart = new Position(1,4, Orientation.N);
        positionArrivee = new Position(1,4, Orientation.E);

        machineT.setPosition(positionDepart);
        explorer.tournerADroite(machineT);
        assertEquals(positionArrivee, machineT.getPosition());

        positionArrivee = new Position(1,4, Orientation.S);
        explorer.tournerADroite(machineT);
        assertEquals(positionArrivee, machineT.getPosition());

        positionArrivee = new Position(1,4, Orientation.W);
        explorer.tournerADroite(machineT);
        assertEquals(positionArrivee, machineT.getPosition());

        positionArrivee = new Position(1,4, Orientation.N);
        explorer.tournerADroite(machineT);
        assertEquals(positionDepart, machineT.getPosition());
    }
}