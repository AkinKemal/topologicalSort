import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

    LinkedList list = new LinkedList();  // LinkedList nesnesi oluşturuldu
    private int size = 0;                 // Boyut değişkeni tanımlandı

    public ReadFile() {

    }

    public void readerFromFile(String fileName) {

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                String[] arraySplit = line.split(" ");

                if (line.length() == 1) {
                    if (size < Integer.parseInt(arraySplit[0])) {
                        size = Integer.parseInt(arraySplit[0]);  // Dosyadaki tek satırda gelen boyutu ayarla
                    }
                } else {
                    int from = Integer.parseInt(arraySplit[0]);  // İlk değeri al
                    int to = Integer.parseInt(arraySplit[1]);    // İkinci değeri al

                    list.add(from, to);  // LinkedList'e düğüm ekle

                    int max = Math.max(from, to);  // En büyük değeri bul

                    if (size < max) {
                        size = max;  // Boyutu güncelle
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }
    }

    public int getSize() {
        return size;  // Boyutu döndür
    }

    public void setSize(int size) {
        this.size = size;  // Boyutu ayarla
    }

}