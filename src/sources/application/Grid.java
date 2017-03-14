/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources.application;

import java.awt.GridLayout;

/**
 *
 * @author admin_master
 */
public class Grid extends GridLayout{
    public Grid(int size){
        this.setColumns(size);
        this.setRows(size);
    }
}
