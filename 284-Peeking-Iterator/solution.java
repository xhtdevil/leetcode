// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private Integer next;
    private Iterator<Integer> Iter;
    
	public PeekingIterator(Iterator<Integer> iterator) {            ////Iter is initialed as Iterator so all of its functions are called from Java functions instead of the functions we write
	    // initialize any member here.
	    Iter = iterator;
	    if(Iter.hasNext()){next = Iter.next();}
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ans = next;
	    if(Iter.hasNext()){
	        next = Iter.next();
	    }
	    else{
	        next = null;
	    }
	    return ans;
	}

 	@Override
 	public boolean hasNext() {
        return next != null;	    
 	}
}