import java.util.StringTokenizer;

public class Correos {

  public String correo;
  public String nombre;

  public Correos(String _nombre, String _correo) {
    this.nombre = setNombre(_nombre);
    this.correo = setCorreo(_correo);
  }

  public Correos(String _correo) {
    this.correo = setCorreo(_correo);
  }

  public String setNombre(String _nombre) {
    String nombreTemporal;
    if (_nombre == null || _nombre.length() <= 0) {
      nombreTemporal = "Default";
    } else {
      nombreTemporal = _nombre;
    }
    return nombreTemporal;
  }

  public String setCorreo(String _correo) {
    String correoTemporal;
    if (validacionCorreo(_correo)) {
      correoTemporal = "error";
    } else {
      correoTemporal = _correo;
    }
    return correoTemporal;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getCorreo() {
    return this.correo;
  }

  public boolean validacionCorreo(String _correo) {
    boolean error = false;
    boolean exPun = _correo.contains(".");
    boolean exAt = _correo.contains("@");
    StringTokenizer token;
    String usuarioTocken = "";
    String correoTocken = "";
    if (
      _correo == null ||
      exPun == false ||
      exAt == false ||
      _correo.length() > 256
    ) {
      error = true;
    } else {
      token = new StringTokenizer(_correo, "@");
      usuarioTocken = token.nextToken();
      correoTocken = token.nextToken();
      if (usuarioTocken.length() <= 64) {
        for (int i = 0; i < usuarioTocken.length(); i++) {
          char caracter = usuarioTocken.charAt(i);
          if (Character.isUpperCase(caracter) == true) {
            caracter = Character.toLowerCase(caracter);
          }
          int codigoCaracter = _correo.charAt(i);
          if (
            !(
              (codigoCaracter >= 48 && codigoCaracter <= 57) ||
              (codigoCaracter >= 65 && codigoCaracter <= 90) ||
              (codigoCaracter >= 97 && codigoCaracter <= 122) ||
              codigoCaracter == 95 ||
              codigoCaracter == 45 ||
              codigoCaracter == 46
            )
          ) {
            error = true;
            break;
          }
        }
      } else {
        error = true;
      }
      /*if (correoTocken.length() <= 192) {
        int posAt = _correo.indexOf("@");
        int posPt = _correo.indexOf(".", posAt);
        if (posPt > posAt) {
          error = true;
        }
        Integer longitud = _correo.length();
        String ult = _correo.substring(longitud - 1);
        if (ult.equals(".")) {
          error = true;
        }
      } else {
        error = true;
      }*/
    }
    return error;
  }

  public static Correos[] agregaCorreos(
    Correos[] arreglo,
    Correos elemento,
    boolean eliminarNulos
  ) {
    Correos[] arregloTemporal;
    if (arreglo != null) {
      int conteoNullos = 0;
      int longitudArreglo = arreglo.length;
      arregloTemporal = new Correos[longitudArreglo + 1];
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
        Correos[] arregloTemporal2 = new Correos[longitudArreglo];
        i = 0;
        for (i = 0; i < longitudArreglo; i++) {
          arregloTemporal2[i] = arregloTemporal[i];
        }
        arregloTemporal = arregloTemporal2;
      }
    } else if (elemento != null) {
      arregloTemporal = new Correos[1];
      arregloTemporal[0] = elemento;
    } else {
      arregloTemporal = null;
    }
    return arregloTemporal;
  }
}
