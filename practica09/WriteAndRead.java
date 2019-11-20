import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
public class WriteAndRead{
	public static void main(String... args){
		//escritor de archivos
		try{
			//archivo que se va a crear/escribir
			Path path=Paths.get("beep.txt");
			//lo que se va a escribir
			Files.write(path,"line 1\nline 2\n".getBytes());
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
		//lector de archivos
		try{
			//archivo que se va a leer
			Path path=Paths.get("coordenadas.txt");
			//se leen todas las lineas del archivo
			List<String> lines=Files.readAllLines(path);
			//por cada linea
			for(String string:lines){
				String row[]=string.split(",");//separamos en un array donde cada cosa entre comas es un elemento
				System.out.println("cord x: "+row[0]+"cord y: "+row[1]);// imprimimos en consola lo que leimos
			}
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}