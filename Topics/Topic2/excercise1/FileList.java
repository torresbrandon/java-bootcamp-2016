import java.util.ArrayList;

public class FileList {

	private ArrayList<String> recentList;

	public FileList() {

		recentList = new ArrayList<String>();
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

	public ArrayList<String> getRecentList() {
		return recentList;
	}

	public void setRecentList(ArrayList<String> recentList) {
		this.recentList = recentList;
	}

}
