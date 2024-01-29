package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class LaunchInterceptorConditionsTest {
    Parameters PARAMETERS;

    @Before
    public void setUp() {
        PARAMETERS = new Parameters();
    }

    /**
     * ========================== [ LIC 0 ] ==========================
     */

    /**
     * Positive test case, ensure LIC0 is satisfied when two consecutive
     * points are more than LENGTH1 apart.
     */
    @Test
    public void LIC0TrueOnDistanceGreaterThanLENGTH1() {
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1+1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Negative test case, ensure LIC0 is not satisfied when no two 
     * consecutive points are more than LENGTH1 apart.
     */
    @Test
    public void LIC0FalseOnDistanceSmallerThanLENGTH1() {
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{ 
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1-1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Edge-case test case, ensure LIC0 is not satisfied when points
     * are exactly LENGHT1 apart.
     */
    @Test
    public void LIC0FalseOnDistanceEqualToLENGTH1() {
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Edge-case test case, ensure LIC0 is not satisfied when there
     * is only one point.
     */
    @Test
    public void LIC0FalseOnOnlyOnePoint() {
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{
            new Point(1, 2)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Invalid input test case, ensure LIC0 throws IllegalArgumentException
     * if the supplied parameter LENGTH1 is less than 0.
     */
    @Test
    public void LIC0ThrowsIllegalArgumentExceptionOnInvalidParameter() {
        PARAMETERS.LENGTH1 = -1;
        Point[] POINTS = new Point[]{
            new Point(1, 2),
            new Point(2, 2),
            new Point(2, 3)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition0(); }
        );
    }
  
  

    
    
    
    /**
     * ========================== [ LIC 8 ] ==========================
     */

    /**
     * Positive test case. Ensure LIC8 is satisfied when three points separated by 
     * exactly A_PTS and B_PTS consecutive intervening points, respectively, 
     * cannot be contained within or on a circle of radius RADIUS1.
     */
    @Test 
    public void LIC8TruePointsNotInRadius(){
        PARAMETERS.RADIUS1 = 2.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 2;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(0, 0), new Point(5, 2.5), new Point(1, 2), new Point(3, 3), new Point(3, 5), new Point(0, 0) };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertTrue(LIC.getLaunchInterceptorCondition8());

    }

    /**
     * Negative test case. Ensure LIC8 is not satisfied when three points separated by 
     * exactly A_PTS and B_PTS consecutive intervening points, respectively, 
     * can be contained within or on a circle of radius RADIUS1.
     */
    @Test 
    public void LIC8FalsePointsInRadius(){
        PARAMETERS.RADIUS1 = 4.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 2;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(0, 0), new Point(1, 2.5), new Point(1, 2), new Point(3, 3), new Point(1, 3), new Point(0, 0)  };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition8());
    }

    /**
     * Edge case test case. Ensure LIC8 is not satisfied when three points separated by 
     * exactly A_PTS and B_PTS consecutive intervening points, respectively, 
     * are on the edge of a circle of radius RADIUS1.
     */
    @Test 
    public void LIC8FalsePointsOnRadiusEdge(){
        PARAMETERS.RADIUS1 = 3.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 1;
        Point[] POINTS = new Point[]{ new Point(7, 4), new Point(10, 10), new Point(4, 1), new Point(0, 7), new Point(1, 4) };
        int NUMPOINTS = POINTS.length;
          // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
         // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition8());
        
    }

    /**
     * Incorrect input test case. Ensure LIC8 is not satisfied when less than 5 points
     * are supplied.
     */
    @Test 
    public void LIC8FalseLessThan5Points(){
        PARAMETERS.RADIUS1 = 2.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 1;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(4, 2), new Point(1, 2), new Point(3, 5)};
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition8());

    }
    
    /**
     * ========================= [ HELPERS ] =========================
     */

    /**
     * Positive test case, ensure the distance between two points is correct.
     */
    @Test
    public void distanceCorrect() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(1, LIC.distance(p1, p2), 0.00001);
    }

    /**
     * Negative test case, ensure the distance between two points is not incorrect.
     */
    @Test
    public void distanceIncorrect() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertNotEquals(1, LIC.distance(p1, p2), 0.00001);
    }

    /**
     * Positive test case, ensure the distance between two diagonal points is correct.
     */
    @Test
    public void diagonalDistanceCorrect() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(0,-1);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(5, LIC.distance(p1, p2), 0.00001);
    }

    /**
     * Invalid input test case, ensure the distance to a null object
     * causes an IllegalArgumentException to be thrown.
     */
    @Test
    public void distanceThrowsIllegalArgumentExceptionOnNull() {
        Point p1 = new Point(0, 0);
        Point p2 = null;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.distance(p1, p2); }
        );
    }

}
