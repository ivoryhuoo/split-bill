import java.util.NoSuchElementException;

/**
 * Iterator for the UniqueOrderedList class
 * Will not copy data into the array but instead keep a pointer to the element in the list that is next to be returned by the iterator 
 * Elements should be returned in the order they appear in the structure 
 * @author Ivory Huo
 * @param <T>
 */

public class UOLIterator<T extends Comparable<T>> implements CopyableIterator<T> {
//Class implements the CopyableIterator interface 
	
	/**
	 * private instance variables provided by assignment 
	 */
	private LinearNode<T> curr; //Points to the next item that should be returned by the iterator

    /**
     * Public constructor 
     * @param startNode is a LonearNode<T> parameter that is a reference to the node in the list where you want to start your iterator
     * (or null if the lnked list is empty)
     */
    public UOLIterator(LinearNode<T> startNode) {
        this.curr = startNode; //Initialize the iterator with the starting node
        //Usually starting node is the first node in the UniqueOrderedList, except when copying)
    }

    /**
     * Method that takes no parameters and returns a boolean to determine if there are unvisited elements in the list 
     * @return boolean if there are unvisited elements in the list 
     */
    public boolean hasNext() {
        return curr != null; //Checks if there is a next element
    }

    /**
     * Method that takes in no parameters and returns an element of type T (next unvisited element in the list)
     * @return an element of type T (next unvisited element in the list)
     */
    public T next() {
        if (!hasNext()) { //If there is no next element (when hasNext would return false)
            throw new NoSuchElementException("iterator empty"); //Throw the NoSuchElementException exception
        }
        T data = curr.getData(); //Get data from current node
        curr = curr.getNext(); //Move the iterator to next node
        return data; //Return the data
    }

    /**
     * Method to make a copy of the iterator at the current position
     * @return new iterator object that is at the same position as the current iterator
     */
    public CopyableIterator<T> copy() { 
        return new UOLIterator<>(curr); //Create & return copy of the current iterator
        //Points to the same place in the UniqueOrderedList (use curr, not first node starting point)
    }
}