/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
    
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        Node deepCopy = new Node(node.val);
        map.put(node, deepCopy);
        q.add(node);
        
        while(!q.isEmpty()){  // T.C - V+E
            Node curr = q.poll();
            List<Node> list = curr.neighbors;
            for(Node li : list){
                if(!map.containsKey(li)){
                    Node copy = new Node(li.val);
                    map.put(li, copy);
                    q.add(li);
                }
                map.get(curr).neighbors.add(map.get(li));    
            }
        }
        return map.get(node);   
    }   
}
