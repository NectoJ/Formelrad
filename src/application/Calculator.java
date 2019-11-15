package application;

/**
 * Berechnet das Formelrad
 * 
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;

	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
		
		calculate();
	}

	public double getLeistung() {
		return leistung;
	}

	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + ", spannung=" + spannung + ", strom=" + strom + ", widerstand="
				+ widerstand + "]";
	}

	public void calculate() {

		int inputs = 0;
		if(leistung.isEmpty()) {
			inputs++;
		}
		if(spannung.isEmpty()) {
			inputs++;
		}
		if(strom.isEmpty()) {
			inputs++;
		}
		if(widerstand.isEmpty()) {
			inputs++;
		}

		if (leistung != 0.0 && spannung != 0.0) {
			strom = leistung / spannung;
			widerstand = spannung * spannung / leistung;
		} else if (leistung != 0.0 && strom != 0.0) {
			spannung = leistung / strom;
			widerstand = leistung / (strom * strom);
		} else if (leistung != 0.0 && widerstand != 0.0) {
			spannung = Math.sqrt(leistung * widerstand);
			strom = Math.sqrt(leistung / widerstand);
		} else if (spannung != 0.0 && widerstand != 0.0) {
			leistung = spannung * spannung / widerstand;
			strom = spannung / widerstand;
		} else if (spannung != 0.0 && strom != 0.0) {
			leistung = spannung * strom;
			widerstand = spannung / strom;
		} else if (widerstand != 0.0 && strom != 0.0) {
			leistung = widerstand * strom * strom;
			spannung = strom * widerstand;
		}
	}

	public double pAusUundI(double u, double i) {
		return u * i;
	}

	public double pAusRundI(double r, double i) {
		return r * i * i;
	}

	public double pAusUundR(double u, double r) {
		return u * u / r;
	}

	public double iAusPundR(double p, double r) {
		return Math.sqrt(p / r);
	}

	public double iAusPundU(double p, double u) {
		return p / u;
	}

	public double iAusUundR(double u, double r) {
		return u / r;
	}

	public double uAusRundI(double r, double i) {
		return r * i;
	}

	public double uAusPundI(double p, double i) {
		return p / i;
	}

	public double uAusPundR(double p, double r) {
		return Math.sqrt(p * r);
	}

	public double rAusUundI(double u, double i) {
		return u / i;
	}

	public double rAusPundI(double p, double i) {
		return p / (i * i);
	}

	public double rAusUundP(double u, double p) {
		return (u * u) / p;
	}
}
