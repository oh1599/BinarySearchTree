package bst;

public class main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();//트리를 만들어준다.
		bst.startInsert();//삽입 시작
		bst.insertBST(bst.root, 8);
		bst.printInorder();
		bst.insertBST(bst.root, 18);
		bst.printInorder();
		bst.insertBST(bst.root, 11);
		bst.printInorder();
		bst.insertBST(bst.root, 5);
		bst.printInorder();
		bst.insertBST(bst.root, 15);
		bst.printInorder();
		bst.insertBST(bst.root, 4);
		bst.printInorder();
		bst.insertBST(bst.root, 9);
		bst.printInorder();
		bst.insertBST(bst.root, 1);
		bst.printInorder();
		bst.insertBST(bst.root, 7);
		bst.printInorder();
		bst.insertBST(bst.root, 17);
		bst.printInorder();
		bst.insertBST(bst.root, 6);
		bst.printInorder();
		bst.insertBST(bst.root, 14);
		bst.printInorder();
		bst.insertBST(bst.root, 10);
		bst.printInorder();
		bst.insertBST(bst.root, 3);
		bst.printInorder();
		bst.insertBST(bst.root, 19);
		bst.printInorder();
		bst.insertBST(bst.root, 20);
		bst.printInorder();
		
		bst.startDelete();//정방향 삭제 시작
		bst.deleteBST(bst.root, 8);
		bst.printInorder();
		bst.deleteBST(bst.root, 18);
		bst.printInorder();
		bst.deleteBST(bst.root, 11);
		bst.printInorder();
		bst.deleteBST(bst.root, 5);
		bst.printInorder();
		bst.deleteBST(bst.root, 15);
		bst.printInorder();
		bst.deleteBST(bst.root, 4);
		bst.printInorder();
		bst.deleteBST(bst.root, 9);
		bst.printInorder();
		bst.deleteBST(bst.root, 1);
		bst.printInorder();
		bst.deleteBST(bst.root, 7);
		bst.printInorder();
		bst.deleteBST(bst.root, 17);
		bst.printInorder();
		bst.deleteBST(bst.root, 6);
		bst.printInorder();
		bst.deleteBST(bst.root, 14);
		bst.printInorder();
		bst.deleteBST(bst.root, 10);
		bst.printInorder();
		bst.deleteBST(bst.root, 3);
		bst.printInorder();
		bst.deleteBST(bst.root, 19);
		bst.printInorder();
		bst.deleteBST(bst.root, 20);
		bst.printInorder();
		
		bst.startInsert();//삽입 시작
		bst.insertBST(bst.root, 8);
		bst.printInorder();
		bst.insertBST(bst.root, 18);
		bst.printInorder();
		bst.insertBST(bst.root, 11);
		bst.printInorder();
		bst.insertBST(bst.root, 5);
		bst.printInorder();
		bst.insertBST(bst.root, 15);
		bst.printInorder();
		bst.insertBST(bst.root, 4);
		bst.printInorder();
		bst.insertBST(bst.root, 9);
		bst.printInorder();
		bst.insertBST(bst.root, 1);
		bst.printInorder();
		bst.insertBST(bst.root, 7);
		bst.printInorder();
		bst.insertBST(bst.root, 17);
		bst.printInorder();
		bst.insertBST(bst.root, 6);
		bst.printInorder();
		bst.insertBST(bst.root, 14);
		bst.printInorder();
		bst.insertBST(bst.root, 10);
		bst.printInorder();
		bst.insertBST(bst.root, 3);
		bst.printInorder();
		bst.insertBST(bst.root, 19);
		bst.printInorder();
		bst.insertBST(bst.root, 20);
		bst.printInorder();
		
		bst.startReverseDelete();//역방향 삭제 시작
		bst.deleteBST(bst.root, 20);
		bst.printInorder();
		bst.deleteBST(bst.root, 19);
		bst.printInorder();
		bst.deleteBST(bst.root, 3);
		bst.printInorder();
		bst.deleteBST(bst.root, 10);
		bst.printInorder();
		bst.deleteBST(bst.root, 14);
		bst.printInorder();
		bst.deleteBST(bst.root, 6);
		bst.printInorder();
		bst.deleteBST(bst.root, 17);
		bst.printInorder();
		bst.deleteBST(bst.root, 7);
		bst.printInorder();
		bst.deleteBST(bst.root, 1);
		bst.printInorder();
		bst.deleteBST(bst.root, 9);
		bst.printInorder();
		bst.deleteBST(bst.root, 4);
		bst.printInorder();
		bst.deleteBST(bst.root, 15);
		bst.printInorder();
		bst.deleteBST(bst.root, 5);
		bst.printInorder();
		bst.deleteBST(bst.root, 11);
		bst.printInorder();
		bst.deleteBST(bst.root, 18);
		bst.printInorder();
		bst.deleteBST(bst.root, 8);
		bst.printInorder();
	}
}
