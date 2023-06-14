import java.util.*;

public class BST<E extends Comparable<E>>{
    private TreeNode<E> root;
    private int size = 0;

    public BST() {
    }

    public boolean search(E e){
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public boolean insert(E e){
        if (root == null) {
            root = new TreeNode<E>(e);
        }
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else {
                    return false;
                }
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<E>(e);
            }
            else {
                parent.right = new TreeNode<E>(e);
            }
        }
        size++;
        return true;
    }

    public int getSize(){
        return size;
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode<E> node){
        if (node == null) {
            return -1;
        }
        else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public E getRoot(){
        return root.element;
    }

    public E minValue(){
        TreeNode<E> min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min.element;
    }

    public E maxValue(){
        TreeNode<E> max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max.element;
    }

    public ArrayList<TreeNode<E>> path (E e){
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else {
                break;
            }
        }
        return list;
    }

    public boolean delete(E e){
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else {
                break;
            }
        }
        if (current == null) {
            return false;
        }
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            }
            else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                }
                else {
                    parent.right = current.right;
                }
            }
        }
        else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            }
            else {
                parentOfRightMost.left = rightMost.left;
            }
        }
        size--;
        return true;
    }

    public boolean clear(){
        root = null;
        size = 0;
        return true;
    }

    protected void inorder(){
        inorder(root);
    }

    private void inorder(TreeNode<E> root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    protected void preorder(){
        preorder(root);
    }

    protected void preorder(TreeNode<E> root){
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    protected void postorder(){
        postorder(root);
    }

    protected void postorder(TreeNode<E> root){
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }
}
