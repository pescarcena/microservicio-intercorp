package com.intercorp.springcloudmsconsulta.integracion.util;

public class Util {

	public static double promedio(int[] v) {
		double prom = 0.0;
		for (int i = 0; i < v.length; i++)
			prom += v[i];

		return prom / (double) v.length;
	}

	public static double desviacion(int[] v) {
		double prom, sum = 0;
		int i, n = v.length;
		prom = promedio(v);

		for (i = 0; i < n; i++)
			sum += Math.pow(v[i] - prom, 2);

		return Math.sqrt(sum / (double) n);
	}

}
