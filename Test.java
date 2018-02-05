import java.util.Arrays;

import ds.list.DList;

class parking{
	private MyArray park;

	public parking(int parksize) {
		this.park = new MyArray(parksize);
	}
	
	public void inCar() {park.add(0, 4885);}
	public void outCar() {park.remove(0);}
	
}

class Student{
	public int sNo;
	public String name;
	public String getName(){return this.name;}
	public void setName(String name) {this.name = name;}
	public Student(int sNo, String name) {
		super();
		this.sNo = sNo;
		this.name = name;
	}
	public void show() {
		System.out.println(sNo+"   "+name);
	}
	
}

public class Test {
	public static void main(String[] args) {
		DList<Student> arr = new DList<>();
		Student s1 = new Student(221, "dddd");
		arr.add(s1);
		//s1.show();
		for (int i = 0; i <arr.getSize(); i++) {
			arr.get(i).show();
		}
		/*
		arr.add(30.2);arr.add(30);arr.add('d');arr.add("sssss");arr.add(1, 40);
		for (int i = 0; i <arr.getSize(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println("");
		arr.remove(0);
		arr.remove(new Integer(40));
		for (int i = 0; i <arr.getSize(); i++) {
			System.out.println(arr.get(i));
		}
		*/
	}
}
