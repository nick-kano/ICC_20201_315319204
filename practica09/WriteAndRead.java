import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Math;
public class WriteAndRead{
	public static void main(String... args){
		String aux="",aux4="";
		double aux2=0.0,aux3=0.0;
		//escritor de archivos
		try{
			//archivo que se va a crear/escribir
			Path path2=Paths.get("polares.txt");
			//archivo que se va a leer
			Path path=Paths.get("coordenadas.txt");
			//se leen las lineas del archivo
			List<String> lines=Files.readAllLines(path);
			//por cada linea convertimos las cordenadas que vienen a polares
			for(String string:lines){
				String row[]=string.split(",");//separamos en un array donde cada cosa entre comas es un elemento
				aux2=Math.sqrt((Double.parseDouble(row[0])*Double.parseDouble(row[0]))+(Double.parseDouble(row[1])*Double.parseDouble(row[1])));//magnitud del vector
				aux3=Math.atan(Double.parseDouble(row[1])/Double.parseDouble(row[0]));//angulo del vector
				aux="("+aux2+","+aux3+")\n";
				aux4+=aux;//buffer de la linea
			}
			Files.write(path2,aux4.getBytes());//la escritura del archivo
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}