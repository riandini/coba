import java.util.Scanner;
import static java.lang.System.*;

public class ValidasiFunction{
	public static void main( String[] args){
		Scanner keyboard = new Scanner(System.in);
		
		String nama = " ", inputUser, tempatLahir;
		boolean isValid;
		int umur, tinggi, beratBadan;
		
		nama = validationInputUser("masukan nama anda: ", "Maaf input tidak boleh mengandung angka");
		tempatLahir = validationInputUser ( "masukan tempat lahir anda: ","Maaf input tidak boleh mengandung angka");
		
		//validasi regex untuk angka "\\d+"
		umur = validationInputUserInt("Masukan umur anda: ", " Maaf inputan hanya angka");
		tinggi = validationInputUserInt("Masukan tinggi badan anda: ", " Maaf inputan hanya angka");
		beratBadan = validationInputUserInt ( "Masukan berat badan anda: ", " Maaf inputan hanya angka");
		System.out.println();
		System.out.println("Hi my name is, " + nama);
		System.out.println("I was born at " + tempatLahir);
		System.out.println("i was " + umur + " Years old now");
		System.out.println("my height is: " + tinggi + " m");
		System.out.println("and my weight is berapa cik? " + beratBadan + " KG ehehe");
		
		
		
		
		
	}
	
	public static String validationInputUser(String question, String errorMessage){
		
			Scanner keyboard = new Scanner(System.in);
			String nama = " ", inputUser;
			boolean isValid;
		
		do{
			
			System.out.println(question);
			inputUser = keyboard.next();
		
		//validasi regex inputUser yg hanya menerima alphabet
		isValid = inputUser.matches("[a-zA-Z[ ]]+");
		
		if(isValid){
			nama = inputUser;
		}else{
			System.out.println(errorMessage);
		}
		
		}while(!isValid);
		
		return nama;
		
	}
	
	public static int validationInputUserInt(String question, String errorMessage){
		
			Scanner keyboard = new Scanner(System.in);
			String nama = " ", inputUser;
			int umur = 0;
			boolean isValid;
		
		do{
			
			System.out.println(question);
			inputUser = keyboard.next();
		
			isValid = inputUser.matches("\\d+");
			if (isValid){
				umur = Integer.valueOf(inputUser);
			}else{
					System.out.println(errorMessage);
			}
		
		}while(!isValid);
		
		return umur;
		
	}
	
	
}