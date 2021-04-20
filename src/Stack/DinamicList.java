package Stack;

public class DinamicList {
    private Node first;
    private Node last;
    private int size;

    private void addStart(Object data) {
        Node node = new Node(data, first);
        first = node;
        if (size == 0) {
            last = first;
        }
        size++;
    }

    public void add(Object data) {
        if (size == 0) {
            addStart(data);
        } else {
            Node node = new Node(data);
            last.setNext(node);
            last = node;
            size++;
        }
    }

    public String toString() {
        if (size == 0)
            return "[]";

        String out = "[";
        Node node = first;
        for (int i = 0; i < this.size - 1; i++) {
            out += node.getData() + ", ";
            node = node.getNext();
        }

        out += node.getData() + "]";
        return out;
    }

    private boolean exists(int position) {
        return position >= 0 && position < size;
    }

    private Node getNode(int position) {
        if (!exists(position))
            throw new IllegalArgumentException("Posição não existe");
        Node atual = first;
        for (int i = 0; i < position; i++) {
            atual = atual.getNext();
        }
        return atual;
    }

    public Object get(int position) {
        return getNode(position).getData();
    }

    public void add(int position, Object data) {
        if (position == 0) {
            addStart(data);
        } else if (position == size) {
            add(data);
        } else {
            Node first = getNode(position - 1);
            Node newNode = new Node(data, first.getNext());
            first.setNext(newNode);
            size++;
        }
    }

    private void deleteStart() {
        if (!exists(0)) 
            throw new IllegalArgumentException("Position does not exists!");
        
        first = first.getNext();
        size--;

        if (size == 0) 
            last = null;
    }

    private void deleteEnd() {
        if (!exists(size - 1)) 
            throw new IllegalArgumentException("Position does not exists!");
        if (size == 1)
            deleteStart();
        else {
            Node node = getNode(size - 2);
            node.setNext(null);
            last = node;
            size--;
        }
    }

    public void delete(int position) {
        if (!exists(position))
            throw new IllegalArgumentException("Position does not exists!");
        if (position == 0) {
            deleteStart();
        } else if (position == size - 1) {
            deleteEnd();
        } else {
            Node prior = getNode(position - 1);
            prior.setNext(prior.getNext().getNext());
            size--;
        }
    }

    public boolean contains(Object data) {
        Node node = this.first;
        while (node != null) {
            if (node.getData().equals(data))
                return true;
            node = node.getNext();
        }
        return false;
    }

    public int size() {
        return size;
    }
}
