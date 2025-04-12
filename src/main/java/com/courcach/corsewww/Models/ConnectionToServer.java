package com.courcach.corsewww.Models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionToServer {
    private Socket userSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void connect(String serverAddress, int port) {
        try {
            userSocket = new Socket(serverAddress, port);
            out = new ObjectOutputStream(userSocket.getOutputStream());
            in = new ObjectInputStream(userSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String authenticate(String login, String password) throws IOException, ClassNotFoundException {
        try {
            String operationType = "LOGIN";
            out.writeObject(operationType);
            out.writeObject(login);
            out.writeObject(password);
            out.flush();
            return (String) in.readObject();
        } finally {
            disconnect();
        }
    }
    
    
    public Boolean register(String email, String name, String surname, String login, String password) throws IOException, ClassNotFoundException {
        try{
            String operationType = "REGISTER";
            out.writeObject(operationType);
            out.writeObject(email);
            out.writeObject(name);
            out.writeObject(surname);
            out.writeObject(login);
            out.writeObject(password);
            out.flush();
            return (Boolean) in.readObject();
        }finally {
            disconnect();
        }
        
    }
    
    public void disconnect() throws IOException {
        try {
            if (out != null) out.close();
        } finally {
            try {
                if (in != null) in.close();
            } finally {
                if (userSocket != null) userSocket.close();
            }
        }
    }
}