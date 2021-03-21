
package itt.clase.tipo;
/*Esta es la primera clase que empezamos a implementar, esta clase nos la dan hecha en el 
 * enunciado, por lo tanto tan solo la tenemos que copiar. Pero como siempre esta compuesta
 * por unos atributos ENCAPSULADOS, un constructor con paso de parametros y los metodos GETTER,
 * SETTER para acceder a los atributos desde fuera de la clase  y el metodo toString para 
 * mostrar los datos de los atributos del objeto cuando lo llamemos
 */

public class Bebida {
	

        private String bebida;

        private float precio;

        public Bebida(String bebida, float precio) {

                      this.bebida = bebida;

                      this.precio = precio;

        }

        public float getPrecio() {

                      return this.precio;

        }

        public String getBebida() {

                      return this.bebida;

        }

        @Override

        public String toString() {

              return "Servicio [bebida=" + bebida + ", precio=" + precio + "]";

        }

}


