package Elevator;

import java.util.*;

public class PiggyBack extends Control{
	protected	double	NextTime=0;
	protected	int	e_n=0;
	protected	int	n=0;
	protected	char sta;
	protected	int[]	FlrStop=new int[11];
	ArrayList<ElevatorReg> ExcuteList =new ArrayList<ElevatorReg>();
	ArrayList<ElevatorReg> CreatInstr(ArrayList<ElevatorReg> RqstList)throws Exception{
		this.ReSetFlrStop();
		for(int i=0;i<RqstList.size();i++) {
			double NextTime =this.GetETime(RqstList.get(i));
			if ((RqstList.get(i).getEleReg_T()<NextTime)&&(RqstList.get(i).getEleReg_T()<elevator.getElevator_t())) { 
				switch (RqstList.get(i).getEleReg_D()) {
					case 'F': {
						if (RqstList.get(i).getEleReg_DU() == this.sta && (this.sta == 'U' || this.sta == 'S')) {
							if ((RqstList.get(i).getEleReg_F() <= this.n)
									&& (RqstList.get(i).getEleReg_F() > this.e_n)) {
								RqstList.get(i).setEleReg_t(this.GetETime(RqstList.get(i)));
								ExcuteList.add(0,RqstList.get(i));
								this.SetFlrStop(RqstList.get(i));
								RqstList.remove(i--);
								break;
								
							}
						}
						if (RqstList.get(i).getEleReg_DU() == this.sta && (this.sta == 'D' || this.sta == 'S')) {
							if ((RqstList.get(i).getEleReg_F() >= this.n)
									&& (RqstList.get(i).getEleReg_F() < this.e_n)) {
								RqstList.get(i).setEleReg_t(this.GetETime(RqstList.get(i)));
								ExcuteList.add(0,RqstList.get(i));
								this.SetFlrStop(RqstList.get(i));
								RqstList.remove(i--);	
								break;
							}
						}
						break;
					}
					case 'E': {
						if (this.sta == 'U' || this.sta == 'S')
							if (RqstList.get(i).getEleReg_F() > this.e_n) {
								RqstList.get(i).setEleReg_t(this.GetETime(RqstList.get(i)));
								ExcuteList.add(0,RqstList.get(i));
								this.SetFlrStop(RqstList.get(i));
								RqstList.remove(i--);
								break;
							}
						if (this.sta == 'D' || this.sta == 'S')
							if (RqstList.get(i).getEleReg_F() < this.e_n) {
								RqstList.get(i).setEleReg_t(this.GetETime(RqstList.get(i)));
								ExcuteList.add(0,RqstList.get(i));
								this.SetFlrStop(RqstList.get(i));
								RqstList.remove(i--);
								break;
						}
						break;
					}
					default:
						throw new Exception();
				}
			}
		}
		if(this.sta=='D'){
			Collections.sort(ExcuteList, new Comparator<ElevatorReg>() {
	            @Override
	            public int compare(ElevatorReg o1, ElevatorReg o2) {
	                return o1.getEleReg_F()>o2.getEleReg_F()?-1:1;
	            }
		});
		}
		else{
		Collections.sort(ExcuteList, new Comparator<ElevatorReg>() {
	            @Override
	            public int compare(ElevatorReg o1, ElevatorReg o2) {
	                return o1.getEleReg_F()<o2.getEleReg_F()?-1:1;
	            }
		});
		}
		return ExcuteList;
	}
	double GetETime(ElevatorReg R){
		double Time=0;
		int i=R.getEleReg_F()-elevator.getElevator_F();
		if(i<0)
			 Time=elevator.getElevator_T()+0.5*i*(-1);
		else if(i>0)
			 Time=elevator.getElevator_T()+0.5*i;		 
		else
			 Time=elevator.getElevator_T()+1;
		for(i=0;i<11;i++){
			if(this.FlrStop[i]!=0&&R.getEleReg_F()>i){
				Time+=1;
			}
		}
		return Time;
		
	}
	void toString(ElevatorReg R){

		int i=R.getEleReg_F()-elevator.getElevator_F();
		if(i<0){
			 this.e_n=elevator.getElevator_F();
			 this.n=R.getEleReg_F();
			 this.sta='D';

		}else if(i>0){
			 this.e_n=elevator.getElevator_F();
			 this.n=R.getEleReg_F();
			 this.sta='U';
		}else{
			 this.e_n=elevator.getElevator_F();
			 this.n=R.getEleReg_F();
			 this.sta='S';

		}

		
	}
	void ReSetFlrStop(){
		for(int i=1;i<11;i++)
			this.FlrStop[i]=0;
	}
	void SetFlrStop(ElevatorReg R){
		if(R.getEleReg_F()<this.n)
			elevator.setElevator_t(elevator.getElevator_t()+1);
		this.FlrStop[R.getEleReg_F()]++;
	}
	void setElevaot_dt(ElevatorReg R){
		double Time=0;
		int i=R.getEleReg_F()-elevator.getElevator_F();
		if(i<0)
			 Time=elevator.getElevator_T()+0.5*i*(-1);
		else if(i>0)
			 Time=elevator.getElevator_T()+0.5*i;		 
		else
			 Time=elevator.getElevator_T()+1;
		elevator.setElevator_t(Time);
	}
}

