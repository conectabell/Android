package com.example.shellexecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class ShellExecuter {
 
     public ShellExecuter() {
 
        }
 
public String Executer(String command) throws IllegalArgumentException {
 
            StringBuffer output = new StringBuffer();
 
            Process p;
            try {
                p = Runtime.getRuntime().exec(command);
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
 
                String line = "";
                while ((line = reader.readLine())!= null) {
                    output.append(line + "\n");
                }
 
            } catch (IOException e) {
                e.printStackTrace();
                String problema = "Error: Introduzca un comando válido para Android Shell";
                return problema;
            } catch (InterruptedException e) {
                e.printStackTrace();
                String problema = "Error: Comando interrumpido";
                return problema;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                String problema = "Error: No ha escrito ningun comando, pruebe con cd, ls, ps...";
                return problema;  
            } catch (Exception e) {
                e.printStackTrace();
                String problema = "Error raro, me rallo, no se que ha pasado, que te den, hala.";
                return problema; }        
            	
            
            String response = output.toString();
            return response;
        }

/*Ejecuta en shell el comando uptime y nos lo devuelve*/

public String getUptime(){
	StringBuffer output = new StringBuffer();
	Process p;
	try {
		String command2 = "uptime";
        p = Runtime.getRuntime().exec(command2);
        p.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    String response = output.toString();
    return response; 
    
}
}