package application;

import javafx.scene.control.Alert;

/**
 * Berechnet das Formelrad
 * 
 * @author Raphael Suter und Jamie Lam
 * @version 01.11.2019
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
		if (leistung == 0.0) {
			inputs++;
		}
		if (spannung == 0.0) {
			inputs++;
		}
		if (strom == 0.0) {
			inputs++;
		}
		if (widerstand == 0.0) {
			inputs++;
		}

		if (inputs != 2) {
			System.out.println("Es sollten nur 2 Felder ausgefuellt werden!");
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Es sollten nur 2 Felder ausgefuellt werden!");

			alert.showAndWait();
		}

		if (leistung != 0.0 && spannung != 0.0) {
			strom = iAusPundU(leistung, spannung);
			widerstand = rAusUundP(spannung, leistung);
		} else if (leistung != 0.0 && strom != 0.0) {
			spannung = uAusPundI(leistung, strom);
			widerstand = rAusPundI(leistung, strom);
		} else if (leistung != 0.0 && widerstand != 0.0) {
			spannung = uAusPundR(leistung, widerstand);
			strom = iAusPundR(leistung, widerstand);
		} else if (spannung != 0.0 && widerstand != 0.0) {
			leistung = pAusUundR(spannung, widerstand);
			strom = iAusPundR(spannung, widerstand);
		} else if (spannung != 0.0 && strom != 0.0) {
			leistung = pAusUundI(spannung, strom);
			widerstand = rAusUundI(spannung, strom);
		} else if (widerstand != 0.0 && strom != 0.0) {
			leistung = pAusRundI(widerstand, strom);
			spannung = uAusRundI(widerstand, strom);
		}
	}

	public double pAusUundI(double u, double i) {
		System.out.println("Aus Spannung und Stromstaerke wird die Leistung berechnet");
		return u * i;
	}

	public double pAusRundI(double r, double i) {
		System.out.println("Aus Widerstand und Stromstaerke wird die Leistung berechnet");
		return r * i * i;
	}

	public double pAusUundR(double u, double r) {
		System.out.println("Aus Spannung und Widerstand wird die Leistung berechnet");
		return u * u / r;
	}

	public double iAusPundR(double p, double r) {
		System.out.println("Aus Leistung und Widerstand wird die Stromstaerke berechnet");
		return Math.sqrt(p / r);
	}

	public double iAusPundU(double p, double u) {
		System.out.println("Aus Leistung und Spannung wird die Stromstaerke berechnet");
		return p / u;
	}

	public double iAusUundR(double u, double r) {
		System.out.println("Aus Spannung und Widerstand wird die Stromstaerke berechnet");
		return u / r;
	}

	public double uAusRundI(double r, double i) {
		System.out.println("Aus Stromstaerke und Widerstand wird die Spannung berechnet");
		return r * i;
	}

	public double uAusPundI(double p, double i) {
		System.out.println("Aus Leistung und Stromstaerke wird die Spannung berechnet");
		return p / i;
	}

	public double uAusPundR(double p, double r) {
		System.out.println("Aus Leistung und Widerstand wird die Spannung berechnet");
		return Math.sqrt(p * r);
	}

	public double rAusUundI(double u, double i) {
		System.out.println("Aus Spannung und Stromstaerke wird der Widerstand berechnet");
		return u / i;
	}

	public double rAusPundI(double p, double i) {
		System.out.println("Aus Leistung und Stromstaerke wird der Widerstand berechnet");
		return p / (i * i);
	}

	public double rAusUundP(double u, double p) {
		System.out.println("Aus Spannung und Leistung wird der Widerstand berechnet");
		return (u * u) / p;
	}
}
