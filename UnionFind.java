public class UnionFind {
	//this uses an id array to store the info
	private int[] id;
	
	public UnionFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) 
			id[i] = i;
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	//to join, change the value at the array index
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid) id[i] = qid;
	}
	
	public void printId(int[] id) {
		for (int i = 0; i < id.length; i++)
			System.out.println(i + "  " + id[i]);
	}

	public static void main(String[] args){
		UnionFind uf = new UnionFind(5);
		uf.printId(uf.id);
		boolean c = uf.connected(3,4);
		System.out.println(c);
		uf.union(3,4);
		boolean new_c = uf.connected(3,4);
		System.out.println(new_c);
		uf.printId(uf.id);
	}
	
}


