import java.util.Scanner;

public class AnaIslemPlatformu {

    private static final int SICAKLIK_GORUNTULE = 1;
    private static final int SOGUTUCU_ACMA = 2;
    private static final int SOGUTUCU_KAPATMA = 3;
    private static final int CIKIS = 4;
    Scanner scanner = new Scanner(System.in);
    Publisher p = new Publisher();
    Subscriber1 s1 = new Subscriber1();
    Subscriber2 s2 = new Subscriber2();

    public void basla(){
        System.out.println();
        AkilliCihaz akilli = new AkilliCihaz.AkilliCihazBuilder("15.05.2021","v1.01")
                .fiyat("15.000 TL")
                .bilgiler("Akıllı Soğutma Cihazı","Fatih Abidin Silan")
                .build();
        System.out.println(akilli);

        System.out.println("**********************************************");

        System.out.println("Lütfen Kullanıcı Adınızı Giriniz ...");
        String kullaniciAdi = scanner.nextLine();
        System.out.println("Lütfen Şifrenizi Giriniz ...");
        String sifre = scanner.nextLine();

        IKullaniciBilgiSistemi kullaniciBilgiSistemi=new KullaniciBilgiSistemi(new PostgreSQLSurucu());
        Kullanici kullanici = this.kullaniciDogrula(kullaniciAdi, sifre, kullaniciBilgiSistemi);

        if (kullanici != null){
            System.out.println("Kullanıcı Doğrulama İşlemi Başarılı...:");
            islemSecimi(kullaniciBilgiSistemi, kullanici);
        } else{
            System.out.println("Hesabınız Doğrulanamadı !!!");
        }
    }

    private Kullanici kullaniciDogrula(String kullaniciAdi, String sifre, IKullaniciBilgiSistemi kullaniciBilgiSistemi){
        return kullaniciBilgiSistemi.kullaniciDogrula(kullaniciAdi,sifre);
    }

    private void islemSecimi(IKullaniciBilgiSistemi kullaniciBilgiSistemi, Kullanici kullanici){
        int secim;
        do{
            secim=anaMenuyuGoster();

            switch (secim) {
                case SICAKLIK_GORUNTULE:
                    ISicaklikAlgilayici sicaklikAlgila=new SicaklikAlgilayici(p,0);
                    System.out.println("Sıcaklık " + sicaklikAlgila.sicaklikUret() + " " + "derece...");

                    if (sicaklikAlgila.sicaklikAl()< 8){
                        p.attach(s1);
                        p.attach(s2);
                        p.notify(" Sıcaklık : " + sicaklikAlgila.sicaklikAl() + " derece --- Sıcaklık 8 dereceden az, soğutuyu açınız... ");
                        p.detach(s1);
                        p.detach(s2);
                    }

                    if (sicaklikAlgila.sicaklikAl()> 21){
                        p.attach(s1);
                        p.attach(s2);
                        p.notify(" Sıcaklık : " + sicaklikAlgila.sicaklikAl() + " derece --- Sıcaklık 21 dereceden fazla, soğutuyu kapatınız... ");
                        p.detach(s1);
                        p.detach(s2);
                    }


                    if (sicaklikAlgila.sicaklikAl() >= 8 && sicaklikAlgila.sicaklikAl() <= 21){
                        p.attach(s1);
                        p.attach(s2);
                        p.notify(" Sıcaklık : " + sicaklikAlgila.sicaklikAl() + " derece --- Sıcaklık Normal... ");
                        p.detach(s1);
                        p.detach(s2);
                    }
                    break;

                case SOGUTUCU_ACMA:
                    IEyleyici sogutucuyuAc=new SogutucuyuAc();
                    sogutucuyuAc.islemYap();
                    break;

                case SOGUTUCU_KAPATMA:
                    IEyleyici sogutucuyuKapat=new SogutucuyuKapat();
                    sogutucuyuKapat.islemYap();
                    break;

                case CIKIS:
                    System.out.println("Çıkılıyor ...");
                    break;
                default:
                    System.out.println("1-4 arasında bir sayı girmelisiniz");
            }
        }while(secim!=4);
    }

    private int anaMenuyuGoster()
    {
        System.out.println("**********************************************");
        System.out.println("Ana Menu");
        System.out.println("1-Sıcaklık Görüntüle");
        System.out.println("2-Soğutucuyu Aç");
        System.out.println("3-Soğutucuyu Kapat");
        System.out.println("4-Cikis");
        System.out.println("Seciminiz:");
        System.out.println("**********************************************");

        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }

}
