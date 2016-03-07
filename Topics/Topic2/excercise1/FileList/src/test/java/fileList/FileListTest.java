package fileList;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fileList.FileList;

/*
 * This class has the TestCase about the recent file list
 * 
 */
public class FileListTest {

	/*
	 * This case test if the list is empty
	 */
	@Test
	public void testEmpty() {
		FileList newList = new FileList();
		assertTrue(newList.getRecentList().isEmpty());
		
	}

	/*
	 * This case test if the file opened is add in the list, if the file is
	 * opened this must to stay like the most recent, is to say the first
	 * position.
	 */
	@Test
	public void testAddRecentList() {
		FileList newList = new FileList();
		String fileName = "Archivo 1";
		String nuevo = "Archivo 1";
		newList.openFile(fileName);
		assertTrue(newList.getRecentList().get(0) == nuevo);
		assertEquals(newList.getRecentList().get(0), nuevo);
	}

	/*
	 * This case test is about size list, is about exist a entry in the list.
	 * If this exist this must to stay the first in the list
	 */
	@Test
	public void testExists() {
		String fileName = "Archivo", fileName2 = "Archivo2", fileName3 = "Archivo3";

		FileList newList = new FileList();
		newList.openFile(fileName);
		newList.openFile(fileName2);
		newList.openFile(fileName3);
		//add again fileName2;
		newList.openFile(fileName2);
		assertTrue(newList.getRecentList().get(0) == fileName2);

	}

	/*
	 * This case test is about size list, the max value is 15 
	 * 
	 */
	@Test
	public void testSize() {

		FileList newList = new FileList();
		for (int i = 0; i < 20; i++) {

			newList.openFile("Archivo" + i + ".doc");

		}
		assertTrue(newList.sizeList() == 15);
		String auxiliary = newList.getRecentList().get(13);
		newList.openFile("Archivo" +12 +".doc");
		if(newList.getRecentList().contains("Archivo12.doc")==true){
			assertTrue(newList.getRecentList().get(0) == "Archivo12.doc");
			assertTrue(newList.sizeList() == 15);
		}else{
		assertTrue(newList.getRecentList().get(14) == auxiliary);
		}
	}
}
