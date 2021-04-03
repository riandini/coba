import java.util.Scanner;
import java.lang.Math;

public class PerhitunganBangunDatar2Vers {

	public static void showMenuSegitigaSamaSisi(){
		double sisi;
		double tinggi;
		double keliling;
		double luas;
		Scanner keyboard = new Scanner(System.in);

		System.out.println( "\t^Segitiga Sama Sisi^" );
		System.out.print("Masukan sisinya : ");
		sisi = keyboard.nextDouble();

		tinggi = hitungTinggiSegitiga(sisi);
		System.out.println("Tingginya yaitu :" + tinggi);

		keliling = hitungKelilingSegitiga(sisi);
		System.out.println("Kelilingnya yaitu :" + keliling);
		System.out.println("\tDengan rumus Sisi x 3");

		luas = hitungLuasSegitiga(sisi,tinggi);
		System.out.println("\nLuasnya yaitu :" + luas);
		System.out.println("\tDengan rumus 0.5 x sisi x tinggi");

	}

	public static void menuAplikasi(){
		System.out.println( "+------------------------------+" );
		System.out.println( "|                              |" );
		System.out.println( "|       Selamat Datang         |" );
		System.out.println( "|             di               |" );
		System.out.println( "|    Aplikasi Bangun Datar     |" );
		System.out.println( "|                              |" );
		System.out.println( "| Kode bangun datar :          |" );
		System.out.println( "|      1 Segitiga Sama Sisi    |" );
		System.out.println( "|      2 Segitiga Siku-Siku    |" );
		System.out.println( "|      3 Persegi Panjang       |" );
		System.out.println( "|      4 Lingkaran             |" );
		System.out.println( "+------------------------------+" );
	}

	public static void main( String[] args ) {
		programUtama();
	}

	public static int inputValidationInt(int nomor){
		Scanner keyboard = new Scanner(System.in);
		try{
			nomor = keyboard.nextInt();
		}catch(Exception exception){
			keyboard.next();
			nomor=0;
		}
		return nomor;
	}

	public static int selectedMenuValidation(int min, int max){
		int nomor=0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print( "Masukan kode bangun datar yang akan dihitung: " );
		
		try{
			nomor = keyboard.nextInt();
		}catch(Exception exception){
			keyboard.next();
			nomor=0;
		}
		
		while( nomor<min || nomor>max){
			System.out.println("Input kode yang kamu masukan tidak ada");
			menuAplikasi();
			System.out.print( "Masukan kode bangun datar yang akan dihitung: " );
			
			try{
				nomor = keyboard.nextInt();
			}catch(Exception exception){
				keyboard.next();
				nomor=0;
			}
			
		}
		return nomor;
	}

	public static void programUtama() {
		Scanner keyboard = new Scanner(System.in);
		String kesiapan;
		int nomor;
		double sisi=0, luas=0, keliling=0, tinggi=0, setengahAlas=0, sisiMiring=0, alas=0, panjang=0, lebar=0, jariJari=0;

		do{
			menuAplikasi();
			nomor = selectedMenuValidation(1,4);
			System.out.print( "Bangun datar yang kamu pilih ialah " );

			if ( nomor == 1 ) {
				showMenuSegitigaSamaSisi();
			}
			if ( nomor == 2 ) {
				System.out.println( "\t^Segitiga Siku-Siku^" );
				System.out.print("Masukan sisi miringnya : ");
				sisiMiring = keyboard.nextDouble();

				System.out.print("Sisi Alasnya :" );
				alas = keyboard.nextDouble();

				tinggi = hitungTinggiSegitigaSiku(sisiMiring,alas);
				System.out.println("Tingginya yaitu :" + tinggi);

				keliling = hitungKelilingSegitigaSiku(sisiMiring,alas,tinggi);
				System.out.println("Keliling dari segitiga siku-siku tersebut :" + keliling);
				System.out.println("\tDengan rumus Sisi Miring + Alas + Tinggi");

				luas = hitungLuasSegitigaSiku(alas,tinggi);
				System.out.println("\nLuasnya dari segitiga siku-siku tersebut :" + luas);
				System.out.println("\tDengan rumus 0.5 x alas x tinggi");
			}
			if ( nomor == 3 ) {
				System.out.println( "\t^Persegi Panjang^" );
				System.out.print("\nMasukan panjangnya : ");
				panjang = keyboard.nextDouble();

				System.out.print("Masukan lebarnya :" );
				lebar = keyboard.nextDouble();

				keliling = hitungKelilingPersegiPanjang(panjang,lebar);
				System.out.println("Kelilingnya dari persegi panjang tersebut :" + keliling);
				System.out.println("\tDengan rumus 2 x (panjang + lebar)");
				luas = panjang*lebar;
				System.out.println("\nLuasnya dari persegi panjang tersebut :" + luas);
				System.out.println("\tDengan rumus panjang x lebar)");
			}
			if ( nomor == 4 ) {
				System.out.println( "\t^Lingkaran^" );
				System.out.print("\nMasukan jari-jari : ");
				jariJari = keyboard.nextDouble();

				keliling = hitungKelilingLingkaran(jariJari);
				System.out.println("Kelilingnya dari lingkaran tersebut :" + keliling);
				System.out.println("\t*Dengan rumus 2 x 3.14 x jari-jari");

				luas = hitungLuasLingkaran(jariJari);
				System.out.println("\nLuasnya dari lingkaran tersebut :" + luas);
				System.out.println("\t*Dengan rumus 3.14 x jari-jari x jari-jari");
			}		
			System.out.println("Mau menghitung kembali ? (YA/TIDAK):" );
			kesiapan = keyboard.next();
		}while (kesiapan.equals ("YA"));
		System.out.println("Terimakasih..." );
	}

	public static double hitungTinggiSegitiga (double sisi){
		double tinggi, setengahAlas;
		setengahAlas = sisi/2;
		tinggi = Math.sqrt( (sisi*sisi)-(setengahAlas*setengahAlas) );
		return tinggi;
	}

	public static double hitungKelilingSegitiga (double sisi){
		double keliling;
		keliling = sisi*3;
		return keliling;
	}
	public static double hitungLuasSegitiga (double sisi, double tinggi){
		double luas;
		luas = 0.5*sisi*tinggi;
		return luas;
	}
	public static double hitungTinggiSegitigaSiku (double sisiMiring, double alas){
		double tinggi ;
		tinggi = Math.sqrt( sisiMiring*sisiMiring - alas*alas );
		return tinggi;
	}
	public static double hitungKelilingSegitigaSiku (double sisiMiring, double alas, double tinggi){
		double keliling;
		keliling = sisiMiring + alas + tinggi;
		return keliling;
	}
	public static double hitungLuasSegitigaSiku (double alas, double tinggi){
		double luas;
		luas = 0.5*alas*tinggi;
		return luas;
	}
	public static double hitungKelilingPersegiPanjang (double panjang, double lebar){
		double keliling;
		keliling = 2*(panjang + lebar);
		return keliling;
	}
	public static double hitungLuasPersegiPanjang (double panjang, double lebar){
		double luas;
		luas = panjang * lebar;
		return luas;
	}
	public static double hitungKelilingLingkaran (double jariJari){
		final double PHI=3.14;
		double keliling;
		keliling = 2 * PHI * jariJari;
		return keliling;
	}
	public static double hitungLuasLingkaran (double jariJari){
		final double PHI=3.14;
		double luas;
		luas = PHI * jariJari * jariJari;
		return luas;
	}
}