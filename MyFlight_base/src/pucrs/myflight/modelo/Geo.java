package pucrs.myflight.modelo;

public class Geo {
	
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public static double distancia(Geo local1, Geo local2) {

		double raioTerra = 6371;
		double lat1 = Math.toRadians(local1.getLatitude());
		double lat2 = Math.toRadians(local2.getLatitude());
		double long1 = Math.toRadians(local1.getLongitude());
		double long2 = Math.toRadians(local2.getLongitude());
		double seno = Math.pow(Math.sin(lat1 - lat2) / 2, 2) ;
        double cosseno = Math.pow(Math.sin(long1 - long2) / 2, 2) * Math.cos(lat1) * Math.cos(lat2);
        double asin = Math.asin(Math.sqrt(seno + cosseno));
        double d = 2 * raioTerra * asin;

		return d;
	}

	//public distancia2(Geo algumacoisa) {
	//
	//}

	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
