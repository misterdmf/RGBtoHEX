import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Program {
	public static void main(String[] args) {
		//HashMap to collect the families colors.
		//Key is family colors
		//Element is object with color details
		
		HashMap<String, String> map = new HashMap<>();
		String input = "";
		
		// Verify the number of parameters 
		if (args.length == 1) {
			input = args[0];
		} else {
			System.out.println("You have to pass the name of input file as parameter.");
			System.out.println("eg.: java Program input.csv");
			System.exit(0);
		}

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Output.json"));
			BufferedWriter bufferedWriterCSV = new BufferedWriter(new FileWriter("Output.csv"));

			//Head of files {input and output.csv}
			String line = bufferedReader.readLine();
			bufferedWriterCSV.write(line + ",Hex\n");
			while ((line = bufferedReader.readLine()) != null) {
				String[] csv = line.split(",");
				
				//Verify the format of input file
				if (csv.length != 5) {
					System.out.println("Input file with invalid format");
					break;
				}
				String family = csv[0];
				String name = csv[1];
				int r = new Integer(csv[2]);
				int g = new Integer(csv[3]);
				int b = new Integer(csv[4]);
				
				// Convert rgb to hex
				String hex = String.format("#%02x%02x%02x", r, g, b);
				
				//Write in output.csv
				bufferedWriterCSV.write(line + "," + hex + "\n");

				//Create new element in JSON format for output.json
				String newElement = "\t\t {\n" + "\t\t\t name: " + name + ",\n" + "\t\t\t hex: " + hex + "\n"
						+ "\t\t },\n";

				//If family {key} is already in collection, append new element.
				// Otherwise, just put a new key and element.
				if (map.containsKey(family)) {
					newElement += map.get(family);
					map.put(family, newElement);
				} else {
					map.put(family, newElement);
				}

			}
			bufferedWriter.write("TableColors:{\n");
			for (String key : map.keySet()) {
				bufferedWriter.write("\t " + key + ":{\n" + map.get(key) + "\n\t},\n");
			}
			bufferedWriter.write("};\n");

			//Close the IO process
			bufferedReader.close();
			bufferedWriter.flush();
			bufferedWriter.close();
			bufferedWriterCSV.flush();
			bufferedWriterCSV.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
