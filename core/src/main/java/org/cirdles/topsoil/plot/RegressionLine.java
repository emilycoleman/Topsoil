package org.cirdles.topsoil.plot;

import org.cirdles.mcLeanRegression.McLeanRegression;
import org.cirdles.mcLeanRegression.McLeanRegressionInterface;
import org.cirdles.mcLeanRegression.core.McLeanRegressionLineInterface;

public class RegressionLine {

    //args come in as Strings because arrays can't be passed between JavaScript and Java
    public void fitLineToDataFor2D(String x, String y, String x1SigmaAbs, String y1SigmaAbs, String rhos) {
        double[] xDouble = toDouble(x);
        double[] yDouble = toDouble(y);
        double[] x1SigmaAbsDouble = toDouble(x1SigmaAbs);
        double[] y1SigmaAbsDouble = toDouble(y1SigmaAbs);
        double[] rhosDouble = toDouble(rhos);

        McLeanRegressionLineInterface mcLeanRegressionLine;
        McLeanRegressionInterface mcLeanRegression = new McLeanRegression();
        mcLeanRegressionLine = mcLeanRegression.fitLineToDataFor2D(xDouble, yDouble, x1SigmaAbsDouble, y1SigmaAbsDouble, rhosDouble);
        //return mcLeanRegressionLine;
    }

    private double[] toDouble(String str) {
        String[] stringList = str.split(",");

        double[] doubleList = new double[stringList.length];

        for(int i = 0; i < stringList.length; i++) {
            doubleList[i] = Double.parseDouble(stringList[i]);
        }

        return doubleList;
    }
}
