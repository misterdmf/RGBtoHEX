# RGBtoHEX
The program receive a input csv file with some colors descriptions(family, name and RGB), then create two new files(csv and json format) with the colors descriptions, but with HEX codes

## Requirements
* java
* A csv file with colors descriptions


## Compile
at folder of the project run: </br>
javac -d bin src/*.java</br>


## Execute
at /bin of the project run: </br>
java Program input.csv</br>

## Input data

The program receive one file as input data: - **input.csv**
###  input.csv
This file have contain a description of set of colors. The file format should follow this model:

Family, Name, R, G, B</br>
Basic, Red, 191, 4, 17</br>
Texture, Violet, 108, 83, 142</br>
...</br>


## Output

The program will create two file as output data: - **Output.csv** and **Output.json**

### Output.csv
This file contain the same data of input.csv and the **HEX codes** of each color.
The file has the following format:

Family, Name, R, G, B, HEX</br>
Basic, Red, 191, 4, 17, #bf0411</br>
Texture, Violet, 108, 83, 142, #6c538e</br>
...</br>

### Output.json
This file contain the same data of input.csv and the **HEX codes** of each color. Separating each color according to their respective family.

The file has the following format:
```json
TableColors:{
	 Basic:{
		 {
			 name: Yellow,
			 hex: #feee00
		 },
		 {
			 name: Blue,
			 hex: #005290
		 },
		 {
			 name: Red,
			 hex: #bf0411
		 },

	},
	 Special:{
		 {
			 name: Ocher,
			 hex: #b68d1b
		 },
		 {
			 name: Black,
			 hex: #211915
		 },
		 {
			 name: Green,
			 hex: #006c4b
		 },

	},
	 Texture:{
		 {
			 name: Brown,
			 hex: #6a5f4d
		 },
		 {
			 name: Orange,
			 hex: #ca5f4c
		 },
		 {
			 name: Violet,
			 hex: #6c538e
		 },

	},
};
```
## Author

### Davi Morais Ferreira, Msc.
Software Engineer with over 10 years experience designing and analyzing complex algorithms. Always 
seeking to improve the efficiency of algorithmic solutions. Taught courses in algorithm design and 
analysis, data structure and object‐oriented programming to over 2500 students at a top 10 
university in Brazil. 
