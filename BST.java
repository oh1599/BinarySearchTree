package bst;

public class BST
{
	public Node root;//Ʈ���� ��Ʈ ����̴�.
	
	//���� �����ϱ��� ��¹�
	public void startInsert()
	{
		System.out.println("---------------------");
		System.out.println("���� ����");
		System.out.println("---------------------");
	}
	
	//������ ���� �����ϱ��� ��¹�
	public void startDelete()
	{
		System.out.println("---------------------");
		System.out.println("���԰� ���� ������ ����");
		System.out.println("---------------------");
	}
	
	//������ ���� �����ϱ��� ��¹�
	public void startReverseDelete()
	{
		System.out.println("---------------------");
		System.out.println("������  �������� ����");
		System.out.println("---------------------");
	}
	
	//���� ���� ��� ��� + ����
	public void printInorder()
	{
		Inorder(root);
		System.out.println();
	}
	
	//���� ���� ����� ����Ѵ�
	//��� ȣ�� ���
	public void Inorder(Node p)
	{
		if(p != null)
		{
			Inorder(p.left);
			System.out.printf("%d ",p.data);
			Inorder(p.right);
		}
	}
	
	//searchKey�� �ش��ϴ� ���� ���� ��带 ��ȯ�ϴ� �Լ��̴�.
	//����Լ��� Ȱ���Ͽ���.
	public Node searchBST(Node node,int searchKey)
	{
		Node p = node;
		if(p == null)	return null;
		if(p.data == searchKey)	return p;
		if(p.data < searchKey)	return searchBST(p.right,searchKey);
		else	return searchBST(p.left,searchKey);
	}
	
	//searchKey�� �ش��ϴ� ���� ���� ��带 �ڽ����� �� ��带 ��ȯ�ϴ� �Լ��̴�.
	//�ݺ����� ���Ͽ� �θ� ����� ���� ���Ͽ���.
	public Node searchParentBST(Node node,int searchKey)//������
	{
		Node p = node;
		Node q = null;
		while(p!=null)
		{
			if(searchKey == p.data)
			{
				//���� �ѹ��� �ݺ��� ȣ��� key���� �ش��ϴ� ��带 ã�´ٸ� 
				//q���� null���� �����Ͽ� ������ �߻���Ų��.
				//�̸� �ذ��ϱ����� q��忡 searchKey���� ������ �ִ� ��带 �����Ͽ� ��ȯ �Ѵ�.
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
	
	//�Ķ������ ��带 �����Ͽ� �ش� ����� �� ���� Ʈ���� �����ϴ�
	//�� ����� ���� ��ȯ�ܴ�.
	//����Լ��� Ȱ���Ͽ���.
	public int noNode(Node node)
	{
		if(node == null)	return 0;
		int res = 1;
		res += noNode(node.left) + noNode(node.right);
		return res;
	}
	
	//Ʈ���� ���̸� ��ȯ�ϴ� �Լ��̴�.
	//�ش� ��带 �������� ���� Ʈ���� ������ Ʈ���� �� ū ������ ���� ��ȯ�Ѵ�.
	//��� �Լ��� Ȱ���Ͽ���.
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
	
	//�ش� ����� �ڽ� ����� ���� ū���� ��带 ��ȯ�Ѵ�.
	public Node maxNode(Node node)
	{
		Node p = node;
		while(p.right != null)
		{
			p = p.right;
		}
		return p;
	}
	
	//�ش� ����� �ڽ� ����� ���� �������� ��带 ��ȯ�Ѵ�.
	public Node minNode(Node node)
	{
		Node p = node;
		while(p.left != null)
		{
			p = p.left;
		}
		return p;
	}
	
	//root��忡�� ���� Ž���Ͽ� �����ϰ��� �ϴ� Ű���� �� ��ġ�� ã�� Ʈ���� ���� ��Ų��.
	//�ݺ����� ����Ͽ� Ʈ���� ��ȸ�ϸ鼭 �����ϰ��� �ϴ� Ű���� ��� ��ġ�� ���ԵǾ�� �ϴ���
	//��ġ�� ã�� �� Ʈ���� ���Խ����ش�.
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
	
	//deletekey���� ���� ��带 ã�� �����ϴ� �Լ��̴�.
	//����� ���� �� 3������ �ִ�. �����ϰ��� �ϴ� ����� ������ 0�� ���,1�ΰ��,2�ΰ���̴�.
	//p���� �����ϰ��� �ϴ� Ű���� ���� ��带 �����Ѵ�.
	//q���� �����ϰ� �ϴ� Ű���� ���� ��带 �ڽĳ��� �� �θ��带 �����Ѵ�.
	//�ڽĳ���� ���� 0�ΰ�� �ܼ��� �θ���� �ڽĳ���� ������ �����ش�.
	//�ڽĳ���� ���� 1�ΰ��� �θ���� �����ϰ��� �ϴ� ����� ������ ����
	//�θ���� �����ϰ����ϴ� ����� �ڽĳ�带 ��������ش�.
	//�ڽĳ���� ���� 2�� ���� �켱 �ش� ����� ���� Ʈ���� ������ ���̸� ���Ͽ�
	//�� ū ���̸� ���� Ʈ���� �ִ밪 Ȥ�� �ּҰ��� ���Ѵ�.
	//���� ������ ���� �¿��� Ʈ���� ������ �� ���� Ʈ���� �ִ밪 Ȥ�� �ּҰ��� ���Ѵ�.
	//���� ��忡�� �ִ밪�� ���Ѱ�� �÷��� ������ L�� ǥ�����ְ�
	//������ ��忡�� �ּҰ��� ���Ѱ�� �÷��� ������ R�� ǥ�����ش�.
	//�����ϰ��� �� ��忡 ���� �ִ� Ȥ�� �ּҰ��� �����͸� �����ϰ� �ٽ� delete�Լ��� ȣ���Ͽ�
	//�����ߴ� ���� ������ ������ �����ش�.
	public void deleteBST(Node node,int deleteKey)
	{
		Node p = searchBST(node,deleteKey);//�����ϰ��� �ϴ� ��带 ����
		Node q = searchParentBST(node,deleteKey);//�����ϰ��� �ϴ� ����� �θ��带 ����
		Node r;
		char flag;
		if(noNode(root) == 0)//Ʈ���� ����ִ°�� �Լ��� �����Ѵ�.
		{
			return;
		}
		if(noNode(root) == 1)//��Ʈ ��常 ����������� Ʈ���� �� Ʈ���� ������ش�.
		{
			root = null;
			return;
		}
		if(p.left == null && p.right == null)//�ڽ� ��� 0
		{
			if(q.left == p)	q.left = null;
			else	q.right = null;
		}
		else if(p.left == null || p.right == null)//�ڽ� ��� 1
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
			if(noNode(root) == 2)//�� ����� ���� 2���̰� �� �� ��Ʈ ��带 �����ϰ��� �ϴ� ���
			{
				if(root.right != null)	root.data = root.right.data;
				else	root.data = root.left.data;
				root.right = null;
				root.left = null;
			}
		}
		else if(p.left !=null && p.right != null)//�ڽ� ��� 2
		{
			if(height(p.left) > height(p.right))//���� Ʈ���� ���̰� �� ū ���
			{
				r = maxNode(p.left);//���� Ʈ������ �ִ밪�� ���Ѵ�.
				flag = 'L';
			}
			else if(height(p.left) < height(p.right))//������ Ʈ���� ���̰� �� ū ���
			{
				r = minNode(p.right);//������ Ʈ������ �ּҰ��� ���Ѵ�.
				flag = 'R';
			}
			else// �¿��� Ʈ���� ���̰� ���� ��� �� ���� �¿��� Ʈ���� ������ �����ش�.
			{
				if(noNode(p.left) >= noNode(p.right))//����� ���� ������ ���ų� �������
				{
					r = maxNode(p.left);//���� Ʈ������ �ִ밪�� ���Ѵ�.
					flag = 'L';
				}
				else//����� ���� �������� �� ���� ���
				{
					r = minNode(p.right);//������ Ʈ������ �ּҰ��� ���Ѵ�.
					flag = 'R';
				}
			}
			p.data = r.data;//�����Ϸ��� ��忡 ���� �ּ� Ȥ�� �ִ밪�� �����͸� �����Ѵ�.
			if(flag == 'L')	//���� Ʈ������ �ִ밪�� ���Ѱ��
			{
				deleteBST(p.left,r.data);//�����ϰ��� �ϴ� ����� �����ڽ� ������ Ž���Ͽ� ������ �����Ͱ��� ���� ��带 ã�� �����Ѵ�.
			}
			else //������ Ʈ������ �ּҰ��� ���Ѱ��
			{
				deleteBST(p.right,r.data);//�����ϰ��� �ϴ� ����� �������ڽ� ������ Ž���Ͽ� ������ �����Ͱ��� ���� ��带 ã�� �����Ѵ�.
			}
		}
	}
}
