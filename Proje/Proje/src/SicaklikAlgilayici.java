import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{

    private int sicaklik;
    ISubject publisher;

    public SicaklikAlgilayici(ISubject publisher, int sicaklik) {
        this.publisher = publisher;
        this.sicaklik=sicaklik;

    }

    public int sicaklikUret(){

        Random rand = new Random();
        sicaklik = rand.nextInt(30);
        return sicaklik;
    }

    public int sicaklikAl(){
        return sicaklik;
    }
}
