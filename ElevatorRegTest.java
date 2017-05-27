package Elevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ElevatorReg Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 27, 2017</pre> 
* @version 1.0 
*/ 
public class ElevatorRegTest { 
    ElevatorReg elevatorReg;
@Before
public void before() throws Exception {
    elevatorReg=new ElevatorReg();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getEleReg_T() 
* 
*/ 
@Test
public void testGetEleReg_T() throws Exception { 
//TODO: Test goes here...
    elevatorReg.setEleReg_T(3);
    double num=elevatorReg.getEleReg_T();
    Assert.assertEquals(3,num,0);
} 

/** 
* 
* Method: getEleReg_t() 
* 
*/ 
@Test
public void testGetEleReg_t() throws Exception { 
//TODO: Test goes here...
    elevatorReg.setEleReg_t(3);
    double num=elevatorReg.getEleReg_t();
    Assert.assertEquals(3,num,0);

} 

/** 
* 
* Method: getEleReg_F() 
* 
*/ 
@Test
public void testGetEleReg_F() throws Exception { 
//TODO: Test goes here...
    elevatorReg.setEleReg_F(3);
    int num=elevatorReg.getEleReg_F();
    Assert.assertEquals(3,num);
} 

/** 
* 
* Method: getEleReg_D() 
* 
*/ 
@Test
public void testGetEleReg_D() throws Exception { 
//TODO: Test goes here...
    char ch=elevatorReg.getEleReg_D();
    Assert.assertEquals('F',ch);
} 

/** 
* 
* Method: getEleReg_DU() 
* 
*/ 
@Test
public void testGetEleReg_DU() throws Exception { 
//TODO: Test goes here...
    char ch=elevatorReg.getEleReg_DU();
    Assert.assertEquals('S',ch);
} 

/** 
* 
* Method: getStr() 
* 
*/ 
@Test
public void testGetStr() throws Exception { 
//TODO: Test goes here...
    elevatorReg.setStr("(ER,3,0)");
    String string=elevatorReg.getStr();
    Assert.assertEquals("(ER,3,0)",string);
} 

/** 
* 
* Method: setEleReg_t(double T) 
* 
*/ 
@Test
public void testSetEleReg_t() throws Exception { 
//TODO: Test goes here...
    elevatorReg.setEleReg_t(3);
    double num=elevatorReg.getEleReg_t();
    Assert.assertEquals(3,num,0);


} 

/** 
* 
* Method: setEleReg_F(int F) 
* 
*/ 
@Test
public void testSetEleReg_F() throws Exception { 
//TODO: Test goes here...
    elevatorReg.setEleReg_F(3);
    int num=elevatorReg.getEleReg_F();
    Assert.assertEquals(3,num);
} 

/** 
* 
* Method: setStr(String str) 
* 
*/ 
@Test
public void testSetStr() throws Exception { 
//TODO: Test goes here...
    elevatorReg.setEleReg_t(3);
    double num=elevatorReg.getEleReg_t();
    Assert.assertEquals(3,num,0);
} 

/** 
* 
* Method: IsCreat(String str, int i) 
* 
*/ 
@Test
public void testIsCreat() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: Elevator_R(String str) 
* 
*/ 
@Test
public void testElevator_R() throws Exception {
//TODO: Test goes here...

} 

/** 
* 
* Method: getTime(String str) 
* 
*/ 
@Test
public void testGetTime() throws Exception { 
//TODO: Test goes here...

}
} 
