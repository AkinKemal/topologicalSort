import java.util.ArrayList;

public class TopologicalSort {
    ReadFile readFile = new ReadFile();
    Graph graph;
    Queue queue = new Queue();
    ArrayList<Integer> controlArrayList = new ArrayList<>();

    public TopologicalSort() {
        create();
    }

    // Dosyadan verileri okuyarak ve grafiği oluşturarak hazırlık yapar
    private void create() {
        readFile.readerFromFile("input.txt");  // Verileri dosyadan okuyup listeye ekliyoruz
        graph = new Graph(readFile.getSize() + 1);  // Grafiği oluşturuyoruz

        // Matris yapısını oluşturuyoruz
        Node walk = readFile.list.getHead();
        while (walk != null) {
            graph.addEdge(walk.getFrom(), walk.getTo());  // Kenarları grafa ekliyoruz
            walk = walk.getNext();
        }
    }

    // Topolojik sıralama işlemini gerçekleştirir
    public void topologicalSortOperation() {
        StringBuilder strOutput = new StringBuilder();
        int counter = 1;

        int[] inDegreeSort = getInDegree(readFile.getSize() + 1);  // Giriş derecelerini hesaplıyoruz

        // Giriş derecesi sıfır olan düğümleri kuyruğa ekliyoruz
        for (int i = 0; i < inDegreeSort.length; i++) {
            if (inDegreeSort[i] == 0) {
                queue.enQueue(i);
                controlArrayList.add(queue.rear.getNumber());
            }
        }

        // Kuyruk boşalana kadar işlem yapıyoruz
        while (!queue.isEmpty()) {
            int box = queue.deQueue();
            strOutput.append(box).append(" ");

            String str = graph.neighbors(box);  // Komşu düğümleri buluyoruz
            String[] strSplit = str.split(" ");

            counter++;

            if (!str.equals("")) {
                for (String s : strSplit) {
                    inDegreeSort[Integer.parseInt(s)]--;

                    if (inDegreeSort[Integer.parseInt(s)] == 0) {
                        if (comparisonOfElement(s)) {
                            queue.enQueue(Integer.parseInt(s));
                            controlArrayList.add(queue.rear.getNumber());
                        }
                    }
                }
            }
        }

        if (counter <= (readFile.getSize() + 1)) {
            System.out.println("G has a cycle.");  // Grafin bir döngüye sahip olup olmadığını kontrol ediyoruz
        }

        System.out.println("Output: " + strOutput);  // Sonucu yazdırıyoruz
    }

    // Her düğüm için giriş derecesini hesaplar
    private int[] getInDegree(int graphSize) {
        int[] inDegreeSort = new int[graphSize];

        for (int k = 0; k < graphSize; k++) {
            inDegreeSort[k] = 0;
        }

        for (int i = 0; i < graphSize; i++) {
            String str = graph.neighbors(i);  // Düğümün komşularını buluyoruz
            String[] strSplit = str.split(" ");

            if (!str.equals("")) {
                for (String s : strSplit) {
                    inDegreeSort[Integer.parseInt(s)]++;  // Giriş derecesini artırıyoruz
                }
            }
        }

        return inDegreeSort;
    }

    // Elemanın daha önce kontrol edilip edilmediğini kontrol eder
    private boolean comparisonOfElement(String str) {
        boolean control = true;
        for (int i : controlArrayList) {
            if (i == Integer.parseInt(str)) {
                control = false;  // Eleman daha önce kontrol edilmişse kontrolü false olarak işaretliyoruz
            }
        }

        return control;
    }

}