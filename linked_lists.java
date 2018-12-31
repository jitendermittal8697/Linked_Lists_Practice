import jdk.nashorn.internal.ir.ReturnNode;

//package ll_practice;

public class linked_lists
{
    int data;
    linked_lists next;
    int frequency = 0;
    linked_lists(){
        System.out.println("Object Created");
    }

    linked_lists(int data){
        this.data = data;
        this.next = null;
    }

    void ll_traversal(linked_lists head){
        if(head == null)
        {
            System.out.println("\nLists is Empty !! Kindly call ll_create() first ");
        }
        else
        {
            linked_lists ptr;
            ptr = head;
            System.out.println();
            while(ptr!=null)
            {
                System.out.print(ptr.data + " -> ");
                ptr = ptr.next;
            }
        }
    }

    linked_lists ll_create(){
        linked_lists head = new linked_lists(1);
        linked_lists node1 = new linked_lists(2);
        linked_lists node2 = new linked_lists(3);
        linked_lists node3 = new linked_lists(4);
        linked_lists node4 = new linked_lists(5);
        linked_lists node5 = new linked_lists(6);
        linked_lists node6 = new linked_lists(7);
        linked_lists node7 = new linked_lists(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        return head;
    }

    linked_lists ll_delete(linked_lists head){
        if(head==null)
        {
            System.out.println("List is already Empty !!!");
        }
        else
        {
            head = null;
            System.out.println("\nList Deleted !!!");
        }
        return head;
    }

    void ll_status(linked_lists head){
        if(head==null)
        {
            System.out.println("\nlist is empty");
        }
        else
        {
            int count = ll_count_elements(head);
            System.out.println("\nlist has now " + count + " elements");
        }
    }

    int ll_count_elements(linked_lists head){
        int count = 0;
        linked_lists ptr = head;
        while(ptr!=null)
        {
            count++;
            ptr = ptr.next;
        }
        return count;
    }

    linked_lists ll_reverse(linked_lists head){
        linked_lists p=null,c=head,n;
                
        while(c != null)
        {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        head = p;
        return head;
    }

    linked_lists ll_delete_key(linked_lists head,int key){
        if(head.data == key)
        {
            head = head.next;
        }
        else
        {
            linked_lists node = head;
            linked_lists temp;
            while(node != null)
            {
                if(node.next.data == key)
                {
                    temp = node.next;
                    node.next = temp.next;
                    break;
                }
                node = node.next;
            }
        }
        return head;
    }

    linked_lists ll_delete_position(linked_lists head,int position){
        if(position <=0)
        {
            System.out.println("\nEnter Position between 1 and " + ll_count_elements(head));
        }
        else
        {
            if(position == 1)
            {
                head = head.next;
            }
            else
            {
                linked_lists node = head;
                linked_lists prev = null;
                while(position !=1)
                {
                    prev = node;
                    node = node.next;
                    position--;
                    if(node == null)
                    {
                        System.out.println("Position should be smaller than " + ll_count_elements(head));
                        return head;
                    }
                }
                prev.next = node.next;
            }
        }
        return head;
    }

    int  ll_count_elements_recursive(linked_lists head){
        if(head == null)
        {
            return 0;
        }
        else
        {
            return 1 + ll_count_elements_recursive(head.next);
        }
    }

    void Search(linked_lists head , int key){
        boolean found = false;
        linked_lists node = head;
        int position = 0;
        while(node != null)
        {
            position++;
            if(node.data == key )
            {
                found = true;
                System.out.println("\nFound Status : " + found);
                System.out.println("\nNode Found At Position : " + position);
            }
            node = node.next;
        }
        if(found == false)
        {
            System.out.println("Found Status : " + found);
        }
    }

    int get_Nth_node(linked_lists head, int n){
        linked_lists node = head;
        if(n<=0)
        {
            System.out.println("\nPlease Enter Value between 1 and " + ll_count_elements_recursive(head));
            return -1;
        }
        else
        {
            while(node != null)
            {
                node = node.next;
                n--;
                if(node == null && n > 1)
                {
                    System.out.println("\nPlease Enter Value between 1 and " + ll_count_elements_recursive(head));
                    return -1;
                }
                if(n==1)
                {
                    return node.data;
                }

            }
        }
        return -1;
    }

    int get_Nth_node_recursive(linked_lists head, int n){
        if(n<=0 || head == null)
        {
            System.out.println("\nEnter correct range");
            return -1;
        }
        if(n==1)
            return head.data;
        else
            return get_Nth_node_recursive(head.next, n-1);
    }

    int get_Nth_node_From_End_Count_method(linked_lists head, int n){
        
        linked_lists node = head;
        int count = 0;
        while(node != null)
        {
            count++;
            node = node.next;
        }
        if(n<=0 || n>count)
        {
            System.out.println("Enter Value Between 1 and " + count);
            return -1;
        }
        node = head;
        for(int i = 1 ; i < count - n + 1 ; i++)
        {
            node = node.next;
        }
        return node.data;
    }

    int get_Nth_node_From_End_Two_Ptr_Method(linked_lists head,int n){
        linked_lists ptr1;
        linked_lists ptr2;
        ptr1 = head;
        ptr2 = head;
        if(n<=0)
        {
            System.out.println("\nEnter Value Between 1 and " + ll_count_elements(head));
            return -1;
        }
        while(n>0)
        {
            if(ptr2 == null)
            {
                System.out.println("\nEnter Value Between 1 and " + ll_count_elements(head));
                return -1;
            }
            n--;
            ptr2 = ptr2.next;
        }
        while(ptr2 != null)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1.data;
    }

    int get_mid_count_method(linked_lists head){
        
        if(head==null)
        {
            System.out.println("List Empty");
            return -1;
        }
        else
        {
            int count = 0;
            linked_lists node = head;
            while(node != null)
            {
                node = node.next;
                count++;
            }
            node = head;
            for(int i = 1 ; i < (count)/2 + 1 ; i++)
            {
                node = node.next;
            }
            return node.data;
        }
    }

    int get_mid_two_ptr_method(linked_lists head){
        if(head == null)
        {
            System.out.println("List Empty");
            return -1;
        }
        else
        {
            linked_lists ptr1 = head;
            linked_lists ptr2 = head;
            while(ptr2 != null && ptr2.next != null)
            {
                ptr2 = ptr2.next.next;
                ptr1 = ptr1.next;
            }
            return ptr1.data;
        }
    }

    int get_mid_two_ptr_even_jump_method(linked_lists head){
        if(head == null)
        {
            return -1;
        }
        else
        {
            linked_lists ptr1 = head;
            linked_lists ptr2 = head;
            int count = 1;
            while(ptr2 != null)
            {
                if(count % 2 == 0)
                {
                    ptr1 = ptr1.next;
                }
                count++;
                ptr2 = ptr2.next;
            }
            return ptr1.data;
        }
    }

    int frequency_of_key(linked_lists head, int key){
        linked_lists node = head;
        int count = 0;
        while(node!=null)
        {
            if(node.data == key)
            {
                count++;
            }
            node = node.next;
        }
        return count;
    }

    int frequency_of_key_recursive(linked_lists head, int key){
        if(head==null)
            return frequency;
        if(head.data == key)
            frequency++;    
        return frequency_of_key_recursive(head.next, key);    
    }

    int frequency_of_key_without_global_var_recursive(linked_lists head, int key){
        
        /*if(head==null)
        {
            return 0;
        }
        if(head.data == key)
        {
            return 1 + frequency_of_key_without_global_var_recursive(head.next, key);
        }

        return frequency_of_key_without_global_var_recursive(head.next, key);
        */

        if(head ==null)
        {
            return 0;
        }
        int frequency = frequency_of_key_without_global_var_recursive(head.next, key);
        if(head.data == key)
        {
            return frequency + 1;
        }

        return frequency;
    }

    public static void main(String... args)
    {
        linked_lists obj = new linked_lists(); //object for calling functions
        linked_lists head = null; //head of list
        
        head = obj.ll_create(); //creation of list and initialisation of head 
        obj.ll_traversal(head); //traversal of empty list
           
    }
}