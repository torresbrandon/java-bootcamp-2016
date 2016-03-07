package fileList;
import java.util.LinkedList;
import java.util.List;

public class FileList {

	private List<String> recentList;

	public FileList() {

		recentList = new LinkedList<String>();
		
	}

	public boolean beginList() {
		return recentList.isEmpty();
	}

	public void openFile(String Filename) {
		repeat(Filename);
		if (recentList.size() < 15) {
			recentList.add(0, Filename);
		} else {
			isFullList(Filename);
		}
	}

	public void isFullList(String Filename) {

		if (recentList.size() == 15) {
			recentList.remove(14);
			recentList.add(0, Filename);
		}
	}

	public boolean repeat(String fileName) {
		if (recentList.contains(fileName) == true) {
			int i = recentList.indexOf(fileName);
			recentList.remove(i);
			return true;
		} else {
			return false;
		}
	}

	public void printList() {
		System.out.println("Recents Files");
		for (int i = 0; i < recentList.size(); i++) {

			System.out.println(recentList.get(i));
		}
	}

	public int sizeList() {
		return recentList.size();
	}

	public List<String> getRecentList() {
		return recentList;
	}

	public void setRecentList(LinkedList<String> recentList) {
		this.recentList = recentList;
	}

}
