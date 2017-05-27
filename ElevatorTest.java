package Elevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Elevator Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 27, 2017</pre> 
* @version 1.0 
*/ 
public class ElevatorTest { 
    Elevator elevator;
@Before
public void before() throws Exception {
    elevator=new Elevator();
    elevator.setElevator_F(3);
    elevator.setElevator_D('D');
    elevator.setElevator_T(0);
    elevator.setElevator_t(0);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getElevator_T() 
* 
*/ 
@Test
public void testGetElevator_T() throws Exception { 
//TODO: Test goes here...
    double num=elevator.getElevator_T();
    Assert.assertEquals(0,num,0);
} 

/** 
* 
* Method: getElevator_t() 
* 
*/ 
@Test
public void testGetElevator_t() throws Exception { 
//TODO: Test goes here...
    double num=elevator.getElevator_t();
    Assert.assertEquals(0,num,0);
} 

/** 
* 
* Method: getElevator_F() 
* 
*/ 
@Test
public void testGetElevator_F() throws Exception { 
//TODO: Test goes here...
    int num=elevator.getElevator_F();
    Assert.assertEquals(3,num);
} 

/** 
* 
* Method: setElevator_T(double d) 
* 
*/ 
@Test
public void testSetElevator_T() throws Exception { 
//TODO: Test goes here...
    elevator.setElevator_T(5);
    double num=elevator.getElevator_T();
    Assert.assertEquals(5,num,0);
} 

/** 
* 
* Method: setElevator_t(double d) 
* 
*/ 
@Test
public void testSetElevator_t() throws Exception { 
//TODO: Test goes here...
    elevator.setElevator_t(5);
    double num=elevator.getElevator_t();
    Assert.assertEquals(5,num,0);
} 

/** 
* 
* Method: setElevator_F(int F) 
* 
*/ 
@Test
public void testSetElevator_F() throws Exception { 
//TODO: Test goes here...
    elevator.setElevator_F(5);
    int num=elevator.getElevator_F();
    Assert.assertEquals(5,num);
} 

/** 
* 
* Method: setElevator_D(char D) 
* 
*/ 
@Test
public void testSetElevator_D() throws Exception { 
//TODO: Test goes here...
    elevator.setElevator_D('U');
    char ch=elevator.getDir();
    Assert.assertEquals('U',ch);
} 

/** 
* 
* Method: setE(ElevatorReg R) 
* 
*/ 
@Test
public void testSetE() throws Exception { 
//TODO: Test goes here...
    ElevatorReg m=new ElevatorReg().Elevator_R("(FR,5,UP,1)");
    elevator.setE(m);
    Assert.assertEquals(1,elevator.E[m.getEleReg_F()]);
} 

/** 
* 
* Method: UpE() 
* 
*/ 
@Test
public void testUpE() throws Exception { 
//TODO: Test goes here...
    elevator.UpE();
    for(int i=0;i<11;i++)
        Assert.assertEquals(0,elevator.E[i]=0);
} 

/** 
* 
* Method: EState(ElevatorReg R) 
* 
*/ 
@Test
public void testEState() throws Exception { 
//TODO: Test goes here...
    ElevatorReg m1=new ElevatorReg().Elevator_R("(FR,5,UP,1)");
    ElevatorReg m2=new ElevatorReg().Elevator_R("(FR,8,UP,1)");
    elevator.setE(m1);
    Assert.assertTrue(elevator.EState(m1));
    Assert.assertFalse(elevator.EState(m2));
}
} 
