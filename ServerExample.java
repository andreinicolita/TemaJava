package ro.mta.ip.lab4.tema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerExample
{
    private ServerSocket serverSocket;
    private ArrayList<Human> humans = new ArrayList<>();

    public void add(Human om)
    {
        humans.add(om);
        System.out.println(om.toString());
    }

    public void startConexiune(int port)
    {
        try
        {
            serverSocket = new ServerSocket(port);
            while(true)
            {
                // realizeaza conexiune
                new ClientHandler(serverSocket.accept(),this).start();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    // de ce extends Thread la ce ma ajuta? cum apelez?
    public static class ClientHandler extends Thread
    {
        private Socket clientSocket;
        private ServerExample server;
        private BufferedReader stdIn;
        private PrintWriter out;
        private BufferedReader in;
        private String inLine, outLine;

        // un simplu constructor
        public ClientHandler(Socket socketClient, ServerExample server)
        {
            this.clientSocket = socketClient;
            this.server = server;
        }

    @Override
        public void run()
        {
            try
            {
                out = new PrintWriter(clientSocket.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                stdIn = new BufferedReader(new InputStreamReader(System.in));
                out.println("Server - Conexiune realizata");

                String inLine, outLine;
                while ((inLine = in.readLine()) != null)
                {
                    out.println(inLine);

                    if (inLine.equals("bye"))
                        break;

                    if(inLine.equals("bye all"))
                        return;

                    HandleMessage(inLine);
                }
                in.close();
                out.close();
                clientSocket.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        private void HandleMessage(String mesaj)
        {
            String[] elements = mesaj.split(" ");
            if(elements[0].equals("Student") || elements[0].equals("student") )
            {
                Student std = new Student(elements[1], elements[2], elements[3],Integer.valueOf(elements[4]),Integer.valueOf(elements[5]));
                server.add(std);

            }
            else if(elements[0].equals("Profesor") || elements[0].equals("profesor") )
            {

                Profesor prof = new Profesor(elements[1], elements[2], elements[3],Integer.valueOf(elements[4]),elements[5]);
                server.add(prof);
            }
        }

    }


    public static void main(String[] args)
    {
        int port = Integer.parseInt(args[0]);

        ServerExample server = new ServerExample();
        server.startConexiune(port);
    }

}