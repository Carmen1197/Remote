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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ryukai
 */
public class servidor {
    public static void main(String []args) throws IOException
    {

        final int Port = 1099;
        byte[] ArrayBytes = new byte[1024];

        try
        {
            JOptionPane.showMessageDialog(null,"PROCESANDO......");
           DatagramSocket datagsocket = new DatagramSocket(Port);
           
           while(true)
           {              
           DatagramPacket Solicitud = new DatagramPacket(ArrayBytes, ArrayBytes.length);
           datagsocket.receive(Solicitud);
 //=================================================================================================================
           JOptionPane.showMessageDialog(null,"RECIBIENDO INFORMACION....");
           String mensaje = new String(Solicitud.getData());
           JOptionPane.showMessageDialog(null,mensaje);
        
          int VerificandoPortClient = Solicitud.getPort();
        //Clase3      OBJ3
          InetAddress Localidad = Solicitud.getAddress();
          
           byte [] NewArray = new byte[1024];
         
           mensaje = new String(Solicitud.getData()); ;
          NewArray = mensaje.getBytes();

//==================================================================================================================          
          //Creando otro paquete para verificar la respuesta
        
          DatagramPacket mensajerespuesta = new DatagramPacket(NewArray, NewArray.length, Localidad, VerificandoPortClient);
          
          JOptionPane.showMessageDialog(null,"ENVIANDO RESPUESTA AL ");
          datagsocket.send(mensajerespuesta);
               
           }
           
        }
        catch(SocketException Valor_Excepxion)
        {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, Valor_Excepxion);

        }

    }
    
}
