import java.sql.*;

public class PostgreSQLSurucu implements IKullaniciBilgiSistemi{

    public Kullanici kullaniciDogrula(String kullaniciAdi, String sifre) {
        Kullanici kullanici =null;

        System.out.println("Kullanıcı Bilgi Sistemi Kullanıcıyı Doğruluyor...");

        System.out.println("PostgreSQL Veritabanı Yönetim Sistemi Kullanıcıyı Sorguluyor...");

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kullanici",
                    "postgres", "koletsa66");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");


            String sql ="SELECT * FROM \"Kullanici\" WHERE \"kullaniciAdi\" LIKE "+ "'"+kullaniciAdi+ "'" +" AND \"sifre\" LIKE "+"'"+sifre+ "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            String kullanici_adi;
            String sifresi;

            while(rs.next())
            {
                kullanici_adi = rs.getString("kullaniciAdi");
                sifresi = rs.getString("sifre");

                System.out.println("Kullanıcı Adi : " + kullanici_adi);
                System.out.println("Şifre : " + sifresi);

                kullanici = new Kullanici(kullanici_adi, sifresi);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kullanici;
    }
}
