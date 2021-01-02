package Sokoban.levels;

/**
 * @author: Callum Jenkins
 * 02/01/2021
 * <p>
 * Class: Stack
 */

public class Stack<E> {

    private E[] array = null;
    private int CAP;
    private int top = -1;
    private int size = 0;

    public Stack(int cap) {
        this.CAP = cap;
        this.array = (E[]) new Object[cap];
    }

    public E pop() {
        if(this.size == 0){
            return null;
        }

        this.size--;
        E result = this.array[top];
        this.array[top] = null;//prevent memory leaking
        this.top--;

        return result;
    }

    public boolean push(E e) {
        if (isFull())
            return false;

        this.size++;
        this.array[++top] = e;

        return true;
    }

    public boolean isFull() {
        if (this.size == this.CAP)
            return false;
        return true;
    }

    public String toString() {
        if(this.size==0){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.size; i++){
            sb.append(this.array[i] + ", ");
        }

        sb.setLength(sb.length()-2);
        return sb.toString();
    }

}
