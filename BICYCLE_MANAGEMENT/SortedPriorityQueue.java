package BICYCLE_MANAGEMENT;

public class PriorityQueue {
    private Vertex head;
    private Vertex tail;
    int n = 0;


    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return n == 0;
    }


    public void insert(Vertex entry) {
        if (isEmpty()) {
            head =  entry;
            tail =  entry;
        } else {
            int indexEntry = 0;
            Vertex temp = head;
            while (temp != null && temp.compareTo(entry) <= 0) {
                temp = temp.next;
                indexEntry++;
            }
            if (indexEntry == 0) {
                entry.next = head;
                head = entry;
            } else if (indexEntry == n) {
                tail.next = entry;
                tail = tail.next;
            } else {
                Vertex preEntry = getNodeByIndex(indexEntry - 1);
                Vertex afterEntry = getNodeByIndex(indexEntry);
                entry.next = afterEntry;
                preEntry.next = entry;
            }
        }
        n++;
    }
    public Vertex removeMin() {
        Vertex result = head;
        head = head.next;
        n--;
        return result;
    }


    public Vertex min() {
        return head;
    }

    Vertex getNodeByIndex(int i) {
        if (i < 0 && i >= n) {
            throw new IndexOutOfBoundsException("This element is not in this queue!!!");
        } else {
            int index = 0;
            Vertex temp = head;
            while (index != i) {
                temp = temp.next;
                index++;
            }
            return temp;
        }
    }

    void print() {
        Vertex temp = head;
        while (temp.next != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
        System.out.println(temp.toString());

    }


        public void setNext(Vertex next) {
            this.next = next;
        }

}

