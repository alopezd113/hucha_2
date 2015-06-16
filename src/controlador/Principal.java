package controlador;

import modelo.Hucha;

public class Principal {

	public Principal() {
		
	}

	public static void main(String[] args) {
		
		Hucha cerdito=new Hucha();
		cerdito.introducirMoneda(225);
		cerdito.introducirMoneda(100);
		cerdito.introducirMoneda(50);
		cerdito.sacarMoneda(200);
		cerdito.mostrarMonedas();
	}
	
}