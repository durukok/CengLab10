public class IntHashTable {
    private static class Node{
        int id;
        String name;
        double grade;
        Node next;
        public Node(int id, String name, double grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
            this.next=null;
        }
    }
    private Node[] table;
    public IntHashTable(int tableSize){
        table=new Node[tableSize];
    }
    private int hash(int id){
        return Math.abs(id)%table.length;
    }
    public void set(int id, String name, double grade){
        int index=hash(id);
        Node current=table[index];

        while(current!=null){
            if(current.id==id){
                current.name=name;
                current.grade=grade;
                return;
            }
            current=current.next;
        }
        Node newNode=new Node(id,name,grade);
        Node oldHead=table[index];
        newNode.next=oldHead;
        table[index]=newNode;
    }


}
