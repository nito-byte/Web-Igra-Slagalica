/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.jsf.avion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MyBean{
    private boolean showDo=true;
    private boolean showUndo=false;

    public void doAction(){
      showUndo=true;
     // showDo=false;
    }

    public void undoAction(){
      showDo=true;
    }

    public boolean isShowDo() {
        return showDo;
    }

    public void setShowDo(boolean showDo) {
        this.showDo = showDo;
    }

    public boolean isShowUndo() {
        return showUndo;
    }

    public void setShowUndo(boolean showUndo) {
        this.showUndo = showUndo;
    }
    
}
