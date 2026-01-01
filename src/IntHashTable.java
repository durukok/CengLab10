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
    public String get(int id){
        int index=hash(id);
        Node current=table[index];
        while(current!=null){
            if(current.id==id){
                return "Id="+current.id+"Name="+current.name+"Grade="+current.grade;
            }
            current=current.next;
        }
        return null;
    }
    public void printTable(){
        System.out.print("-Hash Table Nodes-");
        for(int i=0;i<table.length;i++){
            System.out.print("Table nodes:"+i+":");

            Node current=table[i];
            if(current==null){
                System.out.print("empty");
            }else{
                while(current.next!=null){
                    System.out.print("Id: "+current.id+"Name:"+current.name+"Grade:"+current.grade);
                    current=current.next;
                }
                System.out.println("null");
            }
        }
    }
    public double getAverageGrade(){
        double sum=0.0;
        int count=0;
        for(int i=0;i<table.length;i++){
            Node current=table[i];
            while(current!=null){
                sum+=current.grade;
                count++;
                current=current.next;
            }
        }
        if(count==0){
            return -1.0;
        }
        return sum/count;
    }




}
