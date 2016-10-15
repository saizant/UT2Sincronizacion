
public class DemoProducerConsumer
{
  public static void main(String [] args)
  {
     //Crea Objeto Buffer y le pasa el tamaño (4) del array de char
	 Buffer b = new Buffer(4);
	 
	 //Crea el thread productor
     ProducerThread p = new ProducerThread(b);
     
     //Crea el thread consumidor
     ConsumerThread c = new ConsumerThread(b);

     //Inicia los threads
     p.start();
     c.start();
  }
}