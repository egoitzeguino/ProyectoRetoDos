package Interfaces;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ServidorRMI extends UnicastRemoteObject implements IGestionTerraza{
	
	private static final long serialVersionUID = 1L;
	public ServidorRMI() throws RemoteException {
        super();
    }
	@Override
	public void descargarArchivo(String fileUrl, String saveFilePath) throws IOException, RemoteException {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(fileUrl);
			URLConnection urlC= url.openConnection(); 
			String ct = urlC.getContentType();
			int cl = urlC.getContentLength();
			//System.out.println("ct = "+ ct + " cl = "+cl);
			if(ct.startsWith("text/") || cl ==-1) {
				//error
				//System.out.println("return");
				return;
			}
			InputStream is = urlC.getInputStream();
			BufferedInputStream in = new BufferedInputStream(is);
			
			FileOutputStream FOS = new FileOutputStream("clima.json");
			BufferedOutputStream out = new BufferedOutputStream(FOS);
			
			int i;
			while((i = in.read()) != -1) {
				out.write(i);
			}
			out.flush();
			in.close();
			FOS.close();
			out.close();
		}
		catch(MalformedURLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String interpretarArchivo(String filePath, String fecha) throws IOException, RemoteException {
		String estadoCielo="";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                jsonBuilder.append(linea);
            }

            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(jsonBuilder.toString()).getAsJsonArray();

            for (JsonElement elemento : jsonArray) {
                JsonObject objeto = elemento.getAsJsonObject();
                if(objeto.get("Fecha").getAsString().equals(fecha)) {
                	estadoCielo = objeto.get("EstadoCielo").getAsString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estadoCielo; // Si no se encuentra la cadena "EstadoCielo"
	}
	
	public static void main(String args[]) {
        try {
            ServidorRMI obj = new ServidorRMI();
            
         // Se registra el objeto remoto en el registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("GestionTerraza", obj);
            
            System.out.println("Objeto registrado");
        } catch (RemoteException re) {
            System.out.println("Error en el servidor: " + re.getMessage());
            re.printStackTrace();
        }
    }

}
