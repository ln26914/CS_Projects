/**
 * Assignment 4: Producer Consumer Problem
 * @file buffer.cpp
 * @author Noah Boyd and Sebastian Rojas
 * @brief Implementation file for the buffer class
 * @version 0.1
 */

// You must complete the all parts marked as "TODO". Delete "TODO" after you are
// done. Remember to add sufficient and clear comments to your code
#include "buffer.h"
#include <iostream>
using namespace std;

// Implemented Buffer Class Here

/*
Developer Noah here! This file appears to compile without issue! As for logic
problems, that will be revealed when we develop main.cpp

Send me a discord message at shinespark_ if you need my help with anything!
*/

// Constructor
Buffer::Buffer(int size) {
  this->size = size;
  this->count = 0;
  this->front = 0;
  this->back = -1;
  this->buffer[0] = 0;
}

// Destructor to remove item in the buffer
Buffer::~Buffer() {

  buffer_item removable;

  while (!is_empty()) {
    remove_item(&removable);
  }
}
// Insert Item
bool Buffer::insert_item(buffer_item item) {

  // If the buffer is full, return false since no more items can be inserted
  // into buffer
  if (is_full()) {
    return false;
  }
  // Push item into the buffer
  // Increment Count
  back = (back + 1) % size;
  buffer[back] = item;
  count++;
  return true;
}

// Remove Item. Removes first instance of parameter
bool Buffer::remove_item(buffer_item *item) {
  // If the buffer is empty, return false since nothing can be removed from
  // buffer
  if (is_empty()) {
    return false;
  }
  *item = buffer[front];
  front = (front + 1) % size;
  count--; // Decrement Count
  return true;
}

// Get Buffer Size
int Buffer::get_size() { return this->size; }

// Get Item Count
int Buffer::get_count() { return this->count; }

// Is Buffer Empty?
bool Buffer::is_empty() { return this->count == 0; }

// Is Buffer Full?
bool Buffer::is_full() { return this->count == this->size - 1; }

// Print Buffer
void Buffer::print_buffer() {
  // print function that allows for the buffer to be shown in the format of the
  // example_out.txt
  cout << "[";
  for (int i = front, elements = 0; elements < count;
       i = (i + 1) % size, ++elements) {
    if (elements > 0) {
      cout << ", ";
    }
    cout << buffer[i];
  }
  cout << "]\n";
}
