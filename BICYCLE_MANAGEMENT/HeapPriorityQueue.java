package BICYCLE_MANAGEMENT;

public class HeapPriorityQueue {

    Vertex[] heapPQVertex;
    int defaultSize = 1000000000;
    int size = 0;

    public HeapPriorityQueue() {
        heapPQVertex = new Vertex[defaultSize];
        size = 0;
    }

    protected void swap(int i, int j) {
        Vertex temp = heapPQVertex[i];
        heapPQVertex[i] = heapPQVertex[j];
        heapPQVertex[j] = temp;
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return 2 * i + 2;
    }

    protected boolean hasLeft(int i) {
        return left(i) < size;
    }

    protected boolean hasRight(int i) {
        return right(i) < size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Vertex entry) {
        heapPQVertex[size] = entry;
        int sizeTemp = size;
        while (sizeTemp > 0) {
            int p = parent(sizeTemp);
            if (heapPQVertex[sizeTemp].getDistance() >= heapPQVertex[p].getDistance()) {
                break;
            }
            swap(sizeTemp, p);
            sizeTemp = p;
        }
        size++;
    }

    public Vertex removeMin() {
        swap(0, size - 1);
        Vertex result = heapPQVertex[size - 1];
        size -= 1;
        int i = 0;
        while (i < size) {
            if (hasLeft(i) && hasRight(i)) {
                if (heapPQVertex[i].getDistance() <= heapPQVertex[left(i)].getDistance() && heapPQVertex[i].getDistance() <= heapPQVertex[right(i)].getDistance()) {
                    break;
                } else {
                    if (heapPQVertex[left(i)].getDistance() <= heapPQVertex[right(i)].getDistance()) {
                        int j = left(i);
                        swap(i, j);
                        i = j;
                    } else {
                        int j = right(i);
                        swap(i, j);
                        i = j;
                    }
                }
            } else {
                if (hasLeft(i)) {
                    if (heapPQVertex[i].getDistance() >= heapPQVertex[left(i)].getDistance()) {
                        swap(i, left(i));
                    }
                }
                break;
            }
        }
        return result;
    }


    public Vertex min() {
        return heapPQVertex[0];
    }

    void print() {
        for (int i = 0; i < heapPQVertex.length; i++) {
            System.out.println(heapPQVertex[i]+" ");
        }
    }
}

