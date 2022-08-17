# Appium Apk Test Case

<br /> <span style="font-weight: 600; font-size: 18px; font-style: normal">https://github.com/movilidadagil/ContactManagerAPIProject/tree/master/src/test/resources/apps</span> 
<span style="font-size: 16px">linkteki paitkaapiium.apk uygulaması için 5 adet test senaryosu yazıp bu senaryoları
otomatize ediniz;</span>
<br>
<span style="font-size: 14px">
<br> ℹ İki Ana Başlıkta İnceleyerek Test Çalışmalarımı Yaptım
<br> 1️⃣ Açılış Sayfası
<br> 2️⃣ Kullanıcı Kayıt Sayfası
<br> </span>

🟡 **Açılış Sayfası**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Alanların Görünürlüğünün Kontrol Edilmesi\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Alanlarda Bulunan Textlerin Alınması ve Kontrol Edilmesi\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Email Alanına Herhangi Bir Bilgi Yazılmadan Giriş Denemesi\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Email Alanına Herhangi Bir Bilgi Sonrası Şifre Yazılmadan Giriş Denemesi\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Email Alanına Herhangi Bir Bilgi Sonrası Şifre Yazılarak Giriş Denemesi\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Kayıtlı Olmayan Email/Şifre Kombinasyonu İle Giriş Denemesi\
🔴 **Kullanıcı Kayıt Sayfası**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Bütün Alanların Görünürlüğünün Kontrol Edilmesi \
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Alanlarda Bulunan Textlerin Alınması ve Kontrol Edilmesi \
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Random Bir Sayı İle Birlikte Email ve Şifre Oluşturulup Kullanıcı Kayıt Edilmesi
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ◼ Kayıt Edilen Kullanıcı İle Giriş Yapılması\

---

## Information

* Bir sayfadaki görünürlük ve alanlar içindeki metinlerin doğruluğu önemli olduğu için öncelikle bu testleri her iki başlığa ekledim.
* Açılış sayfasında Email alanında bilgi olmadan giriş yapılma testi sonucunda hata mesajını aldım.
* Benzer şekilde Email sonrası şifre olmadan giriş yapılma testinde de şifre eksik mesajını aldım.
* Email kısmına önce "test" yazıp şifre kısmına da "password" yazıp giriş testinde email için format hatasını aldım.
  * Ardından "test@" denemesi ile format hatasını aldım.
  * Son olarak "test@test" ile  kullanıcı yok hatası ile bu kısmı geçtim.
    * Ancak burada emailin formatının kontrolünü yapmadan direkt bu uyarıya geçti.
    * Daha sonrası için ekstra bir kontrol olmalı.
* Hiç kayıt olmayan bir Email/Şifre ile de kullanıcı yok hatasını aldım.
* Kullanıcı Kayıt kısmında 0-999 arası 1000 tane rastgele sayıdan biri ile email ve şifre oluşturup kullanıcı kayıdı yaptım.
* Oluşturulan kullanıcı bilgileri ile bu sefer giriş yapma testini yaptım.