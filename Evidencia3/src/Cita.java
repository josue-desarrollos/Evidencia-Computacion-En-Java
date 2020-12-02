
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.AsynchronousByteChannel;
import java.util.Properties;

public class Cita {
	
private int contador;
private int NudDoc;
private int NumPaci;
private int NumCit;

	public void AddCita(int cont2) throws FileNotFoundException, IOException {
		
		BufferedReader Entra = new BufferedReader(new InputStreamReader(System.in));
		
		String DatosCita = "C:/Users/Josue/eclipse-workspace/Evidencia3/src/Cita.txt";
		
		Properties Agreg4 = new Properties();
		Agreg4.load(new FileInputStream(DatosCita));
		
		String FechaCit;
		String HoraCit;
		String MotivoCit;
		;
		int contador =0;
		this.contador = cont2;
		
		System.out.println(" El Formato Es: dd-mm-yyyy"); //pide ingrese datos por teclado
		System.out.print("Ingrese Fecha Actual: ");
		FechaCit = Entra.readLine();
		
		System.out.println("El Formato Es De 24hrs: 12:00");
		System.out.print("Ingrese la Hora Deseada para La Cita: ");
		HoraCit = Entra.readLine();
		
		System.out.println("Ingrese El Motivo de la cita: ");
		MotivoCit = Entra.readLine();
		contador = contador +1;
		
		String cadena = Integer.toString(contador);//lo agrega al txt
		Agreg4.setProperty((contador+"Cita_Numero"), cadena);
		Agreg4.setProperty((contador+"Fecha_Cita"), FechaCit.toString());
		Agreg4.setProperty((contador+"Hora_Cita"), HoraCit.toString() + "Horas");
		Agreg4.setProperty((contador+"Motivo_Cita"), MotivoCit.toString());
		
		Agreg4.store(new FileOutputStream(DatosCita), null);
		
		System.out.println(Agreg4.get(contador+"Fecha_Cita"));
		System.out.println(Agreg4.get(contador+"Hora_Cita"));
		System.out.println(Agreg4.get(contador+"Motivo_Cita"));
	}
	
	//EL JOIN DEL TXT
	public void JoinsTxts() throws FileNotFoundException, IOException {
		
		BufferedReader Entra2 = new BufferedReader(new InputStreamReader(System.in));
		
		String TDoc;
		String TPaci;
		String TCita;
		String Tid;
		
		String DocName; 
		String PaciName; 
		String CitaName;  
		
		Properties PDoc = new Properties();
		Properties PClie = new Properties();
		Properties PCita = new Properties();
		Properties propDatos = new Properties();
	
		TDoc = "C:\\Users\\Josue\\eclipse-workspace\\Evidencia3\\src\\Doctor.txt"; //aqui agregamos todos los txt para poder relacionarlos 
		TPaci = "C:\\Users\\Josue\\eclipse-workspace\\Evidencia3\\src\\Paciente.txt";
		TCita = "C:\\Users\\Josue\\eclipse-workspace\\Evidencia3\\src\\Cita.txt";
		Tid = "C:\\Users\\Josue\\eclipse-workspace\\Evidencia3\\src\\Datos.txt";
	
		PDoc.load(new FileInputStream(TDoc));
		PClie.load(new FileInputStream(TPaci));
		PCita.load(new FileInputStream(TCita));
		
		System.out.println("Ingrese los IDs que desea asociar");
		System.out.print("Doctore numero: ");
		NudDoc = Integer.parseInt(Entra2.readLine());
		System.out.print("Paciente Numero: ");
		NumPaci = Integer.parseInt(Entra2.readLine());
		System.out.print("Cita: ");
		NumCit = Integer.parseInt(Entra2.readLine());	
		
		DocName = (String) PDoc.get(NudDoc+"Nombre_Dcotor");//aqui hacemos la relacion
		PaciName = (String) PClie.get(NumPaci+"Nombre_Paciente");
		CitaName    = (String) PCita.get(NumCit+"Dato_Cita");
		PCita.setProperty((NudDoc+"Relacion_Cita"), DocName + ", " + PaciName + ", "+ CitaName);
		PCita.store(new FileOutputStream(Tid), null);
		
		System.out.println("Se Genero La Relacion");
	}
	
}
