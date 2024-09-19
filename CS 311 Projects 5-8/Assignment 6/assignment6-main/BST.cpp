/**
 * Implementation of BST class.
 */
//You must complete the TODO parts and then complete LinkedList.cpp. Delete "TODO" after you are done.
//You should always comments to each function to describe its PURPOSE and PARAMETERS

// =======================================================
// Your name: Noah Boyd (TODO: Add your name)
// Compiler:  g++
// File type: cpp file BST.cpp
// @brief This class implements a BST search tree
//=======================================================

#include "BST.h"
#include <vector>
#include <iostream>
using namespace std;

/**
 * Implement the BST constructor
 */
BST::BST() {
    root = nullptr;
    numElements = 0;
}

/**
 * Implement the BST destructor
 */
BST::~BST() {
    // Must release memory correctly to avoid memory leaks
    clear();
}

/**
 * Implement size() correctly
 */
unsigned int BST::size() const {
     return numElements;
}

/**
 * Implement clear() correctly without memory leaks
 */
void BST::clear() {
    release(root);
    numElements = 0;
    root = nullptr;
}

void BST::release(Node *node) {
 
    if(!node) {
        return;
    }

    release(node->leftChild);
    release(node->rightChild);
    delete node;

}

/**
 * Implement insert() correctly
 */
bool BST::insert(T element) {
    if(!root) {
        root = new Node(element);
        numElements++;
        return true;
    }

    Node *temp = root;

    while(temp) {
        if(element > temp->data) {
            if(!temp->rightChild) {
                temp->rightChild = new Node(element);
                numElements++;
                return true;
            }

            temp = temp->rightChild;

        } else if (element < temp->data) {
            if(!temp->leftChild) {
                temp->leftChild = new Node(element);
                numElements++;
                return true;
            }
            
            temp = temp->leftChild;

        } else if (element == temp->data) {
            return false;
        }
    }
    
    return false;
}

/**
 * Implement find() correctly
 */
bool BST::find(const T &query) const {
    Node *temp = root;
    while(temp) {
        if(query == temp->data) {
            return true;
        } else if (query < temp->data) {
            temp = temp->leftChild;
        } else {
            temp = temp->rightChild;
        }
    }
    return false;
}

/**
 * Implement the height() function correctly
 */
int BST::height() const {
    return height(root);
}

int BST::height(Node *node) const {
    if(node == NULL)
        return -1;
    else return 1 + max(height(node->leftChild),height(node->rightChild));
}

/**
 * Implement the getRoot() function correctly
 */
BST::Node* BST::getRoot() {
    return root;
}

/**
 * @brief Print the subtree at node using inorder traversal
 * @param node a pointer to node in BST
 */
void BST::printInorder(Node* node) {
    //left, center right
    if(node == NULL)
        return;
    printPreorder(node->leftChild);
    cout << node->data;
    printPreorder(node->rightChild);
}

/**
* @brief Print the subtree at node using preorder traversal
* @param node a pointer to node in BST
*/
void BST::printPreorder(Node* node) {
    if(node == NULL)
        return;
    cout << node->data;
    printPreorder(node->leftChild);
    printPreorder(node->rightChild);
}

/**
* @brief Print the subtree at node using postorder traversal
* @param node a pointer to node in BST
*/
void BST::printPostorder(Node* node) {
    if(node == NULL)
        return;
    printPreorder(node->leftChild);
    printPreorder(node->rightChild);
    cout << node->data;
}

/**
 * Implement the getLeftMostNode() function correctly
 */
BST::Node *BST::getLeftMostNode() {
    
    return getLeftMostNode(root);
}

BST::Node *BST::getLeftMostNode(BST::Node *node) {
    if(node->leftChild == nullptr)
        return node;
    else
        return getLeftMostNode(node->leftChild);

}

/**
 * Implement the BST successor function correctly
 */
BST::Node *BST::successor(Node *node) {
    if(!root)
        return nullptr;
    
    if(node->rightChild != nullptr) {
        return getLeftMostNode(node->rightChild);
    }

    Node *parent = node->parent;

    while(parent != nullptr && node== parent->rightChild) {
        node = parent;
        parent = parent->parent;
    }
    return parent;
}

