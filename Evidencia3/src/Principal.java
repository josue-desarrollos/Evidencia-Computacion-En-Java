import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Principal {
	
	public static BufferedReader Entra = new BufferedReader(new InputStreamReader(System.in));
	private static final String BaseDat_USER = "C:\\Users\\Josue\\eclipse-workspace\\Evidencia3\\src\\User.txt";//nos permite acceder al txt donde estan las credenciales
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int NumDoc=0;
		int NumPaci = 0;
		int NumCit = 0;
		int x=0;
		String usuari="";
		String contra="";
		Properties Agre = new Properties();
		Agre.load(new FileInputStream(BaseDat_USER)); 
		Doctor Eldoc = new Doctor();
		Paciente Elpa = new Paciente();
		Cita Laci = new Cita();
		
		do {
			String usuario = (String) Agre.get("Usuario");
			String contrase =  (String) Agre.get("Contrase"); 
			
			System.out.println("Ingrese su Usuario: ");
			System.out.println("Usuario: ");
			usuari = Entra.readLine();
			
			if(usuari.equals(usuario.toString())){ //valida si con correctas las credenciales
				System.out.println("Ingrese su contraseña: ");
				contra = Entra.readLine();
				if(contra.equals(contrase.toString())){   //menu principal
					System.out.println("\n 1. Dar De Alta A Doctores");
					System.out.println("\n 2. Dar De Alta A Pacientes");
					System.out.println("\n 3. Dar De Alta A Citas");
					System.out.println("\n 4. Conciliar Citas");
					x = Integer.parseInt(Entra.readLine());
					try {
						if(x==1) {
							NumDoc = NumDoc +1;
							Eldoc.AddDoc(NumDoc);
						}
						if(x==2) {
							NumPaci = NumPaci +1;
							Elpa.AddPaciente(NumPaci);
						}
						if(x==3){
							NumCit = NumCit +1;
							Laci.AddCita(NumCit);
						}
						if(x==4) {
							Laci.JoinsTxts();
						}				
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else {
				System.out.println("Usurio y Contraseña Incorrectas");
			}
			System.out.print("¿ Desea Volver Al Menu Principal?"); //lo regresa al menu si asi lo deasea
			System.out.println(" \n Si:1 \n No:2:");
			x = Integer.parseInt(Entra.readLine());
		}while(x==1);
		System.out.println("Vuelve Pronto"); //si no sale este mensaje
		System.out.println(".............................");
	}
}
