package com.veterinary.veterinary.exception;


public class MessageConstants {

    // Genel
    public static final String ENTITY_NOT_FOUND = "%s id'li %s bulunamadı.";
    public static final String ENTITY_ALREADY_EXISTS = "%s zaten sistemde mevcut.";

    // Customer
    public static final String CUSTOMER_NOT_FOUND = "Müşteri bulunamadı: %s";
    public static final String CUSTOMER_ALREADY_EXISTS = "Bu mail adresine sahip bir müşteri zaten sistemde mevcut: %s";

    // Animal
    public static final String ANIMAL_NOT_FOUND = "Hayvan bulunamadı: %s";
    public static final String ANIMAL_ALREADY_EXISTS = "Bu hayvan zaten sistemde mevcut: %s";

    // Vaccine
    public static final String VACCINE_ALREADY_EXISTS = "Bu aşı koruma süresi bitmeden tekrar uygulanamaz: %s";

    // Appointment
    public static final String APPOINTMENT_CONFLICT = "Girilen saatte başka bir randevu mevcuttur.";
    public static final String DOCTOR_NOT_AVAILABLE = "Doktor bu tarihte çalışmamaktadır.";

    // AvailableDate
    public static final String DATE_ALREADY_EXISTS = "Bu tarih zaten kayıtlı.";

    // Doctor
    public static final String DOCTOR_NOT_FOUND = "Doktor bulunamadı: %s";

    // Genel tarih kontrolü
    public static final String INVALID_DATE_RANGE = "Geçersiz tarih aralığı.";
    public static final String AVAILABLE_DATE_NOT_FOUND = "id’li AvailableDate sistemde bulunamadı.";

    private MessageConstants() {
        // Sabit sınıfı - nesne oluşturulamaz
    }
}
