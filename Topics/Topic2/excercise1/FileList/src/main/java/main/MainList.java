package main;

import fileList.FileList;

public class MainList {

	 public static void main( String[] args ){
	   FileList list = new FileList();
	   for(int i=0;i<19;i++){
		   
		list.openFile("Archivo "+i);}
		list.printList();
		
	      
	    }
}
