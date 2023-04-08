public class Telefono {

    //Declarar atributos.
    public String numero;
    public String descripcion;
  
    //Constructores
    public Telefono(String _descripcion, String _numero) {
      this.descripcion = setDescripcion(_descripcion);
      this.numero = setNumero(_numero);
    }
  
    public Telefono(String _numero) {
      this.numero = setNumero(_numero);
    }
  
    //Sets.
    //En los constructores usamos los sets para así evitar hacer código redundante de la validación.
    //Esto hace el código mas eficiente, menos memoria y menos oportunidades de error por si algún día cambio algunas de las condiciones.
    public String setDescripcion(String _descripcion) {
      String descripcionTemporal;
      if (_descripcion == null || _descripcion.length() <= 0) {
        descripcionTemporal = "default";
      } else {
        descripcionTemporal = _descripcion;
      }
      return descripcionTemporal;
    }
  
    public String setNumero(String _numero) {
      //Llamamos un método de validación adicional para no hacerlo demasiado largo.
      String numeroTemporal;
      if (esTelefonoInvalido(_numero)) {
        numeroTemporal = "error";
      } else {
        numeroTemporal = _numero;
      }
      return numeroTemporal;
    }
  
    //Gets.
    public String getNumero() {
      return this.numero;
    }
  
    public String getDescripcion() {
      return this.descripcion;
    }
  
    //Otros métodos.
    public boolean esTelefonoInvalido(String _numero) {
      boolean error = false;
      if (_numero == null) {
        error = true;
      } else if (_numero.length() == 10) {
        for (int i = 0; i < _numero.length(); i++) {
          //Validar que el digito sea numerico.
          int codigoCaracter = _numero.charAt(i);
          if (codigoCaracter < 48 || codigoCaracter > 57) {
            error = true;
            break;
          }
        }
      } else {
        error = true;
      }
      return error;
    }
  
    public static Telefono[] agregaElemento(
      Telefono[] arreglo,
      Telefono elemento,
      boolean eliminarNulos
    ) {
      Telefono[] arregloTemporal;
      if (arreglo != null) {
        int conteoNullos = 0;
        int longitudArreglo = arreglo.length;
        arregloTemporal = new Telefono[longitudArreglo + 1];
        int i, j = 0;
        for (i = 0; i < longitudArreglo; i++) {
          if (arreglo[i] != null) {
            arregloTemporal[j] = arreglo[i];
            j++;
          } else {
            conteoNullos++;
          }
        }
        if (elemento == null) {
          conteoNullos++;
        }
        arregloTemporal[j] = elemento;
        if (eliminarNulos && conteoNullos > 0) {
          longitudArreglo = longitudArreglo - conteoNullos;
          Telefono[] arregloTemporal2 = new Telefono[longitudArreglo];
          i = 0;
          for (i = 0; i < longitudArreglo; i++) {
            arregloTemporal2[i] = arregloTemporal[i];
          }
          arregloTemporal = arregloTemporal2;
        }
      } else if (elemento != null) {
        arregloTemporal = new Telefono[1];
        arregloTemporal[0] = elemento;
      } else {
        arregloTemporal = null;
      }
      return arregloTemporal;
    }
  }
  