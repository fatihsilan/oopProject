public class AkilliCihaz {

    private String tarih;
    private String sürüm;
    private String fiyat;
    Bilgiler bilgiler;

    private AkilliCihaz(AkilliCihazBuilder builder) {

        this.tarih = builder.tarih;
        this.sürüm = builder.sürüm;
        this.fiyat = builder.fiyat;
        this.bilgiler = builder.bilgiler;
    }

    public Bilgiler getBilgiler() {
        return bilgiler;
    }

    public void setBilgiler(Bilgiler bilgiler) {
        this.bilgiler = bilgiler;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSürüm() {
        return sürüm;
    }

    public void setSürüm(String sürüm) {
        this.sürüm = sürüm;
    }

    @Override
    public String toString() {
        return "Akıllı Cihaz {" +
                "Tarih = " + tarih +
                ", Sürüm = " + sürüm +
                ", Fiyat = '" + fiyat + '\'' +
                ", Bilgiler=" + bilgiler +
                '}';
    }

    public static class AkilliCihazBuilder
    {
        private String tarih;
        private String sürüm;
        private String fiyat;
        Bilgiler bilgiler;

        public AkilliCihazBuilder(String tarih, String sürüm) {
            this.tarih = tarih;
            this.sürüm = sürüm;
        }
        public AkilliCihazBuilder fiyat (String fiyat) {
            this.fiyat = fiyat;
            return this;
        }
        public AkilliCihazBuilder bilgiler (String isim, String yazar) {
            this.bilgiler = new Bilgiler(isim,yazar);
            return this;
        }

        //Return the finally consrcuted Dikdortgen object
        public AkilliCihaz build() {

            return new AkilliCihaz(this);
        }

    }

}
