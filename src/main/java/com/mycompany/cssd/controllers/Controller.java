package com.mycompany.cssd.controllers;

/**
 *
 * @author NESAS
 */
public interface Controller {
    public void insert(String[] data);
    public void update(String[] data, int id);
    public void delete(int id);
    public void showAll();
    public void showById(int id);
}
