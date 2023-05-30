public class NodeQ {

    private int number;        // Sayıyı tutan değişken
    private NodeQ next;        // Sonraki düğümü referanslayan değişken

    public NodeQ(int number) {
        this.setNumber(number); // "number" değerini ayarlayan metodu çağır
        setNext(null);          // "next" değerini null olarak ayarlayan metodu çağır
    }

    public int getNumber() {
        return number;          // Sayıyı döndüren metot
    }

    public void setNumber(int number) {
        this.number = number;   // Sayıyı ayarlayan metot
    }

    public NodeQ getNext() {
        return next;            // Sonraki düğümü döndüren metot
    }

    public void setNext(NodeQ next) {
        this.next = next;       // Sonraki düğümü ayarlayan metot
    }

}