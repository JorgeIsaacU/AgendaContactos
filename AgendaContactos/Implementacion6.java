import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementacion6 {

  static Telefono[] telefonos;
  static Correos[] correos;
  static Contacto[] contactos;
  static int contador = 0;
  static int eleccion;
  static Telefono[] arregloTemporal;
  static Correos[] arregloTemporal2;
  static Contacto arregloConTemporal;
  static int posicionContacto;
  static Telefono[] arregloTemporalInterno3;
  static Correos[] arregloTemporalInterno4;

  public static void main(String[] args) throws IOException {
    menuPrincipal();
    System.out.println("Ejecución exitosa.");
  }

  public static void menuPrincipal() throws IOException {
    int opcion = 0;
    Boolean opcionInvalida = false;
    contactos =
      ArchivosTextoImplementacion.leerContacto("src/ArchivoEscritura.txt");

    do {
      System.out.println(
        "Bienvenido a la Guía Telefónica. ¿Qué opción deseas?" +
        "\nEstas en el menú principal."
      );
      opcion =
        leerInteger(
          "1.- Agregar contacto \n2.- Listar contactos \n3.- Editar contactos \n4.- Borrar contactos \n5.- Guardar contactos \n6.- Salir"
        );
      do {
        if (opcion < 1 || opcion > 6) {
          System.out.println("Opción Invalida");
          opcionInvalida = true;
        } else {
          opcionInvalida = false;
        }
      } while (opcionInvalida == true);
      if (opcion == 1) { //Agregar
        agregarContacto(formarContacto());
      } else if (opcion == 2) {
        verContactos();
      } else if (opcion == 3) {
        editarContactos();
      } else if (opcion == 4) {
        borrarContactos();
      } else if (opcion == 5) {
        ArchivosTextoImplementacion.escribirArchivo(
          "src/ArchivoEscritura.txt",
          contactos
        );
        System.out.println("Contactos guardados.");
      }
    } while (opcion != 6);
  }

  public static void menuTelefonos() throws IOException {
    int opcion = 0;
    Boolean opcionInvalida = false;
    do {
      System.out.println(
        "Bienvenido al menu de edición de telefónos, seleccione una opción:"
      );
      opcion =
        leerInteger(
          "1.- Agregar telefono \n2.- Listar telefonos \n3.- Editar telefonos \n4.- Borrar telefonos \n5.- Salir"
        );
      do {
        if (opcion < 1 || opcion > 5) {
          System.out.println("Opción Invalida");
          opcionInvalida = true;
        } else {
          opcionInvalida = false;
        }
      } while (opcionInvalida == true);
      if (opcion == 1) {
        agregarTelefono(solicitarTelefono(), posicionContacto);
      } else if (opcion == 2) {
        listarTelefonos2();
      } else if (opcion == 3) {
        editarTelefonos();
      } else if (opcion == 4) {
        borrarTelefonos();
      } else if (opcion == 5) {}
    } while (opcion != 5);
  }

  public static void menuCorreos() throws IOException {
    int opcion = 0;
    Boolean opcionInvalida = false;
    do {
      System.out.println(
        "Bienvenido al menu de edición de correos, seleccione una opción:"
      );
      opcion =
        leerInteger(
          "1.- Agregar correo \n2.- Listar correos \n3.- Editar correos \n4.- Borrar correos \n5.- Salir"
        );
      do {
        if (opcion < 1 || opcion > 5) {
          System.out.println("Opción Invalida");
          opcionInvalida = true;
        } else {
          opcionInvalida = false;
        }
      } while (opcionInvalida == true);
      if (opcion == 1) {
        agregarCorreo(solicitarCorreo(), posicionContacto);
      } else if (opcion == 2) {
        listarCorreos2();
      } else if (opcion == 3) {
        editarCorreos();
      } else if (opcion == 4) {
        borrarCorreos();
      } else if (opcion == 5) {}
    } while (opcion != 5);
  }

  public static Contacto formarContacto() throws IOException {
    Contacto nuevoContacto;
    int contador2;
    int contador3;
    contador++;
    //
    String nombre = leerString("Insertar el nombre del contacto");
    //
    String apellido = leerString("Insertar el apellido del contacto");
    System.out.println(
      "Ha agregado un contacto. Ahora, agregará un teléfono. Recuerde que puede agregar tantos teléfonos como desee."
    );
    //
    Integer IDContacto = null;
    for (int i = 0; i <= contador; i++) {
      IDContacto = contador;
    }
    //
    Integer cantidadTelefonos = leerInteger(
      "¿Cuantos telefonos desea agregar?"
    );
    arregloTemporal = new Telefono[cantidadTelefonos];
    if (cantidadTelefonos == 1) {
      contador2 = 0;
      do {
        contador2++;
        for (int i = 0; i < arregloTemporal.length; i++) {
          arregloTemporal[i] = solicitarTelefono();
        }
      } while (contador2 != cantidadTelefonos);
    } else {
      contador2 = 1;
      do {
        contador2++;
        for (int i = 0; i < arregloTemporal.length; i++) {
          arregloTemporal[i] = solicitarTelefono();
        }
      } while (contador2 != cantidadTelefonos);
    }
    Integer cantidadCorreos = leerInteger("¿Cuantos correos desea agregar?");
    arregloTemporal2 = new Correos[cantidadCorreos];
    if (cantidadCorreos == 1) {
      contador3 = 0;
      do {
        contador3++;
        for (int i = 0; i < arregloTemporal2.length; i++) {
          arregloTemporal2[i] = solicitarCorreo();
        }
      } while (contador3 != cantidadCorreos);
    } else {
      contador3 = 1;
      do {
        contador3++;
        for (int i = 0; i < arregloTemporal2.length; i++) {
          arregloTemporal2[i] = solicitarCorreo();
        }
      } while (contador3 != cantidadCorreos);
    }
    nuevoContacto =
      new Contacto(
        IDContacto,
        nombre,
        apellido,
        arregloTemporal,
        arregloTemporal2
      );
    System.out.println(
      "Contacto agregado. Seleccione otra opción o agregue otro contacto."
    );
    return nuevoContacto;
  }

  /*
   * Dentro hay:
   * Nombre
   * Apellido
   * Telefonos[] telefonos -->
   * descripcion
   * numero
   * (Tendremos distintos telefnos con esos 2 atributos dentre de esos arreglos)
   * Correos[] correos
   * -->
   * descripcion
   * numero
   * (Tendremos otro arreglo igual a telefnoos)
   * Necesitamos un ciclo, for o do while para recorrer contactos, y para cada elemento voy a contruir un string con:
   * renglon = renglon + nombre + ",";
   * renglon = renglon + apellido + ",";
   * Y otro ciclo for para telefonos y construimos esa cadena de carácteres para telefonos.
   * ¿Como sabríamos si un token (texto) es parte de un teléfono o de un correo, o de contacto?
   * Si yo utilizo diferentes separadores, para contacto utilizo "," y para telefonos utlizo "#", el tokenizer te dará un pedacito de elementos que son de telefono, otro que son de contactos, otro de correos, pero necesitamos separadores distintos porque si no te dará separadores distintos".
   */

  public static Contacto obtenerContacto(Integer eleccionContacto) {
    int valorIDEleccion = eleccionContacto;
    for (int i = 0; i < contactos.length; i++) {
      if (contactos[i].valorID == valorIDEleccion) {
        arregloConTemporal = contactos[i];
      }
    }
    return arregloConTemporal;
  }

  public static Integer obtenerAtributos(Integer eleccionContacto) {
    int valorIDEleccion = eleccionContacto;
    posicionContacto = -1;
    for (int i = 0; i < contactos.length; i++) {
      if (contactos[i].valorID == valorIDEleccion) {
        posicionContacto = i;
        break;
      }
    }
    return posicionContacto;
  }

  public static void agregarContacto(Contacto nuevoContacto)
    throws IOException {
    if (contactos != null) {
      //Ya hay telefonos
      int longitudArrCont = contactos.length;
      Contacto[] temporalContacto = new Contacto[longitudArrCont + 1];
      for (int i = 0; i < longitudArrCont; i++) {
        temporalContacto[i] = contactos[i];
      }
      temporalContacto[longitudArrCont] = nuevoContacto;
      contactos = temporalContacto;
    } else {
      //No hay Telefonos, telefonos es null
      contactos = new Contacto[1];
      contactos[0] = nuevoContacto;
    }
  }

  public static Telefono solicitarTelefono() throws IOException {
    String descripcion = leerString(
      "Ingrese la descripción del teléfono. Ej: Celular, Casa etc."
    );
    Telefono nuevoTelefono;
    boolean repetir = false;
    do {
      String numero = leerString("Ingresa el numero telefónico");
      nuevoTelefono = new Telefono(descripcion, numero);
      if (nuevoTelefono.getNumero().equalsIgnoreCase("ERROR")) {
        repetir = true;
        System.out.println("Numero invalido, favor de ingresarlo de nuevo");
      } else {
        repetir = false;
        System.out.println("Telefono agregado.");
      }
    } while (repetir == true);

    return nuevoTelefono;
  }

  public static Correos solicitarCorreo() throws IOException {
    String descripcion = leerString(
      "Inserta la descripción del correo. Ej: Principal, Empresa"
    );
    Correos nuevoCorreo;
    boolean repetir = false;

    do {
      String correo = leerString("Ingresa el correo electrónico");
      nuevoCorreo = new Correos(descripcion, correo);
      if (nuevoCorreo.getCorreo().equalsIgnoreCase("ERROR")) {
        repetir = true;
        System.out.println("Correo invalido, favor de ingresarlo de nuevo");
      } else {
        repetir = false;
        System.out.println("Correo agregado.");
      }
    } while (repetir == true);

    return nuevoCorreo;
  }

  public static void verContactos() throws IOException {
    Integer eleccionContacto;
    if (contactos != null) {
      for (int i = 0; i < contactos.length; i++) {
        Contacto temporalContactos = contactos[i];
        System.out.println(
          i +
          1 +
          " - ID: " +
          temporalContactos.getID() +
          "\n  - Nombre: " +
          temporalContactos.getNombre() +
          "     - Apellido: " +
          temporalContactos.getApellido()
        );
      }
      //
      eleccionContacto =
        leerInteger(
          "¿Cual contacto deseas visualizar? \nIngresa el ID del contacto."
        );
      int valorIDEleccion = eleccionContacto;
      obtenerContacto(valorIDEleccion);
      Integer eleccionProf = leerInteger(
        "¿Qué deseas visualizar del contacto? \n1) Telefonos \n2) Correos"
      );
      if (eleccionProf == 1) {
        listarTelefonos3();
      } else if (eleccionProf == 2) {
        listarCorreos3();
      }
    } else {
      System.out.println(
        "No tienes contactos todavía, ¿Qué te parece si agregamos uno?"
      );
    }
  }

  public static void listarContactos() {
    if (contactos != null) {
      for (int i = 0; i < contactos.length; i++) {
        Contacto temporalContactos = contactos[i];
        System.out.println(
          i +
          1 +
          " - ID: " +
          temporalContactos.getID() +
          "\n  - Nombre: " +
          temporalContactos.getNombre() +
          "     - Apellido: " +
          temporalContactos.getApellido()
        );
      }
    }
  }

  public static void listarTelefonos3() {
    telefonos = arregloConTemporal.getTelefonos();
    if (telefonos != null) {
      for (int i = 0; i < telefonos.length; i++) {
        System.out.println(
          i +
          1 +
          " - Descripcion: " +
          telefonos[i].getDescripcion() +
          "\n  - Numero: " +
          telefonos[i].getNumero()
        );
      }
    } else {
      System.out.println("No hay telefonos almacenados");
    }
  }

  public static void listarTelefonos2() {
    telefonos = contactos[posicionContacto].getTelefonos();
    if (telefonos != null) {
      for (int i = 0; i < telefonos.length; i++) {
        System.out.println(
          i +
          1 +
          " - Descripcion: " +
          telefonos[i].getDescripcion() +
          "\n  - Numero: " +
          telefonos[i].getNumero()
        );
      }
    } else {
      System.out.println("No hay telefonos almacenados");
    }
  }

  public static void listarCorreos2() {
    correos = contactos[posicionContacto].getCorreos();
    if (correos != null) {
      for (int i = 0; i < correos.length; i++) {
        System.out.println(
          i +
          1 +
          " - Nombre: " +
          correos[i].getNombre() +
          "\n  - Correo: " +
          correos[i].getCorreo()
        );
      }
    } else {
      System.out.println("No hay correos almacenados");
    }
  }

  public static void listarCorreos3() {
    correos = arregloConTemporal.getCorreos();
    if (correos != null) {
      for (int i = 0; i < correos.length; i++) {
        System.out.println(
          i +
          1 +
          " - Nombre: " +
          correos[i].getNombre() +
          "\n  - Correo: " +
          correos[i].getCorreo()
        );
      }
    } else {
      System.out.println("No hay correos almacenados");
    }
  }

  public static void editarContactos() throws IOException {
    if (contactos != null) {
      System.out.println("Acaba de ingresar al Sistema de Edición.");
      listarContactos();
      boolean opcionInvalida = false;
      do {
        eleccion = leerInteger("Ingrese el ID del contacto que desea editar.");
        posicionContacto = obtenerAtributos(eleccion);
        if (posicionContacto < 0 || posicionContacto > contactos.length) {
          System.out.println(
            "ID inexistente. El ID esta desplegado encima del nombre y apellido."
          );
          opcionInvalida = true;
        } else {
          opcionInvalida = false;
        }
      } while (opcionInvalida == true);

      Integer editarEleccion = leerInteger(
        "¿Cual atributo deseas cambiar del contacto? \n1.- Nombre y/o apellido \n2.- Telefonos \n3.- Correos"
      );
      if (editarEleccion == 1) {
        //
        System.out.println(
          "El nombre actual es " + contactos[posicionContacto].getNombre()
        );
        String nuevoNombre = leerString(
          "Por favor, introduzca el nuevo nombre."
        );
        contactos[posicionContacto].nombre =
          contactos[posicionContacto].setNombre(nuevoNombre);
        //
        System.out.println(
          "El apellido actual es " + contactos[posicionContacto].getApellido()
        );
        String nuevoApellido = leerString(
          "Por favor, introduzca el nuevo apellido."
        );
        contactos[posicionContacto].apellido =
          contactos[posicionContacto].setApellido(nuevoApellido);
        //
      } else if (editarEleccion == 2) {
        menuTelefonos();
      } else if (editarEleccion == 3) {
        menuCorreos();
      }
    } else {
      System.out.println("No hay contactos almacenados");
    }
  }

  public static void agregarTelefono(Telefono nuevoTelefono, int posicion)
    throws IOException {
    if (contactos[posicion].telefono != null) {
      Telefono[] arregloTemporalInterno = contactos[posicion].telefono;
      Telefono[] arregloTemporal2 = new Telefono[arregloTemporalInterno.length +
      1];
      int j = -1;
      for (int i = 0; i < arregloTemporal2.length - 1; i++) {
        j++;
        arregloTemporal2[j] = arregloTemporalInterno[i];
        arregloTemporal2[arregloTemporal2.length - 1] = nuevoTelefono;
      }
      arregloTemporal = arregloTemporal2;
      contactos[posicion].telefonosEditados(arregloTemporal);
    } else {
      arregloTemporalInterno3 = new Telefono[1];
      arregloTemporalInterno3[0] = nuevoTelefono;
      contactos[posicion].telefonosEditados(arregloTemporalInterno3);
    }
  }

  public static Telefono[] agregarTelefonos(Telefono nuevoTelefono)
    throws IOException {
    if (telefonos != null) {
      //Ya hay telefonos
      int longitudArrTelefonos = telefonos.length;
      Telefono[] temporalTelefonos = new Telefono[longitudArrTelefonos + 1];
      for (int i = 0; i < longitudArrTelefonos; i++) {
        temporalTelefonos[i] = telefonos[i];
      }
      temporalTelefonos[longitudArrTelefonos] = nuevoTelefono;
      telefonos = temporalTelefonos;
    } else {
      //No hay Telefonos, telefonos es null
      telefonos = new Telefono[1];
      telefonos[0] = nuevoTelefono;
    }
    return telefonos;
  }

  public static Correos[] agregarCorreos(Correos nuevoCorreo)
    throws IOException {
    if (correos != null) {
      //Ya hay telefonos
      int longitudArrCorreos = correos.length;
      Correos[] temporalCorreos = new Correos[longitudArrCorreos + 1];
      for (int i = 0; i < longitudArrCorreos; i++) {
        temporalCorreos[i] = correos[i];
      }
      temporalCorreos[longitudArrCorreos] = nuevoCorreo;
      correos = temporalCorreos;
    } else {
      //No hay Telefonos, telefonos es null
      correos = new Correos[1];
      correos[0] = nuevoCorreo;
    }
    return correos;
  }

  public static void agregarCorreo(Correos nuevoCorreo, int posicion)
    throws IOException {
    if (contactos[posicion].correos != null) {
      Correos[] arregloTemporalInterno = contactos[posicion].correos;
      Correos[] arregloTemporal3 = new Correos[arregloTemporalInterno.length +
      1];
      int j = -1;
      for (int i = 0; i < arregloTemporal3.length - 1; i++) {
        j++;
        arregloTemporal3[j] = arregloTemporalInterno[i];
        arregloTemporal3[arregloTemporal3.length - 1] = nuevoCorreo;
      }
      arregloTemporal2 = arregloTemporal3;
      contactos[posicion].correosEditados(arregloTemporal2);
    } else {
      arregloTemporalInterno4 = new Correos[1];
      arregloTemporalInterno4[0] = nuevoCorreo;
      contactos[posicion].correosEditados(arregloTemporalInterno4);
    }
  }

  public static void editarTelefonos() throws IOException {
    listarTelefonos2();
    //Telefono[] arregloTemporalInterno2 = contactos[eleccion - 1].telefono;
    Telefono[] arregloTemporalInterno2;
    if (telefonos != null) {
      boolean opcionInvalida = false;
      boolean salir = false;
      int eleccion2;
      do {
        eleccion2 =
          leerInteger("Favor de ingresar el índice del telefono a editar");
        arregloTemporalInterno2 = contactos[eleccion - 1].telefono;
        if (eleccion2 < 0 || eleccion2 > arregloTemporalInterno2.length) {
          System.out.println("Indice telefonico invalido");
          opcionInvalida = true;
        } else {
          opcionInvalida = false;
        }
      } while (opcionInvalida == true);
      do {
        Integer editarEleccion = leerInteger(
          "¿Cual atributo deseas cambiar del telefono? \n1.- Descripción \n2.- Teléfono"
        );
        if (editarEleccion == 1) {
          String nuevaDescripcion = leerString(
            "Introduzca la nueva descripción"
          );
          arregloTemporalInterno2[eleccion2 - 1].descripcion =
            arregloTemporalInterno2[eleccion2 - 1].setDescripcion(
                nuevaDescripcion
              );
          Integer otroCambio = leerInteger(
            "¿Deseas cambiar otro atributo? \n1.- Si \n2.- No"
          );
          if (otroCambio == 1) {
            salir = false;
          } else {
            salir = true;
            System.out.println("Descripción editada con exito.");
          }
        } else {
          Telefono nuevoTelefono;
          boolean repetir2 = false;
          do {
            String numero2 = leerString("Introduzca el nuevo numero");
            nuevoTelefono = new Telefono(numero2);
            if (nuevoTelefono.getNumero().equalsIgnoreCase("ERROR")) {
              repetir2 = true;
              System.out.println(
                "Numero invalido, favor de ingresarlo de nuevo"
              );
            } else {
              arregloTemporalInterno2[eleccion2 - 1].numero =
                arregloTemporalInterno2[eleccion2 - 1].setNumero(numero2);
              repetir2 = false;
            }
          } while (repetir2 == true);
          Integer otroCambio2 = leerInteger(
            "¿Deseas cambiar otro atributo? \n1.- Si \n2.- No"
          );
          if (otroCambio2 == 1) {
            salir = false;
          } else {
            salir = true;
            System.out.println("Telefono editado con exito.");
          }
        }
      } while (salir == false);
    } else {
      System.out.println("No hay telefonos almacenados");
    }
  }

  public static void editarCorreos() throws IOException {
    listarCorreos2();
    //Telefono[] arregloTemporalInterno2 = contactos[eleccion - 1].telefono;
    Correos[] arregloTemporalInterno2;
    if (correos != null) {
      boolean opcionInvalida = false;
      boolean salir = false;
      int eleccion2;
      do {
        eleccion2 =
          leerInteger("Favor de ingresar el índice del correo a editar");
        arregloTemporalInterno2 = contactos[eleccion - 1].correos;
        if (eleccion2 < 0 || eleccion2 > arregloTemporalInterno2.length) {
          System.out.println("Indice del correo invalido");
          opcionInvalida = true;
        } else {
          opcionInvalida = false;
        }
      } while (opcionInvalida == true);
      do {
        Integer editarEleccion = leerInteger(
          "¿Cual atributo deseas cambiar del correo? \n1.- Nombre \n2.- Correo"
        );
        if (editarEleccion == 1) {
          String nuevoNombre = leerString("Introduzca el nuevo nombre");
          arregloTemporalInterno2[eleccion2 - 1].nombre =
            arregloTemporalInterno2[eleccion2 - 1].setNombre(nuevoNombre);
          Integer otroCambio = leerInteger(
            "¿Deseas cambiar otro atributo? \n1.- Si \n2.- No"
          );
          if (otroCambio == 1) {
            salir = false;
          } else {
            salir = true;
            System.out.println("Nombre editado con exito.");
          }
        } else {
          Correos nuevoCorreo;
          boolean repetir2 = false;
          do {
            String correo2 = leerString("Introduzca el nuevo correo");
            nuevoCorreo = new Correos(correo2);
            if (nuevoCorreo.getCorreo().equalsIgnoreCase("ERROR")) {
              repetir2 = true;
              System.out.println(
                "Numero invalido, favor de ingresarlo de nuevo"
              );
            } else {
              arregloTemporalInterno2[eleccion2 - 1].correo =
                arregloTemporalInterno2[eleccion2 - 1].setCorreo(correo2);
              repetir2 = false;
            }
          } while (repetir2 == true);
          Integer otroCambio2 = leerInteger(
            "¿Deseas cambiar otro atributo? \n1.- Si \n2.- No"
          );
          if (otroCambio2 == 1) {
            salir = false;
          } else {
            salir = true;
            System.out.println("Correo editado con exito.");
          }
        }
      } while (salir == false);
    } else {
      System.out.println("No hay correos almacenados");
    }
  }

  public static void borrarContactos() throws IOException {
    boolean salir3 = false;
    do {
      System.out.println(
        "Acaba de ingresar al sistema de borrado. Tome en cuenta que estará eliminando un contacto completo."
      );
      System.out.println(
        "Si desea eliminar unicamente un teléfono/correo de un contacto, dirigase a Editar Contactos."
      );
      Integer decisionBorrar = leerInteger(
        "¿Esta seguro que desea borrar un contacto? 1.- Si 2.- No"
      );
      if (decisionBorrar == 1) {
        salir3 = false;
        listarContactos();
        int eleccion3;
        boolean opcionInvalida = false;
        do {
          eleccion3 =
            leerInteger("Favor de ingresar el indice del telefono a eliminar") -
            1;
          if (eleccion3 < 0 || eleccion3 > contactos.length) {
            System.out.println("Indice telefonico invalido");
            opcionInvalida = true;
          } else {
            opcionInvalida = false;
          }
        } while (opcionInvalida == true);
        do {
          Integer decisionBorrar2 = leerInteger(
            "¿Esta seguro que desea  eliminar este contacto? 1.- Si \n2.- No"
          );
          if (contactos.length == 1) {
            contactos = null;
          } else {
            Contacto[] temporalContactos = new Contacto[contactos.length - 1];
            int j = -1;
            if (decisionBorrar2 == 1) {
              for (int i = 0; i < contactos.length; i++) {
                if (i != eleccion3) {
                  j++;
                  temporalContactos[j] = contactos[i];
                }
              }
              contactos = temporalContactos;
            } else {
              salir3 = false;
            }
          }
        } while (salir3 == true);
        Integer otroCambio2 = leerInteger(
          "¿Desea eliminar otro contacto? 1.- Si \n2.- No"
        );
        if (otroCambio2 == 1) {
          salir3 = false;
        } else {
          salir3 = true;
        }
      } else {
        salir3 = true;
      }
    } while (salir3 == false);
  }

  public static void borrarTelefonos() throws IOException {
    arregloTemporalInterno3 = contactos[posicionContacto].telefono;
    boolean salir3 = false;
    do {
      System.out.println(
        "Acaba de ingresar al sistema de borrado de telefonos. Estará eliminando solamente un teléfono de un contacto."
      );
      System.out.println(
        "Si desea eliminar un contacto completo, dirigase a Borrar Contactos."
      );
      Integer decisionBorrar = leerInteger(
        "¿Esta seguro que desea borrar un telefono? 1.- Si 2.- No"
      );
      if (decisionBorrar == 1) {
        salir3 = false;
        listarTelefonos2();
        int eleccion3;
        boolean opcionInvalida = false;
        do {
          eleccion3 =
            leerInteger("Favor de ingresar el indice del telefono a eliminar") -
            1;
          if (eleccion3 < 0 || eleccion3 > arregloTemporalInterno3.length) {
            System.out.println("Indice telefonico invalido");
            opcionInvalida = true;
          } else {
            opcionInvalida = false;
          }
        } while (opcionInvalida == true);
        do {
          Integer decisionBorrar2 = leerInteger(
            "¿Esta seguro que desea  eliminar este telefono? 1.- Si \n2.- No"
          );
          if (arregloTemporalInterno3.length == 1) {
            arregloTemporalInterno3 = null;
            contactos[posicionContacto].telefonosEditados(
                arregloTemporalInterno3
              );
          } else {
            Telefono[] temporalContactos2 = new Telefono[arregloTemporalInterno3.length -
            1];
            int j = -1;
            if (decisionBorrar2 == 1) {
              for (int i = 0; i < arregloTemporalInterno3.length; i++) {
                if (i != eleccion3) {
                  j++;
                  temporalContactos2[j] = arregloTemporalInterno3[i];
                }
              }
              arregloTemporalInterno3 = temporalContactos2;
              contactos[posicionContacto].telefonosEditados(
                  arregloTemporalInterno3
                );
            } else {
              salir3 = false;
            }
          }
        } while (salir3 == true);
        Integer otroCambio2 = leerInteger(
          "¿Desea eliminar otro telefono? 1.- Si \n2.- No"
        );
        if (otroCambio2 == 1) {
          salir3 = false;
        } else {
          salir3 = true;
        }
      } else {
        salir3 = true;
      }
    } while (salir3 == false);
  }

  public static void borrarCorreos() throws IOException {
    arregloTemporalInterno4 = contactos[posicionContacto].correos;
    boolean salir3 = false;
    do {
      System.out.println(
        "Acaba de ingresar al sistema de borrado de correos. Estará eliminando solamente un correo de un contacto."
      );
      System.out.println(
        "Si desea eliminar un contacto completo, dirigase a Borrar Contactos."
      );
      Integer decisionBorrar = leerInteger(
        "¿Esta seguro que desea borrar un correo? 1.- Si 2.- No"
      );
      if (decisionBorrar == 1) {
        salir3 = false;
        listarCorreos2();
        int eleccion3;
        boolean opcionInvalida = false;
        do {
          eleccion3 =
            leerInteger("Favor de ingresar el indice del correo a eliminar") -
            1;
          if (eleccion3 < 0 || eleccion3 > arregloTemporalInterno4.length) {
            System.out.println("Indice del correo invalido");
            opcionInvalida = true;
          } else {
            opcionInvalida = false;
          }
        } while (opcionInvalida == true);
        do {
          Integer decisionBorrar2 = leerInteger(
            "¿Esta seguro que desea  eliminar este correo? 1.- Si \n2.- No"
          );
          if (arregloTemporalInterno4.length == 1) {
            arregloTemporalInterno4 = null;
            contactos[posicionContacto].correosEditados(
                arregloTemporalInterno4
              );
          } else {
            Correos[] temporalCorreos2 = new Correos[arregloTemporalInterno4.length -
            1];
            int j = -1;
            if (decisionBorrar2 == 1) {
              for (int i = 0; i < arregloTemporalInterno4.length; i++) {
                if (i != eleccion3) {
                  j++;
                  temporalCorreos2[j] = arregloTemporalInterno4[i];
                }
              }
              arregloTemporalInterno4 = temporalCorreos2;
              contactos[posicionContacto].correosEditados(
                  arregloTemporalInterno4
                );
            } else {
              salir3 = false;
            }
          }
        } while (salir3 == true);
        Integer otroCambio2 = leerInteger(
          "¿Desea eliminar otro correo? 1.- Si \n2.- No"
        );
        if (otroCambio2 == 1) {
          salir3 = false;
        } else {
          salir3 = true;
        }
      } else {
        salir3 = true;
      }
    } while (salir3 == false);
  }

  public static int leerInteger(String mensaje) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(mensaje);
    String datoStr1 = br.readLine();
    int datoInteger = Integer.parseInt(datoStr1);
    return datoInteger;
  }

  public static Double leerDouble(String mensaje) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(mensaje);
    String datoStr2 = br.readLine();
    Double datoDouble = new Double(datoStr2).doubleValue();
    return datoDouble;
  }

  public static String leerString(String mensaje) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(mensaje);
    String datoStr3 = br.readLine();
    return datoStr3;
  }
}
