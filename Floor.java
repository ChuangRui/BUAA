package Elevator;

public class Floor{
	private int[] floor_u= new int[11];
	private int[] floor_d= new int[11];
    Floor(){
	for(int i=0;i<11;i++){
		floor_u[i]=0;
		floor_d[i]=0;
	}
    }
	public boolean FloorState(ElevatorReg R){
		if(R.getEleReg_DU()=='U'){
			if(this.floor_u[R.getEleReg_F()]==1)
				return true;
			else
				return false;
		}
		else if(R.getEleReg_DU()=='D'){
			if(this.floor_d[R.getEleReg_F()]==1)
				return true;
			else
				return false;
		}
		else return false;
	}
	public void SetFloor(ElevatorReg R){
		if(R.getEleReg_DU()=='U')
			this.floor_u[R.getEleReg_F()]=1;
		else if(R.getEleReg_DU()=='D')
			this.floor_d[R.getEleReg_F()]=1;
	}
	public void UpFloor(ElevatorReg R){
		for(int i=0;i<11;i++){
			this.floor_u[i]=0;
			this.floor_d[i]=0;
		}
	}
}
