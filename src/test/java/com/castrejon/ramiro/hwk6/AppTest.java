package com.castrejon.ramiro.hwk6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    App app = new App();
    Triangle isos = new Triangle(5.0,5.0,8.0);
    Triangle equi = new Triangle(5.0,5.0,5.0);
    Triangle scaleRight = new Triangle(3.0,4.0,5.0);
    Point origin = new Point();
    Point test = new Point(3.0,4.0);

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void shouldBeValidTriangle(){
        assertEquals(true, app.isItValid(3.0,4.0,5.0));

    }
    @Test
    public void shouldBeNotValidTriangle(){
        assertEquals(false, app.isItValid(3.0,5.0,8.0));
    }

    @Test
    public void shouldBeIsosTriangle(){
        assertEquals(true,isos.isIsosceles());
    }
    @Test
    public void shouldBeEquilateralTriangle(){
        assertEquals(true,equi.isEquilateral());
    }
    @Test
    public void shouldBeScaleRightTriangle(){
        assertEquals(true,scaleRight.isScalene());
        assertEquals(true,scaleRight.isRight());
    }
    @Test
    public void getArea(){
        assertEquals(6.0,scaleRight.getArea(),0);
        assertEquals(10.825,equi.getArea(),1);
        assertEquals(12.0,isos.getArea(),0);
    }
    @Test
    public void getDistanceTest(){
        assertEquals(5.0,origin.distance(test),0);
    }
}
