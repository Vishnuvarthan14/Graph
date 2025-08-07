# Graph Algorithms in Java

This repository contains clean and well-documented implementations of core **graph algorithms** using Java. It is designed to help learners, students, and professionals understand the internal workings of popular graph-related concepts and algorithms.

 🚀 What's Included?

📌 Core Algorithms

1. Topological Sort (DFS-based and Kahn’s Algorithm)**
   - Detects ordering of tasks/nodes with dependencies
   - Useful in course scheduling, build systems

2. Prim’s Algorithm (Minimum Spanning Tree)**
   - Greedy algorithm using Priority Queue
   - Builds MST from any node using minimum edge weights

3. Kruskal’s Algorithm (Minimum Spanning Tree)**
   - Greedy approach using edge list + sorting
   - Uses Disjoint Set Union (DSU) to detect cycles

4. Disjoint Set Union (Union-Find)**
   - Optimized with Path Compression & Union by Rank
   - Used for Kruskal’s algorithm and cycle detection

---

### 🎯 Problem Implementations (With Solutions)

These Java-based problems reinforce concepts using real-world scenarios:

- `Course Schedule` (Leetcode 207) – uses Topological Sort
- `Number of Connected Components` – uses Union-Find
- `Redundant Connection` – cycle detection using DSU
- `Minimum Cost to Connect All Points` – Kruskal’s MST
- `Network Delay Time` – Dijkstra (extension)
- `Clone Graph` – BFS/DFS practice
- `Alien Dictionary` – Advanced topological sort

Check the `/problems` folder for full source code & comments.

---

## 📁 Project Structure

graph-algorithms-java/
│
├── algorithms/
│ ├── TopologicalSort.java
│ ├── PrimsAlgorithm.java
│ ├── KruskalsAlgorithm.java
│ ├── DisjointSetUnion.java
│
├── problems/
│ ├── CourseSchedule.java
│ ├── ConnectedComponents.java
│ ├── RedundantConnection.java
│ └── ...
│
├── README.md
└── utils/
└── GraphBuilder.java
