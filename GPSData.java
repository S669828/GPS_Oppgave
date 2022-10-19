package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		antall = 0;
		gpspoints = new GPSPoint[n]; 

	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		if (antall < gpspoints.length) {
		gpspoints[antall] = gpspoint;
		antall++;
		inserted = true;
		}
		return inserted;
		
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		
		GPSPoint gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		boolean Result = insertGPS(gpspoint);
		return Result;
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");
		for (int n = 0; n < gpspoints.length; n++) {
		System.out.print(gpspoints[n].toString());	
		}
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
