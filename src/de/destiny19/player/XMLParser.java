package de.destiny19.player;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;

public class XMLParser {
	
	private static Player pl;
	private static PlayerInventory inv;
	
    public static String xmlFilePath = "Player.xml";
 
    public XMLParser (Player _pl, PlayerInventory _inv, String filePath) {
    	pl = _pl;
    	inv = _inv;
    	xmlFilePath = filePath;
    	
    	safePlayer();
    }
 
    private static void safePlayer () {
    	
        try {
 
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("Destiny19");
            document.appendChild(root);
 
            // player element
            Element player = document.createElement("Player");
            root.appendChild(player);
 
            // set an attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue("1");
            player.setAttributeNode(attr);
 
            // level element
            Element level = document.createElement("level");
            level.appendChild(document.createTextNode(Integer.toString(pl.GetLevel())));
            player.appendChild(level);
 
            // statPoints element
            Element statPoints = document.createElement("statPoints");
            statPoints.appendChild(document.createTextNode(Integer.toString(pl.GetStatPoints())));
            player.appendChild(statPoints);
 
            // skillPoints element
            Element skillPoints = document.createElement("skillPoints");
            skillPoints.appendChild(document.createTextNode(Integer.toString(pl.GetSkillPoints())));
            player.appendChild(skillPoints);
 
            // HP elements
            Element HP = document.createElement("HP");
            HP.appendChild(document.createTextNode(Integer.toString(pl.GetHP())));
            player.appendChild(HP);
            
            // aktHP elements
            Element aktHP = document.createElement("aktHP");
            aktHP.appendChild(document.createTextNode(Integer.toString(pl.GetAktHP())));
            player.appendChild(aktHP);
            
            // MP elements
            Element MP = document.createElement("MP");
            MP.appendChild(document.createTextNode(Integer.toString(pl.GetMP())));
            player.appendChild(MP);
            
            // aktMP elements
            Element aktMP = document.createElement("aktMP");
            aktMP.appendChild(document.createTextNode(Integer.toString(pl.GetAktMP())));
            player.appendChild(aktMP);
            
            // strength elements
            Element strength = document.createElement("strength");
            strength.appendChild(document.createTextNode(Integer.toString(pl.GetStrength())));
            player.appendChild(strength);
            
            // defence elements
            Element defence = document.createElement("defence");
            defence.appendChild(document.createTextNode(Integer.toString(pl.GetDefence())));
            player.appendChild(defence);
            
            // intelligence elements
            Element intelligence = document.createElement("intelligence");
            intelligence.appendChild(document.createTextNode(Integer.toString(pl.GetIntelligence())));
            player.appendChild(intelligence);
            
            // skillFire elements
            Element skillFire = document.createElement("skillFire");
            skillFire.appendChild(document.createTextNode(Integer.toString(pl.GetSkillLevelFire())));
            player.appendChild(skillFire);
            
            // skillIce elements
            Element skillIce = document.createElement("skillIce");
            skillIce.appendChild(document.createTextNode(Integer.toString(pl.GetSkillLevelIce())));
            player.appendChild(skillIce);
            
            // skillEarth elements
            Element skillEarth = document.createElement("skillEarth");
            skillEarth.appendChild(document.createTextNode(Integer.toString(pl.GetSKillLevelEarth())));
            player.appendChild(skillEarth);
            
            // skillBlood elements
            Element skillBlood = document.createElement("skillBlood");
            skillBlood.appendChild(document.createTextNode(Integer.toString(pl.GetSkillLevelBlood())));
            player.appendChild(skillBlood);
            
            //----------------------------------------------------
     
            
            // inventory element
            Element inventory = document.createElement("Inventory");
            root.appendChild(inventory);
            
            // nGold elements
            Element gold = document.createElement("Gold");
            gold.appendChild(document.createTextNode(Integer.toString(inv.getGold())));
            inventory.appendChild(gold);
            
            // nWood elements
            Element wood = document.createElement("wood");
            wood.appendChild(document.createTextNode(Integer.toString(inv.getWood())));
            inventory.appendChild(wood);
            
            // nStone elements
            Element stone = document.createElement("stone");
            stone.appendChild(document.createTextNode(Integer.toString(inv.getStone())));
            inventory.appendChild(stone);
            
            // nCopper elements
            Element copper = document.createElement("copper");
            copper.appendChild(document.createTextNode(Integer.toString(inv.getCopper())));
            inventory.appendChild(copper);
            
            // nIron elements
            Element iron = document.createElement("iron");
            iron.appendChild(document.createTextNode(Integer.toString(inv.getIron())));
            inventory.appendChild(iron);
            
            // nSteel elements
            Element steel = document.createElement("steel");
            steel.appendChild(document.createTextNode(Integer.toString(inv.getSteel())));
            inventory.appendChild(steel);
            
            // nObsidian elements
            Element obsidian = document.createElement("obsidian");
            obsidian.appendChild(document.createTextNode(Integer.toString(inv.getObsidian())));
            inventory.appendChild(obsidian);
            
            // nEntHearth elements
            Element entHearth = document.createElement("entHearth");
            entHearth.appendChild(document.createTextNode(Integer.toString(inv.getEntHearth())));
            inventory.appendChild(entHearth);
            
            // nDeamonSoul elements
            Element deamonSoul = document.createElement("deamonSoul");
            deamonSoul.appendChild(document.createTextNode(Integer.toString(inv.getDeamonSoul())));
            inventory.appendChild(deamonSoul);
            
            // nFlameEssence elements
            Element flameEssence = document.createElement("flameEssence");
            flameEssence.appendChild(document.createTextNode(Integer.toString(inv.getFlameEssence())));
            inventory.appendChild(flameEssence);
            
            // nIceEssence elements
            Element iceEssence = document.createElement("iceEssence");
            iceEssence.appendChild(document.createTextNode(Integer.toString(inv.getIceEssence())));
            inventory.appendChild(iceEssence);
            
            // nDarkEssence elements
            Element darkEssence = document.createElement("darkEssence");
            darkEssence.appendChild(document.createTextNode(Integer.toString(inv.getDarkEssence())));
            inventory.appendChild(darkEssence);
            
            // nLightEssence elements
            Element lightEssence = document.createElement("lightEssence");
            lightEssence.appendChild(document.createTextNode(Integer.toString(inv.getLightEssence())));
            inventory.appendChild(lightEssence);
            
            // nPinkFluffyUnicornHorn elements
            Element PinkFluffyUnicornHorn = document.createElement("PinkFluffyUnicornHorn");
            PinkFluffyUnicornHorn.appendChild(document.createTextNode(Integer.toString(inv.getPinkFluffyUnicornHorn())));
            inventory.appendChild(PinkFluffyUnicornHorn);
            
 
 
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
 
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            System.out.println("XMLParser - Player Saved");
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
    
    public void loadPlayer () throws JAXBException, FileNotFoundException {
    	File file = new File(xmlFilePath);
    	
        JAXBContext jaxbContextPl = JAXBContext.newInstance(Player.class);
        Unmarshaller unmarshallerPl = jaxbContextPl.createUnmarshaller();
        pl = (Player) unmarshallerPl.unmarshal(file);
        
        JAXBContext jaxbContextInv = JAXBContext.newInstance(PlayerInventory.class);
        Unmarshaller unmarshallerInv = jaxbContextInv.createUnmarshaller();
        inv = (PlayerInventory) unmarshallerInv.unmarshal(file);
    }
	
}
