public class Node {

    private int from;            // Başlangıç değerini tutan değişken
    private int to;              // Bitiş değerini tutan değişken
    private Node next; // Sonraki düğümü referanslayan değişken

    public Node(int from, int to) {
        this.setFrom(from);      // "from" değerini ayarlayan metodu çağır
        this.setTo(to);          // "to" değerini ayarlayan metodu çağır
        setNext(null);           // "next" değerini null olarak ayarlayan metodu çağır
    }

    public int getFrom() {
        return from;             // Başlangıç değerini döndüren metot
    }

    public void setFrom(int from) {
        this.from = from;        // Başlangıç değerini ayarlayan metot
    }

    public int getTo() {
        return to;               // Bitiş değerini döndüren metot
    }

    public void setTo(int to) {
        this.to = to;            // Bitiş değerini ayarlayan metot
    }

    public Node getNext() {
        return next;             // Sonraki düğümü döndüren metot
    }

    public void setNext(Node next) {
        this.next = next;        // Sonraki düğümü ayarlayan metot
    }

}