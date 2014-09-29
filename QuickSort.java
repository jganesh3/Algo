package chapter9.sorting.searching;

/*
@Author : Ganesh Joshi
@file :  QuickSort Java Generics
*/
public class QuickSort<E extends Comparable<E>> {

	
	
	public void QuickSort(E[] array, int p , int q){
		
		if(p<q){
			
		 int mid=split(array, p, q);
		 QuickSort(array, p, mid-1);
		 QuickSort(array, mid+1, q);
		 	
		}
		
		
		
	}
	
	
	
	public int split(E[] array,int p, int q){
		
		int left=p+1;
		int right=q;
		E pivot=array[p];
		
		
		while(true){
			
			
			while(left<=right){
				//check if the array[left]< pivot if yes left++
				int cmp=array[left].compareTo(pivot);
				if( cmp < 1){
					left++;
				}else
					break;
				
			}
			
			while(right>left){
				
				int cmp=array[right].compareTo(pivot);
				if(cmp>=1){
					right--;
				}else
					break;
			}
			
			
			if(left<right){
				//simply swap array[left] and array[right]
				E temp=array[left];
				array[left]=array[right];
				array[right]=temp;
				left++;
				right--;
			}
			
			if(left >= right)
				break;

			
		}
		
		
		//swap array[left-1] with pivot and returns the left-1 index
		
		E temp=array[left-1];
		array[left-1]=array[p];
		array[p]=temp;
		return left-1;
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
	String[] x={"ganesh","joshi","xyz","hello"};
	QuickSort<String>q=new QuickSort<String>();
	q.QuickSort(x, 0, x.length-1);
	
	for(String s:x)
	{
		System.out.println(s);
	}
		
		
	Integer[] y={30,22,1,89,5,99,10};
	QuickSort<Integer> a=new QuickSort<Integer>();
	a.QuickSort(y, 0, y.length-1);
	
	for(Integer s:y){
		System.out.println(s);
	}
		
		
		
	}
	
	
	
}
