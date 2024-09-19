/**
 * @brief The implementation of the Linked List data structure
 */

//You must complete the TODO parts and then complete LinkedList.cpp. Delete "TODO" after you are done.

//- Make sure description and PARAMETER comments are given in detail
//  Highly recommended to copy HW3P1-help as PURPOSE of each function.
//  Add sufficient comments to your code body to describe what it does.
//      - Make sure all if-then-else are commented describing which case it is
//      - Make sure all local variables are described fully with their purposes

// ====================================================
//Your name: Noah Boyd (TODO: Add your name)
//Complier:  g++
//File type: linkedList.cpp implementation file
//=====================================================
#include <iostream>
#include "linkedlist.h"

using namespace std;

LinkedList::~LinkedList() {
    Node *temp1 = front;
    while(temp1 != nullptr) {
        Node *temp2 = temp1->next;
        delete temp1;
        temp1 = temp2;
    }
}

/**
 * @brief Purpose: Checks if the list is empty
 * @return true if the list is empty, false otherwise
 */
bool LinkedList::isEmpty() const {
    Node *temp1 = front;
    int count = 0;
    while(temp1 != nullptr) {
        count++;
        temp1 = temp1->next;
    }
    return count == 0;
} 

/**
 * @brief  Get the number of nodes in the list
 * @return int The number of nodes in the list
 */
int LinkedList::length() const{
    return count;
}

/**
 * @brief Convert the list to a string
 *
 */
string LinkedList::toString() {
    string str = "[";
    Node *ptr = front;
    if (ptr != nullptr) {
        // Head node is not preceded by separator
        str += to_string(ptr->val);
        ptr = ptr->next;
    }
    while (ptr != nullptr) {
        str += ", " + to_string(ptr->val);
        ptr = ptr->next;
    }
    str  += "]";
    return str;
}

/**
 * @brief Displays the contents of the list
 */
void LinkedList::displayAll() {
    cout << toString() << endl;
}

//TODO: Add comments
void LinkedList::addRear(T val) {
    if(isEmpty()) {
        //List has no elements.
        front = new Node(val);
        rear = front;
    }
    else {
        rear->next = new Node(val);
        rear = rear->next;
    }
    count++;
}

//TODO: Add comments
void LinkedList::addFront(T val) {
    if(isEmpty()) {
        //List has no elements.
        front = new Node(val);
        rear = front;
    }
    else {
        Node *ptr = front;
        front = new Node(val);
        front->next = ptr;
    }
    count++;
} 

//TODO: Add comments
bool LinkedList::deleteFront(T &OldNum) {
    // TODO: Add code here
    if(isEmpty()) {
        return false;
    }
    else if(front == rear) {
        delete front;
        front = nullptr, rear = nullptr;
        count--;
        return true;
    }
    else {
        Node *ptr = front;
        front = front->next;
        OldNum = ptr->val;
        delete ptr;
        count--;
        return true;
    }
} 

//TODO: Add comments
bool LinkedList::deleteRear(T &OldNum) {
    if(isEmpty()) {
        return false;
    } else if(front == rear) {
        OldNum = front->val;
        delete front;
        front = nullptr, rear = nullptr;
        count--;
        return true;
    } else {
        Node *ptr = front;
        while(ptr->next != rear) {
            ptr = ptr->next;
        }
        OldNum = rear->val;
        delete rear;
        rear = ptr;
        ptr->next = nullptr;
        count--;
        return true;
    }

} 

/* --- harder ones for test 2 and 3 -- */

/**
     * @brief Delete a node at a given position from the list. The
     * node at position pos is deleted and the value of the deleted node is returned in val.
     * The valid range of pos is 0 to count-1. if pos = 0, delete first node, and pos = count-1 delete last node.
     * @param pos: position of the node to be deleted
     * @param val: it is set to the value of the node to be deleted
     * @return true: if the node was deleted successfully
     * @return false: if the node was not deleted successfully because the position was out of range
    */
bool LinkedList::deleteAt(int pos, T &val) {
    //TODO: Add code here
    // check if the pos is valid first, then move the ptr to the rigth positon
    // consider the special case of deleting the first node and the last node
    // Do not forget to set value.
    if(pos < 0 || pos > count-1) {
        return false;
    } else if(isEmpty()) {
        return false;
    } else if(pos == count) {
        deleteRear(val);
    } else if(pos==0) {
        deleteFront(val);
    } else {
        Node *ptr = front;
        for(int i = 1; i < pos; i++) {
            ptr = ptr->next;
        }
        val = ptr->next->val;
        Node *qtr = ptr->next;
        ptr->next = qtr->next;
        delete qtr;
        count--;
    }
    return true;
}

/**
     * @brief Insert a value at a specified position in the list. The valid pos is in the range of 0 to count.
     * The value will be inserted before the node at the specified position. if pos = 0, the value will be inserted
     * at the front of the list. if pos = count, the value will be inserted at the rear of the list.
     * @param pos: position to insert the value at.
     * @param val: value to insert.
     * @return true: if the value was inserted.
     * @return false: if the value was not inserted because pos is out of the range.
     */
bool LinkedList::insertAt(int pos, T val) {
    //TODO: Add code here
    // check if the pos is valid first, then move the ptr to the rigth positon
    // consider the special case of inserting the first node and the last node
    if(pos < 0 || pos > count) return false;
    else if(pos == 0) addFront(val);
    else if(pos == count) addRear(val);
    else {
        Node *ptr = front;
        for(int i = pos; i >1; i--) {
            ptr = ptr->next;
        }
        Node *newNode = new Node(val);
        newNode->next = ptr->next;
        ptr->next = newNode;
        count++;
        
    }
    return true;
}

/**
 * @brief Copy Constructor to allow pass by value and return by value of a LinkedList
 * @param other LinkedList to be copied
 */
LinkedList::LinkedList(const LinkedList &other) {
    // Start with an empty list
    front = nullptr;
    rear = nullptr;
    count = 0;
    // TODO: Add code here. Interate through the other list and add a new node to this list
    // for each node in the other list. The new node should have the same value as the other node.

    Node *ptr = other.front;
    while(ptr != nullptr) {
        addRear(ptr->val);
        ptr = ptr->next;
    }
}

/**
 * @brief Overloading of = (returns a reference to a LinkedList)
 * @param other LinkedList to be copied
 * @return reference to a LinkedList
 */
LinkedList &LinkedList::operator=(const LinkedList &other) {
    if(this != &other) { // check if the same object
        // Delete all nodes in this list
        Node *qtr = front;
        while(qtr != nullptr) {
            Node *temp = qtr->next;
            delete qtr;
            qtr = temp;
        }
        // Interate through the other list and add a new node to this list
        // Be sure to set the front and rear pointers to the correct values
        front = nullptr;
        rear = nullptr;
        count = 0;
        Node *ptr = other.front;

    while(ptr != nullptr) {
        addRear(ptr->val);
        ptr = ptr->next;
    }
        // Be sure to set the count to the correct value
        count = length();
        // TODO: Add code here
    }
    return *this;
}

bool LinkedList::search(T Val) const {
    if(isEmpty()) {
        return false;
    }
    Node *ptr = front;
    while(ptr->next != nullptr) {
        if(ptr->val == Val) {
            return true;
        } else {
            ptr = ptr->next;
        }
    }
    return false;
}



