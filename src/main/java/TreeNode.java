import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int value;
    private List<TreeNode> children;
    private TreeNode parent;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
        this.parent = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
        child.setParent(this);
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
