public class Bilgiler {

    private String isim;
    private String yazar;

    public Bilgiler(String isim, String yazar) {
        this.isim = isim;
        this.yazar = yazar;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    @Override
    public String toString() {
        return "Akıllı Cihaz {" +
                " İsim = " + isim +
                ", Yazar = " + yazar +
                '}';
    }
}
