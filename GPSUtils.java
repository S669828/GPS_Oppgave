package no.hvl.dat100ptc.oppgave3;
import static java.lang.Math.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double [] latitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();	
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		
		double [] longitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();	
		}
		return longitudes;


	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double a;
		double d;
		double c;
		double latitude1, longitude1, latitude2, longitude2;
		double Tlatitudes;
		double Tlongitudes;
		
		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		Tlatitudes = toRadians(latitude2) - toRadians(latitude1);
		Tlongitudes = toRadians(longitude2) - toRadians(longitude1); 
		
		a = pow(sin(Tlatitudes % 2), 2) + cos(toRadians(latitude1)) * cos(toRadians(latitude2)) * pow(sin(Tlongitudes % 2), 2);
		c = atan2(sqrt(a), sqrt(1 - a));
		d = c * R;
		return d;
		
		
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		double dist = distance(gpspoint1, gpspoint2);
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = dist / secs;
		speed *= 3.6;
		return speed;
		

	}

	public static String formatTime(int secs) {

        String hh = String.format("%02d", secs / 60 / 60);
        String mm = String.format("%02d", (secs / 60) % 60);
        String ss = String.format("%02d", secs % 60);
        
        String timestr = ("  " + hh + ":" + mm + ":" + ss);
        return timestr;

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

        BigDecimal biTemp = new BigDecimal(d).setScale(2, RoundingMode.HALF_UP);
        double doTemp = biTemp.doubleValue();
        
        String str = String.valueOf(doTemp);
        for(int i = 0; str.length() != TEXTWIDTH; i++) {
            str = " " + str;
        }
        return str;
		
	}
}
