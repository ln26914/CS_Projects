/**
 * @brief Implementation of unionLinkedList and mergeLinkedList functions
 */
//You must complete the TODO parts and then complete LinkedList.cpp. Delete "TODO" after you are done.

#include "linkedlist.h"

/**
    * @brief Assume two linked lists that represent Set A and Set B respectively.
    * Compute the union A U B and return the result as a new linked list.
    *
    * @param LA Input linkedlist A as a set (no duplicated element)
    * @param LB Input linkedlist B as a set (no duplicated element)
    * @return LinkedList return the unioned linkedlist 
    */
LinkedList unionLinkedList(const LinkedList& LA, const LinkedList& LB) {
    //TODO: union function
    LinkedList *NewList = new LinkedList;
    Node *ptrA = LA.front;
    Node *ptrB = LB.front;

    while(ptrA != nullptr) {
        NewList->addRear(ptrA->val);
        ptrA = ptrA->next;
    }
    while(ptrB != nullptr) {
        if(!NewList->search(ptrB->val))
            NewList->addRear(ptrB->val);
        ptrB = ptrB->next;
    }

    return *NewList;
}


LinkedList mergeLinkedList(const LinkedList& LA, const LinkedList& LB) {
    //TODO: union function
    LinkedList *NewList = new LinkedList;
    Node *ptrA = LA.front;
    Node *ptrB = LB.front;

    //Iterate through both lists:
    while(ptrA != nullptr || ptrB != nullptr) {

        //List A is fully copied
        if(ptrA == nullptr) {
            //Add the new node
            NewList->addRear(ptrB->val);
            
            //Increment only ptrB
            ptrB = ptrB->next;
            continue;
        } 
        //List B is fully copied
        else if(ptrB == nullptr) {
            //Add the new node
            NewList->addRear(ptrA->val);

            //Increment only ptrA
            ptrA = ptrA->next;
            continue;
        }

        //Check if both lists have the same element
        else if(ptrA->val > ptrB->val) {
            
            //If B is smaller than A
            NewList->addRear(ptrB->val);
            NewList->addRear(ptrA->val);

            //Increment both
            ptrA = ptrA->next, ptrB = ptrB->next;
            continue;
        }
        else if(ptrA->val < ptrB->val) {

            //If A is smaller than B
            NewList->addRear(ptrA->val);
            NewList->addRear(ptrB->val);

            //Increment both
            ptrA = ptrA->next, ptrB = ptrB->next;
            continue;
        }
        //Same Value: Keep one
        else {
            //Add the value
            NewList->addRear(ptrA->val);
            NewList->addRear(ptrB->val);

            //Increment both
            ptrA = ptrA->next, ptrB = ptrB->next;
            continue;
        }
    }
    return *NewList;
}
