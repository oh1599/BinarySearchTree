package bst;

//Ʈ���� �� Node�� �ش��ϴ� Ŭ����
//left node, right node�� �ش��ϴ� ����� ���� ������ �ִ�.
public class Node
{
	public Node left;
	public Node right;
	public int data;
	//�Ķ������ ������ ����� ������ ����ϴ� ������
	public Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	//����Ʈ ������
	public Node()
	{
		this.data = 0;
		this.left = null;
		this.right = null;
	}
}
