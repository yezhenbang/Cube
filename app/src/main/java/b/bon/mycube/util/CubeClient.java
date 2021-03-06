package b.bon.mycube.util;

import android.util.Log;

import java.io.*;
import java.net.Socket;

public class CubeClient {

    private final static String IP = "192.168.0.102";

    private final static int PORT = 8082;

    private Socket socket;

    public CubeClient() {
        this(IP, PORT);
    }

    public CubeClient(String ip, int port) {
        try {
            Log.i("cube", "ready to connect "+ip+":"+port);
            socket =new Socket(ip,port);
            Log.i("cube","connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String send(String message){
        String str = null;
        try {
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            pw.write(message);
            pw.flush();
            socket.shutdownOutput();
            StringBuilder reply = new StringBuilder();
            while ((str = br.readLine()) != null) {
                reply.append(str);
            }
            str = reply.toString();
            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return str;
        }
    }

    public static void main(String[] args) {
        String result = new CubeClient().send("UBUDUDDFDLLRFRRRBLBUFRFRBDFDFDLDLUBURRLLLULURBDFBBFBUF");
        System.out.println("解决步骤：" + result);
    }
}
