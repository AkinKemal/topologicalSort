public class Graph {

    private int numberOfVertices = 0;  // Grafın düğüm sayısı
    private int numberOfEdges = 0;     // Grafın kenar sayısı
    private int[][] adjMatrix = null;  // Komşuluk matrisi

    public Graph(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Number of vertices must be positive"); // Düğüm sayısı pozitif olmalı
        }

        adjMatrix = new int[size][size]; // Komşuluk matrisini oluştur

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = 0; // Matrisi başlangıçta boş yap
            }
        }

        numberOfVertices = size; // Grafın düğüm sayısını güncelle
    }

    public void addEdge(int from, int to) {
        if (from < 0 && from > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (from vertex):" + from); // from düğümü geçerli aralıkta olmalı
        }

        if (to < 0 && to > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (to vertex):" + to); // to düğümü geçerli aralıkta olmalı
        }

        adjMatrix[from][to] = 1; // İki düğüm arasında bir kenar olduğunu belirtmek için matrisi güncelle
        numberOfEdges++; // Kenar sayısını artır
    }

    public int degree(int vertexNo) {
        if (vertexNo < 0 && vertexNo > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (vertexNo):" + vertexNo); // vertexNo düğümü geçerli aralıkta olmalı
        }

        int degree = 0;
        for (int i = 0; i < numberOfVertices; i++) {

            if (adjMatrix[vertexNo][i] == 1) {
                degree++; // vertexNo düğümüne bağlı olan kenarların sayısını hesapla
            }
        }

        return degree; // Dereceyi döndür
    }

    public boolean isEdge(int v, int w) {
        if (v < 0 && v > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (v vertex):" + v); // v düğümü geçerli aralıkta olmalı
        }

        if (w < 0 && w > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (w vertex):" + w); // w düğümü geçerli aralıkta olmalı
        }
        // Sonucu döndür
        return adjMatrix[v][w] == 1; // v ve w düğümleri arasında bir kenar olduğunu kontrol et
    }

    public String neighbors(int v) {
        if (v < 0 && v > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (v vertex):" + v); // v düğümü geçerli aralıkta olmalı
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numberOfVertices; i++) {

            if (adjMatrix[v][i] == 1) {
                str.append(i).append(" "); // v düğümüne komşu olan düğümleri string olarak birleştir
            }
        }

        return str.toString(); // Komşuları döndür
    }

    public int getNumberOfVertices() {
        return numberOfVertices; // Düğüm sayısını döndür
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices; // Düğüm sayısını güncelle
    }

    public int getNumberOfEdges() {
        return numberOfEdges; // Kenar sayısını döndür
    }

    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges; // Kenar sayısını güncelle
    }

    public int[][] getAdjMatrix() {
        return adjMatrix; // Komşuluk matrisini döndür
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix; // Komşuluk matrisini güncelle
    }

}