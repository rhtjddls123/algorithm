from collections import defaultdict

def solution(n, wires):
    nodes = defaultdict(list)
    for w in wires:
        nodes[w[0]].append(w[1])
        nodes[w[1]].append(w[0])
    
    def dfs(nodes, visited, node, count):
        visited.add(node)
        count[0] += 1
        for n in nodes[node]:
            if n not in visited:
                dfs(nodes, visited, n, count)
    
    result = float('inf')
    for w in wires:
        count = [0]
        nodes[w[0]].remove(w[1])
        nodes[w[1]].remove(w[0])
        visited = set()
        dfs(nodes, visited, w[0], count)
        b = n-count[0]
        result = min(result, abs(b-count[0]))
        nodes[w[0]].append(w[1])
        nodes[w[1]].append(w[0])
        count[0] = 0
    return result
        