import java.util.*;

class Solution {
    // A TreeMap to store columns, which ensures sorted order
    private Map<Integer, Map<Integer, List<Integer>>> mymap = new TreeMap<>();

    // DFS function to fill the map
    private void solve(TreeNode node, int col, int row) {
        if (node == null) {
            return;
        }

        // Insert node value into the corresponding column and row in the TreeMap
        mymap.putIfAbsent(col, new TreeMap<>());
        mymap.get(col).putIfAbsent(row, new ArrayList<>());
        mymap.get(col).get(row).add(node.val);

        // Recurse for left and right children with updated column and row values
        solve(node.left, col - 1, row + 1);
        solve(node.right, col + 1, row + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        solve(root, 0, 0); // Start DFS traversal with root at column 0 and row 0
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Iterate through the map to collect values in correct order
        for (Map.Entry<Integer, Map<Integer, List<Integer>>> colEntry : mymap.entrySet()) {
            List<Integer> colList = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> rowEntry : colEntry.getValue().entrySet()) {
                Collections.sort(rowEntry.getValue()); // Sort values at the same row position
                colList.addAll(rowEntry.getValue()); // Flatten the List to a column list
            }
            result.add(colList); // Add the column to the final result
        }
        
        return result;
    }
}
