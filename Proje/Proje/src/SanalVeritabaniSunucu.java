public class SanalVeritabaniSunucu implements IKullaniciBilgiSistemi {

    @Override
    public Kullanici kullaniciDogrula(String kullaniciAdi, String sifre) {
        Kullanici kullanici =null;

        System.out.println("banka bilgi sistemi  kullanıcıyı doğruluyor...");

        System.out.println("veritabanına bağlandı (sanal veritabanı yönetim sistemi) ve kullanıcıyı sorguluyor...");

        System.out.println();

        if(kullaniciAdi=="Admin" && sifre=="12345")
            kullanici = new Kullanici("Admin", "12345");

        return kullanici;
    }


}
