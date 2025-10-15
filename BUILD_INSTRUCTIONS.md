# 🚀 Instruções de Build e Execução

## 📋 Pré-requisitos

### Software Necessário
- **Android Studio** Flamingo | 2022.2.1 ou superior
- **JDK 8** ou superior
- **Android SDK** com API Level 24+ (Android 7.0)
- **Emulador Android** ou dispositivo físico

### Verificar Instalação
```bash
# Verificar Java
java -version

# Verificar Android SDK (no Android Studio)
Tools → SDK Manager → Android SDK
```

## 🏗️ Como Buildar o Projeto

### 1. Via Android Studio (Recomendado)
1. **Abrir Projeto**
   - File → Open
   - Selecionar pasta `ContadorComposeApp`
   - Wait for Gradle sync

2. **Build do Projeto**
   - Build → Make Project (Ctrl+F9)
   - Ou clique no ícone 🔨 na toolbar

### 2. Via Command Line
```powershell
# Navegar para o diretório do projeto
cd C:\Users\vicen\ContadorComposeApp

# Dar permissão de execução (Linux/Mac)
# chmod +x gradlew

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease
```

## 📱 Como Executar

### 1. No Emulador Android
1. **Criar Emulador**
   - Tools → AVD Manager
   - Create Virtual Device
   - Escolher dispositivo (ex: Pixel 4)
   - Escolher API Level 24+
   - Finish

2. **Executar App**
   - Run → Run 'app' (Shift+F10)
   - Ou clique em ▶️ na toolbar
   - Escolher emulador criado

### 2. Em Dispositivo Físico
1. **Habilitar Developer Options**
   - Settings → About phone
   - Clique 7x em "Build number"

2. **Habilitar USB Debugging**
   - Settings → Developer options
   - Enable "USB debugging"

3. **Conectar e Executar**
   - Conecte via USB
   - Run → Run 'app'
   - Escolher dispositivo conectado

## 🔧 Comandos Gradle Úteis

```powershell
# Limpar build cache
./gradlew clean

# Build + executar testes
./gradlew build

# Apenas compilar (sem gerar APK)
./gradlew compileDebugKotlin

# Verificar dependências
./gradlew dependencies

# Gerar APK assinado para release
./gradlew assembleRelease
```

## 🐛 Problemas Comuns

### **Gradle Sync Failed**
```powershell
# Solução 1: Clean + Rebuild
./gradlew clean
./gradlew build

# Solução 2: Invalidar cache
File → Invalidate Caches and Restart
```

### **Emulator Não Inicia**
1. Verificar Hyper-V (Windows)
2. Aumentar RAM do emulador
3. Usar x86_64 ao invés de ARM
4. Habilitar Hardware Acceleration

### **App Não Compila**
```kotlin
// Verificar imports
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*

// Verificar versões no build.gradle
compileSdk 34
minSdk 24
```

## 📊 Estrutura de Build

### **build.gradle (Project)**
- Plugins do Kotlin e Android
- Repositórios (Google, Maven Central)
- Versões globais

### **build.gradle (Module: app)**
- Configurações do app (minSdk, targetSdk)
- Dependências do Compose
- Build types (debug, release)

### **gradle.properties**
- Configurações do Gradle
- AndroidX flag
- JVM settings

## 🎯 Targets de Build

### **Debug Build**
- Otimizações desabilitadas
- Debug info incluído
- Assinatura de debug
- ProGuard desabilitado

### **Release Build**
- Otimizações habilitadas
- Debug info removido
- Assinatura de release necessária
- ProGuard habilitado

## 📱 APK Output

### **Localização**
```
app/build/outputs/apk/
├── debug/
│   └── app-debug.apk
└── release/
    └── app-release.apk
```

### **Instalação Manual**
```powershell
# Via ADB
adb install app-debug.apk

# Via emulador (drag & drop)
# Arraste o APK para o emulador
```

## ⚡ Dicas de Performance

### **Build Mais Rápido**
```properties
# gradle.properties
org.gradle.daemon=true
org.gradle.parallel=true
org.gradle.configureondemand=true
org.gradle.caching=true
```

### **Emulador Mais Rápido**
- Use API Level mais baixo possível
- Habilite Hardware Acceleration
- Aloque RAM suficiente (2-4GB)
- Use x86_64 images

## 🔍 Debugging

### **Logcat**
```kotlin
// Adicionar logs no código
Log.d("ContadorApp", "Valor atual: $count")

// Ver logs no Android Studio
View → Tool Windows → Logcat
```

### **Preview Debug**
- Use `@Preview` para testar UI
- Múltiplos previews com parâmetros diferentes
- Preview interativo disponível

## 📚 Recursos Adicionais

- [Build Configuration](https://developer.android.com/studio/build)
- [Run Apps on Emulator](https://developer.android.com/studio/run/emulator)
- [Debug Your App](https://developer.android.com/studio/debug)
- [Gradle Tips](https://developer.android.com/studio/build/optimize-your-build)