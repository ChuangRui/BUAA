package Elevator;

import java.util.ArrayList;

public interface InterfaceElevator {
	void Control_C(ElevatorReg R, ElevatorReg M);
	void Update_C(ElevatorReg R);
	boolean IsCreat(String str, int i);
	double getTime(String str);
	ElevatorReg Elevator_R(String str);
	ArrayList<ElevatorReg> CreatInstr(ArrayList<ElevatorReg> RqstList);
	void toString(ElevatorReg R);
}
