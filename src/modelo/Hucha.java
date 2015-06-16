package modelo;

public class Hucha {

	private int[] valorMonedas = {1,2,5,10,20,50,100,200}; //valor en céntimos de las monedas que admite nuestra hucha
	private int[] monedas={0,0,0,0,0,0,0,0,}; //número de monedas de cada tipo  almacenadas en la hucha. Inicialmente la hucha estará vacia.
	                                          // En la posición 0 del array tendremos las monedas de 1 céntimo, y en la 7 las de 200 céntimos.
	private int total; //Total de dinero que tenemos en la hucha expresado en céntimos.
	
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
 * Método para introducir una moneda en la hucha.
 * Parámetro: moneda. Representa el valor en céntimos de la moneda que introducios en la hucha.	
 * El método incremente en 1 el número de monedas que tenemos de ese determinado valor, y la cantidad total de dinero que
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
 * Método que permite sacar una moneda de la hucha.
 * Parametro: Valor de la moneda que queremos sacar de la hucha.
 * El método debe decrementar el número de monedas que tenemos en la hucha de ese valor
 * y decrementar el total de dinero que tenemos en el valor de la moneda que saquemos.	
 * El método no debería permitir sacar una moneda de la hucha, si no tenemos monedas de ese valor
 * en la hucha.
 * Si llamamos al método para sacar una moneda de un valor que no tenemos, debería aparecer
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
 * Método que nos permite obtener el índice que ocupa la moneda con valor igual al parámetro: moneda dentro
 * del array valorMonedas.
 * Si el valor de la moneda que se pasa no existe, el método devolverá -1.
 * Ej: Si llamo a buscarPosicionMoneda con moneda=20, el método devolvería: 4 que es la posición que ocupa
 * el valor 20 dentro del array valorMonedas
 * Si llamamos a buscarPosicionMoneda con moneda=225, el método devolvería -1, pues no existen monedas de 225 céntimos.
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
