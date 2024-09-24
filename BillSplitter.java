/**
 * Method that splits the bill between you and your friend in a recursive way 
 * @author Ivory Huo
 */
public class BillSplitter {

	/**
	 * Public static method that calls the next recursive method 
	 * @param in
	 * @param target
	 * @return the respective split)
	 */
	public static UniqueOrderedList<Integer> split(UniqueOrderedList<Integer> in, int target) {
        CopyableIterator<Integer> it = in.iterator(); //Get an iterator from the input UniqueOrderedList
        return yourSplit(it.copy(), target); //Call the recursive method yourSplit with a copy of iterator & target amount
    }

	/**
	 * Private static method that implements the recursive solution provided in the pseudocode given (call the private method to find the split)
	 * @param it
	 * @param target
	 * @return the respective split 
	 */
    private static UniqueOrderedList<Integer> yourSplit(CopyableIterator<Integer> it, int target) {
        
    	//Recursive Approach 
    	
    	if (!it.hasNext()) { //Base case: If there are no items remaining (no next item)
            if (target == 0) { //If the target is 0
                return new UniqueOrderedList<>(); //Return an empty list 
            } else {
            	return null; //Else, return null
            }
        } else { //If there are more items remaining 
            Integer curr = it.next(); //Let curr be the first item in the remaining items 
            if (curr <= target) { //If curr is less than or equal to the target 
            	//soln = split(items_remaining without curr, target curr) --> Assign to you
            	//Recursive call assigning current item to you
                UniqueOrderedList<Integer> soln1 = yourSplit(it.copy(), target - curr);
                //If soln is a possible solution 
                if (soln1 != null) { //Not null
                    soln1.add(curr); //Return the solution of (soln + curr)
                    //Add the element curr to soln (which is a list) 
                    return soln1; //Return the solution
                }
            }
            //return soln = split(items_remaining without curr, target) --> assign to friend)
            UniqueOrderedList<Integer> solution = yourSplit(it, target);
            return solution;
        }
    }
}
