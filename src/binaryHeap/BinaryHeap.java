package binaryHeap;

public class BinaryHeap<Key extends Comparable<Key>> {
	//����������ص��ǲ�������ʱ����Ӧ�������Σ�ȡ������ʱ��������Ӧ��������һλ�����ݽ���������������������»�����Ӧ��λ��
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
		//�����ֲ����������һ��λ�ã�Ȼ���ô�������������ֱ���ߵ���Ժ��ʵ�λ��
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
		//�˷����ǽ������³������ʵ�λ��
		while(2*i<=N){
			int j=2*i;
			if(j<N&&less(j,j+1)) j++;
			if(!less(i,j)) break;
			exch(i,j);
			i=j;
		}
	}

}
