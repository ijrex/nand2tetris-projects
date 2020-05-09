// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.


(RESET)
	// USE R1 TO STORE CURRENT
	// REGISTER ADDRESS OF PIXEL

	@SCREEN
	D=A
	@R1
	M=D	

(LOOP)
	// SET D TO -1 (BLACK)
	// IF KEY IS PRESSED

	@KBD
	D=M
	@WHT
	D;JEQ
	D=-1
	(WHT)	

	// UPDATE CURRENT PIXEL
	// REGISTER BASED ON KEY INPUT

	@R1
	A=M
	M=D

	// RESET IF PIXEL REGISTER HAS
	// REACHED BOTTOM OF SCREEN

	@24575
	D=A
	@R1
	D=D-M
	@RESET
	D;JEQ
	

	// INCREASE PIXEL POSITION
	// TO NEXT REGISTER

	@R1
	M=M+1	

	@LOOP
	0;JMP
