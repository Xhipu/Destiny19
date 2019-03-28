package de.destiny19.logic;

import de.destiny19.game.Main;
import de.destiny19.game.Timer;

import java.util.ArrayList;

public abstract class Spawner<T> {
    /*
    USAGE
    Spawner contains type array
    declare type in declaration
    declare duration in construction
    declare add method in construction
    run spawner with Spawner.spawn()
     */


    private ArrayList<T> m_instances;
    private Timer m_timer;

    public ArrayList<T> getInstances() {
        return m_instances;
    }

    public void setInstances(ArrayList<T> m_instances) {
        this.m_instances = m_instances;
    }

    public Timer getTimer() {
        return m_timer;
    }

    public void setTimer(Timer m_timer) {
        this.m_timer = m_timer;
    }

    public Spawner(int duration){
        setInstances(new ArrayList<T>());

        m_timer = new Timer() {
            @Override
            public void doAction() {
                addInstance();
                Main.devstream.println("Spawned one element");
            }
        };
        m_timer.setTaskDuration(duration);
        m_timer.init();
    }

    public void spawn(){
        getTimer().perform();
    }

    public abstract void addInstance();
}
