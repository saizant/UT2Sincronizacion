
class ProducerThread extends Thread {
   private Buffer buffer;
     
   //Constructor (recibe objeto Buffer y lo asocia al atributo de la clase: Objeto Buffer)
   ProducerThread(Buffer b) { buffer = b; }
   
   public void run() {
     for(int i = 0; i < 10; i++) {
        buffer.put((char)('A'+ i%26 )); }
   }
}  
