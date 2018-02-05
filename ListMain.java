package ds.list;

public class ListMain {

	public static void main(String[] args) {
		DList dl = new DList();
		dl.add(1.4);
		dl.add(9.3);
		dl.add(0, "dddd");
		//dl.remove();
		for (int i = 0; i < dl.getSize(); i++) {
			System.out.println(dl.get(i));
		}
	}

}
