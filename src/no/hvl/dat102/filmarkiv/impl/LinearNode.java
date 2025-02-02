package no.hvl.dat102.filmarkiv.impl;

public class LinearNode<T> {
    private T data; //Dataen lagres i noden
    private LinearNode<T> neste; //Referanse til neste node.

    //Konstruktør
    public LinearNode(T data) {
        this.data = data;
        this.neste = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinearNode<T> getNeste() {
        return neste;
    }

    public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}
