package org.ambpro.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.ambpro.utils.io.GestionInstruction;

class gestionnaireFichierTest {

    private static String fileName;
    private static int nbLignes;

    @BeforeEach
    public void setUp() throws Exception {
        //fileName = "C:\\Public\\tondeuse.txt";
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("testTondeuse.txt").getPath());
        fileName = Thread.currentThread().getContextClassLoader().getResource("testTondeuse.txt").getPath();
        //fileName = fileName.replaceAll("/C:","C:");
        //fileName = fileName.replaceAll("/","\\\\");

System.out.println(fileName);
        nbLignes = 11;
    }

    @AfterEach
    public void tearDown()throws Exception {

    }


    @Test
    void getInstructionList() {
        String[] data = GestionInstruction.getInstructionList(fileName);

        assertEquals(data.length, 11);
        assertEquals(data[0],"5 5");
        assertEquals(data[4],"AADAADADDA");
        assertEquals(data[data.length-1],"AADAADADDA");

        fileName = null;
        data = GestionInstruction.getInstructionList(fileName);
        assertNull(data[0]);

    }
}