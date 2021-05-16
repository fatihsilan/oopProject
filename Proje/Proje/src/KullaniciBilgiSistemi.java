public class KullaniciBilgiSistemi implements IKullaniciBilgiSistemi{

    private IKullaniciBilgiSistemi veritabani;

    public KullaniciBilgiSistemi(IKullaniciBilgiSistemi veritabani){

        this.veritabani = veritabani;
    }

    public Kullanici kullaniciDogrula(String kullaniciAdi, String sifre){
        return veritabani.kullaniciDogrula(kullaniciAdi, sifre);
    }

}
