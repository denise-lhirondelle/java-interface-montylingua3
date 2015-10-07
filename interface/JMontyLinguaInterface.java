/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmontylingua3.interfaces;

/**
 *
 * @author denise-lhirondelle
 */
public interface JMontyLinguaInterface {
    public String jist_predicates(String text);
    public String jist(String text);
    public String tag_text(String text);
    public String chunk_text(String text);
    public String lemmatise_text(String text);
}
