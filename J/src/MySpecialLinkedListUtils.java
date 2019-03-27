
public class MySpecialLinkedListUtils
{
	public static double [] summary(Node head)
	{
		double []s=new double [5];
		for(int i=0;i<5;i++)
		{
			s[i]=0;
		}
		Node current=head;
		if(head==null)
		{
			return s;
		}
		s[3]=head.value;
		s[4]=head.value;
		while(current!=null)
		{
			s[0]+=current.value;
			s[1]++;
			if(current.value>s[3])
			{
				s[3]=current.value;
			}
			if(s[4]<current.value)
			{
				s[4]=current.value;
			}
			current=current.next;
		}
		s[1]=s[0]/s[1]*1.0;
		s[2]=median(head).value;
		return s;
		
	}
	public static Node median(Node head)
	{
		if(head==null)
		{
			return null;
		}
		Node a=head;
		Node b=head.next;
		while(b!=null&&b.next!=null)
		{
			a=a.next;
			b=b.next.next;
		}
		return a;
	}
	public static Node reverse(Node head)
	{
		if(head==null||head.next==null)
		{
			return head;
		}
		Node temp= reverse(head.next);
		head.next.next=head;
		head.next=null;
		return temp;
	}
	public static Node evenIndexedElements(Node head)
	{
		if(head==null)
		{
			return null;
		}
		Node head2=new Node(head.value);
		Node current2=head2;
		Node current=head;
		int i=0;
		while(current!=null)
		{
			if(i%2==0&&current!=head)
			{
				current2.next=new Node(current.value);
				current2=current2.next;
			}
			i++;
			current=current.next;
		}
		return head2;
	}
	public static Node insertionsort(Node head)
	{
		Node sorted=new Node(0);
		Node current=head;
		while(current!=null)
		{
				Node j=sorted;
				Node current2=new Node(current.value);
				while(j.next!=null&&j.next.value<current.value)
				{
					j=j.next;
				}
				current2.next=j.next;
				j.next=current2;
				current=current.next;
		}
		return sorted.next;
	}
	public static Node mergesort(Node head)
	{
		if(head==null||head.next==null)
		{
			return head;
		}
		Node mid=median(head);
		Node secondhalf=mid.next;
		mid.next=null;
		return merge(mergesort(head),mergesort(secondhalf));
	}
	public static Node merge(Node a,Node b)
	{
		Node temp=new Node(-1);
		Node f=temp;
		while(a!=null&&b!=null)
		{
			if(a.value<b.value)
			{
				temp.next=a;
				a=a.next;
			}
			else
			{
				temp.next=b;
				b=b.next;
			}
			temp=temp.next;
		}
		temp.next=(a==null)?b:a;
		return f.next;
	}
	public static Node removeCentralNode(Node head)
	{
		Node central=median(head);
		Node current =head;
		while(current!=null)
		{
			if(current.next==central)
			{
				current.next=current.next.next;
				break;
			}
			current=current.next;
		}
		return head;
	}
	public static boolean palindrome(Node head)
	{
		Node secondhalf=median(head).next;
		Node firsthalf=head;
		while(secondhalf!=null)
		{
			if(firsthalf.value!=secondhalf.value)
			{
			
				return false;
			}
			firsthalf=firsthalf.next;
			secondhalf=secondhalf.next;
		}
		
		return true;
	}
	public static void show(Node head)
	{
		Node current=head;
		while(current!=null)
		{
			System.out.println(current.value);
			current=current.next;
		}
	}

}
