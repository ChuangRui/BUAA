package Elevator;

import java.util.regex.Pattern;

public class ElevatorReg {
	private double Time;
	private int Flr;
	private char Dir;
	private char DU;
	private double T;
	String str;

	ElevatorReg(){
	 	/*@REQUIRES:None
          @MODIFIES:Time,Flr,Dir,DU
          @EFFECTS:(Time=0&&Flr=1&&Dir='F'&&DU='S');
        */
		this.Time=0;
		this.Flr=1;
		this.Dir='F';
		this.DU='S';
	}

	double getEleReg_T(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.Time;
        */
		return this.Time;
	}
	double getEleReg_t(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.T;
        */
		return this.T;
	}
	int getEleReg_F(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.Flr;
        */
		return this.Flr;
	}
	char getEleReg_D(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.Dir;
        */
		return this.Dir;
	}
	char getEleReg_DU(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.DU;
        */
		return this.DU;
	}
	String getStr(){
        /*@REQUIRES:None
        @MODIFIES:None
        @EFFECTS:\result=this.str;
        */
		return this.str;
	}
	void setEleReg_t(double T){
        /*@REQUIRES:\eixt double T>=0
          @MODIFIES:T
          @EFFECTS:(\old this.T=T;)
        */
		this.T=T;
	}
	void setEleReg_T(double T){
        /*@REQUIRES:\eixt double T>=0
          @MODIFIES:T
          @EFFECTS:(\old this.T=T;)
        */
		this.Time=T;
	}
	void setEleReg_F(int F){
        /*@REQUIRES:\eixt int 1<=F<=10;
          @MODIFIES:Flr
          @EFFECTS:(\old this.Flr=F;)
        */
		this.Flr=F;
	}
	void setStr(String str){
        /*@REQUIRES:\all String str
          @MODIFIES:str
          @EFFECTS:(\old this.str=str;)
        */
		this.str=str;
	}
	boolean IsCreat(String str,int i)throws Exception{
	 	/*@REQUIRES:\all String str,int i
          @MODIFIES:None
          @EFFECTS:判断字符串str是否合法
          		   (i==0&&(str.matches("\(FR,\d+,(DOWN|UP),\d+\)||(str.matches("\\(ER,\\d+,\\d+\\)"))==>\result=true;
          		   (otherwise==>\result=false);
        */
		str=str.replaceAll(" ", "");
		if(i==0&&this.getTime(str)!=0)
			throw new Exception();
		if(Pattern.matches(".*FR.*", str)){
			if(str.matches("\\(FR,\\d+,(DOWN|UP),\\d+\\)")){
				if(this.getTime(str)>=T){
					T=this.getTime(str);
					return true;
				}
				else return false;
			}
			else return false;
		}
		else if(Pattern.matches(".*ER.*", str)){
			if(str.matches("\\(ER,\\d+,\\d+\\)")){
				if(this.getTime(str)>=T){
					T=this.getTime(str);
					return true;
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}
	ElevatorReg Elevator_R(String str) throws Exception{
	 	/*@REQUIRES:\all String str
          @MODIFIES:None
          @EFFECTS:将字符串str转为指令ElevatorReg
        */
	 	ElevatorReg reg=new ElevatorReg();
		str=str.replaceAll(" ", "");
		String[] tokens=str.split("[(),]");
		if(tokens[1].matches("FR")){
			reg.Dir='F';
			reg.Flr=Integer.parseInt(tokens[2]);
			if(reg.Flr>10|reg.Flr<1)
				throw new Exception();
			reg.Time=Double.parseDouble(tokens[4]);
			if(tokens[3].matches("DOWN"))
				reg.DU='D';
			else if(tokens[3].matches("UP"))
				reg.DU='U';
			else throw new Exception();
		}
		else if(tokens[1].matches("ER")){
			reg.Dir='E';
			reg.Flr=Integer.parseInt(tokens[2]);
			if(reg.Flr>10|reg.Flr<1)
				throw new Exception();
			reg.Time=Double.parseDouble(tokens[3]);
		}
		else throw new Exception();
		return reg;
	}
	double getTime(String str) throws Exception{
	 	/*@REQUIRES:\all String str
          @MODIFIES:None
          @EFFECTS:获取字符串str的请求时间
          		   \result=srt.T
        */
		double T=0;
		String[] tokens=str.split("[(),]");
		if(tokens[1].matches("FR")&tokens.length==5)
			T=Integer.parseInt(tokens[4]);
		else if(tokens[1].matches("ER")&tokens.length==4)
			T=Double.parseDouble(tokens[3]);
		else throw new Exception();

		return T;
	}

}
