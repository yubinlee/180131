package ds.list;

public class DList<E> {
	
	private Node head;
	private Node tail;
	private int size;
	
	public int getSize() {
		return size;
	}

	private class Node{
		private E data;
		private Node next;
		private Node prev;

		public Node() {
			this(null);
		}
		public Node(E data) {
			this.data = data;
		}
	}
	
	public DList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
		size = 0;
	}
	
	public E get(int idx) {
		Node p = head.next;
		
		for (int i = 0; i < idx; i++) {
			p = p.next;
		}
		
		return p.data;
	}
	
	//�� �߰�
	public void add(E data) {
		add(size, data);
	}
	
	public void add(int idx, E data) {
		if (idx > size) {
			return ;
		}
		Node p = head;
		for (int i = 0; i < idx; i++) {
			p = p.next;
		}
		//p�� ���� ��� ��
		Node n = new Node(data);
		n.prev = p;
		n.next = p.next;
		p.next.prev = n;
		p.next = n;
		size++;
	}
	
	//�� ����
	public void remove() {
		remove(0);
	}
	//�ε��� ��° ����
	public void remove(int idx) {
		Node d = (Node)find(idx);
		d.prev.next = d.next;
		d.next.prev = d.prev;
		size--;
	}
	//�ش� ��ü
	public void remove(E obj) {
		int delidx = find(obj);
		remove(delidx);
	}
	
	private Object find(int idx) {
		Node p = head.next;
		for (int i = 0; i < idx; i++) {
			p = p.next;
		}
		return p;
	}
	
	private int find(Object obj) {
		Node p = head.next;
		int cnt = 0;
		while (p != tail) {
			if (obj.equals(p.data)) {
				return cnt;
			}
			else {
				p = p.next;
			}
			cnt++;
		}
		return -1;
	}
}










