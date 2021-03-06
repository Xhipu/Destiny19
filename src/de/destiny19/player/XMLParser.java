package de.destiny19.player;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.*;

import de.destiny19.Logger;
import de.destiny19.Main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;


public class XMLParser {
    public XMLParser () {

    }

    public void savePlayer () throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance( Player.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try{
            OutputStream os = new FileOutputStream( "Player.xml" );

            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<Player> je =  objectFactory.createPlayer(Main.mainframe.game.player);
            marshaller.marshal(je, os);


            Logger.trace("Player saved!");
        }catch (Exception e) {
            Logger.trace("Could not save player - "+e.getMessage());
        }
    }
    
    public Player loadPlayer () throws JAXBException, FileNotFoundException{
        try{
            File file = new File("Player.xml");
            JAXBContext jContext = JAXBContext.newInstance(Player.class);
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            Player player = (Player) unmarshallerObj.unmarshal(file);

            player.setTimer(player.getTimer());

            Logger.trace("Player loaded!");
            return player;

        } catch (Exception ex) {
            Logger.trace("Could not load player - "+ex.getMessage());
        }

        return null;
    }

    public void saveInventory () throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance( PlayerInventory.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try{
            OutputStream os = new FileOutputStream( "PlayerInventory.xml" );

            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<PlayerInventory> je =  objectFactory.createPlayerInventory(Main.mainframe.game.inv);
            marshaller.marshal(je, os);

            Logger.trace("Inventory saved!\n");
        }catch (Exception e) {
            Logger.trace("Could not save inventory - "+e.getMessage()+"\n");
        }
    }

    public PlayerInventory loadInventory () throws JAXBException, FileNotFoundException {
        try{
            File file = new File("PlayerInventory.xml");
            JAXBContext jContext = JAXBContext.newInstance(PlayerInventory.class);
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            PlayerInventory inv = (PlayerInventory) unmarshallerObj.unmarshal(file);


            Logger.trace("Inventory loaded!\n");
            return inv;

        } catch (Exception ex) {
            Logger.trace("Could not load inventory - "+ex.getMessage()+"\n");
        }

        return null;
    }

    private final static QName _Player_QNAME = new QName("", "Frame.game.player");
    @XmlElementDecl(namespace = "", name = "Player")
    public JAXBElement<Player> createPlayer(Player value) {
        return new JAXBElement<Player>(_Player_QNAME, Player.class, null, value);
    }

    private final static QName _PlayerInventory_QNAME = new QName("", "Frame.game.inv");
    @XmlElementDecl(namespace = "", name = "PlayerInventory")
    public JAXBElement<PlayerInventory> createPlayer(PlayerInventory value) {
        return new JAXBElement<PlayerInventory>(_PlayerInventory_QNAME, PlayerInventory.class, null, value);
    }
}
