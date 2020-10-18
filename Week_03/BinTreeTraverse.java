import java.util.ArrayList;
import java.util.List;

public class BinTreeTraverse {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(1,root,res);
		return res;
	}

    void dfs(int index,TreeNode root, List<List<Integer>> res) {
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        res.get(index-1).add(root.val);
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
    }
}