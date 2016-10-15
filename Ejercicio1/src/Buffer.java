
class Buffer {
   private char [] buffer;
   private int count = 0, in = 0, out = 0;

   //Constructor del objeto Buffer (con par�metro del tama�o del array de char)
   Buffer(int size)
   {
      buffer = new char[size];
   }
 
   public synchronized void put(char c) {
     while(count == buffer.length) {
    	 //El productor espera con el buffer lleno
    	 try {
			wait();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
     }
     
     System.out.println("Produciendo " + c + " ...");
     buffer[in] = c; 
     in = (in + 1) % buffer.length; 
     count++;
     
     //Notifica al consumidor despu�s de a�adir un nuevo elemento en el buffer
     notifyAll();
   }
    
   public synchronized char get() {
     while (count == 0) {
    	 //El consumidor espera con el buffer vac�o
    	 try {
			wait();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
     }
     char c = buffer[out]; 
     out = (out + 1) % buffer.length;
     count--;
     System.out.println("Consumiendo "+ c + " ...");
     
     //Notifica al productor despu�s de consumir un elemento del buffer
     notifyAll();
     
     return c;
   }
}
     
