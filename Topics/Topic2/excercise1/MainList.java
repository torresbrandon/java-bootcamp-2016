import java.util.ArrayList;

public class MainList {

	 public static void main( String[] args )
	    {	FileList list = new FileList();
	 for(int i=0; i<20;i++){
		
		 list.openFile("Archivo"+i+".txt");
		
		 }
	 list.openFile("Archivo"+12+".txt");
	   list.printList();
	    
	      
	    }
}
