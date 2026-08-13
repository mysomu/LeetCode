class Solution {
    static class Node {
        int maxLen, prefLen, suffLen, size;
        char leftChar, rightChar;

        Node() {}
        Node(char c) {
            maxLen = prefLen = suffLen = size = 1;
            leftChar = rightChar = c;
        }
    }

    private Node[] tree;

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node parent = new Node();
        parent.size = left.size + right.size;
        parent.leftChar = left.leftChar;
        parent.rightChar = right.rightChar;
        parent.prefLen = left.prefLen;
        parent.suffLen = right.suffLen;
        parent.maxLen = Math.max(left.maxLen, right.maxLen);

        if (left.rightChar == right.leftChar) {
            parent.maxLen = Math.max(parent.maxLen, left.suffLen + right.prefLen);
            if (left.prefLen == left.size) {
                parent.prefLen = left.size + right.prefLen;
            }
            if (right.suffLen == right.size) {
                parent.suffLen = right.size + left.suffLen;
            }
        }
        return parent;
    }

    private void build(int node, int start, int end, String s) {
        if (start == end) {
            tree[node] = new Node(s.charAt(start));
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, s);
        build(2 * node + 1, mid + 1, end, s);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, char val) {
        if (start == end) {
            tree[node] = new Node(val);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int m = s.length();
        int n = queryIndices.length;
        tree = new Node[4 * m];
        build(1, 0, m - 1, s);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            update(1, 0, m - 1, queryIndices[i], queryCharacters.charAt(i));
            res[i] = tree[1].maxLen;
        }
        return res;
    }
}