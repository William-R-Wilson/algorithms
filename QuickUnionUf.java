import java.util.Arrays;

public class QuickUnionUf
{
	private int[] id;
	private int[] indexes;
	
	public QuickUnionUf(int N) {
		id = new int[N];
		indexes = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			indexes[i] = i;
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
		id[i] = j;
	}
	
	public void printId(int[] id) {
		System.out.println(Arrays.toString(indexes));
		System.out.println(Arrays.toString(id));
	}

	public static void main(String[] args){
		QuickUnionUf uf = new QuickUnionUf(10);
		uf.printId(uf.id);
		boolean c = uf.connected(3,4);
		System.out.println(c);
		uf.union(3,4);
		boolean new_c = uf.connected(3,4);
		System.out.println(new_c);
		uf.printId(uf.id);
	}

}