#!/bin/bash

# Script de configuración para EC2 - AWS Free Tier Optimized
# Instala Docker y configura el servidor para la aplicación Spring Boot

set -e

echo "🚀 Iniciando configuración del servidor EC2..."

# Actualizar sistema
echo "📦 Actualizando sistema..."
sudo yum update -y

# Instalar Docker si no está instalado
if ! command -v docker &> /dev/null; then
    echo "🐳 Instalando Docker..."
    sudo yum install -y docker
    sudo systemctl start docker
    sudo systemctl enable docker
    sudo usermod -a -G docker $USER
    echo "✅ Docker instalado correctamente"
else
    echo "✅ Docker ya está instalado"
fi

# Verificar que Docker esté corriendo
sudo systemctl start docker

# Crear directorio para logs si no existe
sudo mkdir -p /var/log/shopping-java
sudo chown $USER:$USER /var/log/shopping-java

# Instalar htop para monitoreo (opcional)
if ! command -v htop &> /dev/null; then
    echo "📊 Instalando herramientas de monitoreo..."
    sudo yum install -y htop
fi

# Configurar logrotate para los logs de la aplicación
sudo tee /etc/logrotate.d/shopping-java > /dev/null <<EOF
/var/log/shopping-java/*.log {
    daily
    missingok
    rotate 7
    compress
    delaycompress
    notifempty
    create 644 $USER $USER
    postrotate
        docker restart shopping-java || true
    endscript
}
EOF

# Limpiar contenedores e imágenes antiguas para ahorrar espacio
echo "🧹 Limpiando contenedores e imágenes antiguos..."
docker system prune -f --volumes

# Configurar límites de memoria para Docker (Free Tier tiene 1GB)
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json > /dev/null <<EOF
{
  "log-driver": "json-file",
  "log-opts": {
    "max-size": "10m",
    "max-file": "3"
  },
  "default-ulimits": {
    "nofile": {
      "hard": 64000,
      "soft": 64000
    }
  }
}
EOF

sudo systemctl restart docker

# Mostrar información del sistema
echo "💻 Información del sistema:"
echo "  - CPU: $(nproc) cores"
echo "  - RAM: $(free -h | grep '^Mem:' | awk '{print $2}')"
echo "  - Disco: $(df -h / | grep '^/dev' | awk '{print $4}') disponibles"
echo "  - Docker: $(docker --version)"

echo "✅ Configuración completada exitosamente!"
echo "🔄 Nota: Es posible que necesites hacer logout/login para usar Docker sin sudo"
