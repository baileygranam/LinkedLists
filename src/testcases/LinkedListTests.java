package testcases;

import static org.junit.Assert.*;
import structures.*;

import org.junit.Before;
import org.junit.Test;

/**
 *  Test cases utilized in ensuring the quality of the LinkedList class.
 *  
 *  @due 04/14/2017
 *
 *  @author Bailey Granam
 *  
 */

public class LinkedListTests 
{
    private LinkedList<String> myLinkedList;
    private boolean myCheck;

    @Before
    public void setUp() 
    {
        myLinkedList = new LinkedList<String>();
    }
    
    /**
     * Checks to make sure that if a node passed through to be removed is not 
     * in the linked list then it can not be removed. 
     */
    @Test
    public void testIfNonExistantNodeRemoved()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Matthew");
        
        myCheck = myLinkedList.remove("Plante");
        
        assertFalse("A node that is not in the linked list should not be able to be removed.", myCheck);
    }
    
    /**
     * Checks to make sure that if a null parameter is passed through to be removed 
     * it returns false. Simply because you should not be able to remove a null
     * value. 
     */
    @Test
    public void testIfRemoveNull()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Matthew");

        myCheck = myLinkedList.remove(null);
        
        assertFalse("A null value/paramter should not be able to be removed.", myCheck);
    }
    
    /**
     * Checks to make sure that when the only node in the linked list is removed (the head) 
     * that it removes successfully and that when we try to get the first node in the list 
     * it returns null as we should have removed the head.
     */
    @Test
    public void testIfRemovedOnlyNodeInLinkedList()
    {
        myLinkedList.addFirst("Bailey");
        
        myCheck = (myLinkedList.getFirst() == "Bailey");
        
        myLinkedList.remove("Bailey");
        
        /**
         * When we added the node to the linked list it should have been the first node. Next
         * when we removed the node the head/first item in the list should return as null as 
         * it no longer exists. If both these cases are true then we successfully removed 
         * the head.
         */
        myCheck = ((myCheck) && (myLinkedList.getFirst() == null) && myLinkedList.contains("Bailey") == false);
        
        assertTrue("The only node in the list (the head) should have been removed!", myCheck);    
    }
    
    /**
     * Test to check if the head is removable when there are other nodes in the linked list. 
     */
    @Test
    public void testIfRemovedHeadNode() 
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Kim");
        myLinkedList.addFirst("Matthew");
        
        myLinkedList.remove("Matthew");
        
        myCheck = (myLinkedList.getFirst() == "Kim" && !myLinkedList.contains("Matthew"));
                
        assertTrue("The first node in the linked list should have been removed and replaced "
                + "with the next node in the list.", myCheck);
    }
    
    /**
     * This test case checks to make sure that the tail node is removed properly. We first
     * add three nodes. Next we remove the last node. This means the new tail should be 'Mimi'. 
     */
    @Test
    public void testIfRemovedTailNode()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Kim");
        myLinkedList.addFirst("Matthew");
        
        myLinkedList.remove("Bailey");
        
        myCheck = (myLinkedList.getLast() == "Mimi" && !myLinkedList.contains("Bailey"));
        
        assertTrue("The last node (the tail) in the linked list should have been removed!", myCheck);
    }
    
    /**
     * The purpose of this test case is to make sure that when the node is neither the head or tail
     * that it is still removed. I.e if the node is somewhere in the middle of the linked list, it 
     * can still be removed.
     */
    @Test
    public void testIfRemoveOneNode()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Kim");
        myLinkedList.addFirst("Matthew");
        
        myCheck = (myLinkedList.remove("Mimi") && !myLinkedList.contains("Mimi"));
        
        assertTrue("The node should have successfully been removed!", myCheck); 
    }
    
    /**
     * Similar to the previous test, we want to make sure that nothing goes wrong when we attempt
     * to remove multiple nodes.
     */
    @Test 
    public void testIfRemoveMultipleNodes()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Robert");
        myLinkedList.addFirst("Kim");
        myLinkedList.addFirst("Matthew");
        
        boolean myCheckOne = (myLinkedList.remove("Mimi") && myLinkedList.remove("Robert") && myLinkedList.remove("Kim"));
        boolean myCheckTwo = (myLinkedList.contains("Mimi") && myLinkedList.contains("Robert") && myLinkedList.contains("Kim"));
        
        myCheck = myCheckOne && !myCheckTwo;
        
        assertTrue("Multiple nodes should have successfully been removed!", myCheck); 
    }
    
    /**
     * The purpose of this test case is to make sure that a node can not be removed twice when 
     * there are no duplicate nodes.
     */
    @Test
    public void testIfRemoveNodeTwice()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Matthew");
        
        myCheck = (myLinkedList.remove("Bailey") && myLinkedList.remove("Bailey"));
        
        assertFalse("It should not be possible to remove the same node twice when there are no duplicates.", myCheck);
    }
    
    /**
     * This test makes sure that even when there are two nodes with the same datum, only one node is removed.
     */
    @Test
    public void testIfRemoveDuplicateNode()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Matthew");
        
        myLinkedList.remove("Mimi");
        
        myCheck = (myLinkedList.contains("Mimi"));
        
        assertTrue("Only one node should have been removed even though their is a duplicate.", myCheck); 
    }
    
    /**
     * This test checks to see if the contains() method in the LinkedList class returns true
     * when a specific node exists in the list.
     */
    @Test
    public void testIfListContainsSpecificNode()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Matthew");
        
        myCheck = (myLinkedList.contains("Mimi"));
        
        assertTrue("The list should contain a node with the specificed value.", myCheck); 
    }
    
    /**
     * Similar to the previous test, this checks to see if a node is not
     * in the list. 
     */
    @Test
    public void testIfListDoesNotContainSpecificNode()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Matthew");
        
        myCheck = (myLinkedList.contains("Pug"));
        
        assertFalse("The list should not contain the node specific but is saying it does anyways.", myCheck); 
    }
    
    /**
     * If the linked list contains null this means the head is null.
     */
    @Test
    public void testIfListContainsNull()
    {
        myCheck = myLinkedList.contains(null);
        
        assertTrue("The list should contain a null as the head is null.", myCheck);
    }
    
    /**
     * Test to make sure that the contains method works for multiple nodes in a list.
     */
    @Test
    public void testIfListContainsMultiple()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Matthew");
        
        myCheck = (myLinkedList.contains("Mimi") && myLinkedList.contains("Matthew") && myLinkedList.contains("Bailey"));
        
        assertTrue("The list should contain multiple nodes with the specificed value.", myCheck); 
        
    }
    
    /**
     * Test to make sure that when the before value is a null the node is not inserted into the 
     * list. We first check to make sure the node attempted to be inserted returns false
     * and that the list does not contain the node we tried to add. 
     */
    @Test
    public void testIfInsertBeforeNull()
    {
       boolean myCheckOne = (myLinkedList.insertBefore("Bailey", null));
       boolean myCheckTwo = (myLinkedList.contains("Bailey"));
       
       myCheck = !(myCheckOne == myCheckTwo);
        
       assertFalse("Should not be able to insert a node when the before node is a null.", myCheck);
    }
    
    /**
     * This test makes sure that if we try inserting a node where the previous node does not exist in the
     * list then the insertion should fail/return false.
     */
    @Test
    public void testIfInsertBeforeImaginaryNode()
    {
        myLinkedList.addFirst("Bailey");
        
        myCheck = (myLinkedList.insertBefore("Pug", "Bob") && !myLinkedList.contains("Pug"));
        
        assertFalse("Should not be able to insert a node when the previous node is not in the list.", myCheck);  
    }
    
    /**
     * The following test checks to make sure that a node is correctly inserted after the previous 
     * node defined. For example, if the previous node is "Bailey" and we want to insert a node with
     * "Pug" it should execute. Additionally the linked list should now contain a node with datum "Pug"
     * and the index of the node with datum "Pug" should be 1 as it is now the second node in the list. 
     */
    @Test
    public void testIfInsertBeforeOneNode() 
    {
        myLinkedList.addFirst("Bailey");
        
        myCheck = (myLinkedList.insertBefore("Pug", "Bailey") && 
                   myLinkedList.contains("Pug") &&
                   myLinkedList.indexOf("Pug") == 1);
        
        assertTrue("Should be able to insert a node when the previous node exists in the list.", myCheck);  
    }
    
    /**
     * This test ensures that we can still insert a node at a point such as when the previous node is 
     * the tail. We check to see that it is inserted (returns true). Next we make sure the list contains
     * the datum "Austin" and that the node we inserted is at the tail index which in this case is 3.
     */
    @Test
    public void testIfInsertBeforeTailNode()
    {
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        myCheck = (myLinkedList.insertBefore("Austin", "Bailey") &&
                   myLinkedList.contains("Austin") &&
                   myLinkedList.indexOf("Austin") == 3);
        
        assertTrue("Should be able to insert a node when the previous node is the tail!", myCheck);
    }
    
    /**
     * The purpose of this test is to make sure that when a null datum is passed through
     * that it returns an index of -1 meaning it does not exist. 
     */
    @Test
    public void testIfIndexEmptyForNullDatum()
    {
        myCheck = (myLinkedList.indexOf(null) == -1);
        
        assertTrue("The index of a null datum should not exist!", myCheck);
    }
    
    /**
     * The purpose of this test is to make sure that when we try to get the index
     * of a datum in a linked list that does not exist it returns -1. 
     */
    @Test
    public void testIfIndexExistsForNonExistantDatum()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        // myCheckEvaluates to true in the case that the index of a non-existent node is equal to -1. 
        myCheck = (myLinkedList.indexOf("taco") == -1);
        
        // Assert true that datum/nodes that do not exist in the list should not have an index in the list.
        assertTrue("The index for a non-existant node should not exist!", myCheck);  
    }
    
    /**
     * The purpose of this test is to make sure that when there are multiple nodes in a list
     * that the {@link LinkedList#indexOf} method returns the correct index of the given datum of a node. 
     */
    @Test
    public void testIfIndexExistsForDatum()
    {
        // Add/create node to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        // myCheck evaluates to true if the index of the node with datum "Mimi" is equal to index 1. 
        myCheck = (myLinkedList.indexOf("Mimi") == 1);
        
        assertTrue("The index of a node in the second position of a linked list should be 1.", myCheck);
    }
    
    /**
     * The purpose of this test is to make sure that the {@link LinkedList#indexOf} method returns the correct 
     * index of the head/first node in the list. 
     */
    @Test
    public void testIfIndexExistsForHead()
    {
        // Add/create node to the linked list
        myLinkedList.addFirst("Bailey");
        
        // myCheck evaluates to true if the first node in the list (with datum "Bailey") has an index of 0. 
        myCheck = (myLinkedList.indexOf(myLinkedList.getFirst()) == 0);
        
        // Assert true that the head/first node in the list should have an index of 0.
        assertTrue("The index of the head/first node in the list should be 0.", myCheck);
    }
    
    /**
     * Test to make sure the {@link LinkedList#indexOf} method returns the correct index for the tail of the list which
     * should be the size of the list - 1 as the index starts at zero. 
     */
    @Test
    public void testIfIndextExistsForTail()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        // myCheck evaluates to true if the tail of the linked list has the correct index. 
        // Index of tail should be equal to the size of list - 1. 
        myCheck = (myLinkedList.indexOf(myLinkedList.getLast()) == myLinkedList.size() - 1);
        
        assertTrue("The index of the tail/last node in the list should be equal to the size of the list.", myCheck);
    }
    
    /**
     * This test ensures that even after a node is removed the index of another node is still accurate/updated.
     */
    @Test
    public void testIfCorrectIndexAfterRemovedNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Josh");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        // Get the index of the node with the datum "Josh".
        int myIndex = myLinkedList.indexOf("Josh");
        
        // After removing a node from the list, the index of the node containing "Josh" should change.
        myLinkedList.remove("Mimi");
        
        /**
         * myCheck evaluates to true if the index of the node with datum "Josh" is equal to the node's 
         * original index minus 1. 
         */
        myCheck = (myLinkedList.indexOf("Josh") == myIndex - 1);
        
        // After removing a node from the list, the index of the node containing "Josh" should change again. 
        myLinkedList.remove("Sam");
        
        /**
         * myCheck evaluates to true if myCheck is true in the first declaration AND the index of node with
         * datum "Josh" is now equal to the original index minus 2. 
         */
        myCheck = (myCheck && myLinkedList.indexOf("Josh") == myIndex - 2);
        
        // Assert true if in both instances the index of the node changed correctly when removing nodes.
        assertTrue("The index of the datum should have properly changed after removing a node", myCheck);
    }
    
    /**
     * This test ensures that even after a node is added the index of another node is still accurate/updated.
     */
    @Test
    public void testIfCorrectIndexAfterAddNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Josh");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        // Get the index of the node with the datum "Josh".
        int myIndex = myLinkedList.indexOf("Josh");
        
        // After adding a node to the list, the index of the node containing "Josh" should change.
        myLinkedList.addFirst("Mike");
        
        /**
         * myCheck evaluates to true if the index of the node with datum "Josh" is equal to the node's 
         * original index plus 1. 
         */
        myCheck = (myLinkedList.indexOf("Josh") == myIndex + 1);
        
        // After adding another node to the list, the index of the node containing "Josh" should change again. 
        myLinkedList.addFirst("Mason");
        
        /**
         * myCheck evaluates to true if myCheck is true in the first declaration AND the index of node with
         * datum "Josh" is now equal to the original index plus 2. 
         */
        myCheck = (myCheck && myLinkedList.indexOf("Josh") == myIndex + 2);
        
        // Assert true if in both instances the index of the node changed correctly when adding nodes.
        assertTrue("The index of the datum should have properly changed after adding a node", myCheck);
    }
    
    /**
     * The purpose of this case is to make sure the {@link LinkedList#size} method returns the correct
     * size of a linked list populated with nodes. I.e a list with 1 node returns a size of 1. 
     */
    @Test
    public void testIfCorrectSizeOne()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        
        // Get the size of the linked list
        int mySize = myLinkedList.size();
        
        // myCheck will be equated to true if mySize is equal to 1, and false otherwise. 
        myCheck = (mySize == 1);
        
        // Assert true that mySize (the size of the list) should be equal to 1 when the list has 1 node.
        assertTrue("The size() method in the LinkedList class should return the correct size of the list.", myCheck); 
    }
    
    /**
     * The purpose of this case is to make sure the {@link LinkedList#size} method returns the correct
     * size of a linked list populated with nodes. I.e a list with 4 nodes returns a size of 4. 
     */
    @Test
    public void testIfCorrectSize()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Josh");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        // Get the size of the linked list
        int mySize = myLinkedList.size();
        
        // myCheck will be equated to true if mySize is equal to 4, and false otherwise. 
        myCheck = (mySize == 4);
        
        // Assert true that mySize (the size of the list) should be equal to 4 when the list has 4 nodes.
        assertTrue("The size() method in the LinkedList class should return the correct size of the list.", myCheck); 
    }
    
    /**
     * This test case checks to confirm that when we call the {@link LinkedList#size} method
     * on an empty linked list that it returns a value of 0. The value returned from size 
     * indicates the size of the list. 
     */
    @Test
    public void testIfCorrectSizeEmptyList()
    {
        // Get the size of the linked list
        int mySize = myLinkedList.size();
        
        // myCheck will be equated to true if mySize is equal to 0, and false otherwise.
        myCheck = (mySize == 0);
        
        // Assert true that mySize (the size of the list) should be equal to 0 in the case that the linked list is empty.
        assertTrue("The size of the linked list should be zero when there are no nodes in the list", myCheck);
    }
    
    /**
     * This test case checks to ensure that when we remove a node from the linked list the
     * {@link LinkedList#size} method is correctly reflected by this change. I.e if the 
     * linked list has a size of 3 and we remove a node then it is now a size of 2. 
     * 
     * I.e Original size - 1 should be equal to new size as we removed a node. 
     */
    @Test
    public void testIfCorrectSizeAfterRemovingNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Sam");
        myLinkedList.addFirst("Mimi");
        
        // Get the size of the linked list
        int mySize = myLinkedList.size();
        
        // Remove a node from the linked list with a given datum
        myLinkedList.remove("Sam");
        
        /**
         * myCheck will be equated to true if the original size of the linked list
         * subtracted by 1 is equal to the new size of the linked list after removing
         * the node.
         */
        myCheck = ((mySize - 1) == myLinkedList.size());
        
        // Assert true that the original size of the list minus 1 is equal to the new size of the list after removing a node.
        assertTrue("The size of the link list should change when nodes are removed.", myCheck);
    }
    
    /**
     * This test case checks to ensure that when we add a node from the linked list the
     * {@link LinkedList#size} method is correctly reflected by this change. I.e if the 
     * linked list has a size of 2 and we add a node then it is now a size of 3. 
     * 
     * I.e Original size + 1 should be equal to new size as we added a node. 
     */
    @Test
    public void testIfCorrectSizeAfterAddingNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Sam");
        myLinkedList.addFirst("Mimi");
        
        // Get the size of the linked list
        int mySize = myLinkedList.size();
        
        // Add a node to the linked list with a given datum
        myLinkedList.addFirst("Plante");
        
        /**
         * myCheck will be equated to true if the original size of the linked list
         * added by 1 is equal to the new size of the linked list after adding
         * the node.
         */
        myCheck = ((mySize + 1) == myLinkedList.size());
        
        // Assert true that the original size of the list plus 1 is equal to the new size of the list after adding a node.
        assertTrue("The size of the link list should change when nodes are added.", myCheck);
    }
    
    /**
     * The purpose of this case is to ensure that the first node is removed when calling 
     * the {@link LinkedList#removeFirst} method.
     */
    @Test
    public void testIfRemoveFirstNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        /**
         * myCheck evaluates to true if the {@link LinkedList#removeFirst} method returns 
         * the datum of the first node removed AND the first node in the linked list is now 
         * the node that was next to the head. 
         */
        myCheck = (myLinkedList.removeFirst() == "Sam" && myLinkedList.getFirst() == "Mimi");
        
        // Assert true when the first node is correctly removed through the {@link LinkedList#removeFirst} method. 
        assertTrue("The first node in the list should have been removed!", myCheck); 
    }
    
    /**
     * The purpose of this case is to ensure that the {@link LinkedList#removeFirst} method
     * returns null when trying to remove the first element of an empty linked list/head.
     */
    @Test
    public void testIfRemoveFirstNodeNull()
    { 
        /**
         * myCheck evaluates to true if the {@link LinkedList#removeFirst} method returns null.
         */
        myCheck = (myLinkedList.removeFirst() == null);
        
        // Assert true when {@link LinkedList#removeFirst} method returns null because the list is empty. 
        assertTrue("You should not be able to remove the first node of an empty linked list/head!", myCheck); 
    }
    
    /**
     * The purpose of this case is to ensure that the first node is removed when calling 
     * the {@link LinkedList#removeFirst} method multiple times.
     */
    @Test
    public void testIfRemoveMultipleFirstNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Mike");
        myLinkedList.addFirst("Emily");
        myLinkedList.addFirst("Sam");
        
        /**
         * myCheck evaluates to true if the {@link LinkedList#removeFirst} method returns 
         * the datum of the first node removed AND the first node in the linked list is now 
         * the node that was next to the head. 
         */
        myCheck = (
                   (myLinkedList.removeFirst() == "Sam" && myLinkedList.getFirst() == "Emily") &&
                   (myLinkedList.removeFirst() == "Emily" && myLinkedList.getFirst() == "Mike") &&
                   (myLinkedList.removeFirst() == "Mike" && myLinkedList.getFirst() == "Mimi")
                  );
        
        // Assert true when multiple first nodes are correctly removed through the {@link LinkedList#removeFirst} method. 
        assertTrue("The multiple first nodes should have been removed.", myCheck); 
    }
    
    /**
     * The purpose of this case is to ensure that the last node is removed when calling 
     * the {@link LinkedList#removeLast} method.
     */
    @Test
    public void testIfRemoveLastNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Sam");
        
        /**
         * myCheck evaluates to true if the {@link LinkedList#removeLast} method returns 
         * the datum of the last node removed AND the last node in the linked list is now 
         * the node that was previous to the tail.
         */
        myCheck = (myLinkedList.removeLast() == "Bailey" && myLinkedList.getLast() == "Mimi");
        
        // Assert true when the last node is correctly removed through the {@link LinkedList#removeLast} method. 
        assertTrue("The last node in the list should have been removed!", myCheck); 
    }
    
    /**
     * The purpose of this case is to ensure that the {@link LinkedList#removeLast} method
     * returns null when trying to remove the last element of an empty linked list.
     */
    @Test
    public void testIfRemoveLastNodeNull()
    { 
        /**
         * myCheck evaluates to true if the {@link LinkedList#removeLast} method returns null.
         */
        myCheck = (myLinkedList.removeLast() == null);
        
        // Assert true when {@link LinkedList#removeLast} method returns null because the list is empty. 
        assertTrue("You should not be able to remove the last node of an empty linked list!", myCheck); 
    }
    
    /**
     * The purpose of this case is to ensure that the last node is removed when calling 
     * the {@link LinkedList#removeLast} method multiple times.
     */
    @Test
    public void testIfRemoveMultipleLastNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Mimi");
        myLinkedList.addFirst("Mike");
        myLinkedList.addFirst("Emily");
        myLinkedList.addFirst("Sam");
        
        /**
         * myCheck evaluates to true if the {@link LinkedList#removeLast} method returns 
         * the datum of the last node removed AND the last node in the linked list is now 
         * the node that was next to the head. 
         */
        myCheck = (
                   (myLinkedList.removeLast() == "Bailey" && myLinkedList.getLast() == "Mimi") &&
                   (myLinkedList.removeLast() == "Mimi" && myLinkedList.getLast() == "Mike") &&
                   (myLinkedList.removeLast() == "Mike" && myLinkedList.getLast() == "Emily")
                  );
        
        // Assert true when multiple last nodes are correctly removed through the {@link LinkedList#removeLast} method. 
        assertTrue("The multiple last nodes should have been removed.", myCheck); 
    }
    
    /**
     * Test to check that the {@link LinkedList#getFirst} returns the correct first node in the linked list.
     */
    @Test
    public void testIfGetFirstNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Sam");
        
        // myCheck will be equated to true if the first node is equal to "Sam", and false otherwise. 
        myCheck = (myLinkedList.getFirst() == "Sam");
        
        // Assert true that the method {@link LinkedList#getFirst} returns the accurate datum of the first node.
        assertTrue("Should have returned the correct first node but did not.", myCheck);  
    }
    
    /**
     * Test to check that the {@link LinkedList#getFirst} returns the correct first node in the linked list after multiple times.
     */
    @Test
    public void testIfGetMultipleFirstNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Plante");
        myLinkedList.addFirst("ElAarag");
        myLinkedList.addFirst("Sam");
        
        // myCheck will be equated to true if the first node is equal to "Sam", and false otherwise. 
        myCheck = (myLinkedList.getLast() == "Sam");
        
        // Remove the first node
        myLinkedList.removeFirst();
        
        // myCheck will be equated to true if myCheck is true AND the new first node is equal to "ElAarag". False otherwise.
        myCheck = (myLinkedList.getFirst() == "ElAarag");
        
        // Assert true that the method {@link LinkedList#getFirst} returns the accurate datum of the first node.
        assertTrue("Should have returned the correct first node multiple times but did not.", myCheck);  
    }
    
    /**
     * Test to check that the {@link LinkedList#getFirst} returns null for an empty linked list.
     */
    @Test
    public void testIfGetNullFirstNode()
    {
        // myCheck will be equated to true if the first node is equal to null, false otherwise.
        myCheck = (myLinkedList.getFirst() == null);
        
        // Assert true that the method {@link LinkedList#getFirst} returns null for an empty list.
        assertTrue("Should have returned null as the first node does not exist in the linked list.", myCheck);  
    }
    
    /**
     * Test to check that the {@link LinkedList#getLast} returns the correct last node in the linked list.
     */
    @Test
    public void testIfGetLastNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Sam");
        
        // myCheck will be equated to true if the last node is equal to "Bailey", and false otherwise. 
        myCheck = (myLinkedList.getLast() == "Bailey");
        
        // Assert true that the method {@link LinkedList#getLast} returns the accurate datum of the last node.
        assertTrue("Should have returned the correct last node but did not.", myCheck);  
    }
    
    /**
     * Test to check that the {@link LinkedList#getLast} returns the correct last node in the linked list after multiple times.
     */
    @Test
    public void testIfGetMultipleLastNode()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Plante");
        myLinkedList.addFirst("ElAarag");
        myLinkedList.addFirst("Sam");
        
        // myCheck will be equated to true if the last node is equal to "Bailey", and false otherwise. 
        myCheck = (myLinkedList.getLast() == "Bailey");
        
        // Remove the last node
        myLinkedList.removeLast();
        
        // myCheck will be equated to true if myCheck is true AND the new last node is equal to "Plante". False otherwise.
        myCheck = (myLinkedList.getLast() == "Plante");
        
        // Assert true that the method {@link LinkedList#getLast} returns the accurate datum of the last node.
        assertTrue("Should have returned the correct last node multiple times but did not.", myCheck);  
    }
    
    /**
     * Test to check that the {@link LinkedList#getLast} returns null for an empty linked list.
     */
    @Test
    public void testIfGetNullLastNode()
    {
        // myCheck will be equated to true if the last node is equal to null, false otherwise.
        myCheck = (myLinkedList.getLast() == null);
        
        // Assert true that the method {@link LinkedList#getLast} returns null for an empty list.
        assertTrue("Should have returned null as the last node does not exist in the linked list.", myCheck);  
    }
    
    /**
     * Test to check that the {@link LinkedList#setFirst} method sets a node so 
     * that it is now the first node.
     */
    @Test
    public void testIfSetFirst()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Plante");
        myLinkedList.addFirst("ElAarag");
        myLinkedList.addFirst("Sam");
        
        // Set the new first node of the linked list.
        myLinkedList.setFirst("Bob");
        
        // myCheck will equate to true if the first node is now equal to "Bob".
        myCheck = (myLinkedList.getFirst() == "Bob");
        
        // Assert true when we successfully set a datum to be the first in the linked.
        assertTrue("The first node in the linked list should be that of the datum we set first.", myCheck);
    }
    
    /**
     * Test to check that the {@link LinkedList#setFirst} method correctly sets a node as the first, multiple times.
     */
    @Test
    public void testIfSetFirstMultiple()
    {
        // Add/create nodes to the linked list
        myLinkedList.addFirst("Bailey");
        myLinkedList.addFirst("Plante");
        myLinkedList.addFirst("ElAarag");
        myLinkedList.addFirst("Sam");
        
        // Set the first node
        myLinkedList.setFirst("Matthew");
        
        // myCheck evaluates to true if the first node is equal to the node we set first.
        myCheck = (myLinkedList.getFirst() == "Matthew");
        
        // Set the first node, again.
        myLinkedList.setFirst("Emily");
        
        // myCheck evaluates to true if the first check is true and the first node is now equal to the node we set first
        myCheck = (myCheck && myLinkedList.getFirst() == "Emily");
                
        // Assert true when we successfully set a node as the first using the {@link LinkedList#setFirst} method multiple times
        assertTrue("The new node should have been able to be set multiple times.", myCheck);
    }
    
    /**
     * This test is to confirm that even if a linked list has a null head we may still
     * use the {@link LinkedList#setFirst} method to set a datum as the first node in the list.
     */
    @Test
    public void testIfSetFirstNullHead()
    {    
        // Set the new first node of the linked list.
        myLinkedList.setFirst("Bailey");
        
        // myCheck will equate to true if the first node is now equal to "Bailey".
        myCheck = (myLinkedList.getFirst() == "Bailey");
        
        // Assert true when we successfully set a datum to be the first in the linked list.
        assertTrue("The first node in the linked list should be set even with the head originally being null.", myCheck); 
    }
    
    /**
     * Test to make sure we can successfully set the first node in the list to null
     */
    @Test
    public void testIfSetFirstNullDatum()
    {
        // Add node to list
        myLinkedList.addFirst("Sam");
        
        // Set the new first node of the linked list.
        myLinkedList.setFirst(null);
        
        // myCheck will equate to true if the first node in the linked list is now equal to null.
        myCheck = (myLinkedList.getFirst() == null);
        
        // Assert true that the linked list was able to set the first node as null.
        assertTrue("You should be able to set the first node as null.", myCheck); 
    } 
    
}
