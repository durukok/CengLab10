public class HashTable {
    public static void main(String[] args) {
        IntHashTable index = new IntHashTable(5);

        index.set(1001, "Alice", 85.5);
        index.set(1006, "Bob", 72.0);
        index.set(1011, "Charlie", 90.0); // likely same bucket as 1001
        index.set(2002, "Diana", 60.0);  //likely same bucket again
        index.set(3003, "Eve", 95.5);

        index.printTable();

        int searchId=1011;
        String result=index.get(searchId);
        if (result!=null) {
            System.out.println("Found student: "+result);
        } else {
            System.out.println("Student with ID "+searchId+" not found.");
        }

        int missingId=9999;
        String result2=index.get(missingId);
        if (result2!=null) {
            System.out.println("Found student: "+result2);
        } else {
            System.out.println("Student with ID "+missingId+" not found.");
        }

        double avg=index.getAverageGrade();
        if (avg>=0) {
            System.out.println("Average grade in table = "+avg);
        } else {
            System.out.println("No students in the table, average is undefined.");
        }


    }
}
