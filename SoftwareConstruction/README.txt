
===== READ ME =====
This is a readme file for the LTL Generator program.
Language: Java

===== About =======
Authors:
Victoria Bravo, Lucia Rodriguez, Jorge Martinez,
Troy McGarity, David Reyes, Florencia Larsen

Created:
August 3, 2015


===== Input File Needed ====
The input file must be placed in the same folder as the
program folder. 

The file must be name "file.txt"


===== Input File Format ====
The format of the input file, named "file.txt" is as follows:
	_______________
	|Scope: Global
	|Pattern: Precedence
	|PropP:	ParallelE 3
	|PropQ: Atomic 1
	|PropL:	EventualE 2
	|PropR: AtLeastOneE 4
	________________________
	
	The propositions must be followed by a number. Including a
	proposition of type "Atomic".
	
===== TO RUN ===========
Use a java compiler to execute the following class:

ltlGenerator/Main.java