package binarySearchTree;

import java.util.LinkedList;
import java.util.Stack;




class bnode implements Comparable<bnode>{
	
	private int data;
	private bnode left;
	private bnode right;
	
	
	public bnode(int x){
		this.data=x;
		this.left=null;
		this.right=null;
	}
	
	
	public int getData(){
		return this.data;
	}
	
	
	
	public void setLeft(bnode l){
		this.left=l;
		
	}
	
	
	public void setRight(bnode r){
		this.right=r;
	}
	
	
	public bnode getleft(){
		return this.left;
	}
	
	
	public bnode getRight(){
		return this.right;
	}
	
	
	public int compareTo(bnode o){
		
		if(this.data < o.data)
			return -1;
		else if(this.data> o.data)
			return 1;
		else return 0;
		
	}
	
	
	public String toString(){
		return "Data :"+this.data;
	}
	
}

public class bTree {
	
	
	 bnode root;
	
	public void add(int x){
		
		root=add(root,x);
		
	}

	private bnode add(bnode root2, int x) {
		
		if(root2==null)
			return new bnode(x);
		else{
			if(x<root2.getData())
				root2.setLeft(add(root2.getleft(),x));
			else if(x > root.getData())
				root2.setRight(add(root2.getRight(),x));
		}
		
		return root2;
	}
	
	
	
	public void inOrder(){
		
		inOrder(root);
		
	}
	private void inOrder(bnode root2) {
			if(root2!=null){
				inOrder(root2.getleft());
				System.out.print(root2.getData()+" ");
				inOrder(root2.getRight());
			}
			
			
		
	}
	
	
	public void preOrder(){
		preOrder(root);
	}
	
	
	public void delete(int x){
		//check if the tree is empty
		if(isEmpty())return;
		else{
			
			delete(root,x);
		}
				
	}
	
	private void delete(bnode root2, int x) {
		
		
		bnode parent=null;
		bnode temp=root2;
		bnode deletionNode=null;
	
		// Traverse till that node;
		
		while(temp!=null){
		
			if(x < temp.getData())
				{
				parent=temp;
				temp=temp.getleft();
				}
			else if(x > temp.getData()){
				parent=temp;
				temp=temp.getRight();
			}else{
				break;
			}
			
		}
		
		//no data found
		if(temp==null)
			return;
		
		
		//Now we have the deletion node in temp;
		
		/*
		 * Case 1 if temp.left == null and temp.right==null
		 * Simply disconnect this node from the tree
		*/
		
		if(temp.getleft()==null && temp.getRight()==null){
			if(parent.getleft()==temp)
				parent.setLeft(null);
			else
				parent.setRight(null);
			
		}
		
		
		/*
		 * Case 2 
		*/
		
		// Find the smallest element in right sub tree
		
		deletionNode=temp;
		while(deletionNode.getleft()!=null){
			deletionNode=deletionNode.getleft();
		}
		
		
		
		
	}

	

	public boolean isEmpty(){
		return root==null;
	}
	
	
	
	

	private void preOrder(bnode root2) {
			
		if(root2!=null){
			System.out.print(root2.getData()+" ");
			preOrder(root2.getleft());
			preOrder(root2.getRight());
		}
		
		
	}
	
	
	
	public int depth(){
		
		return 1;
		
	}
	
	public void levelTraversal(){
		
		bnode u;
		if(root==null)
			return;
		LinkedList<bnode>Q=new LinkedList<>();
		
		//Push the root into Q
		Q.add(root);
		
		//while Q is not empty add its children into Q and print the data
		while(!Q.isEmpty()){
			
			u=Q.poll();
			if(u.getleft()!=null) Q.add(u.getleft());
			if(u.getRight()!=null) Q.add(u.getRight());
			
			System.out.println(u.getData());
		}
		
		
		
	}
	
	
	
	public void nonrecursivePreorder(){
		nonrecursivePreorder(root);
	}
	
	
	
	private void nonrecursivePreorder(bnode root2) {
		
		Stack<bnode> stack=new Stack<>();
		bnode u;
		//Push root node onto the stack
		
		stack.push(root2);
		
		//now while stack is non empty
		
		while(!stack.isEmpty()){
			
			u=stack.pop();
			if(u==null) break;
			System.out.print(u.getData()+" ");
			
			//now Push right child onto the stack
			if(u.getRight()!=null)
			stack.push(u.getRight());
			
			// Now push left child onto the stack
			if(u.getleft()!=null)
			stack.push(u.getleft());
			
			
			
		}
		
		// Mark stack to null so that it will be garbage collected
		
		stack=null;
		System.out.println();
		
	}

	
	
	
	
	public void LowestCommonAnsestor(int n1,int n2){
		
		
		bnode temp=LowestCommonAnsestor(root, n1, n2);
		System.out.println("Lowest common ansestor is : "+temp.getData());
		
	}
	
	
	
	private bnode LowestCommonAnsestor(bnode x,int n1,int n2){
		
		if(x==null) return x;
		
		//if both n1 and n2 are smaller than the root data, they will be present in left sub tree
		if(x.getData() > n1 && x.getData() > n2){
			return LowestCommonAnsestor(x.getleft(), n1, n2);
		}
		
		// if both n1 and n2 are greater than the root data they will be present in right sub tree
		
		if(x.getData() < n1 && x.getData() < n2)
		{
			return LowestCommonAnsestor(x.getRight(), n1, n2);
		}
		
		
		
		return x;
		
		
		
	}
	
	public void postOrder(){
		
		postOrder(root);
		
	}

	private void postOrder(bnode root2) {
		
		if(root2!=null){
			postOrder(root2.getleft());
			postOrder(root2.getRight());
			System.out.print(root2.getData()+" ");
		}
		
	}
	
	
	public boolean contains(int d){
		
		return contains(root,d);
	}

	private boolean contains(bnode root2, int d) {
		
		if(root2==null)
			return false;
		if(root2!=null && root2.getData()==d)
			return true;
		if(d < root2.getData())
			return contains(root2.getleft(),d);
		else if(d>root2.getData())
			return contains(root2.getRight(),d);
		else
			return false;
		
	}

	public static void main(String[] args) {
		bTree x=new bTree();
		
		x.add(100);
		x.add(50);
		x.add(150);
		x.add(25);
		x.add(75);
		x.add(125);
		x.add(175);
		x.add(185);
		
		System.out.print("In order traversl :- ");
		x.inOrder();
		System.out.println("");
		System.out.println("Pre order without recusion ");
		x.nonrecursivePreorder();
		System.out.println("Pre order with reusrsion");
		x.preOrder();
		System.out.println("");
		x.postOrder();
		
		System.out.println(x.contains(99));
		
		System.out.println("");
		x.levelTraversal();
		
		
		x.LowestCommonAnsestor(25, 75);
		
		
	}
	
	
	
	
	

}
