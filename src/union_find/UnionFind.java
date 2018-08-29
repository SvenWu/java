package union_find;

/**
 * Created by WuTianhao on 8/18/2017.
 */


/**
 * 可以查看http://blog.csdn.net/dm_vincent/article/details/7655764
 *
 */
public class UnionFind {
    private int count;
    private int[] id;
    public UnionFind(int n){
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public int find(int p) {
        while(id[p] != p) {
            p = id[p];
        }
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public void uion(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
}
