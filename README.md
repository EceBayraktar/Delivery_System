🚚 Delivery System – Microservices Architecture

Bu proje, sipariş – kurye – teslimat süreçlerini yöneten, Spring Boot tabanlı mikroservis mimarisi ile geliştirilmiş bir Delivery (Teslimat) Yönetim Sistemidir.

Sistem; sipariş oluşturma, uygun kuryeye otomatik atama, teslimat durumlarının güncellenmesi ve servisler arası iletişimi kapsar.

🧠 Sistem Mimarisi

Proje microservices architecture kullanır.
Her servis bağımsızdır, kendi veritabanına sahiptir ve REST API üzerinden haberleşir.

Client
   |
API Gateway
   |
------------------------------------------------
| Auth | Order | Shipment | Courier | Notification |
------------------------------------------------

📦 Servisler
🔐 auth-service

Kullanıcı kimlik doğrulama

JWT tabanlı authentication & authorization

📦 order-service

Sipariş oluşturma

Sipariş durum yönetimi

Kurye atama sürecini başlatır

🚚 courier-service

Kurye bilgileri

Kurye uygunluk ve yoğunluk durumu

En az yoğun kuryenin seçilmesi

📮 shipment-service

Teslimat süreci

Sipariş → Kurye → Teslim edildi akışı

Teslimat durum güncellemeleri

🔔 notification-service

Sipariş / teslimat bildirimleri

Event tabanlı bildirim altyapısı

🌐 api-gateway

Tüm servisler için tek giriş noktası

Route ve request yönlendirme

🛠 Kullanılan Teknolojiler

Java 21

Spring Boot

Spring Cloud Gateway

Spring Data JPA

PostgreSQL

Docker & Docker Compose

Kubernetes (k8s)

Maven

Postman

📁 Proje Yapısı
Delivery_System/
│
├── auth-service/
├── order-service/
├── courier-service/
├── shipment-service/
├── notification-service/
├── api-gateway/
│
├── k8s/                # Kubernetes deployment & service yaml'ları
├── docker-compose.yml
├── pom.xml
└── README.md

🚀 Projeyi Çalıştırma
✅ Gereksinimler

Java 21

Docker & Docker Compose

Maven

PostgreSQL (Docker ile otomatik gelir)

▶️ Docker Compose ile Çalıştırma (ÖNERİLEN)

1️⃣ Projeyi klonla:

git clone https://github.com/EceBayraktar/Delivery_System.git
cd Delivery_System


2️⃣ Servisleri ayağa kaldır:

docker compose up --build


3️⃣ Servisler hazır 🎉
API Gateway üzerinden erişebilirsin:

http://localhost:8080

🔌 Portlar (Varsayılan)
Servis	Port
API Gateway	8080
Auth Service	8081
Order Service	8082
Courier Service	8083
Shipment Service	8084
Notification Service	8085
📬 API Kullanımı

Tüm istekler API Gateway üzerinden geçer.

Örnek:

POST /api/orders
GET  /api/couriers
PUT  /api/shipments/{id}/status


Test için Postman collection kullanılabilir.

🧩 Kurye Atama Mantığı (Özet)

Aktif kuryeler kontrol edilir

En az teslimatı olan kurye seçilir

Kurye müsait değilse hata döner

Atanan kurye ID’si siparişe yazılır

☸️ Kubernetes ile Çalıştırma

k8s/ klasörü altında her servis için:

Deployment

Service

Config dosyaları bulunmaktadır.

kubectl apply -f k8s/

🧪 Geliştirme Notları

Her servis kendi DB’sine sahiptir

Servisler loosely-coupled tasarlanmıştır

Yeni servis eklemek kolaydır

Cloud-native yapıya uygundur
