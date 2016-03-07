package main;

import blogger.Blogger;

/**
 * 
 */


public class MainBlogger {

	
	 public static void main( String[] args ){
		 Blogger blog = new Blogger();

			for (int i = 0; i < 20; i++) {

				blog.addEntry("This is the " + i + " entry to my blog");

			}
			
			blog.printList();
			System.out.println("----------------------------------------------------------------");
			blog.showRecentEntries();
	 }
}

