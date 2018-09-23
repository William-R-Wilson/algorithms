import java.util.Arrays;

public class WeightedQuickUnion
{
	private int[] id;
	private int[] indexes;
	private int[] sz;
	
	public WeightedQuickUnion(int N) {
		id = new int[N];
		indexes = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			indexes[i] = i;
			sz[i] = 1;
		}
	}

	private int root(int i)
	{
		while (i != id[i]) i = id[i];
		return i;
	}

	public boolean connected(int p,int q){
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i == j) return;
		if (sz[i] < sz[j]) 	{ id[i] = j; sz[j] += sz[i]; }
		else				{ id[j] = i; sz[i] += sz[j]; }
	}
	
	public void printId(int[] id) {
		System.out.println(Arrays.toString(indexes));
		System.out.println(Arrays.toString(id));
	}
	
	public void printSz(int[] sz) {
		System.out.println("Sz array: ");
		System.out.println(Arrays.toString(indexes));
		System.out.println(Arrays.toString(sz));
	}

	public static void main(String[] args){
		WeightedQuickUnion uf = new WeightedQuickUnion(10);
		uf.printId(uf.id);
		uf.printSz(uf.sz);
		boolean c = uf.connected(3,4);
		System.out.println("3 and 4 are connected: " + c);
		uf.union(3,4);
		System.out.println("Joining 3 and 4");
		boolean new_c = uf.connected(3,4);
		System.out.println("3 and 4 are connected: " + new_c);
		uf.printId(uf.id);
		uf.printSz(uf.sz);
		uf.union(4, 5);
		System.out.println("Joining 4 and 5");
		uf.printId(uf.id);
		uf.printSz(uf.sz);
		uf.union(7, 8);
		System.out.println("Joining 7 and 8");
		uf.printId(uf.id);
		uf.printSz(uf.sz);
		uf.union(1, 7);
		System.out.println("Joining 1 and 7");
		uf.printId(uf.id);
		uf.printSz(uf.sz);
		uf.union(8, 5);
		System.out.println("Joining 8 and 5");
		uf.printId(uf.id);
		uf.printSz(uf.sz);
	}
}