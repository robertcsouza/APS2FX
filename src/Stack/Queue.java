package Stack;

public class Queue {

    private DinamicList list;

    public Queue() {
        list = new DinamicList();
    }

    public void enqueue(Object data) { // colocar na fila
        list.add(data);
    }

    public Object dequeue() { // tirar da fila
        if (isEmpty())
            return null;
        
        Object data = list.get(0); // busca o 1o elemento da lista
        list.delete(0);
        return data;
    }

    public Object peek() { // retornar o próximo a sair da fila
        if (isEmpty())
            return null;
        
        return list.get(0);
    }

    public Object get(int pos) { // retornar o próximo a sair da fila
        if (isEmpty())
            return null;

        return list.get(pos);
    }

    public boolean isEmpty() { // verificar se a fila está vazia
        return list.size() == 0;
    }

    public int size() { // verificar o tamanho da fila
        return list.size();
    }

    public String toString() {
        return list.toString();
    }

}
