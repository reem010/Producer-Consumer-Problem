# ProducerConsumerProblem

<html>

<body>
  <p>
    In this system, we simulate a real-life scenario of how buffering works to obtain prime numbers. The user specifies a value N, and the system generates prime numbers from 0 to N. The simulation utilizes multiple threads to perform concurrent operations, reducing the overall elapsed time.
  </p>
  
  <h2>Buffering Process</h2>
  <p>
    The system consists of a producer and a consumer thread. The producer schedules prime numbers in a queue, while the consumer thread writes these primes to a file. By using multiple threads, the application can perform multiple actions simultaneously, improving efficiency.
  </p>
  
  <h3>Producer Thread</h3>
  <ul>
    <li>The producer generates prime numbers from 0 to N.</li>
    <li>It schedules these prime numbers in a queue, ready for consumption by the consumer thread.</li>
  </ul>
  
  <h3>Consumer Thread</h3>
  <ul>
    <li>The consumer thread acquires a lock at the start to ensure exclusive access to the shared resources.</li>
    <li>It writes the prime numbers from the ready queue to a file.</li>
    <li>If the ready queue becomes empty, the consumer thread releases the lock, notifies all other threads, and waits for the producer to populate the queue again.</li>
  </ul>
  
</body>
<h3> Sample </h3> <br>
</html>

![image](https://user-images.githubusercontent.com/108128985/205487629-7a27eee2-b833-4457-9484-6227b1926f9c.png)


