package tp;

public class Client {
	private String nom;
	private double total = 0;
	
	public Client (String nomClient){
		nom = nomClient;
	}
	
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String nomClient){
		nom = nomClient;
	}
	
	public void setTotal(double montant){
		total = montant;
	}
	
	public void addTotal(double montant){
		total += montant;
	}
	
	@Override
	
	public String toString(){
		return (nom + " " + total + "$");
	}
	
	@Override
	
    public boolean equals(Object obj) {
       boolean equals = false;
       if(obj instanceof Client) {
    	   if (this.getNom().equals( ( (Client) obj ).getNom())) {
    		   equals = true;
    		   
    	   }
       }
		return equals;
	}


	public double getTotal() {
		
		return total;
	}
}
