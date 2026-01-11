# 🚚 Delivery System – Microservices Architecture

Bu proje, **sipariş – kurye – teslimat** süreçlerini yöneten, **Spring Boot tabanlı mikroservis mimarisi** ile geliştirilmiş bir **Delivery (Teslimat) Yönetim Sistemi**dir.

---

## 🧠 Genel Mimari

Proje **microservices architecture** kullanır.  
Her servis bağımsızdır, kendi veritabanına sahiptir ve REST API üzerinden haberleşir. Sipariş durumu değiştiğinde veya siprişe bir kurye atandığında notification service db ye ve kafka uı a bildiirm gönderilir. pgadmin üzeirnden ve kafka ui üzerinden görüntüleyebilirsiniz.

Client
|
API Gateway
|
| Auth | Order | Courier | Shipment | Notification |

---

## 📦 Servisler

### 🔐 auth-service
- Kullanıcı girişi 

### 📦 order-service
- Sipariş oluşturma
- Sipariş durum yönetimi
- Kurye atama sürecini başlatır

### 🚚 courier-service
- Kurye bilgileri
- Kurye uygunluk ve yoğunluk durumu
- En az yoğun kuryenin seçilmesi

### 📮 shipment-service
- Teslimat süreci
- Sipariş → Kurye → Teslim edildi akışı
- Teslimat durum güncellemeleri

### 🔔 notification-service
- Sipariş ve teslimat bildirimleri
- Event tabanlı bildirim altyapısı

### 🌐 api-gateway
- Tüm servisler için tek giriş noktası
- Request yönlendirme ve routing

---

## 🛠 Kullanılan Teknolojiler

- Java 21
- Spring Boot
- Spring Cloud Gateway
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Kubernetes
- Maven
- Postman
- Kafka
- Cloud

---

---

## 🚀 Projeyi Çalıştırma

### ✅ Gereksinimler

- Java 21
- Docker & Docker Compose
- Maven

> PostgreSQL Docker container olarak otomatik ayağa kalkar.

---

### ▶️ Docker Compose ile Çalıştırma (Önerilen)

1️⃣ Projeyi klonlayın:
```bash
git clone https://github.com/EceBayraktar/Delivery_System.git
cd Delivery_System
```

2️⃣ Servisleri ayağa kaldırın:
```bash
docker compose up --build
```

3️⃣ Tüm servisler çalıştığında API Gateway üzerinden erişebilirsiniz:
```bash
http://localhost:8888
```


🔌 Varsayılan Portlar
Servis	Port
API Gateway	8888
Auth Service	8081
Order Service	8082
Courier Service	8083
Shipment Service	8084
Notification Service	8085
Kafka UI 9092
Pgadmin 5050


📬 API Kullanımı

Tüm istekler API Gateway üzerinden yapılır.

Örnek endpointler:
```bash

POST   /api/orders
GET    /api/couriers
PUT    /api/shipments/{id}/status
```

🧩 Kurye Atama Mantığı (Özet)

Aktif ve müsait kuryeler kontrol edilir

En az teslimatı olan kurye seçilir

Uygun kurye yoksa hata döndürülür

Atanan kurye ID’si siparişe yazılır

☸️ Kubernetes ile Çalıştırma

k8s/ klasörü altında her servis için:

Deployment

Service

Config dosyaları bulunmaktadır.

Çalıştırmak için:
```bash
kubectl apply -f k8s/
```
🧪 Geliştirme Notları

Her servis kendi veritabanına sahiptir.

Yeni servis eklemek kolaydır

