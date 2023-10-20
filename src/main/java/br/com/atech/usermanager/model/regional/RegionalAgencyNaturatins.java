package br.com.atech.usermanager.model.regional;

public enum RegionalAgencyNaturatins {
    PALMAS("Agência Regional de Palmas", -10.182056, -48.330108),
    GURUPI("Agência Regional de Gurupi", -11.719457, -49.067883),
    ARAGUATINS("Agência Regional de Araguatins", -5.666078, -48.131842),
    ARAGUAINA("Agência Regional de Araguaína", -7.192650, -48.204977),
    PARAISO("Agência Regional de Paraíso do Tocantins", -10.175108, -48.882364);

    private final String name;
    private final double latitude;
    private final double longitude;

    RegionalAgencyNaturatins(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
