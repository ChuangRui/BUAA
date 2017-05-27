package Elevator;
public class Elevator {
	private static final char NUll = 0;
	private static double Time;
	private static double T;
	private static char Dir;
	private static int Flr;
	static int[] E=new int[11];
	Elevator(){
		this.Time=0;
		this.Dir=NUll;
		this.Flr=1;
		for(int i=0;i<11;i++)
			this.E[i]=0;
	}

	public char getDir() {
		return Dir;
	}

	double getElevator_T(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.Time;
        */
		return this.Time;
	}
	double getElevator_t(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.T;
        */
		return this.T;
	}
	int getElevator_F(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.Flr;
        */
		return this.Flr;
	}
	void setElevator_T(double d){
        /*@REQUIRES:\eixt double d>=0
          @MODIFIES:Time
          @EFFECTS:(\old this.Time=d;)
        */
		this.Time=d;
	}
	void setElevator_t(double d){
        /*@REQUIRES:\eixt double d>=0
          @MODIFIES:T
          @EFFECTS:(\old this.T=d;)
        */
		this.T=d;
	}
	void setElevator_F(int F){
        /*@REQUIRES:\eixt int 1<=F<=10
          @MODIFIES:Flr
          @EFFECTS:(\old this.Flr=F;)
        */
		this.Flr=F;
	}
	void setElevator_D(char D){
        /*@REQUIRES:\eixt char D=='U'|'D'|'S'
          @MODIFIES:Dir
          @EFFECTS:(\old this.Dir=D;)
        */
		this.Dir=D;
	}

	void setE(ElevatorReg R){
        /*@REQUIRES:\all ElevatorReg R
          @MODIFIES:E
          @EFFECTS:(\old E[R.getEleReg_F()]=1;)
        */
		this.E[R.getEleReg_F()]=1;
	}
	void UpE(){
        /*@REQUIRES:None
          @MODIFIES:E
          @EFFECTS:(\all int 1<=i<=10;\old E[i]=0;)
        */
		for(int i=0;i<11;i++)
			this.E[i]=0;
	}
    boolean EState(ElevatorReg R){
        /*@REQUIRES:\all ElevatorReg R
          @MODIFIES:None
          @EFFECTS:(E[R.getEleReg_F()]==1==>\result=true)
          		   (otherwise==>\result=false)
        */
    	if(this.E[R.getEleReg_F()]==1)
    		return true;
    	else return false;
    }

}
