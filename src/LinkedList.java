public class LinkedList {

    public Node head; // Bağlı listenin baş düğümü

    public LinkedList() {
        head = null; // Başlangıçta baş düğümü boş olarak ayarla
    }

    public Node getHead() {
        return head; // Baş düğümü döndüren metot
    }

    public void add(int from, int to) {
        Node newNode = new Node(from, to); // Yeni bir düğüm oluştur

        if (isUnique(from, to)) { // from ve to değerlerinin benzersiz olup olmadığını kontrol et
            if (head == null) { // Eğer baş düğüm boşsa, yeni düğümü baş düğüm yap
                head = newNode;
                head.setNext(null);
            } else {
                Node walk = head;

                while (walk.getNext() != null) { // Son düğüme kadar yürü
                    walk = walk.getNext();
                }

                walk.setNext(newNode); // Yeni düğümü son düğüme bağla
                newNode.setNext(null);
            }
        }
    }

    private boolean isUnique(int from, int to) {
        Node walk = head;
        boolean isUnique = true;

        while (walk != null) { // Baştan sona kadar düğümleri kontrol et

            if (walk.getFrom() == from && walk.getTo() == to) { // from ve to değerleri zaten mevcutsa
                isUnique = false;
                break;
            }

            walk = walk.getNext();
        }

        return isUnique; // from ve to değerlerinin benzersiz olup olmadığını döndür
    }

}