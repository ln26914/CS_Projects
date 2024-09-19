#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    printf("hello world (pid:%d)\n", (int) getpid());
    int rc = fork();
    if(rc < 0) { // fork failed
        printf("Fork Failed!\n");
        fprintf(stderr, "Fork Failed!\n");
        exit(1);
    } else if(rc == 0) { // Child Process
        printf("I am child process. (pid:%d)\n", (int) getpid());
        sleep(1);
    } else { // Parent Process goes down this path
        wait(NULL);
        printf("I am parernt of %d. (pid:%d)\n", rc, (int) getpid());
    }
    return 0;
}