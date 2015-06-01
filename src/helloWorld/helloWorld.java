package helloWorld;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Gibt ein helloWorld aus 
 * @author Behar
 *
 */
public class helloWorld {
	
    private static final Logger log = LogManager.getLogger(helloWorld.class.getName());
	
	/**
	 * 
	 * @param say wird ausgegeben mit System.out.println
	 */
	static public void say(String say) {
		
		System.out.println(say);
	}
	
	/**
	 * 
	 * @param say wird ausgegeben mit log4j2 
	 */
	static public void sayInLog4j (String say) {
		
		log.info(say);
	}
	
}
