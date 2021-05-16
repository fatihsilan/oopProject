public class Kullanici {

    private String kullaniciAdi;
    private String sifre;

    public Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public String getSifre() {
        return sifre;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public String getkullaniciAdi() {
        return kullaniciAdi;
    }
    public void setkullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
}
