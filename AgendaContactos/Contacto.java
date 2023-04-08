import java.io.IOException;

public class Contacto {

  public int valorID;
  public String nombre;
  public String apellido;
  public Telefono[] telefono;
  public Correos[] correos;

  public Contacto(
    int _valorID,
    String _nombre,
    String _apellido,
    Telefono[] telefono,
    Correos[] correos
  ) throws IOException {
    this.nombre = setNombre(_nombre);
    this.apellido = setApellido(_apellido);
    this.valorID = setID(_valorID);
    this.telefono = setTelefono(telefono);
    this.correos = setCorreo(correos);
  }

  public Telefono[] setTelefono(Telefono[] _nuevoTelefono) {
    for (Telefono t : _nuevoTelefono) {
      telefono = Telefono.agregaElemento(telefono, t, false);
    }
    return telefono;
  }

  public void telefonosEditados(Telefono[] nuevosTelefonos) {
    this.telefono = nuevosTelefonos;
  }

  public void correosEditados(Correos[] nuevosCorreos) {
    this.correos = nuevosCorreos;
  }

  public void telefonosBorrados(Telefono[] telefonosBorrados) {
    this.telefono = telefonosBorrados;
  }

  public Correos[] setCorreo(Correos[] _nuevoCorreo) {
    for (Correos t : _nuevoCorreo) {
      correos = Correos.agregaCorreos(correos, t, false);
    }
    return correos;
  }

  public String setNombre(String _nombre) {
    String nombreTemporal;
    if (_nombre == null || _nombre.length() <= 0) {
      nombreTemporal = "default";
    } else {
      nombreTemporal = _nombre;
    }
    return nombreTemporal;
  }

  public String setApellido(String _apellido) {
    String apellidoTemporal;
    if (_apellido == null || _apellido.length() <= 0) {
      apellidoTemporal = "default";
    } else {
      apellidoTemporal = _apellido;
    }
    return apellidoTemporal;
  }

  public int setID(Integer _valorID) {
    Integer valorIDTemporal;
    if (_valorID == null) {
      valorIDTemporal = 0;
    } else {
      valorIDTemporal = _valorID;
    }
    return valorIDTemporal;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public int getID() {
    return this.valorID;
  }

  public Telefono[] getTelefonos() {
    return telefono;
  }

  public Correos[] getCorreos() {
    return correos;
  }

  public static Contacto[] agregaContacto(
    Contacto[] arreglo,
    Contacto elemento,
    boolean eliminarNulos
  ) {
    Contacto[] arregloTemporal;
    if (arreglo != null) {
      int conteoNullos = 0;
      int longitudArreglo = arreglo.length;
      arregloTemporal = new Contacto[longitudArreglo + 1];
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
        Contacto[] arregloTemporal2 = new Contacto[longitudArreglo];
        i = 0;
        for (i = 0; i < longitudArreglo; i++) {
          arregloTemporal2[i] = arregloTemporal[i];
        }
        arregloTemporal = arregloTemporal2;
      }
    } else if (elemento != null) {
      arregloTemporal = new Contacto[1];
      arregloTemporal[0] = elemento;
    } else {
      arregloTemporal = null;
    }
    return arregloTemporal;
  }

  public void agregaTelefono(Telefono elemento, boolean eliminarNulos) {
    Telefono[] arregloTemporal;
    if (telefono != null) {
      int conteoNullos = 0;
      int longitudArreglo = telefono.length;
      arregloTemporal = new Telefono[longitudArreglo + 1];
      int i, j = 0;
      for (i = 0; i < longitudArreglo; i++) {
        if (telefono[i] != null) {
          arregloTemporal[j] = telefono[i];
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
    telefono = arregloTemporal;
  }

  public static Contacto[] agregaElemento(
    Contacto[] arreglo,
    Contacto elemento,
    boolean eliminarNulos
  ) {
    Contacto[] arregloTemporal;
    if (arreglo != null) {
      int conteoNullos = 0;
      int longitudArreglo = arreglo.length;
      arregloTemporal = new Contacto[longitudArreglo + 1];
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
        Contacto[] arregloTemporal2 = new Contacto[longitudArreglo];
        i = 0;
        for (i = 0; i < longitudArreglo; i++) {
          arregloTemporal2[i] = arregloTemporal[i];
        }
        arregloTemporal = arregloTemporal2;
      }
    } else if (elemento != null) {
      arregloTemporal = new Contacto[1];
      arregloTemporal[0] = elemento;
    } else {
      arregloTemporal = null;
    }
    return arregloTemporal;
  }
}
