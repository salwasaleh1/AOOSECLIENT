/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmi.Trips_interface;
import rmi_client.posttrip;
/**
 *
 * @author hp
 */
public class posttrips_controller {
    posttrip gui3;
    Registry r;

    public posttrips_controller(posttrip gui3, Registry r) {
        this.gui3 = gui3;
        this.r = r;
        gui3.getjButton1OISTTRIPsubmit().addActionListener(new getSubmitbtn());
    }
    class getSubmitbtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try {
                Trips_interface p = (Trips_interface)r.lookup("trip");
                
                String rloc = gui3.getjTextField2POSTTRIPloc().getText();
                String rcate = gui3.getjTextField1POSTTRIPcate().getText();
                int rprice = Integer.parseInt(gui3.getjTextField3POSTTRIPprice().getText());
                int rResv = Integer.parseInt(gui3.getjTextField4POSTTRIPReservno().getText());
                p.post_trips(rcate, rprice, rcate, rprice);
                
                gui3.getjLabel1POSTTRIPLABELSUCESS().setText("TRIP POSTED");
                
            } catch (Exception e) {
            }
            
            
        }
    
        
    
    }
    
}
