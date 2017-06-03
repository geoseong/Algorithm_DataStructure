package dataStructure.linkedlist;

public class LinkedList {
	private int size;
	private Element root;
	
	public LinkedList() {
		size = 0;
	}

	void insert(Object obj){
		if(size == 0){
			root = new Element(obj);
		}else{

			Element element = root;
			for(int i=0;i<size-1;i++){
				element = element.getNext();
			}
			element.setNext(new Element(obj));
		}
		size++;
	}
	
	void delete(int index){
		if(index == 0){
			root = root.getNext();
			return;
		}
		Element elementPrev = root;
		for(int i=0;i<index-1;i++){
			elementPrev = elementPrev.getNext();
		}
		elementPrev.setNext(elementPrev.getNext().getNext());
		size--;
		if(size == 0)
			root = null;
		
	}
	
	Object search(int index){
		if(index >= size || index<0 || size == 0){
			return -1;
		}
		
		Element element = root;
		for(int i=0;i<index;i++){
			element = element.getNext();
		}
		return element.getValue();
		
	}
	
	void deleteList(){
		root = null;
		size = 0;
	}
	
	int count(){
		return size;
	}
	
	
	public static void main(String[] args) {
		LinkedList lklist = new LinkedList();
		for(int i=0;i<10;i++)
			lklist.insert(i);
		
		for(int i=0;i<10;i++)
			System.out.println(lklist.search(i));
		
		lklist.delete(5);
		
		for(int i=0;i<9;i++)
			System.out.println(lklist.search(i));
		
		
		lklist.deleteList();
		
		for(int i=0;i<9;i++)
			System.out.println(lklist.search(i));
		
		
		for(int i=0;i<10;i++)
			lklist.insert(i);
		
		System.out.println(lklist.count());
		
		for(int i=9;i>=0;i--)
			System.out.println(lklist.search(i));
		
		
		
	}
	
}
class Element{
	private Object value;
	private Element next  = null;
	
	public Element(Object value){
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}
}
