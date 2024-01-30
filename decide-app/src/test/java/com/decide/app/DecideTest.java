package com.decide.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DecideTest {
    Parameters PARAMETERS;

    @Before
    public void setUp() {
        PARAMETERS = new Parameters();
    }
    
    /**
     * ========================= [ GENERAL ] =========================
     */

    @Test
    public void shouldAnswerWithTrue() {
        Point[] POINTS = new Point[]{
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
        };
        int NUMPOINTS = POINTS.length;
        PARAMETERS.AREA1 = 1.0;
        Connector[][] LCM = new Connector[][]{
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED}
        };
        boolean[] PUV = new boolean[]{ false };
        Decide decide = new Decide(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);
        assertTrue(decide.DECIDE());
    }
    
    /**
     * =========================== [ PUM ] ===========================
     */

    /**
     * Positive test case, ensure that the elements in PUM corectly correspond
     * to the elements given in the LCM and CMV.
     */
    @Test
    public void PUMOperationsCorrespondToLCMAndCMV() {
        Connector[][] LCM = new Connector[][]{
            {Connector.NOTUSED, Connector.NOTUSED, Connector.ORR, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.ORR, Connector.NOTUSED, Connector.ANDD, Connector.ORR, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.ORR},
            {Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.ANDD},
            {Connector.ORR, Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.NOTUSED, Connector.ANDD, Connector.ANDD},
            {Connector.ANDD, Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.ORR, Connector.ANDD, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.ANDD, Connector.ORR},
            {Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.ORR, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.ORR, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.ORR, Connector.ANDD, Connector.NOTUSED, Connector.ORR, Connector.NOTUSED, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ANDD, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ANDD, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR},
            {Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.NOTUSED, Connector.ORR, Connector.ANDD, Connector.ORR, Connector.ANDD, Connector.ORR, Connector.ORR},
            {Connector.ORR, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.ORR, Connector.NOTUSED, Connector.ANDD},
            {Connector.ANDD, Connector.ORR, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.ANDD, Connector.ORR, Connector.ANDD, Connector.ANDD},
            {Connector.ANDD, Connector.NOTUSED, Connector.ORR, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.ORR, Connector.ORR, Connector.NOTUSED, Connector.ANDD, Connector.ORR, Connector.NOTUSED, Connector.ANDD, Connector.ORR},
            {Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.ANDD, Connector.ORR, Connector.ORR, Connector.NOTUSED, Connector.ORR, Connector.ANDD, Connector.ORR},
            {Connector.NOTUSED, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.ORR, Connector.NOTUSED, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.NOTUSED, Connector.NOTUSED},
            {Connector.ORR, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.NOTUSED, Connector.NOTUSED, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ANDD, Connector.ANDD, Connector.ORR, Connector.ORR, Connector.NOTUSED, Connector.ORR}
        };
        Decide decide = new Decide(0, null, PARAMETERS, LCM, null);
        boolean[] CMV = new boolean[]{
            true,
            true,
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            true,
            true,
            true,
            true,
            false,
            true
        };
        boolean[][] PUM_CORRECT = new boolean[][]{
            {true, true, true, true, true, true, true, true, false, true, true, true, true, true, true},
            {true, true, true, true, false, true, false, true, false, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
            {true, true, true, true, false, true, true, true, false, true, true, true, true, false, true},
            {true, false, true, false, false, true, true, true, false, true, true, false, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, false, true, true, true, true, false, true, false, false, true, true, true, false, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {false, false, true, false, false, true, false, true, true, true, false, true, false, false, true},
            {true, true, true, true, true, true, false, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, false, true, true, true, true, false, true},
            {true, true, true, true, false, true, true, true, true, true, true, true, true, false, true},
            {true, true, true, true, true, true, true, true, false, true, true, true, true, false, true},
            {true, true, false, false, true, true, false, true, false, true, false, false, false, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
        };
        boolean[][] PUM = decide.getPreliminaryUnlockingMatrix(CMV);
        for (int i = 0; i < PUM.length; ++i) {
            for (int j = 0; j < PUM[i].length; ++j) {
                assertTrue(PUM[i][j] == PUM_CORRECT[i][j]);
            }
        }
    }
    
    /**
     * =========================== [ FUV ] ===========================
     */

    

    /**
     * ========================= [ LAUNCH ] ==========================
     */

    /**
     * Positive test case, ensure that the final launch decision is
     * true if all elements in the Final Unlocking Vector are true.
     */
    @Test
    public void LaunchIsTrueIfFinalUnlockingVectorIsTrue() {
        Decide decide = new Decide();
        boolean[] FUV = new boolean[]{
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
        };
        assertTrue(decide.getLaunchDecision(FUV));
    }

    /**
     * Negative test case, ensure that the final launch decision is
     * false if not all elements in the Final Unlocking Vector are true.
     */
    @Test
    public void LaunchIsFalseIfFinalUnlockingVectorIsFalse() {
        Decide decide = new Decide();
        boolean[] FUV = new boolean[]{
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
        };
        assertFalse(decide.getLaunchDecision(FUV));
    }

}
