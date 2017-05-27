package Elevator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
/**
* Control Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 27, 2017</pre> 
* @version 1.0 
*/ 
public class ControlTest {
    Control tcontrol;
    ElevatorReg televatorReg;

@Before
public void before() throws Exception {
    tcontrol=new Control();
    televatorReg=new ElevatorReg();
} 

@After
public void after() throws Exception {
    tcontrol.elevator.setElevator_T(0);
    tcontrol.elevator.setElevator_t(0);
    tcontrol.elevator.setElevator_D('S');
    tcontrol.elevator.setElevator_F(1);
}

/**
* 
* Method: Control_C(ElevatorReg R, ElevatorReg M) 
* 
*/ 
@Test
public void testControl_C() throws Exception {
    //TODO: Test goes here...
    tcontrol.elevator.setElevator_T(3);
    tcontrol.elevator.setElevator_t(3);
    ElevatorReg m=televatorReg.Elevator_R("(FR,5,UP,1)");
    ElevatorReg f1=televatorReg.Elevator_R("(FR,1,DOWN,4)");
    ElevatorReg f2=televatorReg.Elevator_R("(FR,10,UP,4)");
    ElevatorReg f3=televatorReg.Elevator_R("(FR,5,UP,2)");
    ElevatorReg f4=televatorReg.Elevator_R("(FR,6,DOWN,3)");
    ElevatorReg f5=televatorReg.Elevator_R("(FR,5,DOWN,2)");
    ElevatorReg e1=televatorReg.Elevator_R("(ER,5,2)");
    ElevatorReg e2=televatorReg.Elevator_R("(ER,5,4)");
    ElevatorReg e3=televatorReg.Elevator_R("(ER,2,2)");
    tcontrol.floor.SetFloor(f3);
    tcontrol.Control_C(f1,m);
    tcontrol.Control_C(f2,m);
    tcontrol.Control_C(f3,m);
    tcontrol.Control_C(f4,m);
    tcontrol.Control_C(f5,m);
    tcontrol.Control_C(e1,m);
    tcontrol.Control_C(e2,m);
    tcontrol.Control_C(e3,m);

    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    assertEquals("[FR,1,DOWN,4.0]/Input is illegal",str);
    String str1 = scanner.nextLine();
    assertEquals("[FR,10,UP,4.0]/Input is illegal",str);
    str = scanner.nextLine();
    assertEquals("[FR,5,UP,2.0]/Input is noneffective",str);

} 

/** 
* 
* Method: Update_C(ElevatorReg R) 
* 
*/ 
@Test
public void testUpdate_C() throws Exception {
//TODO: Test goes here...
    ElevatorReg r1=televatorReg.Elevator_R("(FR,5,DOWN,1)");
    ElevatorReg r2=televatorReg.Elevator_R("(FR,3,DOWN,2)");
    ElevatorReg r3=televatorReg.Elevator_R("(FR,3,UP,10)");
    tcontrol.Update_C(r1);
    tcontrol.Update_C(r2);
    tcontrol.Update_C(r3);

} 

/** 
* 
* Method: PrintElevatorReg(ElevatorReg R) 
* 
*/ 
@Test
public void testPrintElevatorReg() throws Exception { 
//TODO: Test goes here...
    ElevatorReg r1=televatorReg.Elevator_R("(FR,5,DOWN,0)");
    ElevatorReg r2=televatorReg.Elevator_R("(FR,6,UP,1)");
    ElevatorReg r3=televatorReg.Elevator_R("(ER,5,2)");
    tcontrol.PrintElevatorReg(r1);
    tcontrol.PrintElevatorReg(r2);
    tcontrol.PrintElevatorReg(r3);
} 

/** 
* 
* Method: SetPreR(ElevatorReg R, String str) 
* 
*/ 
@Test
public void testSetPreR() throws Exception { 
//TODO: Test goes here...
    ElevatorReg r1=televatorReg.Elevator_R("(FR,5,DOWN,0)");
    String string="(FR,5,DOWN,0)";
    tcontrol.SetPreR(r1,string);
    assertEquals(r1,tcontrol.preR);
    assertEquals(string,tcontrol.preR.str);
}

/** 
* 
* Method: GetPreR() 
* 
*/ 
@Test
public void testGetPreR() throws Exception { 
//TODO: Test goes here...
    int num=tcontrol.GetPreR();
    assertEquals(5,num);
} 


} 
