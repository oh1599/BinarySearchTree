package bst;

//트리의 각 Node에 해당하는 클래스
//left node, right node와 해당하는 노드의 값을 가지고 있다.
public class Node
{
	public Node left;
	public Node right;
	public int data;
	//파라미터의 정수를 노드의 값으로 사용하는 생성자
	public Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	//디폴트 생성자
	public Node()
	{
		this.data = 0;
		this.left = null;
		this.right = null;
	}
}
