//Qs: You are given a Doubly Linked List, write code to check if the list is Palindrome or not.
class Dnode{
    int data;
    Dnode left;
    Dnode right;
    Dnode(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class DLL {
    Dnode root;

    void create_list() {
        root = null;//indicates list is not created till now
    }

    void insert_left(int data) {
        Dnode n = new Dnode(data);
        if (root == null)//root is assigned not created
            root = n;
        else {
            n.right = root;//1
            root.left = n;//2
            root = n;//3
        }
    }


    void insert_right(int data) {
        Dnode n = new Dnode(data);
        if (root == null)//root is assigned not created
            root = n;
        else {
            Dnode t = root;//1
            while (t.right != null)//2
                t = t.right;//
            t.right = n;//3
            n.left = t;//4
        }
    }





    
    public static boolean isPalindrome(String str) {
        DLL dll = new DLL();
        dll.create_list();

        for (int i = 0; i < str.length(); i++) {
            dll.insert_right(str.charAt(i));
        }

        Dnode start = dll.root;
        Dnode end = dll.root;
        while (end.right != null) {
            end = end.right;
        }

        while (start != end && start.left != end) {
            if (start.data != end.data) {
                return false;
            }
            start = start.right;
            end = end.left;
        }

        return true;
    }
    
    public static void main(String[] args)
    {
        String str = "kanak";
        if(isPalindrome(str))
        {
            System.out.println("Yes");
        }
        
        else{
            System.out.println("No");
        }
        
    }
}