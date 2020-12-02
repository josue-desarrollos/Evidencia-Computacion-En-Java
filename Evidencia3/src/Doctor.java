import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Properties;


public class Doctor {
	
	private static final String DatosDoc = "/C:/Users/Josue/eclipse-workspace/Evidencia3/src/Doctor.txt"; 
	private int contador;
		
	public void AddDoc(int cont2) throws FileNotFoundException, IOException {//este metodo agrega o da de alta a doctores
		
		this.contador = cont2;
		BufferedReader Entra = new BufferedReader(new InputStreamReader(System.in));
		Properties Agrega2 = new Properties();
		
		Agrega2.load(new FileInputStream(DatosDoc));//permite leer el txt
		
		String NombreDoc;
		String ApellidoDoc;
		String EspecialidadDoc;
		int cont =0;
		
		System.out.print("Ingrese Nombre Del Doctor A Dar De Alta:");
		NombreDoc = Entra.readLine();
		System.out.print("Ingrese el Primer Apellido Del Doctor:");
		ApellidoDoc = Entra.readLine();
		System.out.print("Ingrese la Especialidad Del Doctor:");
		EspecialidadDoc = Entra.readLine();
		
		cont =cont +1;
		
		Agrega2.setProperty((cont+"Nombre_Doctor"), NombreDoc.toString()); //permite agregar al txt los datos predeterminados mas los tecleados
		Agrega2.setProperty((cont+"Apellido_Doctor"), ApellidoDoc.toString());
		Agrega2.setProperty((cont+"Especialidad_Doctor"), EspecialidadDoc.toString());
		Agrega2.store(new FileOutputStream(DatosDoc), null); //aqui los agrega al txt
		System.out.println(Agrega2.get(cont+"Nombre_Doctor"));
		System.out.println(Agrega2.get(cont+"Apellido_Doctor"));
		System.out.println(Agrega2.get(cont+"Especialidad_Doctor"));
	}
}
