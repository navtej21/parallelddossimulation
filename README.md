<h1 align="center">🚀 Parallel Simulation of DDoS Attack Detection and Mitigation</h1>
<h3 align="center">Using Queue-Based Filtering and Parallel Programming</h3>

<hr/>

<h2>📌 Overview</h2>
<p>
Distributed Denial of Service (DDoS) attacks overwhelm servers by flooding them with a massive number
of malicious requests, resulting in high latency, service unavailability, and potential system crashes.
</p>

<p>
This project implements a <b>parallel, queue-based simulation system</b> that detects and mitigates DDoS
attacks <b>before requests reach the server</b>. A detailed comparison between
<b>sequential (single-threaded)</b> and <b>parallel (multi-threaded)</b> execution is performed to
analyze performance improvements on multi-core systems.
</p>

<p>
The primary focus is on <b>system design, parallelism, scalability, and performance measurement</b>,
making this project highly aligned with <b>systems and performance-oriented roles</b>.
</p>

<hr/>

<h2>🎯 Objectives</h2>
<ul>
  <li>Simulate legitimate and malicious (DDoS) traffic safely</li>
  <li>Filter requests using a queue-based mechanism</li>
  <li>Apply parallel programming to improve throughput</li>
  <li>Compare sequential vs parallel performance</li>
  <li>Measure execution time, server load, and scalability</li>
  <li>Demonstrate effective use of multi-core CPUs</li>
</ul>

<hr/>

<h2>🏗️ System Architecture</h2>

<pre>
Request Generator
        ↓
Bounded Request Queue
        ↓
Parallel Filter Workers
        ↓
Decision Engine
   ↙            ↘
Accept        Drop
   ↓
Simulated Server
</pre>

<p>
All incoming requests are first placed into a bounded queue. Multiple parallel worker threads
analyze each request using rate-based heuristics. Malicious requests are dropped early,
while valid requests are forwarded to the simulated server.
</p>

<hr/>

<h2>⚙️ Key Features</h2>
<ul>
  <li><b>Queue-Based Filtering:</b> Prevents server overload during traffic bursts</li>
  <li><b>Dynamic Rate Limiting:</b> Adaptive thresholds based on queue size</li>
  <li><b>Parallel Processing:</b> Multiple worker threads process requests concurrently</li>
  <li><b>Server Load Simulation:</b> Models real server processing delays</li>
  <li><b>Bounded Queue Protection:</b> Prevents memory exhaustion</li>
  <li><b>Detailed Metrics:</b> Tracks accepted, dropped, and misclassified requests</li>
</ul>

<hr/>

<h2>🔬 Comparison Study: Sequential vs Parallel</h2>

<h3>Sequential Execution</h3>
<ul>
  <li>Single filtering thread</li>
  <li>Requests processed one at a time</li>
  <li>High queue wait time under DDoS load</li>
  <li>Poor scalability</li>
</ul>

<h3>Parallel Execution</h3>
<ul>
  <li>Multiple worker threads</li>
  <li>Concurrent request analysis</li>
  <li>Lower latency and faster queue drainage</li>
  <li>Efficient multi-core utilization</li>
</ul>

<hr/>

<h2>📊 Performance Metrics</h2>
<ul>
  <li>Total execution time (ms)</li>
  <li>Sequential vs parallel speedup</li>
  <li>Accepted legitimate requests</li>
  <li>Dropped malicious requests</li>
  <li>False positives and false negatives</li>
  <li>Server load under attack</li>
</ul>

<hr/>

<h2>📈 Sample Results</h2>

<pre>
Sequential Execution Time : 5420 ms
Parallel Execution Time   : 1820 ms
Speedup Achieved          : ~3x
</pre>

<p>
Parallel processing significantly reduces execution time while maintaining similar detection accuracy,
demonstrating the effectiveness of parallel filtering under high traffic load.
</p>

<hr/>

<h2>🛠️ Technologies Used</h2>
<ul>
  <li><b>Language:</b> Java</li>
  <li><b>Concurrency:</b> Java Multithreading (ExecutorService)</li>
  <li><b>Data Structures:</b> BlockingQueue, ConcurrentHashMap, Atomic variables</li>
  <li><b>Simulation:</b> Custom traffic and server workload modeling</li>
</ul>

<hr/>

<h2>🚀 How to Run</h2>
<ol>
  <li>Clone the repository</li>
  <li>Compile the Java files</li>
  <li>Run <code>Main.java</code></li>
  <li>Observe sequential and parallel performance metrics</li>
</ol>

<hr/>

<h2>📌 Why No Machine Learning?</h2>
<p>
This project intentionally avoids machine learning to focus on
<b>deterministic, low-latency filtering</b>. ML models introduce inference overhead
and require extensive training data, which may not be ideal for
real-time mitigation during high-volume DDoS attacks.
</p>

<hr/>

<h2>🔮 Future Enhancements</h2>
<ul>
  <li>Machine learning-based adaptive detection</li>
  <li>Real-time deployment support</li>
  <li>Integration with firewall or IDS systems</li>
  <li>Hardware acceleration and OpenMP implementation</li>
  <li>Large-scale distributed simulations</li>
</ul>

<hr/>

<h2>✅ Conclusion</h2>
<p>
This project demonstrates that <b>parallel, queue-based request filtering</b> is an effective
strategy for mitigating DDoS attacks. The comparison study clearly shows that
parallel programming significantly improves throughput and scalability while maintaining
detection accuracy.
</p>

<p>
The system provides a strong foundation for real-world DDoS mitigation solutions
and aligns well with modern multi-core processor architectures.
</p>

<hr/>

<h2 align="center">📌 Author</h2>
<p align="center">
<b>Navtej S. Nair</b><br/>
M.Tech Integrated Software Engineering<br/>
VIT Chennai
</p>
