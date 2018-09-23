public class QuickUnionUF
{
	private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
	}

	private int root(int i)
	{
		while (i != id[i]) i = id[i];
		return i;
	}

	public boolean connected(int p; int q)n{
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	public void printId(int[] id) {
		for (int i = 0; i < id.length; i++)
			System.out.println(i + "  " + id[i]);
	}

	public static void main(String[] args){
		QuickUnionUF uf = new QuickUnionUF(10);
		uf.printId(uf.id);
		boolean c = uf.connected(3,4);
		System.out.println(c);
		uf.union(3,4);
		boolean new_c = uf.connected(3,4);
		System.out.println(new_c);
		uf.printId(uf.id);
	}

}