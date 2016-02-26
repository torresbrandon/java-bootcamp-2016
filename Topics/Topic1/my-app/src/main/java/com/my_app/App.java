package com.my_app;

/**
 * Hello world!
 *
 */
public class App 
{
	//Attributes
	private static int x;
	private static int y;
	
	//Builder
	public App(int num1, int num2){
		this.x=num1;
		this.y=num2;
		
	}
	//Method that sum two numbers
	public static int numberSum(){
		int answer=0;
		answer=x+y;
		return answer;
		
	}
	
	
    public static void main( String[] args )
    {	x=123;
    	y=322;
        System.out.println( "The sum is "+ numberSum() );
      
    }
}
