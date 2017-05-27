package Elevator;
import java.util.ArrayList;
/**
 * Created by Bruce on 2017/5/27.
 */
public class Mainfunction {
    private static Input reqst=new Input();
    private	static  ElevatorReg	R=new ElevatorReg();
    private	static	Control	C=new Control();
    private	static	PiggyBack	piggyback=new PiggyBack();
    public static void main(String[] args) throws Exception{
        ArrayList<String> list=new ArrayList<String>();
        try{
            System.out.println("Please input the request and end in RUN/run:");
            list=reqst.getInput();

            for(int i=0;i<list.size();i++){
                try{
                    if(R.IsCreat(list.get(i),i)) {
                        ElevatorReg R=new ElevatorReg();
                        reqst.RqstList.add(R.Elevator_R(list.get(i)));
                    }
                    else {

                        System.out.print(list.get(i));
                        System.out.println("Input is illegal");

                    }
                }
                catch(Exception e1){
                    System.out.print(list.get(i));
                    System.out.println("Input is illegal");
                }
            }
            while(reqst.RqstList.size()!=0||piggyback.ExcuteList.size()!=0){
                try{
                    if(piggyback.ExcuteList.size()==0){
                        R=reqst.RqstList.get(0);
                        piggyback.ExcuteList.add(R);
                        reqst.RqstList.remove(0);
                    }
                    else R=piggyback.ExcuteList.get(0);
                    if(R.getEleReg_T()>=C.elevator.getElevator_T())
                        C.elevator.setElevator_T(R.getEleReg_T());
                    piggyback.toString(R);
                    piggyback.setElevaot_dt(R);
                    piggyback.ExcuteList=piggyback.CreatInstr(reqst.RqstList);
                    while(R!=piggyback.ExcuteList.get(0)){
                        C.Control_C(piggyback.ExcuteList.get(0),R);
                        piggyback.ExcuteList.remove(0);
                    }
                    C.Control_C(piggyback.ExcuteList.get(0),R);
                    piggyback.ExcuteList.remove(0);
                }
                catch(Exception e1){
                    System.out.println("Input is illegal");
                }
            }

        }catch(Exception e){
            System.out.println("Input is illegal");
        }
    }
}
