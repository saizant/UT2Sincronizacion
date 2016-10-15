
public class CoffeeStore {
	    private String lastClient;
	    private int soldCoffees;
	     
	    private void someLongRunningProcess() throws InterruptedException {
	        Thread.sleep(3000);
	    }
	     
	    //Declara el método synchronized para prevenir inconsistencias (establece
	    //relación happens-before con cualquier llamada al método)
	    public synchronized void buyCoffee(String client) throws InterruptedException {
	        someLongRunningProcess();
	        lastClient = client;
	        soldCoffees++;
	        System.out.println(client + " bought some coffee");
	    }
	     
	    public int countSoldCoffees() {return soldCoffees;}
	     
	    public String getLastClient() {return lastClient;}
}
