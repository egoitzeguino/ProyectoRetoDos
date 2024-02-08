package Interfaces;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGestionTerraza extends Remote{
	 void descargarArchivo(String fileUrl, String saveFilePath) throws IOException, RemoteException;
	 String interpretarArchivo(String filePath,String fecha) throws IOException,RemoteException;
}
