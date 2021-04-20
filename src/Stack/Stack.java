package Stack;

public class Stack {

    private DinamicList list;

    public Stack() {
        list = new DinamicList();
    }

    public void push(Object data) { // adicionar na pilha
        list.add(data);
    }

    public Object pop() { // remover da pilha
        if (isEmpty()) 
            return null;
        
        int last = list.size() - 1;
        Object data = list.get(last);
        list.delete(last);
        return data;
    }

    public Object peek() { // saber qual o ultimo elemento da pilha
        if (isEmpty()) 
            return null;
        
        int last = list.size() - 1;
        return list.get(last);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

}