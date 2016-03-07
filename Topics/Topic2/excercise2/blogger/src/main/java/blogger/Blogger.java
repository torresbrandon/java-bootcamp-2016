package blogger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Blogger {

	private List entryList;

	public Blogger() {
		entryList = new LinkedList();
	}

	//This method is about to add a entry for the blogger
	public void addEntry(String entry) {

		entryList.add(0, entry);

	}

	//This method is about delete a entry
	public void deleteEntry(String entry) {
		if (entryList.contains(entry) == true) {
			int i = entryList.indexOf(entry);
			entryList.remove(i);
		}

	}

	//This methos is about the size of the entry list
	public int getSize() {
		return entryList.size();
	}

	//Print only the ten recent entries
	public ArrayList showRecentEntries() {
		ArrayList aux = new ArrayList();
		System.out.println("10 Recent Entries");
		for (int i = 0; i < entryList.size() && i < 10; i++) {

			aux.add(entryList.get(i));
			
			System.out.println(aux.get(i));
		}

		return aux;
	}

	

	public List getEntryList() {
		return entryList;
	}

	public void setEntryList(List entryList) {
		this.entryList = entryList;
	}

	// Print all the ehtries
	public void printList() {
		System.out.println("Recents Entries");
		for (int i = 0; i < entryList.size(); i++) {

			System.out.println(entryList.get(i));
		}
	}

}
