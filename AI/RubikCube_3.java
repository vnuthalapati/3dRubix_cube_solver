package RUBICCUBE;

import java.io.*;


import java.util.*;

 class SolveCube{
	 public char top[]=new char[10];
	  public char bot[]=new char[10];
	  public char lef[]=new char[10];
	  public char rig[]=new char[10];
	  public char fow[]=new char[10];
	  public char bac[]=new char[10];	 
	  public char select,select1,select2;
	  public BufferedReader R=new BufferedReader(new InputStreamReader(System.in));
	  public Scanner cin=new Scanner(System.in);
	  public char c;
	  
	public void getInput() throws IOException
	{ 
		  String ss=new String();
		  System.out.println("*******************SOLVING RUBIK'S CUBE*********************");	
		System.out.println("Pattern of entering Cube Colours \n White-W \n Blue-B \n Red-R\n Orange-O \n Green-G \n Yellow-Y ");
		System.out.println("Note:-1.Enter a Garbage character first bfore entering the correct Input for every side\n2.Enter the Top portion colours in wich it has White at the Mid postion");
		System.out.println("Enter the Colours at Top side of d cube");
		ss=cin.nextLine(); 
			top=ss.toCharArray();
		
		System.out.println("Enter the Colours at Bottom side of d cube");
		ss=cin.nextLine();
			bot=ss.toCharArray();
		System.out.println("Enter the Colours at Right side of d cube");
		ss=cin.nextLine();
		rig=ss.toCharArray();
		System.out.println("Enter the Colours at Left side of d cube");
		ss=cin.nextLine();
		lef=ss.toCharArray();
		System.out.println("Enter the Colours at Back side of d cube");
		ss=cin.nextLine();
		bac=ss.toCharArray();
		System.out.println("Enter the Colours at Front side of d cube");
		ss=cin.nextLine();
		fow=ss.toCharArray();
		displayCube();
	}
	 public  void Right() throws IOException
	  {
		  char temp;
		  System.out.println("Right");
		  temp=top[3];
		  top[3]=fow[3];
		  fow[3]=bot[3];
		  bot[3]=bac[7];
		  bac[7]=temp;
		  
		  temp=top[6];
		  top[6]=fow[6];
		  fow[6]=bot[6];
		  bot[6]=bac[4];
		  bac[4]=temp;
		  
		  temp=top[9];
		  top[9]=fow[9];
		  fow[9]=bot[9];
		  bot[9]=bac[1];
		  bac[1]=temp;
		  
		  temp=rig[1];
		  rig[1]=rig[7];
		  rig[7]=rig[9];
		  rig[9]=rig[3];
		  rig[3]=temp;
		  
		  temp=rig[2];
		  rig[2]=rig[4];
		  rig[4]=rig[8];
		  rig[8]=rig[6];
		  rig[6]=temp;
		  //displayCube();
		  //temp=(char) R.read();
		  }
	 public void RightInverse() throws IOException
	  {
		  char temp;
		  System.out.println("Right-Inverse");
		  temp=top[3];
		  top[3]=bac[7];
		  bac[7]=bot[3];
		  bot[3]=fow[3];
		  fow[3]=temp;
		  
		  temp=top[6];
		  top[6]=bac[4];
		  bac[4]=bot[6];
		  bot[6]=fow[6];
		  fow[6]=temp;
		  
		  temp=top[9];
		  top[9]=bac[1];
		  bac[1]=bot[9];
		  bot[9]=fow[9];
		  fow[9]=temp;
		  
		  temp=rig[3];
		  rig[3]=rig[9];
		  rig[9]=rig[7];
		  rig[7]=rig[1];
		  rig[1]=temp;
		  
		  temp=rig[2];
		  rig[2]=rig[6];
		  rig[6]=rig[8];
		  rig[8]=rig[4];
		  rig[4]=temp;
	  }
	 public void Left() throws IOException
	  { char temp;
	  System.out.println("Left");
		  temp=top[1];
		  top[1]=bac[9];
		  bac[9]=bot[1];
		  bot[1]=fow[1];
		  fow[1]=temp;
		  
		  temp=top[4];
		  top[4]=bac[6];
		  bac[6]=bot[4];
		  bot[4]=fow[4];
		  fow[4]=temp;
		  
		  temp=top[7];
		  top[7]=bac[3];
		  bac[3]=bot[7];
		  bot[7]=fow[7];
		  fow[7]=temp;
		  
		  temp=lef[1];
		  lef[1]=lef[7];
		  lef[7]=lef[9];
		  lef[9]=lef[3];
		  lef[3]=temp;
		  
		  temp=lef[2];
		  lef[2]=lef[4];
		  lef[4]=lef[8];
		  lef[8]=lef[6];
		  lef[6]=temp;
		  }
	 public void LeftInverse() throws IOException
	  {
		  char temp;
		  System.out.println("Left-Inverse");
		  temp=top[1];
		  top[1]=fow[1];
		  fow[1]=bot[1];
		  bot[1]=bac[9];
		  bac[9]=temp;
		  
		  temp=top[4];
		  top[4]=fow[4];
		  fow[4]=bot[4];
		  bot[4]=bac[6];
		  bac[6]=temp;
		  
		  temp=top[7];
		  top[7]=fow[7];
		  fow[7]=bot[7];
		  bot[7]=bac[3];
		  bac[3]=temp;
		  
		  temp=lef[2];
		  lef[2]=lef[6];
		  lef[6]=lef[8];
		  lef[8]=lef[4];
		  lef[4]=temp;
		  
		  temp=lef[1];
		  lef[1]=lef[3];
		  lef[3]=lef[9];
		  lef[9]=lef[7];
		  lef[7]=temp;
		  }
	 public void Front() throws IOException
	  {
		  char temp;
		  System.out.println("Front");
		  temp=top[7];
		  top[7]=lef[9];
		  lef[9]=bot[3];
		  bot[3]=rig[1];
		  rig[1]=temp;
		  
		  temp=top[8];
		  top[8]=lef[6];
		  lef[6]=bot[2];
		  bot[2]=rig[4];
		  rig[4]=temp;
		  
		  temp=top[9];
		  top[9]=lef[3];
		  lef[3]=bot[1];
		  bot[1]=rig[7];
		  rig[7]=temp;
		  
		  temp=fow[1];
		  fow[1]=fow[7];
		  fow[7]=fow[9];
		  fow[9]=fow[3];
		  fow[3]=temp;
		  
		  temp=fow[2];
		  fow[2]=fow[4];
		  fow[4]=fow[8];
		  fow[8]=fow[6];
		  fow[6]=temp;
	  }
	 public void FrontInverse() throws IOException
	  {
		  char temp;
		  System.out.println("Front-Inverse");
		  temp=top[7];
		  top[7]=rig[1];
		  rig[1]=bot[3];
		  bot[3]=lef[9];
		  lef[9]=temp;
		  
		  temp=top[8];
		  top[8]=rig[4];
		  rig[4]=bot[2];
		  bot[2]=lef[6];
		  lef[6]=temp;
		  
		  temp=top[9];
		  top[9]=rig[7];
		  rig[7]=bot[1];
		  bot[1]=lef[3];
		  lef[3]=temp;
		  
		  temp=fow[1];
		  fow[1]=fow[3];
		  fow[3]=fow[9];
		  fow[9]=fow[7];
		  fow[7]=temp;
		  
		  temp=fow[2];
		  fow[2]=fow[6];
		  fow[6]=fow[8];
		  fow[8]=fow[4];
		  fow[4]=temp;
	  }
	 public void Back() throws IOException
	  {
		  char temp;
		  System.out.println("Back");
		  temp=top[1];
		  top[1]=lef[7];
		  lef[7]=bot[9];
		  bot[9]=rig[3];
		  rig[3]=temp;
		  
		  temp=top[2];
		  top[2]=lef[4];
		  lef[4]=bot[8];
		  bot[8]=rig[6];
		  rig[6]=temp;
		  
		  temp=top[3];
		  top[3]=lef[1];
		  lef[1]=bot[7];
		  bot[7]=rig[9];
		  rig[9]=temp;
		  
		  temp=bac[1];
		  bac[1]=bac[3];
		  bac[3]=bac[9];
		  bac[9]=bac[7];
		  bac[7]=temp;
		  
		  temp=bac[6];
		  bac[6]=bac[8];
		  bac[8]=bac[4];
		  bac[4]=bac[2];
		  bac[2]=temp;
	  }
	 public  void BackInverse() throws IOException
	  {
		  char temp;
		  System.out.println("Back-Inverse");
		  temp=top[1];
		  top[1]=rig[3];
		  rig[3]=bot[9];
		  bot[9]=lef[7];
		  lef[7]=temp;
		  
		  temp=top[2];
		  top[2]=rig[6];
		  rig[6]=bot[8];
		  bot[8]=lef[4];
		  lef[4]=temp;
		  
		  temp=top[3];
		  top[3]=rig[9];
		  rig[9]=bot[7];
		  bot[7]=lef[1];
		  lef[1]=temp;
		  
		  temp=bac[1];
		  bac[1]=bac[7];
		  bac[7]=bac[9];
		  bac[9]=bac[3];
		  bac[3]=temp;
		  
		  temp=bac[2];
		  bac[2]=bac[4];
		  bac[4]=bac[8];
		  bac[8]=bac[6];
		  bac[6]=temp;
	  }
	 public void Up() throws IOException
	  {
		  char temp;
		  System.out.println("Up");
		  temp=bac[3];
		  bac[3]=lef[3];
		  lef[3]=fow[3];
		  fow[3]=rig[3];
		  rig[3]=temp;
		  
		  temp=bac[2];
		  bac[2]=lef[2];
		  lef[2]=fow[2];
		  fow[2]=rig[2];
		  rig[2]=temp;
		  
		  temp=bac[1];
		  bac[1]=lef[1];
		  lef[1]=fow[1];
		  fow[1]=rig[1];
		  rig[1]=temp;
		  
		  temp=top[1];
		  top[1]=top[7];
		  top[7]=top[9];
		  top[9]=top[3];
		  top[3]=temp;
		  
		  temp=top[2];
		  top[2]=top[4];
		  top[4]=top[8];
		  top[8]=top[6];
		  top[6]=temp;
	  }
	 public void UpInverse() throws IOException
	  {
		  char temp;
		  System.out.println("Up-Inverse");
		  temp=rig[3];
		  rig[3]=fow[3];
		  fow[3]=lef[3];
		  lef[3]=bac[3];
		  bac[3]=temp;
		  
		  temp=rig[2];
		  rig[2]=fow[2];
		  fow[2]=lef[2];
		  lef[2]=bac[2];
		  bac[2]=temp;
		  
		  temp=rig[1];
		  rig[1]=fow[1];
		  fow[1]=lef[1];
		  lef[1]=bac[1];
		  bac[1]=temp;
		  
		  temp=top[1];
		  top[1]=top[3];
		  top[3]=top[9];
		  top[9]=top[7];
		  top[7]=temp;
		  
		  temp=top[2];
		  top[2]=top[6];
		  top[6]=top[8];
		  top[8]=top[4];
		  top[4]=temp;
	  }
	 public void Down() throws IOException
	  {
		  char temp;
		  System.out.println("Down");
		  temp=fow[7];
		  fow[7]=lef[7];
		  lef[7]=bac[7];
		  bac[7]=rig[7];
		  rig[7]=temp;
		  
		  temp=fow[8];
		  fow[8]=lef[8];
		  lef[8]=bac[8];
		  bac[8]=rig[8];
		  rig[8]=temp;
		  
		  temp=fow[9];
		  fow[9]=lef[9];
		  lef[9]=bac[9];
		  bac[9]=rig[9];
		  rig[9]=temp;
		  
		  temp=bot[1];
		  bot[1]=bot[7];
		  bot[7]=bot[9];
		  bot[9]=bot[3];
		  bot[3]=temp;
		  
		  temp=bot[2];
		  bot[2]=bot[4];
		  bot[4]=bot[8];
		  bot[8]=bot[6];
		  bot[6]=temp;
	  }
	 public void DownInverse() throws IOException
	  {
char temp;
System.out.println("Down-Inverse");
		  temp=fow[7];
		  fow[7]=rig[7];
		  rig[7]=bac[7];
		  bac[7]=lef[7];
		  lef[7]=temp;
		  
		  temp=fow[8];
		  fow[8]=rig[8];
		  rig[8]=bac[8];
		  bac[8]=lef[8];
		  lef[8]=temp;
		  
		  temp=fow[9];
		  fow[9]=rig[9];
		  rig[9]=bac[9];
		  bac[9]=lef[9];
		  lef[9]=temp;
		  
		  temp=bot[1];
		  bot[1]=bot[3];
		  bot[3]=bot[9];
		  bot[9]=bot[7];
		  bot[7]=temp;
		  
		  temp=bot[2];
		  bot[2]=bot[6];
		  bot[6]=bot[8];
		  bot[8]=bot[4];
		  bot[4]=temp;
	  }
	 public void Center() throws IOException
	  {
		  char temp;
		  System.out.println("Center");
		  temp=fow[4];
		  fow[4]=lef[4];
		  lef[4]=bac[4];
		  bac[4]=rig[4];
		  rig[4]=temp;
		  
		  temp=fow[5];
		  fow[5]=lef[5];
		  lef[5]=bac[5];
		  bac[5]=rig[5];
		  rig[5]=temp;
		 
		  temp=fow[6];
		  fow[6]=lef[6];
		  lef[6]=bac[6];
		  bac[6]=rig[6];
		  rig[6]=temp;
		}
	 public void CenterInverse() throws IOException
	  {
		  char temp;
		  System.out.println("Center-Inverse");
		  temp=fow[4];
		  fow[4]=rig[4];
		  rig[4]=bac[4];
		  bac[4]=lef[4];
		  lef[4]=temp;
		  
		  temp=fow[5];
		  fow[5]=rig[5];
		  rig[5]=bac[5];
		  bac[5]=lef[5];
		  lef[5]=temp;
		  
		  temp=fow[6];
		  fow[6]=rig[6];
		  rig[6]=bac[6];
		  bac[6]=lef[6];
		  lef[6]=temp;
		  }
	 public void Mid() throws IOException
	  {
		  char temp;
		  System.out.println("Mid");
		  temp=top[8];
		  top[8]=fow[8];
		  fow[8]=bot[8];
		  bot[8]=bac[2];
		  bac[2]=temp;
		  
		  temp=top[5];
		  top[5]=fow[5];
		  fow[5]=bot[5];
		  bot[5]=bac[5];
		  bac[5]=temp;
		  
		  temp=top[2];
		  top[2]=fow[2];
		  fow[2]=bot[2];
		  bot[2]=bac[8];
		  bac[8]=temp;
	}
	 public void RotateCubeClockWise() throws IOException
	  {
		  Up();
		  CenterInverse();
		  DownInverse();
		  System.out.println();
	  }
	 public void RotateCubeAntiClockwise() throws IOException
	  {
		  UpInverse();
		  Center();
		  Down();
		  System.out.println();
	  }
	
	 public boolean isSetBlock()
	 {
		 if(select1==rig[5]&&select2==fow[5]||select1==fow[5]&&select2==rig[5]/*||select1==fow[5]&&select2==lef[5]*/)
			 return false;
		 else 
			 return true;
	 }
	
	 public boolean isColourSet()
	{
		if(fow[2]==fow[5])
			return false;
		else
			return true;
	}
	 public boolean isSecondRowRightBlockSet()
	{
		if(fow[6]==fow[5]&&rig[4]==rig[5])
		return false;
		else 
			return true;
	}
	 public	boolean isSecondRowLeftBlockSet()
	{
		if(fow[4]==fow[5]&&lef[6]==lef[5])
			return false;
			else
				return true;
	}
	 public boolean isThereColours() throws IOException
	{
		boolean f=false,r=false,l=false,b=false;
		if(fow[5]==fow[2]&&top[8]!=top[5]||fow[5]==rig[2]&&top[6]!=top[5]||fow[5]==bac[2]&&top[2]!=top[5]||fow[5]==lef[2]&&top[4]!=top[5])
			f=true;
		RotateCubeClockWise();
		if(fow[5]==fow[2]&&top[8]!=top[5]||fow[5]==rig[2]&&top[6]!=top[5]||fow[5]==bac[2]&&top[2]!=top[5]||fow[5]==lef[2]&&top[4]!=top[5])
			r=true;
		RotateCubeClockWise();
		if(fow[5]==fow[2]&&top[8]!=top[5]||fow[5]==rig[2]&&top[6]!=top[5]||fow[5]==bac[2]&&top[2]!=top[5]||fow[5]==lef[2]&&top[4]!=top[5])
			b=true;
		RotateCubeClockWise();
		if(fow[5]==fow[2]&&top[8]!=top[5]||fow[5]==rig[2]&&top[6]!=top[5]||fow[5]==bac[2]&&top[2]!=top[5]||fow[5]==lef[2]&&top[4]!=top[5])
			l=true;
		RotateCubeClockWise();
		c=(char) R.read();
		System.out.println("F="+f +"\t"+"R="+r +"\t"+"B="+b +"\t"+"L="+l);
		if(f)
			return true;
		else if(r)
			return true;
		else if(b)
			return true;
		else if(l)
			return true;
		else
			return false;
	}
	 public boolean isSideColourMatch()
	{
		if(rig[2]==rig[5]&&fow[2]==fow[5]&&bac[2]==bac[5]&&lef[2]==lef[5])
			return true;
		else if(rig[2]==rig[5]&&fow[2]==fow[5])
			return false;
		else 
			return false;
	}
	 public boolean isAllCornerColoursSet()
	{
		boolean result=true,result1=true,result2=true,result3=true;
		if(top[9]==top[5]&&fow[3]==fow[5]&&rig[1]==rig[5] ||
		   top[9]==rig[5]&&fow[3]==top[5]&&rig[1]==fow[5] ||
		   rig[1]==top[5]&&fow[3]==rig[5]&&top[9]==fow[5]   )
		result=false;
		if(top[3]==top[5]&&rig[3]==rig[5]&&bac[1]==bac[5] ||
				   top[3]==bac[5]&&rig[3]==top[5]&&bac[1]==rig[5] ||
				   bac[1]==top[5]&&rig[3]==bac[5]&&top[3]==rig[5]  )
			result1=false;
		if(top[1]==top[5]&&bac[3]==bac[5]&&lef[1]==lef[5] ||
				   top[1]==lef[5]&&bac[3]==top[5]&&lef[1]==bac[5] ||
				   lef[1]==top[5]&&bac[3]==lef[5]&&top[1]==bac[5]  )
		result2=false;
		if(top[7]==top[5]&&lef[3]==lef[5]&&fow[1]==fow[5] ||
				   top[7]==fow[5]&&lef[3]==top[5]&&fow[1]==lef[5] ||
				   fow[1]==top[5]&&lef[3]==fow[5]&&top[7]==lef[5]  )
		result3=false;
		if(((!result)&&(!result1))&&((!result2)&&(!result3)))
			return true;
		else 
			return false;
	}
	 public boolean isSideColours2Set()
	{
		if(fow[5]==fow[2]&&rig[2]==rig[5])
			return false;
		else
			return true;
	}
	 public boolean AllMidColoursSet()
	{
		if(rig[2]==rig[5]&&fow[2]==fow[5]&&bac[2]==bac[5]&&lef[2]==lef[5])
			return true;
		else
			return false;
	}
	

	
	 public void RiDiRD() throws IOException
	{
		RightInverse();
		DownInverse();
		Right();
		Down();
		System.out.println();
	}
	 public void LDLiDi() throws IOException
	{
		Left();
		Down();
		LeftInverse();
		DownInverse();
		System.out.println();
		
	}
	 public void URUiRiUiFiUF() throws IOException
	{
		Up();
		Right();
		UpInverse();
		RightInverse();
		UpInverse();
		FrontInverse();
		Up();
		Front();
		System.out.println();
		displayCube();
	}
	 public	void UiLiULUFUiFi() throws IOException
	{
		UpInverse();
		LeftInverse();
		Up();
		Left();
		Up();
		Front();
		UpInverse();
		FrontInverse();
		System.out.println();
		displayCube();
	}
	 public void RURiURUURiU() throws IOException
	{
		Right();
		Up();
		RightInverse();
		Up();
		Right();
		Up();
		Up();
		RightInverse();
		Up();
		System.out.println();
	}
	 public void URUiLiURiUiL() throws IOException
	{
		Up();
		Right();
		UpInverse();
		LeftInverse();
		Up();
		RightInverse();
		UpInverse();
		Left();
		System.out.println();
	}
	 public	void FRURiUiFi() throws IOException
	{
		Front();
		Right();
		Up();
		RightInverse();
		UpInverse();
		FrontInverse();
		System.out.println();
	}
	 
	 public void displayCube()
	  {
		
		 System.out.println();
		 System.out.print("\t\tLeft\t\t\t\tTop\t\t\t\tRight\t\t\t\tBack\t\t\t\tBottom\t\t\tFront");
		 System.out.println();
		 for(int i=1;i<=3;i++)
			 System.out.print("\t"+lef[i]);
		 System.out.print("\t");
		 for(int i=1;i<=3;i++)
			 System.out.print("\t"+top[i]);
		 System.out.print("\t");
		 for(int i=1;i<=3;i++)
			 System.out.print("\t"+rig[i]);
		 System.out.print("\t");
		 for(int i=1;i<=3;i++)
			 System.out.print("\t"+bac[i]);
		 System.out.print("\t");
		 for(int i=1;i<=3;i++)
			 System.out.print("\t"+bot[i]);
		 System.out.print("\t");
		 for(int i=1;i<=3;i++)
			 System.out.print("\t"+fow[i]);
			 
		 System.out.println();
		 for(int i=4;i<=6;i++)
			 System.out.print("\t"+lef[i]);
		 System.out.print("\t");
		 for(int i=4;i<=6;i++)
			 System.out.print("\t"+top[i]);
		 System.out.print("\t");
		 for(int i=4;i<=6;i++)
			 System.out.print("\t"+rig[i]);
		 System.out.print("\t");
		 for(int i=4;i<=6;i++)
			 System.out.print("\t"+bac[i]);
		 System.out.print("\t");
		 for(int i=4;i<=6;i++)
			 System.out.print("\t"+bot[i]);
		 System.out.print("\t");
		 for(int i=4;i<=6;i++)
			 System.out.print("\t"+fow[i]);
		 System.out.print("\t");
			
		 System.out.println();
		 for(int i=7;i<=9;i++)
			 System.out.print("\t"+lef[i]);
		 System.out.print("\t");
		 for(int i=7;i<=9;i++)
			 System.out.print("\t"+top[i]);
		 System.out.print("\t");
		 for(int i=7;i<=9;i++)
			 System.out.print("\t"+rig[i]);
		 System.out.print("\t");
		 for(int i=7;i<=9;i++)
			 System.out.print("\t"+bac[i]);
		 System.out.print("\t");
		 for(int i=7;i<=9;i++)
			 System.out.print("\t"+bot[i]);
		 System.out.print("\t");
		 for(int i=7;i<=9;i++)
			 System.out.print("\t"+fow[i]);
		 System.out.print("\t");
		 System.out.println();
   }
}



 class SolveSecondRow extends SolveFirstRow
{
	 public void solveSecondRow() throws IOException
		{
			while(isThereColours())
			{
				displayCube();
				for(int i=0;i<4;i++)
				{
					select=fow[5];
					searchForColour();
					RotateCubeClockWise();
					System.out.println();
				}
			}
			SecondRowFinalCheck();
		}
	  public void RotateBotToUp() throws IOException
	  {
		  Mid();
		  Right();
		  LeftInverse();
		  System.out.println();
		  Mid();
		  Right();
		  LeftInverse();
		  System.out.println();
	   
	  }
	 
	  void SecondRowFinalCheck() throws IOException
		{
			for(int i=0;i<4;i++)
			{
				if(isSecondRowRightBlockSet())
				{
					URUiRiUiFiUF();
					solveSecondRow();
				}
				else
				{
					RotateCubeClockWise();
				}
				
			}
			for(int i=0;i<4;i++)
			{
				if(isSecondRowLeftBlockSet())
				{
					UiLiULUFUiFi();
					solveSecondRow();
				}
				else
				{
					RotateCubeClockWise();
				}
			}
			
		}
		
		void searchForColour() throws IOException
		{
			if(select==fow[2]&&top[8]!=top[5])
			{
				if(top[8]==lef[5])
				{
					UiLiULUFUiFi();
				}
				else if(top[8]==rig[5])
				{
					URUiRiUiFiUF();
				}
			}
			else if(select==rig[2]&&top[6]!=top[5])
			{
				Up();
				System.out.println();
				if(top[8]==lef[5])
				{
					UiLiULUFUiFi();
				}
				else if(top[8]==rig[5])
				{
					URUiRiUiFiUF();
				}
			}
			else if(select==bac[2]&&top[2]!=top[5])
			{
				Up();
				System.out.println();
				Up();
				System.out.println();
				if(top[8]==lef[5])
				{
					UiLiULUFUiFi();
				}
				else if(top[8]==rig[5])
				{
					URUiRiUiFiUF();
				}
			}
			else if(select==lef[2]&&top[4]!=top[5])
			{
				UpInverse();
				System.out.println();
				if(top[8]==lef[5])
				{
					UiLiULUFUiFi();
				}
				else if(top[8]==rig[5])
				{
					URUiRiUiFiUF();
				}
			}
			c=(char) R.read();
			
		}
	
}


class SolveThirdRow extends SolveSecondRow
{
	public void solveThirdRow() throws IOException
	{ char c;
		int count=0;
		for(int i=2;i<=8;i+=2)
		{
			if(top[i]==top[5])
				count++;
		}
		if(count==4)
		{
			SideColourMatch();
		}
		else if(top[4]==top[5]&&top[6]==top[5]||top[2]==top[5]&&top[8]==top[5])
		{
				setPlus();
			
		}
		else if(top[2]==top[5]&&top[4]==top[5]||top[6]==top[5]&&top[8]==top[5]||top[2]==top[5]&&top[6]==top[5]||top[4]==top[5]&&top[8]==top[5])
		{
			if(top[2]==top[5]&&top[4]==top[5])
			{
				FRURiUiFi();
				c=(char) R.read();
				setPlus();
				
			}
			else if(top[6]==top[5]&&top[8]==top[5])
			{
				UpInverse();
				System.out.println();
				UpInverse();
				System.out.println();
				FRURiUiFi();
				c=(char) R.read();
				setPlus();	
			}
			else if(top[2]==top[5]&&top[6]==top[5])
			{
				UpInverse();
				System.out.println();
				FRURiUiFi();
				c=(char) R.read();
				setPlus();
				
			}
			else if(top[4]==top[5]&&top[8]==top[5])
			{
				Up();
				System.out.println();
				FRURiUiFi();
				c=(char) R.read();
				setPlus();
			}
		}
			else
			{
				FRURiUiFi();
				if(top[2]==top[5]&&top[4]==top[5]||top[6]==top[5]&&top[8]==top[5]||top[2]==top[5]&&top[6]==top[5]||top[4]==top[5]&&top[8]==top[5])
				{
					if(top[2]==top[5]&&top[4]==top[5])
					{
						FRURiUiFi();
						c=(char) R.read();
						setPlus();
						
					}
					else if(top[6]==top[5]&&top[8]==top[5])
					{
						UpInverse();
						System.out.println();
						UpInverse();
						System.out.println();
						FRURiUiFi();
						c=(char) R.read();
						setPlus();	
					}
					else if(top[2]==top[5]&&top[6]==top[5])
					{
						UpInverse();
						System.out.println();
						FRURiUiFi();
						c=(char) R.read();
						setPlus();
						
					}
					else if(top[4]==top[5]&&top[8]==top[5])
					{
						Up();
						System.out.println();
						FRURiUiFi();
						c=(char) R.read();
						setPlus();
					}
				}
			 }
	}
	void FinalStep() throws IOException
	{
		while(isTopLayerSet()==false)
			if(top[9]==top[5])
			{
				Up();
				System.out.println();
			}
			else if(top[5]==fow[3])
			{
				for(int j=0;j<4;j++)
					RiDiRD();
			}
			else if(top[5]==rig[1])
			{
				for(int k=0;k<2;k++)
					RiDiRD();
			    Up();
			    System.out.println();
			    for(int j=0;j<4;j++)
			    {	Up();
			    	if(top[9]!=top[5])
			    	{
			    		if(top[5]==fow[3])
						{
							for(int k=0;k<4;k++)
								RiDiRD();
						}
						else if(top[5]==rig[1])
						{
							for(int k=0;k<2;k++)
								RiDiRD();
			    	    }
			    	}
			    }
			}
		}
      boolean isTopLayerSet() {
		if(top[1]==top[5]&&top[3]==top[5]&&top[7]==top[5]&&top[9]==top[5])
			return true;
		else
		return false;
	}
	void TopFinalCase() throws IOException
	{
		boolean flag=true,flag1=true;
		for(int i=0;i<4;i++)
		{
			if(top[9]==top[5]&&fow[3]==fow[5]&&rig[1]==rig[5]||top[9]==top[5]&&fow[3]==rig[5]&&rig[1]==fow[5])   
			{
				while(flag1)
				{
					System.out.println("I'm in first case of Top final case");
					if(isAllCornerColoursSet()==true)
						flag1=false;
					else if(flag1==true)
					URUiLiURiUiL();
				}
				if(flag1==false)
					FinalStep();
				    i=4;
				    flag=false;
			}
			else 
				RotateCubeClockWise();
		}
		if(flag)
		{
		for(int i=0;i<4;i++)
		{
			if(top[9]==rig[5]&&fow[3]==top[5]&&rig[1]==fow[5] ||
			   rig[1]==top[5]&&fow[3]==rig[5]&&top[9]==fow[5]  )
			{
				while(flag1)
				{
					System.out.println("I'm in second case of Top final case");
					if(isAllCornerColoursSet()==true)
						flag1=false;
					else if(flag1==true)
					URUiLiURiUiL();
				
				}
				if(flag1==false)
					FinalStep();
					i=4;
				    flag=false;
			}
			else
				RotateCubeClockWise();
		}
		}
		if(flag)
		{
			do
			{
				System.out.println("i'm do while loop");
				URUiLiURiUiL();
				for(int i=0;i<4;i++)
				{
					if(top[9]==top[5]&&fow[3]==fow[5]&&rig[1]==rig[5]||top[9]==top[5]&&fow[3]==rig[5]&&rig[1]==fow[5])   
					{
						while(flag1)
						{
							System.out.println("I'm in Third case of Top final case");
							if(isAllCornerColoursSet()==true)
								flag1=false;
							else if(flag1==true)
							URUiLiURiUiL();
						
						}
						if(flag1==false)
							FinalStep();
							i=4;
					        flag=false;
					}
					else 
						RotateCubeClockWise();
				}
					if(flag)
					{
						for(int i=0;i<4;i++)
						{
							if(top[9]==rig[5]&&fow[3]==top[5]&&rig[1]==fow[5] ||
									rig[1]==top[5]&&fow[3]==rig[5]&&top[9]==fow[5])
							{
								while(flag1)
								{
									System.out.println("I'm in Fourth case of Top final case");
									if(isAllCornerColoursSet()==true)
										flag1=false;
									else if(flag1==true)
									URUiLiURiUiL();   
								
								}
								if(flag1==false)
									FinalStep();
									i=4;
									flag=false;
							}
							else
							RotateCubeClockWise();
						}
					}
			}while(flag);
				
		}
	}
	
	void SideColourMatch() throws IOException
	{char c;
	 boolean a=false,flag=false;
			for(int i=0;i<4;i++)
			{
				if(AllMidColoursSet()==true)
				{
					flag=true;
					break;
				}
				Up();
			}
		if(flag==true)
			TopFinalCase();
		else if(rig[2]==lef[5]&&lef[2]==rig[5]||bac[2]==fow[5]&&fow[2]==bac[5]||
				lef[2]==bac[5]&&rig[2]==fow[5]||rig[2]==bac[5]&&lef[2]==fow[5])
		{
			RURiURUURiU();
			if(isSideColours2Set()==true)
			{
				for(int i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
						if(isSideColours2Set()==true)
						{
							System.out.println("i'm in for(j) loop");
							Up();
							System.out.println();
							if(isSideColours2Set()==false)
							{
								a=true;	
								break;
							}
								
						}
							c=(char) R.read();
						
					}
					if(a==true)
						break;
					else
					RotateCubeClockWise();
					if(isSideColours2Set()==false)
					{
						a=true;	
						break;
					}
				}
				RotateCubeAntiClockwise();
				RURiURUURiU();
				c=(char) R.read();
				while(AllMidColoursSet()==false)
				{
					System.out.println("i'm in while last bt one");
					Up();
					System.out.println();
				}
				c=(char) R.read();
				TopFinalCase();
		}
		}
			else
			{
				if(isSideColours2Set()==true)
				{
					for(int i=0;i<4;i++)
					{
						for(int j=0;j<4;j++)
						{
							if(isSideColours2Set()==true)
							{
								System.out.println("i'm in for(j) loop");
								Up();
								System.out.println();
								if(isSideColours2Set()==false)
								{
									a=true;	
									break;
								}
									
							}
								c=(char) R.read();
							
						}
						if(a==true)
							break;
						else
						RotateCubeClockWise();
						if(isSideColours2Set()==false)
						{
							a=true;	
							break;
						}
					}
					RotateCubeAntiClockwise();
					RURiURUURiU();
					c=(char) R.read();
					while(AllMidColoursSet()==false)
					{
						System.out.println("i'm in while last one");
						Up();
						System.out.println();
					}
					c=(char) R.read();
					TopFinalCase();
			}
		}
	}
	
	
	void setPlus() throws IOException
	{
		if(top[4]==top[5]&&top[6]==top[5]||top[2]==top[5]&&top[8]==top[5])
		{
				if(top[4]==top[5]&&top[6]==top[5])
				{
					FRURiUiFi();
					c=(char) R.read();
					SideColourMatch();
				}
				else if(top[2]==top[5]&&top[8]==top[5])
				{
					Up();
					FRURiUiFi();
					c=(char) R.read();
					SideColourMatch();
				}
			
		}
	}
	 void TopLayerRotation() throws IOException
	 {
		while(fow[2]!=fow[5])
		{
			Up();
		}
		
	}
	
}

class SolveFirstRow extends SolveCube
{
	public void solveFirstRow() throws IOException
	{System.out.println("I'M IN SOLVE FIRST ROW");
				search(9);
				search(7);
				searchBotCorner(1);
				searchBotCorner(3);
				searchBotCorner(7);
				searchBotCorner(9);
				search(3);
				search(1);
				FirstRowFinalCheck();
				 while(isThereWhite(7)||isThereWhite(9)||isThereWhite(1)||isThereWhite(3)||
					 isThereWhiteBotCorner(1)||isThereWhiteBotCorner(3)||isThereWhiteBotCorner(7)||isThereWhiteBotCorner(9))
			      {
			    	  if(isThereWhite(7))
			    	      search(7);
			    	  if(isThereWhite(9))
			    		  search(9);
			    	  if(isThereWhite(1))
			    		  search(1);
			    	  if(isThereWhite(3))
			    		  search(3);
			    	  if(isThereWhiteBotCorner(1))
			    	  searchBotCorner(1);
			    	  if(isThereWhiteBotCorner(3))
			    	  searchBotCorner(3);
			    	  if(isThereWhiteBotCorner(7))
				    	  searchBotCorner(7);
			    	  if(isThereWhiteBotCorner(9))
				    	  searchBotCorner(9);
			    }
	}
	public void solvePlus() throws IOException
	{
		System.out.println("I'M IN SOLVEPLUS");
	  search(8);
      search(6);
      search(2);
      search(4);
      searchbot();
      c=(char) R.read();
      while(isThereWhite(8)||isThereWhite(6)||isThereWhite(4)||isThereWhite(2)||isThereWhiteBot())
      {
    	  if(fow[8]=='W'||rig[8]=='W'||bac[8]=='W'||lef[8]=='W')
    	      search(8);
    	  if(fow[6]=='W'||rig[6]=='W'||bac[6]=='W'||lef[6]=='W')
    		  search(6);
    	  if(fow[2]=='W'||rig[2]=='W'||bac[2]=='W'||lef[2]=='W')
    		  search(2);
    	  if(fow[4]=='W'||rig[4]=='W'||bac[4]=='W'||lef[4]=='W')
    		  search(4);
    	  if(bot[2]=='W'||bot[4]=='W'||bot[8]=='W'||bot[6]=='W')
    		  searchbot();
    	  
      }
     
    }
	
	void searchBotCorner(int n) throws IOException
	{
		if(bot[n]=='W' )
		{
			if(n==1)
			{
				Down();
				System.out.println();
			}
			else if(n==7)
			{
				Down();
				Down();
				System.out.println();
			}
			else if(n==9)
			{
				DownInverse();
				System.out.println();
			}
			select1=fow[9];
			select2=rig[7];
			while(isSetBlock())
			{
				
				Down();
				RotateCubeClockWise();
				System.out.println();
			}
			for(int i=0;i<3;i++)
			RiDiRD();
			
		}
	}
	void search_select7() throws IOException
	{
		while(isSetBlock())
		{
			Down();
			Up();
			CenterInverse();
			DownInverse();
			System.out.println();
		}
		for(int i=0;i<1;i++)
		RiDiRD();
		
	}
	void search_select9() throws IOException
	{
		while(isSetBlock())
		{   
			Down();
			RotateCubeClockWise();
			System.out.println();
		}
		for(int i=0;i<5;i++)
		RiDiRD();
	}
    void search(int n) throws IOException
	{
    	boolean isThere=isThereWhite(n);
    	System.out.println(""+isThere);
		while(isThereWhite(n))
		  {
			  if(fow[n]=='W')
			  {
				  if(n==1)
				  {
					  LDLiDi();
				  System.out.println();
				  }
			      else if(n==2)
					  select=top[8];
				  else if(n==3)
				  {
					  RiDiRD();
				  System.out.println();
				  }
				  else if(n==4)
				      select=lef[4];
				  else if(n==6)
					  select=rig[4]; 
				  else if(n==8)
					  select=bot[2];
				  else if(n==9)
				  {
					  select1=rig[7];
					  select2=bot[3];
				  }
				  else if(n==7)
				  {
					  Down();
				  System.out.println();
				  }
				  
			  }
			  else if(rig[n]=='W')
			  {  
				  if(n!=7)
				  {
				  Up();
				  CenterInverse();
				  DownInverse();
				  System.out.println();
				  } 
					  
			  }
			  else if(bac[n]=='W')
			  {
				  Up();
				  Up();
				  CenterInverse();
				  CenterInverse();
				  DownInverse();
				  DownInverse();
				  System.out.println();
                    if(n==7)
					  Down();
			  }
			  else if(lef[n]=='W')
			  {
				  RotateCubeAntiClockwise();
				  System.out.println();
				  if(n==7)
				  {
				    Down();
				    System.out.println();
				  }
			  }
			  if(n==1)
				  searchBotCorner(1);
			  else if(n==2)
			  {
				  select=top[8];
				  search_select2();
			  }
			  else if(n==3)
				  searchBotCorner(3);
			  if(n==4)
			  {
			  select=lef[6];
			  search_select4();
			  }
			  else if(n==6)
			  {
				  select=rig[4];
				     search_select6();  
			  }
			  else if(n==8)
			  {
				  select=bot[2];
					 search_select8();
			  }
			  else if(n==9)
			  {
				  select1=rig[7];
				  select2=bot[3];
				  search_select9();
			  }
			  else if(n==7)
			  {
				  select1=fow[9];
				  select2=bot[3];
				  search_select7();
			  }
		  }
	}
	void FirstRowFinalCheck() throws IOException
	{
		for(int i=0;i<2;i++)
		{
			if(top[9]==top[5])
			{
			select1=fow[3];
			select2=rig[1];
				if(isSetBlock())
				{
				RiDiRD();
				System.out.println();
			    search(9);
				}
			}
			if(top[7]==top[5])
			{
			select1=fow[1];
			select2=lef[3];
				if(isSetBlock())
				{
				LDLiDi();
				System.out.println();
			    search(7);
				}
			}
			Up();
			CenterInverse();
			System.out.println();
		}
	}
	void search_select8() throws IOException
	{
		if(rig[5]==select)
		{
			FrontInverse();
			Right();
			Front();
			System.out.println();
		}
		else if(fow[5]==select)
		{
			FrontInverse();
			CenterInverse();
			Front();
			Center();
			System.out.println();
		}
		else if(bac[5]==select)
		{
			UpInverse();
			UpInverse();
			Center();
			Center();
			FrontInverse();
			CenterInverse();
			Front();
			Center();
			System.out.println();
		}
		else if(lef[5]==select)
		{
			Front();
			LeftInverse();
			FrontInverse();
			System.out.println();
		}
		displayCube();
		c=(char) R.read();
	}
	void search_select6() throws IOException
	{
		if(rig[5]==select)
		{
			Right();
			System.out.println();
		}
		else if(bac[5]==select)
		{
			Center();
			Up();
			CenterInverse();
			DownInverse();
			Right();
			CenterInverse();
			System.out.println();
		}
		else if(lef[5]==select)
		{
			RightInverse();
			DownInverse();
			DownInverse();
			LeftInverse();
			LeftInverse();
			Right();
			System.out.println();
		}
		else if(fow[5]==select)
		{
			CenterInverse();
			Front();
			Center();
			System.out.println();
		}
		displayCube();
		c=(char) R.read();
	}
	void search_select2() throws IOException
	{
		System.out.println("I'm in 2");
		if(fow[5]==select)
		{
			Front();
			CenterInverse();
			Front();
			Center();
			System.out.println();
		}
		else if(rig[5]==select)
		{
			Front();
			Right();
			System.out.println();
		}
		else if(bac[5]==select)
		{
			Front();
			Center();
			BackInverse();
			CenterInverse();
			System.out.println();
		}
		else if(lef[5]==select)
		{
			FrontInverse();
			LeftInverse();
			Front();
			System.out.println();
		}
		displayCube();
		c=(char) R.read();
	}
	void search_select4() throws IOException
	{
		System.out.println("I'm in 4");
		if(fow[5]==select)
		{
			Center();
			FrontInverse();
			CenterInverse();
			System.out.println();
		}
		else if(rig[5]==select)
		{
			Left();
			Down();
			Down();
			Right();
			Right();
			LeftInverse();
			System.out.println();
		}
		else if(lef[5]==select)
		{
			LeftInverse();
		System.out.println();
		}
		else if(bac[5]==select)
		{
			CenterInverse();
			Back();
			Center();
			System.out.println();
		}
		displayCube();
		c=(char) R.read();
	}
	void search_selectBot() throws IOException
	{System.out.println("I'm in Bot");
		if(fow[5]==select)
		{
			FrontInverse();
			FrontInverse();
			System.out.println();
		}
		else if(rig[5]==select)
		{
			Down();
			Right();
			Right();
			System.out.println();
		}
		else if(bac[5]==select)
		{
			Down();
			Down();
			BackInverse();
			BackInverse();
			System.out.println();
		}
		else if(lef[5]==select)
		{
			DownInverse();
			LeftInverse();
			LeftInverse();
			System.out.println();
		}
		displayCube();
	    c=(char) R.read();
	}
	void searchbot() throws IOException
	{System.out.println("I'm in search bot");
		while(isThereWhiteBot())
		  {
			  if(bot[2]=='W')
			  {
				  select=fow[8];
			  }
			  else if(bot[6]=='W')
			  {
				  Up();
				  CenterInverse();
				  DownInverse();
				  System.out.println();
			  }
			  else if(bot[8]=='W')
			  {
				  Up();
				  Up();
				  CenterInverse();
				  CenterInverse();
				  DownInverse();
				  DownInverse();
				  System.out.println();
			  }
			  else if(bot[4]=='W')
			  {
				  UpInverse();
				  Center();
				  Down();
				  System.out.println();
			  }
			  select=fow[8];
			  search_selectBot();
		  }
		 
	}
	  boolean isThereWhite(int n)
	 {
		 if(fow[n]=='W'||rig[n]=='W'||bac[n]=='W'||lef[n]=='W')
				return true;
			else 
				return false;
	 }
	 	boolean isThereWhiteBot()
		{
			if(bot[2]=='W'||bot[4]=='W'||bot[8]=='W'||bot[6]=='W')
				return true;
			else
				return false;
		}
	 boolean isThereWhiteBotCorner(int n) 
		{
			if(bot[n]=='W')
				return true;
			else
				return false;
		}
}

public class RubikCube_3{
	public static void main(String[] args) throws IOException
	{
	    SolveThirdRow R3=new SolveThirdRow();
	    R3.getInput();
	    R3.solvePlus();
	    R3.solveFirstRow();
	    R3.RotateBotToUp();
	    R3.solveSecondRow();
	    R3.solveThirdRow();
		R3.TopLayerRotation();
		R3.displayCube();
		}
}


