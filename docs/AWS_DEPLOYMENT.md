# Guía de Despliegue AWS EC2 Free Tier

Esta guía te ayudará a desplegar automáticamente tu aplicación Spring Boot en AWS EC2 usando GitHub Actions, optimizada para el Free Tier.

## 📋 Prerrequisitos

- ✅ Cuenta AWS con Free Tier activo
- ✅ Instancia EC2 creada (t2.micro recomendada)
- ✅ Base de datos PostgreSQL configurada
- ✅ Repositorio GitHub de la aplicación
- ✅ Par de llaves SSH para acceder a EC2

## 🚀 Configuración Inicial

### 1. Configurar Instancia EC2

**Especificaciones recomendadas para Free Tier:**
- **Tipo:** t2.micro (1 vCPU, 1 GB RAM)
- **Sistema Operativo:** Amazon Linux 2
- **Almacenamiento:** 8-30 GB gp2 (incluido en Free Tier)
- **Security Group:** 
  - SSH (22) desde tu IP
  - HTTP (80) desde cualquier lugar (0.0.0.0/0)
  - HTTPS (443) desde cualquier lugar (opcional)

### 2. Configurar Base de Datos

**Opciones para Free Tier:**
- **RDS PostgreSQL:** db.t3.micro con 20 GB (12 meses gratis)
- **PostgreSQL en EC2:** Instalar en la misma instancia (más económico)

## 🔧 Configuración de GitHub Secrets

Ve a tu repositorio → Settings → Secrets and Variables → Actions y agrega:

### Secretos Requeridos:

```
# Conexión EC2
EC2_HOST=tu-ip-publica-ec2
EC2_USER=ec2-user
EC2_SSH_KEY=-----BEGIN OPENSSH PRIVATE KEY-----
[tu-llave-privada-completa]
-----END OPENSSH PRIVATE KEY-----

# Base de Datos
DB_HOST=localhost  # o tu-endpoint-rds
DB_PORT=5432
DB_NAME=shopping_db
DB_USERNAME=tu-usuario-db
DB_PASSWORD=tu-password-db
SCHEMA_CONTEXT=shopping_cart
```

## 🛠️ Configuración Manual del EC2

### Opción 1: Configuración Automática (Recomendada)

El workflow ejecutará automáticamente el script `setup-ec2.sh`. No requiere configuración manual.

### Opción 2: Configuración Manual

Si prefieres configurar manualmente, conéctate via SSH:

```bash
# Conectar a EC2
ssh -i tu-llave.pem ec2-user@tu-ip-ec2

# Ejecutar script de configuración
curl -sSL https://raw.githubusercontent.com/tu-usuario/shopping-java/master/scripts/setup-ec2.sh | bash
```

## 🔄 Proceso de Despliegue

### Automático (GitHub Actions)

1. **Push a master:** El workflow se ejecuta automáticamente
2. **Tests:** Se ejecutan las pruebas unitarias
3. **Build:** Se construye la aplicación y imagen Docker
4. **Deploy:** Se despliega a EC2 automáticamente

### Manual (Desarrollo Local)

```bash
# Construir imagen
docker build -t shopping-java .

# Ejecutar localmente
docker run -d --name shopping-java \
  -p 8080:8080 \
  -e PROFILE_ACTIVE=local \
  shopping-java
```

## 📊 Monitoreo

### Health Check
```bash
curl http://tu-ip-ec2/api/actuator/health
```

### Logs de la Aplicación
```bash
# En el EC2
docker logs shopping-java -f

# Logs del sistema
tail -f /var/log/shopping-java/application.log
```

### Uso de Recursos
```bash
# Memoria y CPU
htop

# Uso de disco
df -h

# Contenedores Docker
docker stats
```

## 🎯 Optimizaciones Free Tier

### 1. Configuraciones de Memoria
- **JVM Heap:** Máximo 512MB (-Xmx512m)
- **Connection Pool:** 5 conexiones máximo
- **Tomcat Threads:** 10 threads máximo

### 2. Optimización Docker
- Imágenes Alpine (menor tamaño)
- Log rotation configurado
- Límites de memoria establecidos

### 3. Base de Datos
- Connection pooling optimizado
- Índices apropiados
- Consultas optimizadas

## 🚨 Troubleshooting

### Problema: Aplicación no inicia
```bash
# Verificar logs
docker logs shopping-java

# Verificar conectividad BD
docker exec -it shopping-java ping tu-db-host
```

### Problema: Memoria insuficiente
```bash
# Verificar uso de memoria
free -h
docker stats

# Optimizar configuración JVM en Dockerfile
ENV JAVA_OPTS="-Xms128m -Xmx512m"
```

### Problema: Espacio en disco
```bash
# Limpiar Docker
docker system prune -af

# Verificar espacio
df -h
```

## 📈 Escalabilidad

### Cuando superes Free Tier:

1. **Upgrade EC2:** t2.micro → t3.small
2. **Load Balancer:** Application Load Balancer
3. **Auto Scaling:** Configurar escalado automático
4. **RDS:** Aumentar instancia de BD
5. **CloudWatch:** Monitoreo avanzado

## 🔐 Seguridad

### Mejores Prácticas:
- ✅ Security Groups restrictivos
- ✅ Certificados SSL/TLS (Let's Encrypt)
- ✅ Variables de entorno para secretos
- ✅ Actualizaciones regulares del sistema
- ✅ Backup de base de datos

## 💰 Costos Estimados

**Free Tier (12 meses):**
- EC2 t2.micro: GRATIS
- EBS 30GB: GRATIS
- RDS db.t3.micro: GRATIS
- Transferencia de datos: 1GB/mes GRATIS

**Post Free Tier (mensual):**
- EC2 t2.micro: ~$8.50
- EBS 30GB: ~$3.00
- RDS db.t3.micro: ~$13.00
- **Total estimado:** ~$25/mes

## 📞 Soporte

Si encuentras problemas:

1. Revisa los logs de GitHub Actions
2. Verifica las configuraciones de EC2
3. Comprueba conectividad de red
4. Revisa la documentación de AWS

## 🚀 Comandos Útiles

```bash
# Reiniciar aplicación
docker restart shopping-java

# Ver todos los contenedores
docker ps -a

# Acceder al contenedor
docker exec -it shopping-java bash

# Verificar configuración
docker exec shopping-java env | grep -E "DB_|PROFILE"

# Backup de BD (si está en EC2)
docker exec postgres pg_dump -U usuario shopping_db > backup.sql
```
