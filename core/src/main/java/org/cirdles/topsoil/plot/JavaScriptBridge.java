package org.cirdles.topsoil.plot;

/**
 * Intended to be added as a member to a JavaScriptPlot, so that the JavaScript may make upcalls to JavaFX.
 *
 * @author Emily Coleman
 */
public class JavaScriptBridge {

    public void test(Object data) {
        System.out.println(data + "\n");
    }

    /**
     * Prints a string to System.out.
     *
     * @param s String
     */
    public void println(String s) {
            System.out.println(s);
        }

}
