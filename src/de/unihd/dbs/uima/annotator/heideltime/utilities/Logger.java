package de.unihd.dbs.uima.annotator.heideltime.utilities;
/**
 * Logger class to facilitate a centralized logging effort. Upon initialization of
 * the HeidelTime annotator, the verbosity (printDetails) should be set; any kind of
 * output should be done using either the printDetail()-methods for DEBUG-Level,
 * conditional output or the printError()-methods for ERROR-Level, unconditional
 * output.
 * 
 * @author julian zell
 *
 */
public class Logger {
	private static Boolean printDetails = false;

	/**
	 * Controls whether DEBUG-Level information is printed or not
	 * @param printDetails
	 */
	public static void setPrintDetails(Boolean printDetails) {
		Logger.printDetails = printDetails;
	}
	
	/**
	 * print DEBUG level information with package name
	 * @param component Component from which the message originates
	 * @param msg DEBUG-level message
	 */
	public static void printDetail(Package component, String msg) {
		if(Logger.printDetails) {
			String preamble;
			if(component != null) 
				preamble = "["+component.getName()+"]";
			else
				preamble = "";
			System.out.println(preamble+" "+msg);
		}
	}
	
	/**
	 * no-package proxy method
	 * @param msg DEBUG-Level message
	 */
	public static void printDetail(String msg) {
		printDetail(null, msg);
	}
	
	/**
	 * print an ERROR-Level message with package name
	 * @param component Component from which the message originates
	 * @param msg ERROR-Level message
	 */
	public static void printError(Package component, String msg) {
		String preamble;
		if(component != null) 
			preamble = "["+component.getName()+"]";
		else
			preamble = "";
		System.err.println(preamble+" "+msg);
	}

	/**
	 * no-package proxy method
	 * @param msg ERROR-Level message
	 */
	public static void printError(String msg) {
		printError(null, msg);
	}
}
