package beyen074_lab9;

import beyen074_lab9.ArrayQueue.Iterator;

public class ArrayQueue<Base> {
	private int    front;    //  Index of front object in OBJECTS.
	  private int    rear;     //  Index of rear object in OBJECTS.
	  private Base[] objects;  //  The OBJECTs in the queue.


	//  Constuctor. Make a new empty queue that can hold SIZE - 1 elements.

	  @SuppressWarnings("unchecked")
	public ArrayQueue(int size)
	  {
	    if (size <= 1)
	    {
	      throw new IllegalArgumentException("Illegal size.");
	    }
	    else
	    {
	      front   = 0;
	      rear    = 0;
	     objects = (Base []) new Object[size];
	    }
	  }

	//  DEQUEUE. Remove an object from the queue.

	  public Base dequeue()
	  {
	    if (front == rear)
	    {
	      throw new IllegalStateException("Queue is empty.");
	    }
	    else
	    {
	     front = (front + 1) % objects.length;
	      Base temp = objects[front];
	      objects[front] = null;
	      //front = (front + 1) % objects.length;
	      return temp;
	    }
	  }

	//  ENQUEUE. Add a new OBJECT to the queue.

	  public void enqueue(Base object)
	  {
	    int nextRear = (rear + 1) % objects.length;
	    if (front == nextRear)
	    {
	      throw new IllegalStateException("Queue is full.");
	    }
	    else
	    {
	      rear = nextRear;
	      objects[rear] = object;
	    }
	  }

	//  IS EMPTY. Test if the queue is empty.

	  public boolean isEmpty()
	  {
	    return front == rear;
	  }

	//  IS FULL. Test if the queue is full.

	  public boolean isFull()
	  {
	    return front == (rear + 1) % objects.length;
	  }

public class Iterator {

	//private int frontPointer; //  the next element to be visited
	private int nextPointer;
	private int rearPointer;
	 private Iterator( int nextPointer, int rearPointer) {
	        this.nextPointer=nextPointer;
	        //this.frontPointer=frontPointer;
	        this.rearPointer=rearPointer;
}

	 public boolean hasNext() {
		 return (nextPointer  != rearPointer);
	 }

	 public Base next() {
		 if(nextPointer ==rearPointer) {
			 throw new IllegalStateException("no more elements to visit");
		 }
		 else {
			nextPointer = (nextPointer + 1) % objects.length;
			 Base temp = objects[nextPointer];
			 //nextPointer = (nextPointer + 1) % objects.length;
			 return temp;
		 }
	 }
}
	  public Iterator iterator() {


	 return new Iterator(front,rear);

	  }
}
