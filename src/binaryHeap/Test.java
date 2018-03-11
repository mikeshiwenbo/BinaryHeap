package binaryHeap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double currentTime=System.currentTimeMillis();
		BinaryHeap<Double> binary=new BinaryHeap<Double>(2000);
		System.out.println(binary.isEmpty());
		for(int i=0;i<2000;i++){
			binary.insert(Math.random()*2000);
		}
		System.out.println(binary.size());
		for(int i=0;i<2000;i++){
			System.out.println(binary.delMax());
		}
		double t=System.currentTimeMillis()-currentTime;
		System.out.println(t);
	}

}
