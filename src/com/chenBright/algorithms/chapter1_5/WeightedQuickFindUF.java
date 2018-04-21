package com.chenBright.algorithms.chapter1_5;

/**
 * Created by chenbright on 2018/4/21.
 * 习题1.5.11
 */
public class WeightedQuickFindUF {
    private int[] id; // 分量id
    private int[] sz; // 各个根结点所对应的分量的数量
    private int count; // 分量数量

    public WeightedQuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * 连通分量数量
     * @return 数量
     */
    public int count() {
        return count;
    }

    /**
     * p和q是否存在同一分量中
     * @param p
     * @param q
     * @return true / false
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p所在的分量的id
     * @param p
     * @return id
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * 连接p、q
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        int larger, smaller;
        if (sz[pID] < sz[qID]) {
            larger = qID;
            smaller = pID;
        }
        else {
            larger = pID;
            smaller = qID;
        }
        sz[larger] += sz[smaller];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == smaller) {
                id[i] = larger;
            }
        }
        count--;
    }
}
