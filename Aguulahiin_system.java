// Aguulah System
 
 import java.util.*;
 
 // Бараа класс
 class Baraa {
     private String code;
     private String ner;
     private int too;
 
     public Baraa(String code, String ner, int too) {
         this.code = code;
         this.ner = ner;
         this.too = too;
     }
 
     public String getCode() { return code; }
     public String getNer() { return ner; }
     public int getToo() { return too; }
     public void setToo(int too) { this.too = too; }
 }
 
 // Агуулах класс
 class Aguulah {
     private String ner;
     private Nyarav nyarav;
     private List<Baraa> baraanuud = new ArrayList<>();
 
     public Aguulah(String ner) {
         this.ner = ner;
     }
 
     public void baraaNemeh(Baraa baraa) {
         baraanuud.add(baraa);
     }
 
     public void baraaHasah(Baraa baraa) {
         baraanuud.remove(baraa);
     }
 
     public List<Baraa> getBaraanuud() { return baraanuud; }
     public void setNyarav(Nyarav nyarav) { this.nyarav = nyarav; }
     public String getNer() { return ner; }
 }
 
 // Нярав класс
 class Nyarav {
     private String ner;
     private Aguulah aguulah;
 
     public Nyarav(String ner, Aguulah aguulah) {
         this.ner = ner;
         this.aguulah = aguulah;
         aguulah.setNyarav(this);
     }
 
     public void orlogoHiih(OrloginPadaan padaan) {}
     public void zarlagaGargah(ZarlagiinPadaan padaan) {}
     public void tailanHaruulah(Tailan tailan) {}
     public void toollogoHiih(Baraa baraa, String ognoo, int boditToo) {}
     public String getNer() { return ner; }
     public Aguulah getAguulah() { return aguulah; }
 }
 
 // Орлогын падаан
 class OrloginPadaan {
     private Date ognoo;
     private Map<Baraa, Integer> huleenAvsanBaraa = new HashMap<>();
     private String huleelgenOgosonHun;
 
     public OrloginPadaan(Date ognoo, String huleelgenOgosonHun) {
         this.ognoo = ognoo;
         this.huleelgenOgosonHun = huleelgenOgosonHun;
     }
 
     public void baraaNemeh(Baraa baraa, int too) {
         huleenAvsanBaraa.put(baraa, too);
     }
 
     public void hevleh() {
         System.out.println("Орлогын падаан - " + ognoo);
         for (Map.Entry<Baraa, Integer> entry : huleenAvsanBaraa.entrySet()) {
             System.out.println(entry.getKey().getNer() + ": " + entry.getValue());
         }
         System.out.println("Хүлээлгэн өгсөн хүн: " + huleelgenOgosonHun);
     }
 }
 
 // Зарлагын падаан
 class ZarlagiinPadaan {
     private Date ognoo;
     private Map<Baraa, Integer> zarlagaBaraa = new HashMap<>();
     private String huleenAvsanHun;
 
     public ZarlagiinPadaan(Date ognoo, String huleenAvsanHun) {
         this.ognoo = ognoo;
         this.huleenAvsanHun = huleenAvsanHun;
     }
 
     public void baraaNemeh(Baraa baraa, int too) {
         zarlagaBaraa.put(baraa, too);
     }
 
     public void hevleh() {
         System.out.println("Зарлагын падаан - " + ognoo);
         for (Map.Entry<Baraa, Integer> entry : zarlagaBaraa.entrySet()) {
             System.out.println(entry.getKey().getNer() + ": " + entry.getValue());
         }
         System.out.println("Хүлээн авсан хүн: " + huleenAvsanHun);
     }
 }
 
 // Тайлан
 class Tailan {
     private Date ehlehOgnoo;
     private Date duusahOgnoo;
     private List<Baraa> songosonBaraa = new ArrayList<>();
 
     public Tailan(Date ehleh, Date duusah) {
         this.ehlehOgnoo = ehleh;
         this.duusahOgnoo = duusah;
     }
 
     public void baraaSongoh(Baraa baraa) {
         songosonBaraa.add(baraa);
     }
 
     public void haruulah() {
         System.out.println("Тайлан: " + ehlehOgnoo + " - " + duusahOgnoo);
         for (Baraa baraa : songosonBaraa) {
             System.out.println("Бараа: " + baraa.getNer() + " Үлдэгдэл: " + baraa.getToo());
         }
     }
 }
 
 // Тооллого
 class Toollogo {
     private Baraa baraa;
     private String ognoo;
     private int boditToo;
     private int toollogiinZoruu;
 
     public Toollogo(Baraa baraa, String ognoo, int boditToo) {
         this.baraa = baraa;
         this.ognoo = ognoo;
         this.boditToo = boditToo;
         this.toollogiinZoruu = boditToo - baraa.getToo();
         baraa.setToo(boditToo);
     }
 
     public void hevleh() {
         System.out.println("Тооллого: " + ognoo);
         System.out.println("Бараа: " + baraa.getNer());
         System.out.println("Бодит тоо: " + boditToo);
         System.out.println("Зөрүү: " + toollogiinZoruu);
     }
 }