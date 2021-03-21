
import itt.clase.tipo.Bebida;//Importamos el paquete donde tenemos nuestra clase Bebida

import java.text.DecimalFormat;//Este paquete lo importamos para poder redondear a 2 decimales nuestros precios
import java.util.ArrayList;//Importamos el paquete que contiene la clase ArrayList
import java.util.InputMismatchException;//Importamos el paquete de la excepcion si introducimos cadena en vez de numeros
import java.util.Scanner;//Importamos el paquete que contiene la clase Scanner

//Comenzamos a implementar nuestra clase principal con su metodo main

public class Principal {
	/*Instanciamos un nuevo objeto de la clase Scanner para pedir los datos por consola
	 * Lo declaramos como estatico porque es un atributo de clase
	 */
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		/*Intanciamos un objeto de la clase ArrayList de tipo Bebida en donde almacenaremos
		 * las bebidas que vayamos comprando para mostrarlas todas juntas al finalizar 
		 * el programa
		 */
		ArrayList <Bebida> bebidas=new ArrayList<Bebida>();
	try{/* Introducimos un bloque try catch que capturará la excepcion si introducimos
	una cadena en vez de numeros y mostrara un mensaje en la consola antes de finalizar el programa*/
		
		boolean salir=false;
		while (!salir) { /*Este bloque while lo utilizamos para mostrar el menu todo el rato
		hasta que decidamos introducir la opcion de terminar el programa. Cuando escogemos
		esa opcion, la variable salir se pone a true y salimos del bucle*/
			
			switch  (muestra_Menu()){
			/*Utilizamos una sentencia condicional de multiples casos switch para saber que hacer en
			 * cada opcion que marquemos. El valor de la expresion que le introducimos
			 * es el valor que nos devuelve nuestro metodo muestra_Menu que tenemos implementado
			 * en la parte final de este codigo.
			 */
			
			case 1:
				/*Cuando el metodo muestra_Menu nos devuelve un 1, añadiremos un objeto 
				 * Bebida a nuestro ArrayList con los dos parametros que nos pide el 
				 * constructor de Bebida(un String y un Float) y mostraremos por consola 
				 * un texto con su compra. 
				 * 
				 */
				bebidas.add(new Bebida("Coca Cola",1.30F));
				System.out.println("Su Coca Cola . Gracias");
				break;
			case 2:
				/*Si pulsamos el 2 pues lo mismo que el anterior, volvemos a crear un objeto
				 * Bebida y lo volvemos a almacenar en nuestro ArrayList. El caso 3 y 4 serian
				 * iguales.
				 */
				bebidas.add(new Bebida ("Fanta Naranja",1.20F));
				System.out.println("Su Fanta Naranja . Gracias");
				break;
			case 3:
				bebidas.add(new Bebida ("Fanta Limón",1.20F));
				System.out.println("Su Fanta Limón . Gracias");
				break;
			case 4:
				bebidas.add(new Bebida("Agua",1.00F));
				System.out.println("Su Agua . Gracias");
				break;
			case 5:
				/*Si introducimos un 5 por teclado, de esta forma queremos que la maquina 
				 * se apague y haga un recuento de todo lo vendido y la recaudacion. Aqui 
				 * tenemos que "destripar" nuestro ArrayList para saber todos los elementos 
				 * que contiene
				 */
				
				System.out.println("HASTA PRONTO\nINFORME DE VENTAS:");
				float recaudacion=0;//Con este float haremos un sumatorio de la recaudacion
				
				/*A continuacion con un bucle for recorremos nuestro ArrayList para sacar
				 * el toString de cada elemento que lo compone y de esta manera dejar
				 * constancia en consola de todo lo que se ha vendido. El valor de cada
				 * elemento lo vamos agregando al sumatorio con el metodo getter getPrecio
				 * de la clase Bebidas donde nos traemos el valor del atributo precio.
				 */
				for (int i=0;i<bebidas.size();i++){
					System.out.println(bebidas.get(i).toString());
					recaudacion=recaudacion+bebidas.get(i).getPrecio();
				}
				/*Para representar la recaudacion solo con dos decimales, instanciamos
				 * un objeto de la clase DecimalFormat y le decimos que su estructura
				 * tiene que ser de dos decimales.
				 */
				DecimalFormat df = new DecimalFormat("#.00");
				/*Imprimimos en consola el sumatorio de la recaudacion con el formato decimal
				 * que hemos definido antes
				 */
				System.out.println("RECAUDACIÓN: "+df.format(recaudacion));
				salir=true;//Ponemos a true la variable para salir del bucle y terminar el programa
				break;
			default:
				/*Con la opcion default le decimos que ha introducido una opcion incorrecta
				 * y seguimos en el bucle mostrando el menu de nuevo
				 */
				System.out.println("OPCIÓN INCORRECTA");
				break;
			
			}
			
		
			
		}
		sc.close();//Cerramos el Scanner para no consumir recursos
	}catch (InputMismatchException e){/*Aqui es donde capturamos la excepcion de introducir 
		letras en vez de numeros, cuando esto ocurre, el programa se cae y nos informa del error*/
			System.out.println("Has introducido letras o un numero mayor de lo permitido\n FIN DEL PROGRAMA");
			
		}
		
		

	}
	/*Aqui implementamos nuestro menu que sale en pantalla y que nos devolverá el valor
	 * de la expresion(opcion) para introducir en la sentencia switch. Utilizaremos el objeto Scanner
	 * y el metodo nextInt de su clase para leer el numero que le introducimos por teclado
	 * 
	 */
	public static int  muestra_Menu(){
		int opcion;
		System.out.println("---------------------------");
		System.out.println("MÁQUINA DE BEBIDAS");
		System.out.println("---------------------------");
		System.out.println("1. Coca Cola ------ 1,30 €");
		System.out.println("2. Fanta Naranja -- 1,20 €");
		System.out.println("3. Fanta Limón ---- 1,20 €");
		System.out.println("4. Agua ----------- 1,00 €");
		System.out.println("5. Apagar máquina");
		System.out.println("---------------------------");
		System.out.println("¿Qué opción elige?");
		opcion=sc.nextInt();
		return opcion;
		
	}
	

}
