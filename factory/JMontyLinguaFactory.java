/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmontylingua3.factory;

import jmontylingua3.interfaces.JMontyLinguaInterface;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 *
 * @author denise-lhirondelle
 */
public class JMontyLinguaFactory {
    public JMontyLinguaFactory() throws Exception {
        PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("import sys\n"
                + "import os.path\n"
        );
        interpreter.exec("print os.getcwd()\n");
        interpreter.exec("if (os.path.exists('ExternalLib\\python')):\n"
                + "    sys.path.insert(0, os.path.abspath('ExternalLib\\python'))\n"
                + "    print 'Works in Windows'\n"
                + "elif (os.path.exists('ExternalLib/python')):\n" 
                + "    sys.path.insert(0, os.path.abspath('ExternalLib/python'))\n"
                + "    print 'Works in Nix '\n"
                + "else:\n"
                + "    print 'At least the condition is being checked.'\n"
                + "print sys.path\n"
        );
        interpreter.exec("from JMontyLingua import JMontyLingua");
        jyMontyLingua = interpreter.get("JMontyLingua");
    }
    
    public JMontyLinguaInterface create() {
        PyObject JMontyLinguaObj = jyMontyLingua.__call__();
        return (JMontyLinguaInterface)JMontyLinguaObj.__tojava__(JMontyLinguaInterface.class); 
    }

    private final PyObject jyMontyLingua;
}
