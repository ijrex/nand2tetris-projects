// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)


	// RESET R2 TO 0

	@R2
	M=0

	// START LOOP

(LOOP)

	// DECREASE R1 BY 1 AT THE START OF EACH LOOP

	@R1
	M=M-1
	D=M
	
	// IF R1 < 0 JUMP TO 'END'

	@END
	D;JLT

	// ADD THE VALUE OF R1 TO R2 AND LOAD INTO R2

	@R0
	D=M

	@R2
	M=M+D

	// UNCONDITIONALLY JUMP BACK TO 'LOOP'

	@LOOP
	0;JMP

(END)

	//INFINITE LOOP TO END THE PROGRAMME

	@END
	0;JMP



















	
