import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ArchivosTextoImplementacion {

  public static String getDirectorioTrabajo() {
    String directoryName = new File("").getAbsoluteFile().toString();
    return directoryName;
  }

  public static void escribirArchivo(
    String nombreArchivo,
    Contacto[] contactos
  ) throws IOException {
    File archivo = new File(nombreArchivo);
    BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, false));
    for (Contacto i : contactos) {
      writer.write(
        i.getID() + "|" + i.getNombre() + "," + i.getApellido() + "|"
      );
      Telefono[] telefonos = i.getTelefonos();
      if (telefonos != null) {
        for (Telefono t : telefonos) {
          writer.write(t.getDescripcion() + "-" + t.getNumero() + "!");
        }
        writer.write("|");
      } else {
        writer.write("");
      }
      Correos[] correos = i.getCorreos();
      if (correos != null) {
        for (Correos c : correos) {
          writer.write(c.getNombre() + "=" + c.getCorreo() + "/");
        }
        writer.write("|");
      } else {
        writer.write("");
      }
      writer.write("\n");
    }
    writer.close();
  }

  public static Contacto[] leerContacto(String nombreArchivo)
    throws IOException {
    File archivo = new File(nombreArchivo);
    //
    StringTokenizer atributosTokenizer;
    //
    String contactoToken = "";
    String correoToken = "";
    String telefonoToken = "";
    Integer IDToken;
    //
    Contacto[] temporalContactos = null;
    Telefono[] arregloTemporalTel = null;
    Correos[] arregloTemporalCorr = null;
    //
    Contacto nuevoContacto;
    Telefono telefono;
    Correos correos;
    boolean EOF = false;
    String linea;
    //
    if (archivo.exists()) {
      BufferedReader br = new BufferedReader(new FileReader(archivo));
      linea = br.readLine();
      if (linea == null) {
        EOF = true;
      }
      do {
        try {
          if (linea != null) {
            atributosTokenizer = new StringTokenizer(linea, "|");
            IDToken = Integer.parseInt(atributosTokenizer.nextToken());
            contactoToken = atributosTokenizer.nextToken();
            telefonoToken = atributosTokenizer.nextToken();
            correoToken = atributosTokenizer.nextToken();
            //
            String[] contactoTemporal = contactoToken.split(",");
            String nombre = contactoTemporal[0];
            String apellido = contactoTemporal[1];
            String[] telefonoTemporal = telefonoToken.split("!");
            String[] correoTemporal = correoToken.split("/");
            //
            arregloTemporalTel = new Telefono[telefonoTemporal.length];
            int j = 0;
            for (int i = 0; i < telefonoTemporal.length; i++) {
              String[] atributosTel = telefonoTemporal[i].split("-");
              if (atributosTel.length == 2) {
                telefono = new Telefono(atributosTel[0], atributosTel[1]);
                arregloTemporalTel[j] = telefono;
                j++;
              }
            }
            arregloTemporalCorr = new Correos[correoTemporal.length];
            int o = 0;
            for (int i = 0; i < correoTemporal.length; i++) {
              String[] atributosCorr = correoTemporal[i].split("=");
              if (atributosCorr.length == 2) {
                correos = new Correos(atributosCorr[0], atributosCorr[1]);
                arregloTemporalCorr[o] = correos;
                o++;
              }
            }
            nuevoContacto =
              new Contacto(
                IDToken,
                nombre,
                apellido,
                arregloTemporalTel,
                arregloTemporalCorr
              );
            temporalContactos =
              Contacto.agregaContacto(temporalContactos, nuevoContacto, true);
            linea = br.readLine();
            if (linea == null) {
              EOF = true;
            }
          } else {
            EOF = true;
            temporalContactos = null;
          }
        } catch (Exception nullPointerException) {}
      } while (EOF != true);
      br.close();
    }
    return temporalContactos;
  }
}
