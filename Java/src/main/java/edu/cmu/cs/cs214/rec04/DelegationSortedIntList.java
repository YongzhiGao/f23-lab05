package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private SortedIntList innerList;
    private int totalAdded;

    public DelegationSortedIntList(){
        this.innerList = new SortedIntList();
        this.totalAdded = 0;
    }

    public boolean add(int num){
        totalAdded++;
        return innerList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();  // Increment the count by the size of the incoming list.
        return innerList.addAll(list);  // Delegate to the inner list.
    }

    @Override
    public int get(int index) {
        return innerList.get(index);  // Delegate to the inner list.
    }

    @Override
    public boolean remove(int num) {
        return innerList.remove(num);  // Delegate to the inner list.
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return innerList.removeAll(list);  // Delegate to the inner list.
    }

    @Override
    public int size() {
        return innerList.size();  // Delegate to the inner list.
    }

    /**
     * Returns the total number of elements that have been added to the list.
     *
     * @return total number of elements added
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}