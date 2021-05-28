/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ryukai
 */


public class cliente {
    public static void main(String []args) throws IOException
    {
        //Puerto
        final int PortDelServer = 1099;
        byte[] ArrayBytes = new byte[1024];
        String Cadena;
        String Ip;
        
        //Creando el socket
        try
        {  
            //  Pedimos la IP del servidor
            Ip = JOptionPane.showInputDialog("INTRODUZCA IP DEL SERVIDOR: ");//Mensaje para obtener ip
            
            
            InetAddress Localserver = InetAddress.getByName(Ip); //capturamos la ip
            
            
            //Creamos los datagramaSocket
            DatagramSocket datagsocket = new DatagramSocket();
           
            do{
            
                 Cadena =(JOptionPane.showInputDialog("INSERTE CADENA: "));
                 ArrayBytes = Cadena.getBytes();  


                DatagramPacket datagpacket = new DatagramPacket(ArrayBytes, ArrayBytes.length, Localserver, PortDelServer);

                JOptionPane.showMessageDialog(null,"ENVIANDO DATAGRAMA...");
                datagsocket.send(datagpacket);


                DatagramPacket Solicitud = new DatagramPacket(ArrayBytes, ArrayBytes.length);

                datagsocket.receive(Solicitud);

                JOptionPane.showMessageDialog(null,"RECIBINDO SOLICITUD");

                  Cadena = new String (Solicitud.getData());

                 JOptionPane.showMessageDialog(null, Cadena);

                datagsocket.close();

            }while(!"".equals(Cadena)); 
            
        }
        catch(SocketException Valor_Excepxion)
        {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, Valor_Excepxion);

        } catch (IOException Valor_Excepxion) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, Valor_Excepxion);
        }
        
    }
}
