package modelo;

public class Hucha {

	private int[] valorMonedas = {1,2,5,10,20,50,100,200}; //valor en c�ntimos de las monedas que admite nuestra hucha
	private int[] monedas={0,0,0,0,0,0,0,0,}; //n�mero de monedas de cada tipo  almacenadas en la hucha. Inicialmente la hucha estar� vacia.
	                                          // En la posici�n 0 del array tendremos las monedas de 1 c�ntimo, y en la 7 las de 200 c�ntimos.
	private int total; //Total de dinero que tenemos en la hucha expresado en c�ntimos.
	
	public Hucha() {
		
		this.total = 0;
	}

	public int[] getValorMonedas() {
		return valorMonedas;
	}

	public void setValorMonedas(int[] valorMonedas) {
		this.valorMonedas = valorMonedas;
	}

	public int[] getMonedas() {
		return monedas;
	}

	public void setMonedas(int[] monedas) {
		this.monedas = monedas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
/***********************************************************************************************/
	
/*
 * M�todo para introducir una moneda en la hucha.
 * Par�metro: moneda. Representa el valor en c�ntimos de la moneda que introducios en la hucha.	
 * El m�todo incremente en 1 el n�mero de monedas que tenemos de ese determinado valor, y la cantidad total de dinero que
 * tengo en la hucha.
 */
/************************************************************************************************/
	public void introducirMoneda(int moneda ){
		
		int posicionMoneda=buscarPosicionMoneda(moneda);		
		if(posicionMoneda!=-1){
			
			 monedas[posicionMoneda]++;
			 total+=moneda;
			
		}
		else
			System.out.println("No existe esa moneda");
	}
/**************************************************************************************/	
/*
 * M�todo que permite sacar una moneda de la hucha.
 * Parametro: Valor de la moneda que queremos sacar de la hucha.
 * El m�todo debe decrementar el n�mero de monedas que tenemos en la hucha de ese valor
 * y decrementar el total de dinero que tenemos en el valor de la moneda que saquemos.	
 * El m�todo no deber�a permitir sacar una moneda de la hucha, si no tenemos monedas de ese valor
 * en la hucha.
 * Si llamamos al m�todo para sacar una moneda de un valor que no tenemos, deber�a aparecer
 * un mensaje: No hay monedas con ese valor en la hucha.
 */
	public void sacarMoneda(int moneda ){
		int posicionMoneda=buscarPosicionMoneda(moneda);
		
		if(monedas[posicionMoneda]==0){
			System.out.println("No tienes monedas de este valor");
		}
		else{
			if(posicionMoneda!=-1){
				monedas[posicionMoneda]--;
				total-=moneda;
				}
				else
					System.out.println("No existe esa moneda");
		}
			
	}	
	
/***************************************************************************************/
/*
 * M�todo que nos permite obtener el �ndice que ocupa la moneda con valor igual al par�metro: moneda dentro
 * del array valorMonedas.
 * Si el valor de la moneda que se pasa no existe, el m�todo devolver� -1.
 * Ej: Si llamo a buscarPosicionMoneda con moneda=20, el m�todo devolver�a: 4 que es la posici�n que ocupa
 * el valor 20 dentro del array valorMonedas
 * Si llamamos a buscarPosicionMoneda con moneda=225, el m�todo devolver�a -1, pues no existen monedas de 225 c�ntimos.
 * 
 */
	public int buscarPosicionMoneda(int moneda){
		int posicion = -1;
		for(int i=0; i<monedas.length; i++){
			if (valorMonedas[i]==moneda)
				posicion=i;
		}
		return posicion;
	}
/********************************************************************************/
	public void mostrarMonedas(){

		for(int i=0;i<valorMonedas.length;i++){
			
			if(!(monedas[i]==0)){
			   System.out.println("Moneda "+this.valorMonedas[i]+ " Cantidad: " 
					   					   +this.monedas[i]+" Total ="+ 
					   					   (this.monedas[i]*this.valorMonedas[i]));
			}
		}
		System.out.printf("Total en la hucha: %02.02f Euros",(double)(this.total/100.0));

	}
}
