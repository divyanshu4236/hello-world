package DynamicProgramming;
import java.util.NoSuchElementException;
public class dp {

	
	public static int fibb(int n,int[] arr) {
		
		if(n==0 || n==1) {
			return n;
		}
		int ans1,ans2;
		if(arr[n-1] == 0) {
			ans1 = fibb(n-1,arr);
			arr[n-1] = ans1;
		}else {
			ans1 = arr[n-1];
		}
		
		if(arr[n-2] == 0) {
			ans2 = fibb(n-2,arr);
			arr[n-2] = ans2;
		}else {
			ans2 = arr[n-2];
		}
		return ans1 + ans2 ;
	}
	
	public static int minSteps(int n,int[] dp) {
		
		if(n==1) {
			return 0;
		}
		
		int ans1,ans2 = Integer.MAX_VALUE,ans3 = Integer.MAX_VALUE;
		
		if(dp[n-1] == 0) {
			ans1 = minSteps(n-1,dp);
			dp[n-1] = ans1;
		}else {
			ans1 = dp[n-1];
		}
		
		if(n%2 == 0) {
			if(dp[n/2] == 0) {
				ans2 = minSteps(n/2,dp);
				dp[n/2] = ans2;
			}else {
				ans2 = dp[n/2];
			}
		}
		if(n%3 == 0) {
			if(dp[n/3] == 0) {
				ans3 = minSteps(n/3,dp);
				dp[n/3] = ans3;
			}else {
				ans3 = dp[n/3];
			}
		}
		return 1 + Math.min(ans1,Math.min(ans2,ans3));
	}
	
	public static int lcsRecursive(String s1,String s2,int s1Index,int s2Index) {
		
		if(s1Index >= s1.length() || s2Index >= s2.length()) {
			return 0;
		}
		int ans;
		if(s1.charAt(s1Index) == s2.charAt(s2Index)) {
			ans = 1 + lcsRecursive(s1, s2, s1Index+1, s2Index+1);
		}else {
			int ans1,ans2;
			ans1 = lcsRecursive(s1, s2, s1Index+1, s2Index);
			ans2 = lcsRecursive(s1, s2, s1Index, s2Index+1);
			
			ans = Math.max(ans1, ans2);
		}
		return ans;
		
	}
	
	public static int minCostIterative(int[][] arr) {
		
		int dp[][] = new int[arr.length+1][arr[0].length+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int m = arr.length;
		int n = arr[0].length;
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				if(i== m-1 && j== n-1) {
					dp[i][j] = arr[i][j];
				}else {
					dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], 
						Math.min(dp[i][j+1], dp[i+1][j+1]));
				}
				
			}
		}
		return dp[0][0];
	}
	
	public static int minCost(int[][] arr,int i,int j,int[][] dp) {
		
		if(i== arr.length-1 && j==arr[0].length-1) {
			return arr[i][j];
		}
		if(i>= arr.length || j>= arr[0].length) {
			return Integer.MAX_VALUE;
		}
		int ans1,ans2,ans3;
		
		if(dp[i][j+1] ==Integer.MAX_VALUE) {
			ans1 = minCost(arr,i,j+1,dp);
			dp[i][j+1] = ans1;
		}else {
			ans1 = dp[i][j+1];
		}
		
		if(dp[i+1][j] == Integer.MAX_VALUE) {
			ans2 = minCost(arr,i+1,j,dp);
			dp[i+1][j] = ans2;
		}else {
			ans2 = dp[i+1][j];
		}
		
		if(dp[i+1][j+1] == Integer.MAX_VALUE) {
			ans3 = minCost(arr,i+1,j+1,dp);
			dp[i+1][j+1] = ans3;
		}else {
			ans3 = dp[i+1][j+1];
		}
		
		
		return arr[i][j] + Math.min(ans1, Math.min(ans2, ans3));
	}
	
	public static int numberOfBalancedBTs(int h) {
		
		if(h==0 || h==1) {
			return 1;
		}
		int x = numberOfBalancedBTs(h-1);
		int y = numberOfBalancedBTs(h-2);
		
		int ans = x*x + 2*x*y;
		return ans;
	}
	
	public static int fibbIterative(int n) {
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = new int[6];
//		int ans = fibb(5,arr);
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] dp = new int[arr.length+1][arr[0].length+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		int value = minCost(arr,0,0,dp);
		
	}

}


/**
 * @author Shreyas Casturi
 * An interface that contains methods to implement.
 * Correct implementations of these methods will produce a working Linked List.
 * DO NOT MODIFY THIS INTERFACE.
 * Good luck.
 **/
public interface SimpleList<T> {


    // takes an element of T type and an index, creates a Node filled with that element,
    // and adds it as the i-th node of the list.
    // EX: 0 -> 1 -> 2 -> 3, let's say I want to add element 4 at index 1.
    // Then: 0 -> 4 -> 1 -> 2 -> 3 is the correct list.
    // What changes will this cause?
    // Remember, throw exceptions when necessary.
    void addAtIndex(T data, int index); 


    // takes an index (throw exception if necessary), and retrieves the element
    // associated with the index-th node. ALSO: we swap the data of the (index-1)th
    // node with the data of the index-th node.
    // EX: 0 -> 1 -> 2 -> 3, list.get(2) will return "2",
    // and the final list will be: 0 -> 2 -> 1 -> 3.
    // What happens if we keep invoking get()
    // with smaller and smaller indices? Where will the data end up?   
    T get(int index); 

    // Check if a particular element is contained in a LinkedList.
    // This is an O(n) operation.
    boolean contains(T element); 

    // Tell us if the list is empty or not. A straightforward method.
    boolean isEmpty(); 


    // takes an index (check if index is valid), and retrieves and returns the data
    // at the index-th node, and removes the Node from the list. What changes will this cause?
    // EX: 0 -> 1 -> 2 -> 3 -> 4. list.removeAtIndex(2) will return "2". 
    // The linked list is then: 0 -> 1 -> 3 -> 4.
    // Throw exceptions when necessary.
    // THINK ABOUT WHAT VARIABLES MAY CHANGE AS A RESULT OF THIS REMOVE!!!
    T removeAtIndex(int index); 

    // A straightforward method.
    int size(); 

    // Take the current list, and transfer all of its data (not the Nodes themselves)
    // into an array of T type. Return this array. Make sure the array is allocated
    // only as much space as the list needs. That is, if there's seven elements in the list,
    // don't return a 10 element array with 7 filled spots and 3 non-filled spots.
    // Rather, return an array with 7 filled spots only.
    T[] toArray(); 
} 

/**
 * @author Carl Schriever
 * The Node class to use for your linked list
 * DO NOT MODIFY
 **/
class Node<T> {

    private T data;
    private Node<T> next;
    
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    // get the data of the current node.
    public T getData() {
        return data;
    }

    // get the current Node's next Node. THIS DOES NOT RETURN DATA.
    public Node<T> getNext() {
        return next;
    }

    // changes the data of the current node.
    public void setData(T data) {
        this.data = data;
    }

    // changes what the current node's next Node is.
    public void setNext(Node<T> next) {
        this.next = next;
    }
}

class LinkedList<T> implements SimpleList<T>{
	
	private Node head<T>;
	private int size;
	
	public LinkedList() {
		this.head=null;
		this.size=0;
	}
	public void addAtIndex(T data, int index) {
		
		if(index<0 || index>this.size) {
		// TODO	
		}
		else {
			if(index==0) {
				Node<T> curr = new Node<T>(data,head);
				this.head = curr;
				
			}
			else {
				index--;
				Node<T> temp = this.head;
				while(index>0) {
					temp=temp.getNext();
					index--;
				}
				Node<T> after = temp.getNext();
				Node<T> curr = new Node<T>(data,after);
				temp.setNext(curr);
			}
			this.size++;			
		}
		
	}
	
	public T get(int index) {
		if(this.size==0) {
			throw new NoSuchElementException();
		}
		else if(index<0 || index>this.size-1) {
			throw new IllegalArgumentException();
		}
		else {
			T ans;
			if(index==0) {
				ans=this.head.getData();
			}
			else {
				index--;
				Node<T> temp = this.head;
				while(index>0) {
					temp = temp.getNext();
					index--;
				}
				ans = temp.getNext().getData();
				T t1 = temp.getNext().getData();
				temp.getNext().setData(temp.getData());
				temp.setData(t1);
				return ans;
			}
		}
		
	}
	public boolean contains(T data) {
		
		Node<T> temp = this.head;
		while(temp!=null) {
			if(temp.getData().equals(data)) {
				return true;
			}
			temp=temp.getNext();
		}
		return false;
		
	}
	
	public boolean isEmpty() {
		
		if(this.size==0) {
			return true;
		}
		return false;
	}
	
	public T removeAtIndex(int index) {
		if(this.size==0) {
			throw new NoSuchElementException();
		}
		else if(index<0 || index>this.size-1) {
			throw new IllegalArgumentException();
		}
		else {
			T ans;
			if(index==0) {
				ans = head.getData();
				this.head=head.getNext();
				
			}
			else {
				index--;
				Node<T> temp = this.head;
				while(index>0) {
					temp = temp.getNext();
					index--;
				}
				ans = temp.getNext().getData();
				Node<T> after = temp.getNext().getNext();
				temp.setNext(after);
			}
			this.size--;
			return ans;
		}
		
	}
	public int size() {
		return this.size();
	}
	public T[] toArray() {
		T[] arr = new T[this.size];
		Node<T> temp = this.head;
		for(int i=0;i<this.size;i++) {
			arr[i] = temp.getData();
			temp=temp.getNext();
		}
		return arr;
	}
	
}
