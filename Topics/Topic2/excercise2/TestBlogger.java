import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This class has the TestCase about little features of  Blogger
 */
public class TestBlogger {

	/*
	 * This case evaluated that the entry in the blog is the saved like the first in the list of entries 
	 */
	@Test
	public void testAddEntry() {
		Blogger blog = new Blogger();
		String entry = "This is a entry to my blog";
		blog.addEntry(entry);
		assertTrue(blog.getEntryList().get(0) == entry);
	}


	/*
	 * This case evaluated when a entry is deleted, this entry is searched in the list and is deleted
	 */
	@Test
	public void testDeleteEntry() {
		Blogger blog = new Blogger();
		String entry = "This is a entry to my blog", entry2 = "This is a second entry to my blog";
		blog.addEntry(entry);
		blog.addEntry(entry2);
		blog.deleteEntry(entry);
		assertFalse(blog.getEntryList().contains(entry));
	}

	/*
	 * This case evaluated that shows the ten recent entries, is only show the ten but  could have more entries. 
	 */
	@Test
	public void testShowRecentEntries() {
		Blogger blog = new Blogger();

		for (int i = 0; i < 20; i++) {

			blog.addEntry("This is the " + i + " entry to my blog");

		}
		assertTrue(blog.showRecentEntries().size() == 10);
	}

}
