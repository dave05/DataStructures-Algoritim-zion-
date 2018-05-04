package beyen074_lab11;

public class AssociationList<Key, Value> 
{

	private Node head;
	
	private class Node
	{
		private Key key;
		
		private Value value;
		
		private Node next;
		
	public Node(Key key, Value value, Node next) {
		this.key = key;
		this.value=value;
		this.next=next;
		
	}
	
	}
	
	public AssociationList() {
		
		head = new Node(null, null, null);
}

public void delete(Key key) {
	
	Node left = head;
	Node right = head.next;

	while(right !=null)
	{
		if((isEqual(key,right.key) && left!=null))
		{
			left.next= right.next;
			return;
		}
		else
		{
			left=right;
			right=right.next;
		}
	}
}

public Value get(Key key) {
	

Node get = head.next;
	while(get!=null)
	{
		if(isEqual(get.key,key))
		{
			return get.value;
		}
		
		else
		{
			get=get.next;
		}
	}
	
	throw new IllegalArgumentException("element not found");
	

}
private boolean isEqual(Key leftKey, Key rightKey) 
    {
	
	if(leftKey!=null && rightKey!=null) {
	   
		
	return leftKey.equals(rightKey);
	}
	
	else
	{
	
		return (leftKey==rightKey);
	
    }
	
}

public boolean isIn(Key key)
{
	Node get = head.next;
	while(get!=null) {
		
		if(isEqual(get.key,key)) 
		{
			
		    return true;
		}
			get=get.next;
		
		}
	return false;
	}
	
public void put(Key key, Value value) {
	
	Node get = head.next;
	
	while(get!=null) {
		if(isEqual(get.key,key))
		{
			get.value=value;
			break;
		}
		
		get=get.next;
		
	}
	
	head.next=new Node(key,value, head.next);
}


}


/*
 outputs 
false
No null
true
false
true
true
true
false
Lavender
Ginny
null
Wormtail
No Joanne
false
true
null
Ginny
Ginny
Hermione
No Dean

*/
 
