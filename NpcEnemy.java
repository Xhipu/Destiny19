package de.destiny19.Destiny19;


public class NpcEnemy {

    private int nLevel;
    private int nMaxHP;
    private int nAktHP;
    private int nDamage;
    private int nDefence;



    //Sprites => Benamung der Sprites = Monster1.jpg, Monster2.jpg ...
    //Randomzahl + Name ("Monster" + rndm <= max Anzahlmonster + ".jpg")

    NpcEnemy (int _nLevel, int _nMaxHP, int _nDamage, int _nDefence) {
        nLevel = _nLevel;
        nMaxHP = _nMaxHP;
        nAktHP = nMaxHP;
        nDamage = _nDamage;
        nDefence = _nDefence;
    }

    public int getLevel () {
        return nLevel;
    }

    public int getMaxHP () {
        return nMaxHP;
    }

    public int getAktHP () {
        return nAktHP;
    }

    public int getDamage () {
        return nDamage;
    }

    public int getDefence () {
        return nDefence;
    }

    public bool getDamage (int _nDamage) {
        if(_nDamage >= nAktHP) {
            return false;
        } else {
            nAktHP -= _nDamage;
        }
    }
}