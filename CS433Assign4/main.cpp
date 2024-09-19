/**
 * Assignment 4: Producer Consumer Problem
 * @file main.cpp
 * @author Noah Boyd and Sebastian Rojas
 * @brief The main program for the producer consumer problem.
 * @version 0.1
 */
// You must complete the all parts marked as "TODO". Delete "TODO" after you are
// done.
//  Remember to add sufficient and clear comments to your code
#include "buffer.h"
#include <iostream>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

using namespace std;

// global buffer object
Buffer buffer;
pthread_mutex_t mutex;
sem_t full;  // semaphore for count when full
sem_t empty; // semaphore for count when empty

// Producer thread function
void *producer(void *param) {
  // Each producer insert its own ID into the buffer
  // For example, thread 1 will insert 1, thread 2 will insert 2, and so on.
  buffer_item item = *((int *)param);

  while (true) {
    /* sleep for a random period of time */
    usleep(rand() % 1000000);
    sem_wait(&empty);           // wait for empty opening
    pthread_mutex_lock(&mutex); // Lock for critical section
    if (buffer.insert_item(item)) {
      cout << "Producer " << item << ": Inserted item " << item << endl;
      buffer.print_buffer();
    } else {
      cout << "Producer error condition" << endl; // shouldn't come here
    }                                             // End of if/else
    pthread_mutex_unlock(&mutex); // Unlock after critical section
    sem_post(&full);              // send when buffer is full
  }
}

// Consumer thread function
void *consumer(void *param) {
  buffer_item item;

  while (true) {
    /* sleep for a random period of time */
    usleep(rand() % 1000000);
    sem_wait(&full);            // wait for when full
    pthread_mutex_lock(&mutex); // Lock for critical section
    if (buffer.remove_item(&item)) {
      cout << "Consumer " << item << ": Removed item " << item << endl;
      buffer.print_buffer();
    } else {
      cout << "Consumer error condition" << endl; // shouldn't come here
    }                                             // End of if/else block
    pthread_mutex_unlock(&mutex); // Unlock after critical section
    sem_post(&empty);             // send when buffer is not at max size
  }
}

int main(int argc, char *argv[]) {
  /* 1. Get command line arguments argv[1],argv[2],argv[3] */

  // all three command line arguments
  int sleepPeriod = atoi(argv[1]);
  int producersNum = atoi(argv[2]);
  int consumersNum = atoi(argv[3]);

  /* 2. Initialize buffer and synchronization primitives */

  pthread_mutex_init(&mutex, NULL);
  sem_init(&full, 0, 0); // full semaphore initalized to 0
  sem_init(&empty, 0,
           5); // empty semaphore initalized to the size of the buffer(5)

  pthread_t producerThread[producersNum]; // producer thread
  pthread_t consumerThread[consumersNum]; // consumer thread

  /* 3. Create producer thread(s).
   * You should pass an unique int ID to each producer thread, starting from 1
   * to number of threads */
  for (int i = 0; i < producersNum; i++) {
    pthread_create(&producerThread[i], NULL, &producer, (void *)&i);
  }

  /* 4. Create consumer thread(s) */
  for (int i = 0; i < consumersNum; i++) {
    pthread_create(&consumerThread[i], NULL, &consumer, NULL);
  }
  /* 5. Main thread sleep */
  // sleep for a period of time
  sleep(sleepPeriod);

  /* 6. Exit */
  return 0;
}
