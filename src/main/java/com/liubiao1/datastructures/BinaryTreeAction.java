package com.liubiao1.datastructures;

/**
 * 手动实现二叉树
 */
public class BinaryTreeAction {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        //  手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        BinaryTree binaryTree = new BinaryTree(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.midOrder();
        System.out.println("后序遍历");
        binaryTree.afterOrder();
        System.out.println("前序搜索：" + binaryTree.preSearch(3));
        System.out.println("中序搜索：" + binaryTree.midSearch(3));
        System.out.println("后序搜索：" + binaryTree.afterSearch(3));
    }

}

/**
 * 定义二叉树
 */
class BinaryTree {
    private HeroNode root;


    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 后序遍历
    public void afterOrder() {
        if (this.root != null) {
            this.root.afterOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 前序遍历搜索
    public HeroNode preSearch(int no) {
        if (root != null) {
            return root.preSearch(no);
        } else {
            return null;
        }
    }

    // 前序遍历搜索
    public HeroNode midSearch(int no) {
        if (root != null) {
            return root.midSearch(no);
        } else {
            return null;
        }
    }

    // 前序遍历搜索
    public HeroNode afterSearch(int no) {
        if (root != null) {
            return root.afterSearch(no);
        } else {
            return null;
        }
    }
}

/**
 * 节点
 */
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; // 左子节点，默认为null
    private HeroNode right; // 右子节点，默认为nul

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name=" + name +
                '}';
    }

    // 递归删除节点： 规定1、如果删除的是叶子节点，直接删除；2、如果删除的是非叶子节点  直接删除子树
    public void deleteNode(int no) {
        //TODO
    }

    // 编写前序遍历的方法
    public void preOrder() {
        System.out.println(this); //先输出父节点
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 编写中序遍历的方法
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this); //输出父节点
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    // 编写后序遍历的方法
    public void afterOrder() {
        if (this.left != null) {
            this.left.afterOrder();
        }
        if (this.right != null) {
            this.right.afterOrder();
        }
        System.out.println(this); //输出父节点
    }

    /**
     * 前序遍历查找
     *
     * @param no 查找的编号
     * @return 找到后返回相应node
     */
    public HeroNode preSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preSearch(no);  // 左递归
        }
        if (heroNode != null) {
            return heroNode;    // 左递归找到了
        }
        if (this.right != null) {
            heroNode = this.right.preSearch(no); // 右递归
        }
        return heroNode; // 不管找没找到都要返回
    }

    /**
     * 中序遍历查找
     *
     * @param no 查找的编号
     * @return 找到后返回相应node
     */
    public HeroNode midSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.midSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            heroNode = this.right.midSearch(no); // 右递归
        }
        return heroNode; // 不管找没找到都要返回
    }

    /**
     * 后序遍历查找
     *
     * @param no 查找的编号
     * @return 找到后返回相应node
     */
    public HeroNode afterSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.afterSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preSearch(no); // 右递归
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        return heroNode; // 不管找没找到都要返回
    }
}
