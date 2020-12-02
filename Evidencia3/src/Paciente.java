import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Paciente {
	
	private static final String DatosPaci = "C:/Users/Josue/eclipse-workspace/Evidencia3/src/Paciente.txt";
	
	private int contador;
	public void AddPaciente(int cont2) throws FileNotFoundException, IOException {//esta funcion permite dar de alta o agregar a pacientes
		
		BufferedReader Entra = new BufferedReader(new InputStreamReader(System.in));
		Properties Agrega3 = new Properties(); 
		
		Agrega3.load(new FileInputStream(DatosPaci));
		
		int contador =0;
		this.contador = cont2;
		String NombrePaci;
		String ApellidoPaci;
		
		System.out.print("Ingrese el Nombre Del Paciente:");   //pedimos los datos
		NombrePaci = Entra.readLine();
		System.out.print("Ingrese el Primer Apellido Del Paciente:");
		ApellidoPaci = Entra.readLine();
		
		contador = contador + 1;
		Agrega3.setProperty((contador+"Nombre_Paciente"), NombrePaci.toString()); //lo agregamos al txt lo predeterminado mas lo tecleado
		Agrega3.setProperty((contador+"Apellido_Paciente"), ApellidoPaci.toString());
		
		Agrega3.store(new FileOutputStream(DatosPaci), null);
		
		System.out.println(Agrega3.get(contador+"Nombre_Paciente"));//nos regresa lo ingresado al txt
		System.out.println(Agrega3.get(contador+"Apellido_Paciente"));
	}
}
