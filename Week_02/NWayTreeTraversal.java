class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class NWayTreeTraversal {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) 
			return res;
		helper(root, 0, res);
		return res;
	}

	private void helper(Node root, int depth, List<List<Integer>> res) {
		if (root == null) 
			return;
		if (depth + 1 > res.size()) {
			res.add(new ArrayList<>());
		}
		res.get(depth).add(root.val);
		for (Node node : root.children) {
			if (node != null) {
				helper(node, depth + 1, res);
			}
		}
	}
}