# concurrent-word-count

A set of files (1.txt, 2.txt,..., 11.txt) is available on a server. Each file has a series of lines and you want to count the number of times a word appears in all files. A number is passed to the server and the corresponding file is returned.

We want to use a pool of fixed-sized threads (the number will be passed as an argument when executing the application).
Declare a class that implements `Callable <Integer>` and counts the number of times a word appears in a single file obtained from the server.

Declare a class that contains the main method and that uses an `ExecutorService` to execute `Callable <Integer>` tasks. Test
with 1 and 6 threads.

The word to look for, the server, the port (where the files are located) and the number of threads to use should be passed as arguments to move the application away.