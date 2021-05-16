public class Subscriber2 implements IObserver{

    @Override
    public void update(String mesaj) {

        System.out.println("Akıllı Cihaz Kontrol Merkezine gelen mesaj->" + mesaj);
    }
}
