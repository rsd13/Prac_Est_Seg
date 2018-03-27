package shelter;

import aux.ObjetoEnvio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import static shelter.AES.doEncryptedAES;

/**
 */
public class ConexionServidor implements ActionListener {

    private Usuario usuario;
    private Socket socket;
    private JTextField tfMensaje;
    private String key;
    private Mensaje mensaje;

    public void escribirSocket(ObjetoEnvio objeto) {

        //OutputStream flujo = null;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println(objeto);
            oos.writeObject(objeto);
        } catch (Exception ex) {
            System.out.println("Fallo en envia socket de Conexion servidor");
        }

    }
    
    public ObjetoEnvio leerSocket(Socket socket) throws IOException {
        ObjetoEnvio objeto = null;

        InputStream aux = socket.getInputStream();
        ObjectInputStream flujo = new ObjectInputStream(aux);
        try {
            objeto = (ObjetoEnvio) flujo.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Shelter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objeto;
    }

    //registra el usuario en el servidor
    public ConexionServidor(Usuario usuario, String key) {
        this.usuario = usuario;
        String user = usuario.getUsuario();
        String ip = usuario.getIP();
        int port = usuario.getPuerto();
        this.key = key;

        try {
            socket = new Socket(ip, port);
            System.out.println("Socket creado correctamente.");
            //registro al usuario en el servidor
            
            RSA objetoRSA = new RSA(1024);
            
            String claves = objetoRSA.getPublicKey() + ":" + objetoRSA.getPrivateKey() + ":" + objetoRSA.getModulus();
            
            
            
            ObjetoEnvio objeto = new ObjetoEnvio(user,"servidor",claves,"REGISTRO");
            escribirSocket(objeto);

        } catch (IOException ex) {
            System.out.println("Error al crear socket");
        }

    }

    public void setJTextField(JTextField tfMensaje) {
        this.tfMensaje = tfMensaje;
    }

    public Socket getSocket() {
        return socket;
    }
    
    public void setMensaje(Mensaje m){mensaje = m;}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String user = usuario.getUsuario();
        String receptor = mensaje.getReceptor();
        ObjetoEnvio objeto = new ObjetoEnvio();
        objeto.setEmisor(user);
        objeto.setReceptor(receptor);
        objeto.setTipo("MENSAJE");
        
        String mensajeCifrado = doEncryptedAES(user + ": " + tfMensaje.getText(), key);
                
        objeto.setMensaje(mensajeCifrado);
        escribirSocket(objeto);
        tfMensaje.setText("");
    }
    

}
