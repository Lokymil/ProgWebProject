package fr.esiea.main.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SqlScriptUtils {
	
	public static String getScript(String fileName, Class clazz) throws Exception{
		String script = null;
		
		ClassLoader classLoader = clazz.getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		String path = file.getPath();
		
		 byte[] encoded = Files.readAllBytes(Paths.get(path));
		 script = new String(encoded, "UTF-8");
		
		return script;
	}
	
}
