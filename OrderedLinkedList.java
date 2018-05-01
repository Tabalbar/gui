/**
 * A generic list of ordered linked nodes
 * 
 * @author William McDaniel Albritton
 * @author Edoardo Biagioni
 */
public class OrderedLinkedList<T extends Comparable<T>> extends
		LinkedList<T> {
	/*
	 * Explanation of above line of code: The class we are declaring is
	 * parametrized on a type T which is a subclass of java.lang.Comparable<T>.
	 * The class we are declaring is a subclass of GenericLinkedList<T>. The two
	 * types T must match, as, in this application, it would not make any sense
	 * to derive a OrderedLinkedList from a LinkedList parametrized on a
	 * different type: it would mean the superclass would provide a generic
	 * linked list of one class of objects, but our add method would add an
	 * object of a different class.
	 */
	public OrderedLinkedList() {
		// call super class's constructor
		super();
	}

	/**
	 * Adds an item to the list in order
	 * 
	 * @param item
	 *            The object that is added to the list
	 */
	public void add(T item) {
		// case1: if empty list
		if (head == null) {
			// list is empty, so add to beginning of list
			// make new node and assign to head of list
			head = new Node<T>(item, null);
		}
		// if not empty list
		else {
			// case2: add to beginning of list
			if (item.compareTo(head.getData()) <= 0) {
				// add new node to list
				head = new Node<T>(item, head);
			}
			// case3: add to middle or end of list
			else {
				// start at 2nd node in list
				Node<T> previous = head;
				Node<T> current = head.getNext();
				// while not at end of list and item is greater than current
				while (current != null && item.compareTo(current.getData()) > 0) {
					// advance to current node
					previous = current;
					// advance to next node
					current = current.getNext();
				}
				// add new node to list
				// make new node that points to next node
				Node<T> node = new Node<T>(item, current);
				// point previous node to new node
				previous.setNext(node);
			}
		}
		// increase size of list
		size++;
	}

}// end of class definition

