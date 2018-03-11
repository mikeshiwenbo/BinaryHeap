package binaryHeap;

public class BinaryHeap<Key extends Comparable<Key>> {
	//二叉堆排序，重点是插入数据时数据应该往上游，取出数据时，此数据应该与最后的一位的数据交换，并将交换后的数据下滑至对应的位置
	private Key[] pq;
	private int N=0;
	public BinaryHeap(int maxN){
		pq=(Key[]) new Comparable[maxN+1];
	}
	private boolean less(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	private void exch(int i,int j){
		Key t=pq[i];
		pq[i]=pq[j];
		pq[j]=t;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void insert(Key v){
		pq[++N]=v;
		swim(N);
	}
	private void swim(int k) {
		// TODO Auto-generated method stub
		//将数字插入数组最后一个位置，然后让此数字向上爬，直至走到相对合适的位置
		while(k>1&&less(k/2,k)){
			exch(k,k/2);
			k=k/2;
		}
	}
	public Key delMax(){
		Key max=pq[1];
		exch(1,N--);
		pq[N+1]=null;
		sink(1);
		return max;
	}
	private void sink(int i) {
		// TODO Auto-generated method stub
		//此方法是将数字下沉到合适的位置
		while(2*i<=N){
			int j=2*i;
			if(j<N&&less(j,j+1)) j++;
			if(!less(i,j)) break;
			exch(i,j);
			i=j;
		}
	}

}
