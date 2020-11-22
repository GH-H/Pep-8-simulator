
package model;

import controller.Controller;
import model.instructionType.*;

/**
 * This class reads the input binary strings and assign them to correct
 * instruction obj
 *
 * @version 22 November 2020
 */
public final class Decode {

	/**
	 * Decode the binary string and create the appropriate Instruction object.
	 * 
	 * @throws IllegalArgumentException if value for immediate is out of bound.
	 */
	public Instruction decodeInstruction(final Controller theCon, final String theInstructionRegister) throws IllegalArgumentException {
		Instruction instruction;

		if (theInstructionRegister.length() != 24) {
			throw new IllegalArgumentException("Entered InstructionRegister is not 24 bits long.");
		}
		String instructionSpecifier = theInstructionRegister.substring(0,8);
		String operandSpecifier = theInstructionRegister.substring(8);

		// Decode and create appropriate instruction
		switch (instructionSpecifier) {
			case "00000000": // STOP
				instruction = new Stop(instructionSpecifier, null);
				theCon.setMyInstructionWordLabel("Stop");
				break;

			case "01110000": //i,ac
				instruction = new Addr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ADDA, i");
				break;
			case "01111000": //i,index
				instruction = new Addr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ADDX, i");
				break;
			case "01110001": //address,ac
				instruction = new Addr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ADDA, d");
				break;

			case "10000000": //i,ac
				instruction = new Subr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("SUBA, i");
				break;
			case "10001000": //i,index
				instruction = new Subr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("SUBX, i");
				break;
			case "10000001": //address,ac
				instruction = new Subr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("SUBA, d");
				break;
			case "10001001": //address,index
				instruction = new Subr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("SUBX, d");
				break;

			case "00010010":  // BRV i
				instruction = new BRV(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("BRV, i");
				break;

			case "00010100":  // BRC i
				instruction = new BRC(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("BRC, i");
				break;

			case "00011000":  // NOTA
				instruction = new NOTr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("NOTA");
				break;
			case "00011001":  // NOTX
				instruction = new NOTr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("NOTX");
				break;

			case "10010000": // ANDA, i
				instruction = new ANDr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ANDA, i");
				break;
			case "10010001": // ANDA, d
				instruction = new ANDr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ANDA, d");
				break;
			case "10010010": // ANDA, n
				instruction = new ANDr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ANDA, n");
				break;
			case "10011000": // ANDX, i
				instruction = new ANDr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ANDX, i");
				break;
			case "10011001": // ANDX, d
				instruction = new ANDr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ANDX, d");
				break;
			case "10011010": // ANDX, n
				instruction = new ANDr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ANDX, n");
				break;

			case "10100000": // ORA, i
				instruction = new ORr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ORA, i");
				break;
			case "10100001": // ORA, d
				instruction = new ORr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ORA, d");
				break;
			case "10100010": // ORA, n
				instruction = new ORr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ORA, n");
				break;
			case "10101000": // ORX, i
				instruction = new ORr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ORX, i");
				break;
			case "10101001": // ORX, d
				instruction = new ORr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ORX, d");
				break;
			case "10101010": // ORX, n
				instruction = new ORr(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("ORX, n");
				break;

			case "01001010": // CHARI, n
				instruction = new CharIn(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("CHARI, n");
				break;
			case "01001001": // CHARI, d
				instruction = new CharIn(instructionSpecifier, operandSpecifier);
				theCon.setMyInstructionWordLabel("CHARI, d");
				break;

			default:
				theCon.setMyInstructionWordLabel("");
				throw new IllegalArgumentException("Instruction " + instructionSpecifier + " not supported.");
		}
		return instruction;
	}
}