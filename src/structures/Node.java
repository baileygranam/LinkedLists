package structures;

/**
 *  Provides the basic structure of a linked-list node
 *
 *  @author Daniel Plante
 *  @version 1.0   2 March 2002
 */
public class Node
{
    ///////////////////////////////////
    //           Properties          //
    ///////////////////////////////////
    private Object myData;
    private Node myNext;
    
    ///////////////////////////////////
    //             Methods           //
    ///////////////////////////////////
    
    /**
     *  Default constructor for a node with null
     *  data and pointer to a next node
     */
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
    public Node(Object datum)
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
    public Node(Object datum, Node next)
    {
        myData = datum;
        myNext = next;
    }
    
    // Accessor methods
    public void setData(Object datum)
    {
        myData = datum;
    }
    
    public Object getData()
    {
        return myData;
    }
    
    public void setNext(Node next)
    {
        myNext = next;
    }
    
    public Node getNext()
    {
        return myNext;
    }
}
    