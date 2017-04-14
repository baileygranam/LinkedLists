package structures;

/**
 *  A class to provide the basic methods of a singly linked list.
 *  Note that it is simplified in that it does not implement or extend
 *  List, Collection, etc.  It is for learning the basics of Linked
 *  Lists.
 *
 *  @author Daniel Plante
 *  @author Bailey Granam
 *  
 *  @version 1.0   2 March 2002
 *  @version 1.1   19 November 2013
 *  @version 1.2   13 April 2017
 */
public class LinkedList<E>
{
    /////////////////////////////
    //         Properties      //
    /////////////////////////////
    private Node<E> myHead;
    private int mySize;
    
    /////////////////////////////
    //         Methods         //
    /////////////////////////////
    
    /**
     *  Default constructor that creates an empty linked list
     *
     *  <pre>
     *  pre:  the linked list is empty
     *  post: the linked list is empty
     *  </pre>
     */
    public LinkedList()
    {
        myHead = null;
        mySize = 0;
    }
    
    /**
     *  Constructor that creates a new linked list with a single 
     *  node storing the object passed in
     *
     *  <pre>
     *  pre:  myHead points to null (the linked list is empty)
     *  post: myHead points to the only node in the linked list,
     *        that node holding the object passed in
     *  </pre>
     *
     *  @param datum an object to be inserted at the head of the
     *         linked list
     */
    public LinkedList(E datum)
    {
        myHead = new Node<E>(datum);
        myHead.setNext(null);
        mySize++;
    }
    
    /**
     *  Adds a node to the head of the linked list; the special
     *  condition of an empty linked list is handled without
     *  special treatment since if myHead points to null, that
     *  simply becomes the next node in the list, immediately
     *  following the new entered node at the head of the list
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     *  </pre>
     *
     *  @param node the node to be entered
     */
    private void addFirst(Node<E> node)
    {
        node.setNext(myHead);
        myHead = node;
        mySize++;
    }
    
    /**
     *  Adds a node to the head of the linked list; the special
     *  condition of an empty linked list is handled without
     *  special treatment since if myHead points to null, that
     *  simply becomes the next node in the list, immediately
     *  following the new entered node at the head of the list
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     *  </pre>
     *
     *  @param datum the object used to create a new node to be 
     *         entered at the head of the list
     */
    public void addFirst(E datum)
    {
        Node<E> node;
        
        node = new Node<E>(datum);
        this.addFirst(node);
    }
    
    /**
     *  Adds a node to the tail of the linked list; the special
     *  condition of an empty linked list is handled separately
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     *  </pre>
     *
     *  @param node the node to be entered
     */
    private void addLast(Node<E> node)
    {
        Node<E> lastNode;
        
        if(myHead==null)
        {
            this.addFirst(node);
            mySize++;
        }
        else
        {
            lastNode = this.getPrevious(null);
            lastNode.setNext(node);
            node.setNext(null);
            mySize++;
        }
    }
    
    /**
     *  Adds a node to the tail of the linked list; the special
     *  condition of an empty linked list is handled separately
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     *  </pre>
     *
     *  @param datum the object used to create a new node to be 
     *         entered at the tail of the list
     */
    public void addLast(E datum)
    {
        Node<E> node;
        
        node = new Node<E>(datum);
        this.addLast(node);
    }
    
    /**
     *  Deletes a node from the list if it is there
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     *  </pre>
     *
     *  @param node the node to be deleted from the list
     *
     *  @return boolean indicating whether or not the node
     *          was deleted
     */
    private boolean remove(Node<E> node)
    {
        /**
         * Assign the node parameter passed through to Node<E> variable, myRemoveNode.
         */
        Node<E> myRemoveNode = node;
        
        /**
         * If the node passed through is null then return false.
         */
        if(myRemoveNode == null)
        {
            return false;
        }
        
        /** 
         * If the node passed through does not exist in the linked 
         * list then return false.
         */
        if(!this.contains(myRemoveNode.getData()))
        {
            return false;
        }

        /**
         * If the head is null then we are unable to remove the node and will return false.
         */
        if(myHead == null) 
        {
            return false;
        }
        
        Node<E> myPreviousNode = this.getPrevious(node);
        Node<E> myNextNode     = node.getNext();
        
        /**
         * If the node that was passed in has a previous node value equal to null
         * then this means the node passed through is possibly the head. Before we complete 
         * any further operations we must see if the myNextNode is null
         * or if it exists.
         */
        if(myPreviousNode == null)
        {
            /** 
             * If the previous node is null (checked in the previous statement above) 
             * and the next node after myRemoveNode is null then it is likely that the
             * head is indeed the node to be removed. Just to be 100% sure we will also
             * check that myRemoveNode is equal to myHead.
             */
            if((myNextNode == null) && (myRemoveNode == getHead()))
            {
                mySize--;
                this.setHead(null);
                return true; 
            }
            /**
             * If there is a node after the head then we will remove the first node in the 
             * list and re-establish a new head as the next node.
             */
            else 
            {
                mySize--;
                this.setHead(myNextNode);
                return true;
            }
        }
        
        /**
         * If the head was not the node then the node to be removed in somewhere else in 
         * the linked list. We already checked to see if myPreviousNode is null. If we
         * reached this point then myPreviousNode has a value. We must now check to see
         * if myNextNode is the tail (null). If it is the tail then we will remove it
         * and return true.
         */
        if(myNextNode == null)
        {
            myPreviousNode.setNext(null);
            mySize--;
            return true;
        }
        /**
         * If the next node has a value then this means the node we are looking to remove
         * in somewhere in the list that is neither the head or tail. In this case we can
         * simply set the previous node to point to the next node, thus removing the node
         * we originally wanted to remove. Return true in this case.
         */
        else 
        {
            myPreviousNode.setNext(myNextNode);
            mySize--;
            return true; 
        }        
    }
    
    /**
     *  Deletes a node from the list if it is there
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     *  </pre>
     *
     *  @param datum the object to be deleted from the list
     *
     *  @return boolean indicating whether or not the node
     *          was deleted
     */
    public boolean remove(E datum)
    {
        Node<E> myRemoveNode = findNode(datum);
        return this.remove(myRemoveNode);
    }
    
    /**
     *  Find a node in the list with the same data as that passed in 
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     *  </pre>
     *
     *  @param datum the object for which a node is to be found 
     *         in the list
     *
     *  @return null if a node with the given object datum is not in
     *          the list, or the node if it does
     */
    private Node<E> findNode(E datum)
    {
        Node<E> currentNode;
        E currentDatum;
        
        currentNode = getHead();
        currentDatum = null;
        
        while(currentNode != null)
        {
            currentDatum = currentNode.getData();
            if(currentDatum.equals(datum))
            {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    
    /**
     *  Determine if a node exists in the list with the same 
     *  data as that passed in 
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     *  </pre>
     *
     *  @param datum the object for which a node is to be found 
     *         in the list
     *
     *  @return false if a node with the given object datum is not in
     *          the list, or true if it does
     */
    public boolean contains(E datum)
    {
        if(datum == null && myHead == null)
        {
            return true;
        }
        else if(findNode(datum) == null)
        {
            return false;
        }
        else
        {
            return true;
        } 
    }
    
    /**
     *  Determines the node that resides one closer to the
     *  head of the list than the node passed in
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: the list is unchanged
     *  </pre>
     *
     *  @param node the node whose predecessor is being looked for
     *
     *  @return the node that resides one closer to the head of the
     *          list than the node passed in
     */
    private Node<E> getPrevious(Node<E> node)
    {
        Node<E> currentNode;
        
        currentNode = myHead;
        
        if(currentNode.equals(node))
        {
            return null;
        }
        
        while(currentNode!=null && currentNode.getNext() != node)
        {
            currentNode = currentNode.getNext();
        }
        
        return currentNode;
    }
    
    /**
     *  A new node is entered into the list immediately before
     *  the designated node
     *
     *  <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the beforeNode is not in the list, no change
     *        takes place to the list; otherwise, the new
     *        node is entered in the appropriate place
     *  </pre>
     *
     *  @param node the node to be entered into the list
     *  @param beforeNode the node before which the new node
     *         is to be entered
     *
     *  @return boolean designating if the node was or was not
     *          entered into list
     */
    private boolean insertBefore(Node<E> node, Node<E> beforeNode)
    {
        if(beforeNode == null)
        {
            return false;
        }
        else
        {
            Node<E> myNextNode = beforeNode.getNext();
            beforeNode.setNext(node);
            node.setNext(myNextNode);
            mySize++;
            return true;
        }    
    }
    
    /**
     *  A new node with datum is entered into the list immediately
     *  before the node with beforeDatum, the designated node
     *
     *  <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the node with beforeDatum is not in the list, 
     *        no change takes place to the list; otherwise, a new
     *        node is entered in the appropriate place with the 
     *        object datum
     *  </pre>
     *
     *  @param datum the object used to create the new node 
     *         to be entered into the list
     *  @param beforeDatum the datum of the node before which the 
     *         new node is to be entered
     *
     *  @return boolean designating if the node was or was not
     *          entered
     */
    public boolean insertBefore(E datum, E beforeDatum)
    {
        Node<E> myNode     =   new Node<E>(datum);
        Node<E> myBeforeNode = findNode(beforeDatum);

        return insertBefore(myNode,myBeforeNode);
    }
    
    /**
     *  print the list by converting the objects in the list
     *  to their string representations
     *
     *  <pre>
     *  pre:  the list has 0 or more elements
     *  post: no change to the list
     *  </pre>
     */
    public String toString()
    {
        String string;
        Node<E> currentNode;
        
        currentNode = myHead;
        
        string = "head ->";
        
        while(currentNode!=null)
        {
            string += currentNode.getData().toString()+ " -> ";
            currentNode = currentNode.getNext();
        }
        string += "|||";
        return string;
    }

    /**
     * Method to find the index of a specific node given the datum of 
     * that node.
     * 
     * @param o the data of the node we are looking for
     * @return the index of which the node is located in the linked list
     */
    public int indexOf(E o)
    {
        if(o==null)
        {
            return -1;
        }
        if(this.findNode(o) == null)
        {
            return -1;
        }
        else
        {
            Node<E> myNode        = findNode(o);
            Node<E> myCurrentNode = myHead;
            int index             = 0;
            
            while(myCurrentNode != myNode)
            { 
                myCurrentNode = myCurrentNode.getNext();
                index++;
            }
            return index;
        }
    }

    /**
     * Method to easily remove the first node in the linked list. If the linked list
     * has a null head then return null. Otherwise remove the first node.
     * 
     * @return the value of the removed node
     */
    public E removeFirst()
    {
        if(myHead == null)
        {
            return null;
        }
        else
        {
            E myFirstNode = this.getFirst();
            remove(myFirstNode);
            return myFirstNode;
        }
    }
    
    /**
     * Method to easily remove the last node in the linked list. If the linked list
     * has a null head then return null. Otherwise remove the last node.
     * 
     * @return the value of the removed node
     */
    public E removeLast()
    {
        if(myHead == null)
        {
            return null;
        }
        E myLastNode = this.getLast();
        remove(myLastNode);
        return myLastNode;
    }

    /**
     * Method to return the size of the linked list.
     * 
     * @return list size
     */
    public int size()
    {
        return mySize;
    }

    /**
     * Method that gets the datum of the first node in the linked list.
     * @return datum of first node
     */
    public E getFirst()
    {
        // If the linked list is empty return null
        if(myHead == null)
        {
            return null;
        }
        // Return datum of the first node in the linked list
        else
        {
            return getHead().getData();
        }
    }
    
    /**
     * Method that gets the datum of the last node in the linked list.
     * @return datum of last node
     */
    public E getLast()
    {
        Node<E> myLastNode = myHead;
        
        // If the linked list is empty return null
        if(myHead == null)
        {
            return null;
        }        
        
        // Loop through the linked list until reaching the end. Return the datum of the last node.
        for(Node<E> myStart = myHead; myStart != null; myStart = myStart.getNext())
        {
           if(myStart.getNext() == null)
           {
               myLastNode = myStart;
           }
        }
        
        return myLastNode.getData();
    }

    /**
     * Method that inserts a node at the beginning of the list.
     * @param o datum to be inserted into linked list at the beginning
     */
    public void setFirst(E o)
    {
        if(myHead == null)
        {
            this.addFirst(o);
        }
        else 
        {
            Node<E> mySetFirst = new Node<E>(o);
            this.setHead(mySetFirst);
        }
    }
    
    /**
     * Method to set the head of the linked list
     * @param node to be set as the head
     */
    private void setHead(Node<E> node)
    {
        myHead = node;
    }
    
    /**
     * Method to get the head of the linked list
     * @return head of list
     */
    private Node<E> getHead()
    {
        return myHead;
    }
    
    private class Node<T>
    {
        ///////////////////////////////////
        //           Properties          //
        ///////////////////////////////////
        private T myData;
        private Node<T> myNext;
        
        ///////////////////////////////////
        //             Methods           //
        ///////////////////////////////////
        
        /**
         *  Default constructor for a node with null
         *  data and pointer to a next node
         */
        @SuppressWarnings("unused")
        public Node()
        {
            myData = null;
            myNext = null;
        }
        
        /**
         *  Constructor for a node with some object for
         *  its data and null for a pointer to a next node
         *
         *  <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        null for a pointer to a next node
         *  </pre>
         *
         *  @param datum an object for the node's data
         */
        public Node(T datum)
        {
            myData = datum;
            myNext = null;
        }
        
        /**
         *  Constructor for a node with some object for 
         *  its data and a pointer to another node
         *
         *  <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        a pointer to a next node
         *  </pre>
         *
         *  @param datum an object for the node's data
         *  @param next the node that this node points to
         */
        @SuppressWarnings("unused")
        public Node(T datum, Node<T> next)
        {
            myData = datum;
            myNext = next;
        }
        
        // Accessor methods
        @SuppressWarnings("unused")
        public void setData(T datum)
        {
            myData = datum;
        }
        
        public T getData()
        {
            return myData;
        }
        
        public void setNext(Node<T> next)
        {
            myNext = next;
        }
        
        public Node<T> getNext()
        {
            return myNext;
        }
    }
}
