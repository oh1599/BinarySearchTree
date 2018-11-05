package bst;

public class BST
{
	public Node root;//트리의 루트 노드이다.
	
	//삽입 시작하기전 출력문
	public void startInsert()
	{
		System.out.println("---------------------");
		System.out.println("삽입 시작");
		System.out.println("---------------------");
	}
	
	//정방향 삭제 시작하기전 출력문
	public void startDelete()
	{
		System.out.println("---------------------");
		System.out.println("삽입과 같은 순서로 삭제");
		System.out.println("---------------------");
	}
	
	//역방향 삭제 시작하기전 출력문
	public void startReverseDelete()
	{
		System.out.println("---------------------");
		System.out.println("삽입의  역순서로 삭제");
		System.out.println("---------------------");
	}
	
	//중위 연산 결과 출력 + 개행
	public void printInorder()
	{
		Inorder(root);
		System.out.println();
	}
	
	//중위 연산 결과를 출력한다
	//재귀 호출 사용
	public void Inorder(Node p)
	{
		if(p != null)
		{
			Inorder(p.left);
			System.out.printf("%d ",p.data);
			Inorder(p.right);
		}
	}
	
	//searchKey에 해당하는 값을 가진 노드를 반환하는 함수이다.
	//재귀함수를 활용하였다.
	public Node searchBST(Node node,int searchKey)
	{
		Node p = node;
		if(p == null)	return null;
		if(p.data == searchKey)	return p;
		if(p.data < searchKey)	return searchBST(p.right,searchKey);
		else	return searchBST(p.left,searchKey);
	}
	
	//searchKey에 해당하는 값을 가진 노드를 자식으로 둔 노드를 반환하는 함수이다.
	//반복문을 통하여 부모 노드의 값을 구하였다.
	public Node searchParentBST(Node node,int searchKey)//문제점
	{
		Node p = node;
		Node q = null;
		while(p!=null)
		{
			if(searchKey == p.data)
			{
				//만약 한번의 반복문 호출로 key값에 해당하는 노드를 찾는다면 
				//q노드는 null값을 리턴하여 오류를 발생시킨다.
				//이를 해결하기위해 q노드에 searchKey값을 가지고 있는 노드를 저장하여 반환 한다.
				if(q == null)
				{
					q = searchBST(root,searchKey);
					return q;
				}
				else	return q;
			}
			q = p;
			if(searchKey < p.data)	p = p.left;
			else	p = p.right;
		}
		return null;
	}
	
	//파라미터의 노드를 포함하여 해당 노드의 좌 우측 트리가 포함하는
	//총 노드의 수를 반환단다.
	//재귀함수를 활용하였다.
	public int noNode(Node node)
	{
		if(node == null)	return 0;
		int res = 1;
		res += noNode(node.left) + noNode(node.right);
		return res;
	}
	
	//트리의 높이를 반환하는 함수이다.
	//해당 노드를 기준으로 왼쪽 트리와 오른쪽 트리중 더 큰 높이의 값을 반환한다.
	//재귀 함수를 활용하였다.
	public int height(Node node)
	{
	  if (node == null)
	    return 0;
	  else {
	    int left = height(node.left);
	    int right = height(node.right);
	    return 1 + (left > right ? left : right);
	  }
	}
	
	//해당 노드의 자식 노드중 가장 큰값의 노드를 반환한다.
	public Node maxNode(Node node)
	{
		Node p = node;
		while(p.right != null)
		{
			p = p.right;
		}
		return p;
	}
	
	//해당 노드의 자식 노드중 가장 작은값의 노드를 반환한다.
	public Node minNode(Node node)
	{
		Node p = node;
		while(p.left != null)
		{
			p = p.left;
		}
		return p;
	}
	
	//root노드에서 부터 탐색하여 삽입하고자 하는 키값이 들어갈 위치를 찾아 트리에 삽입 시킨다.
	//반복문을 사용하여 트리를 순회하면서 삽입하고자 하는 키값이 어느 위치에 삽입되어야 하는지
	//위치를 찾은 후 트리에 삽입시켜준다.
	public void insertBST(Node node,int newKey)
	{
		Node p = node;
		Node q = new Node();
		while(p!=null)
		{
			if(newKey == p.data)	return;
			q = p;
			if(newKey < p.data) p = p.left;
			else	p = p.right;
		}
		Node newNode = new Node(newKey);
		if(node == null)	root = newNode;
		else if(newKey < q.data)	q.left = newNode;
		else	q.right = newNode;
	}
	
	//deletekey값을 가진 노드를 찾아 삭제하는 함수이다.
	//경우의 수는 총 3가지가 있다. 삭제하고자 하는 노드의 차수가 0인 경우,1인경우,2인경우이다.
	//p에는 삭제하고자 하는 키값을 가진 노드를 저장한다.
	//q에는 삭제하고 하는 키값을 가진 노드를 자식노드로 둔 부모노드를 저정한다.
	//자식노드의 수가 0인경우 단순히 부모노드와 자식노드의 연결을 끊어준다.
	//자식노드의 수가 1인경우는 부모노드와 삭제하고자 하는 노드의 연결을 끊고
	//부모노드와 삭제하고자하는 노드의 자식노드를 연결시켜준다.
	//자식노드의 수가 2인 경우는 우선 해당 노드의 왼쪽 트리와 오른쪽 높이를 비교하여
	//더 큰 높이를 가진 트리의 최대값 혹은 최소값을 취한다.
	//같은 높이인 경우는 좌우측 트리의 노드수가 더 많은 트리의 최대값 혹은 최소값을 취한다.
	//왼쪽 노드에서 최대값을 취한경우 플래그 변수를 L로 표시해주고
	//오른쪽 노드에서 최소값을 취한경우 플래그 변수를 R로 표시해준다.
	//삭제하고자 한 노드에 취한 최대 혹은 최소값의 데이터를 복사하고 다시 delete함수를 호출하여
	//복사했던 원본 도으의 연결을 끊어준다.
	public void deleteBST(Node node,int deleteKey)
	{
		Node p = searchBST(node,deleteKey);//삭제하고자 하는 노드를 저장
		Node q = searchParentBST(node,deleteKey);//삭제하고자 하는 노드의 부모노드를 저장
		Node r;
		char flag;
		if(noNode(root) == 0)//트리가 비어있는경우 함수를 종료한다.
		{
			return;
		}
		if(noNode(root) == 1)//루트 노드만 남아있을경우 트리를 빈 트리로 만들어준다.
		{
			root = null;
			return;
		}
		if(p.left == null && p.right == null)//자식 노드 0
		{
			if(q.left == p)	q.left = null;
			else	q.right = null;
		}
		else if(p.left == null || p.right == null)//자식 노드 1
		{
			if(p.left != null)
			{
				if(q.left == p)	
				{
					q.left = p.left;
				}
				else	q.right = p.left;
			}
			else
			{
				if(q.left == p)	q.left = p.right;
				else	q.right = p.right;
			}
			if(noNode(root) == 2)//총 노드의 수가 2개이고 이 때 루트 노드를 삭제하고자 하는 경우
			{
				if(root.right != null)	root.data = root.right.data;
				else	root.data = root.left.data;
				root.right = null;
				root.left = null;
			}
		}
		else if(p.left !=null && p.right != null)//자식 노드 2
		{
			if(height(p.left) > height(p.right))//왼쪽 트리의 높이가 더 큰 경우
			{
				r = maxNode(p.left);//왼쪽 트리에서 최대값을 취한다.
				flag = 'L';
			}
			else if(height(p.left) < height(p.right))//오른쪽 트리의 높이가 더 큰 경우
			{
				r = minNode(p.right);//오른쪽 트리에서 최소값을 취한다.
				flag = 'R';
			}
			else// 좌우측 트리의 높이가 같은 경우 이 때는 좌우측 트리의 노드수를 비교해준다.
			{
				if(noNode(p.left) >= noNode(p.right))//노드의 수가 왼쪽이 많거나 같은경우
				{
					r = maxNode(p.left);//왼쪽 트리에서 최대값을 취한다.
					flag = 'L';
				}
				else//노드의 수가 오른쪽이 더 많은 경우
				{
					r = minNode(p.right);//오른쪽 트리에서 최소값을 취한다.
					flag = 'R';
				}
			}
			p.data = r.data;//삭제하려는 노드에 취한 최소 혹은 최대값의 데이터를 복사한다.
			if(flag == 'L')	//왼쪽 트리에서 최대값을 취한경우
			{
				deleteBST(p.left,r.data);//삭제하고자 하는 노드의 왼쪽자식 노드부터 탐색하여 복사한 데이터값을 가진 노드를 찾아 삭제한다.
			}
			else //오른쪽 트리에서 최소값을 취한경우
			{
				deleteBST(p.right,r.data);//삭제하고자 하는 노드의 오른쪽자식 노드부터 탐색하여 복사한 데이터값을 가진 노드를 찾아 삭제한다.
			}
		}
	}
}
