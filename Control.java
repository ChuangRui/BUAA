package Elevator;

import java.math.*;
public class Control {
	 Floor floor=new Floor();
	 Elevator elevator=new Elevator();
	 ElevatorReg preR=new  ElevatorReg();
	 void Control_C(ElevatorReg R,ElevatorReg M){
	 	/*@REQUIRES:\all ElevatorReg R,ElevatorReg M
          @MODIFIES:floor
          @EFFECTS:(M.T>elevator.T==>floor.UpFloor(R)&&elevator.UpE()更新floor,elevator);
          		   (R.Dir=='F'&&(R is legal)==>Update_C(R)&&floor.SetFloor(R)调度执行指令R并且更新floor);
          		   (R.Dir=='E'&&(R is legal)==>Update_C(R)&&floor.SetFloor(R)调度执行指令R并且更新floor);
          		   (otherwise throw Exception==>Exception_behavior)
        */
		 try{
		 if(M.getEleReg_T()>elevator.getElevator_T()){
			 floor.UpFloor(R);
			 elevator.UpE();
		 }
		 if(R.getEleReg_D()=='F'){
			 if(R.getEleReg_F()==1&R.getEleReg_DU()=='D'&R.getEleReg_D()=='F')
				 throw new Exception();
			 if(R.getEleReg_F()==10&R.getEleReg_DU()=='U'&R.getEleReg_D()=='F')
				 throw new Exception();
			 if(R.getEleReg_T()<=elevator.getElevator_T())
				 if(floor.FloorState(R)){
					 this.PrintElevatorReg(R);
					 System.out.println("Input is noneffective");
					 return ;
				 }
				 else {
					 Update_C(R);
					 floor.SetFloor(R);
				 }
			 else {
				 Update_C(R);
				 floor.SetFloor(R);
			 }
		 }
		 else if(R.getEleReg_D()=='E'){
			 if(R.getEleReg_T()<=elevator.getElevator_T())
				 if(elevator.EState(R)){
					 this.PrintElevatorReg(R);
					 System.out.println("Input is noneffective");
					 return ;
				 }
				 else{
					 Update_C(R);
					 elevator.setE(R);
				 }
			 else{
				 Update_C(R);
				 elevator.setE(R);
			 }
		 }
		 }
		 catch(Exception e){
			    this.PrintElevatorReg(R);
				System.out.println("Input is illegal");
			}
	 }
	void Update_C(ElevatorReg R){
	 	/*@REQUIRES:\all ElevatorReg R
          @MODIFIES:elevator
          @EFFECTS:执行指令R,调度电梯运行并输出相关信息
          		   (R.Flr-elevator,Flr<0==>(elevator.Dir='D')&&(elevator.T=elevator.T()+0.5*(R.Flr-elevator)*(-1)+1))
          		   &&(elevator.Fir=R.Fir)&&(输出指令R运行信息到控制台和文件中);
          		   (R.Flr-elevator,Flr>0==>(elevator.Dir='U')&&(elevator.T=elevator.T()+0.5*(R.Flr-elevator)+1))
          		   &&(elevator.Fir=R.Fir)&&(输出指令R运行信息到控制台和文件中);
          		   (R.Flr-elevator,Flr==0==>(elevator.Dir='S')&&(elevator.T=elevator.T()+1))
          		   &&(elevator.Fir=R.Fir)&&(输出指令R运行信息到控制台和文件中);
        */
		String result;
		int i=R.getEleReg_F()-elevator.getElevator_F();
		if(i<0){
			 elevator.setElevator_D('D');
			 elevator.setElevator_T((double) (elevator.getElevator_T()+0.5*i*(-1)+1));
			 elevator.setElevator_F(R.getEleReg_F());
			 BigDecimal bigD=new BigDecimal(elevator.getElevator_T()-1);
			 result=bigD.toPlainString();
			 String str1="("+String.valueOf(elevator.getElevator_F())+",DOWN,"+result+")";
			 this.SetPreR(R, str1);
			 this.PrintElevatorReg(R);
			 System.out.println(str1);
			 //this.sche.add(str1);
		 }
		 else if(i>0){
			 elevator.setElevator_D('U');
			 elevator.setElevator_T((double) (elevator.getElevator_T()+0.5*i+1));
			 elevator.setElevator_F(R.getEleReg_F());
			 BigDecimal bigD=new BigDecimal(elevator.getElevator_T()-1);
			 result=bigD.toPlainString();
			 String str2="("+String.valueOf(elevator.getElevator_F())+",UP,"+ result+")";
			 this.SetPreR(R, str2);
			 this.PrintElevatorReg(R);
			 System.out.println(str2);
			 //this.sche.add(str2);
		 }
		 else{
			 if(this.GetPreR()==R.getEleReg_F()&&elevator.getElevator_T()!=0){
				 this.PrintElevatorReg(R);
				 System.out.println(preR.getStr());
			 }
			 else{
				 elevator.setElevator_D('S');
				 elevator.setElevator_T((double)(elevator.getElevator_T()+1));
				 elevator.setElevator_F(R.getEleReg_F());
				 BigDecimal bigD=new BigDecimal(elevator.getElevator_T());
				 result=bigD.toPlainString();
				 String str3="("+String.valueOf(elevator.getElevator_F())+",STILL,"+ result+")";
				 //this.SetPreR(R, str3);
				 this.PrintElevatorReg(R);
				 System.out.println(str3);
			 }
			 }
	}
	void PrintElevatorReg(ElevatorReg R){
	 	/*@REQUIRES:\all ElevatorReg R
          @MODIFIES:None
          @EFFECTS:将指令R作为字符串格式输出
        */
		switch(R.getEleReg_D()){
		case'F':{
			if(R.getEleReg_DU()=='U'){
				String str="["+"FR,"+String.valueOf(R.getEleReg_F())+",UP,"+String.valueOf(R.getEleReg_T())+"]/";
				System.out.print(str);
			}
			if(R.getEleReg_DU()=='D'){
				String str="["+"FR,"+String.valueOf(R.getEleReg_F())+",DOWN,"+String.valueOf(R.getEleReg_T())+"]/";
				System.out.print(str);
			}
			break;
			}
		case'E':{
			String str="["+"ER,"+String.valueOf(R.getEleReg_F())+","+String.valueOf(R.getEleReg_T())+"]/";
			System.out.print(str);
			break;
		}
		}
	}
	void SetPreR(ElevatorReg R,String str){
        /*@REQUIRES:\all ElevatorReg R,String str
          @MODIFIES:preR
          @EFFECTS:(\old preR.Flr=R.Flr;)
                   (\old preR.Str=str;)
        */
		preR.setEleReg_F(R.getEleReg_F());
		preR.setStr(str);
	}
	int GetPreR(){
	  /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=preR.Fir;
        */
		return preR.getEleReg_F();
	}

}




