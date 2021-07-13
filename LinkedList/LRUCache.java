import java.util.Hashtable;
class LRUCache {

class Node {
  int key;
  int value;
  Node prev;
  Node next;
}


private void addNode(Node node) {
    
  node.prev = head;
  node.next = head.next;

  head.next.prev = node;
  head.next = node;
}

private void removeNode(Node node){
  Node prev = node.prev;
  Node next = node.next;

  prev.next = next;
  next.prev = prev;
}

private void moveToHead(Node node){
  this.removeNode(node);
  this.addNode(node);
}

private Node popTail(){
  Node res = tail.prev;
  this.removeNode(res);
  return res;
}

private Hashtable<Integer,Node> cache = new Hashtable<Integer,Node>();
private int count;
private int capacity;
private Node head, tail;

public LRUCache(int capacity) {
  this.count = 0;
  this.capacity = capacity;

  head = new Node();
  head.prev = null;
  tail = new Node();
  tail.next = null;

  head.next = tail;
  tail.prev = head;
}

public int get(int key) {

  Node node = cache.get(key);
  if(node == null){
    return -1; 
  }
  this.moveToHead(node);

  return node.value;
}


public void put(int key, int value) {
  Node node = cache.get(key);

  if(node == null){

    Node newNode = new Node();
    newNode.key = key;
    newNode.value = value;

    this.cache.put(key, newNode);
    this.addNode(newNode);

    ++count;

    if(count > capacity){
      // pop the tail
      Node tail = this.popTail();
      this.cache.remove(tail.key);
      --count;
    }
  }else{
    // update the value.
    node.value = value;
    this.moveToHead(node);
  }
}

}

