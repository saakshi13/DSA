//Qs: You are given a Singly Linked List, write code to check if the list is Palindrome or not.
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
public class Linear_Linked_List
{
    Node root;
    void create_list()
    {
        root=null;
    }
    void insert_left(int data)
    {
        Node n=new Node(data);
        if(root==null)
            root=n;
        else {
            n.next=root;//1
            root=n;//2
        }
    }

    void insert_right(int data)
    {
        Node n=new Node(data);
        if(root==null)
            root=n;
        else {
            Node t=root;//1
            while(t.next!=null)//2
            {
                t = t.next;//
            }
            t.next=n;//3
        }
    }
    
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false; 
        }

        Linear_Linked_List sll = new Linear_Linked_List();
        sll.create_list();

        for (int i = 0; i < str.length(); i++) {
            sll.insert_right(str.charAt(i));
        }

        
        char[] arr = new char[str.length()];
        Node temp = sll.root;
        int index = 0;
        while (temp != null) {
            arr[index++] = (char) temp.data;
            temp = temp.next;
        }

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    
    
    public static void main(String args[])
    {
        String str = "nayan";
        if(isPalindrome(str))
        {
            System.out.println("Yes");
        }
        
        else
        {
            System.out.println("No");
        }
       
    }

    }