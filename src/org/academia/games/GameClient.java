package org.academia.games;

import org.academia.server.serverClient.ClientPOJO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public abstract class GameClient {

    public BufferedReader in;
    public PrintWriter out;
    private ClientPOJO client;

    public GameClient(ClientPOJO client) {

        try {
            this.client = client;
            this.in = new BufferedReader(new InputStreamReader(client.getSocket().getInputStream()));
            this.out = new PrintWriter(client.getSocket().getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public String getName(){
        return client.getName();
    }

    public int getChips() {
        return client.getChips();
    }

    public void addChips(int chips) {
        client.addChips(chips);
    }

    public boolean removeChips(int chips) {
        return client.removeChips(chips);
    }

    public void getBacktoChat() {
        client.getBackToList();
    }

    public void removeFromLobby(){
        client.removeFromList();
    }

    public void removeFromQueue(){
        client.setOnQueue(false);
    }

}
