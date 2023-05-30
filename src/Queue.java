public class Queue {

    public NodeQ front;  // Kuyruğun önü
    public NodeQ rear;   // Kuyruğun sonu

    public Queue() {
        front = null;  // Başlangıçta kuyruk boş
        rear = null;
    }

    public NodeQ getFront() {
        return front;  // Kuyruğun önünü döndüren metot
    }

    public void enQueue(int number) {

        NodeQ newNode = new NodeQ(number);  // Yeni bir düğüm oluştur

        if (front == null) {
            front = newNode;  // Kuyruk boşsa, yeni düğümü hem front hem de rear olarak ayarla
        } else {
            NodeQ walk = front;

            while (walk.getNext() != null) {
                walk = walk.getNext();  // Kuyruğun sonuna kadar yürü
            }

            walk.setNext(newNode);  // Yeni düğümü sona ekle
        }
        rear = newNode;  // Yeni düğümü rear olarak ayarla
    }

    public int deQueue() {
        if (isEmpty()) {
            return -1;  // Kuyruk boşsa -1 döndür
        } else {
            int box = front.getNumber();  // Kuyruğun önündeki sayıyı al
            front = front.getNext();      // Önü bir ileri kaydır
            return box;                   // Sayıyı döndür
        }
    }

    public boolean isEmpty() {
        return front == null;  // Kuyruk boş mu kontrolü
    }

}