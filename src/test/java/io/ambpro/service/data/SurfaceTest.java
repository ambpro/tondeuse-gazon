package io.ambpro.service.data;

import io.ambpro.service.machine.api.IMachine;
import io.ambpro.service.machine.data.Position;
import io.ambpro.service.machine.data.Surface;
import io.ambpro.service.machine.impl.Tondeuse;
import io.ambpro.utils.commande.Orientation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SurfaceTest {

    private static Position positionA;
    private static Position positionB;
    private static Position positionC;
    private static Position positionD;
    private static Surface surface;
    private static IMachine machineT;
    private static IMachine machineT2;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        machineT = Mockito.mock(Tondeuse.class);
        machineT2 = Mockito.mock(Tondeuse.class);
        Mockito.doCallRealMethod().when(machineT).setPosition(Mockito.any(Position.class));
        Mockito.when(machineT.getPosition()).thenCallRealMethod();
        Mockito.doCallRealMethod().when(machineT2).setPosition(Mockito.any(Position.class));
        Mockito.when(machineT2.getPosition()).thenCallRealMethod();

        positionA = new Position(1,4, Orientation.N);
        positionB = new Position(1,5, Orientation.N);
        positionC = new Position(10,1, Orientation.W);
        positionD = new Position(1,10, Orientation.E);
        surface = Surface.getSurface();
        surface.setAbscisseMax(6);
        surface.setOrdonneeMax(6);
        surface.setMachines(new IMachine[surface.getAbscisseMax()][surface.getOrdonneeMax()]);
    }

    @AfterEach
    public void tearDown()throws Exception {

    }

    @Test
    void getSurface() {
    }

    @Test
    void changerPosition() {
        machineT.setPosition(positionA);
        surface.addMachine(machineT);
        surface.changerPosition(machineT,positionB);

        assertNull(surface.getMachines()[positionA.getX()][positionA.getY()]);
        assertEquals(surface.getMachines()[positionB.getX()][positionB.getY()], machineT);

    }

    @Test
    void addTondeuses() {
        machineT.setPosition(positionB);
        surface.addMachine(machineT);

        assertEquals(surface.getMachines()[positionB.getX()][positionB.getY()], machineT);

        machineT2.setPosition(positionC);
        surface.addMachine(machineT2);
        Stream<IMachine[]> temp = Arrays.stream(surface.getMachines());
        Stream<IMachine> stringStream = temp.flatMap(x -> Arrays.stream(x));
        Stream<IMachine> stream = stringStream.filter(x -> machineT2 == (x));

        assertEquals(0,stream.count());
    }
}