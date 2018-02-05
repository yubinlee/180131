import java.util.Arrays;

public class MyArray<E> {
	private int size;
	private int capacity;
	private E[] buf;
	
	public MyArray() {
		this(5);
	}

	public MyArray(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.buf = (E[]) new Object[capacity];
	}

	public int getSize() {
		return size;
	}
	
	public E get(int idx) {return buf[idx];}
	
	public boolean add(E newValue) {
		if (this.size >=  this.capacity) {
			resize((int)(this.capacity*1.5));
		}
		
		this.buf[size] = newValue;
		this.size++;
		return true;
	}
	
	public void add(int idx, E newValue) {
		if (this.size >= this.capacity) {
			resize((int)(this.capacity*1.5));
		}
		if (idx < size) {
			for (int i = size; i > idx; i--) {
				this.buf[i] = this.buf[i-1];
			}
			this.buf[idx] = newValue;
			size++;
		}
	}
	
	public void remove(int idx) {
		for (int i = idx; i < this.size-1; i++) {
			this.buf[i] = this.buf[i+1];
		}
		size--;
	}

	public void remove(Object obj) {
		for (int i = 0; i < this.size; i++) {
			if (obj.equals(this.buf[i])) {
				remove(i);
			}
		}
	}
	
	private void resize(int newCapacity) {
		this.capacity = newCapacity;
		E[] tempbuf = (E[]) new Object[this.capacity];
		for (int i = 0; i < this.buf.length; i++) {
			tempbuf[i] = this.buf[i];
		}
		this.buf = tempbuf;
	}
	
}
