package de.destiny19.player;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

import de.destiny19.Main;
import de.destiny19.game.Timer;

@XmlRegistry
public class ObjectFactory {
    private final static QName _Player_QNAME = new QName("", "Player");
    private final static QName _Timer_QNAME = new QName("", "Timer");
    private final static QName _PlayerInventory_QNAME = new QName("", "playerinventory");


    public ObjectFactory() {

    }

    public Player createPlayer () {
        return Main.GetPlayer();
    }

    public PlayerInventory createInventory () {
        return Main.mainframe.game.inv;    		
    }

    @XmlElementDecl(namespace = "", name = "Player")
    public JAXBElement<Player> createPlayer(Player value) {
        return new JAXBElement<Player>(_Player_QNAME, Player.class, null, value);
    }
    @XmlElementDecl(namespace = "", name = "Timer")
    public JAXBElement<Timer> createTimer(Timer value) {
        return new JAXBElement<Timer>(_Timer_QNAME, Timer.class, null, value);
    }

    @XmlElementDecl(namespace="https://www.example.org/playerinventory", name = "playerinventory")
    public JAXBElement<PlayerInventory> createPlayerInventory(PlayerInventory value) {
        return new JAXBElement<PlayerInventory>(_PlayerInventory_QNAME, PlayerInventory.class, null, value);
    }
}
