package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {	

	public static int toSeconds(String timestr) {
		String sub1 = timestr.substring(11, 13);
		String sub2 = timestr.substring(14, 16);
		String sub3 = timestr.substring(17, 19);
		
		int secs;
		int hr = Integer.parseInt(sub1);
		int min = Integer.parseInt(sub2);
		int sec = Integer.parseInt(sub3);
		hr = hr * 60 * 60;
		min = min *60;
		secs = hr + min + sec;
		return secs;
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		int time1 = GPSDataConverter.toSeconds(timeStr);
		double latitude1 = Double.parseDouble(latitudeStr);
		double longitude1 = Double.parseDouble(longitudeStr);
		double elevation1 = Double.parseDouble(elevationStr);
		
		GPSPoint gpspoint = new GPSPoint(time1, latitude1, longitude1, elevation1);
		
		return gpspoint;
	}
	
}
