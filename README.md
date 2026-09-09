# Healthypath

Aplicación Android de bienestar y salud que ofrece información sobre nutrición, actividad física y sueño, además de un chatbot con inteligencia artificial.

## Características

- **Autenticación de usuarios**: Registro, inicio de sesión y recuperación de contraseña mediante Firebase Authentication.
- **Nutrición**: Calculadora de IMC (Índice de Masa Corporal) con categorización del resultado y recomendaciones de alimentación.
- **Actividad física**: Secciones informativas sobre gimnasio/levantamiento de pesas, calistenia y ejercicio aeróbico, con beneficios, rutinas y recomendaciones.
- **Sueño**: Información sobre la importancia del sueño, consecuencias de no dormir bien y detalle sobre el insomnio (causas, síntomas y tratamiento).
- **Chatbot con IA**: Asistente conversacional impulsado por Google Gemini Pro (modelo `gemini-pro`).
- **Perfil**: Gestión del perfil de usuario, cambio de contraseña y cierre de sesión.

## Tecnologías

- **Kotlin** + **Jetpack Compose** y vistas XML (ViewBinding)
- **Firebase**: Authentication, Firestore y Analytics
- **Google AI (Gemini)**: `generativeai` 0.9.0 para el chatbot
- **Dagger 2**: Inyección de dependencias
- **Arquitectura MVP** para el módulo de login (presenter / interactors / contract)
- **Lottie**: Animaciones
- **Navigation Component**, **Material 3** y **Material Design**

## Estructura del proyecto

```
app/src/main/java/com/unefa7mo/healthypath/
├── Login/                  # Autenticación (MVP)
│   ├── view/               # MainActivity, contrato de login
│   ├── presenter/          # Presentadores
│   ├── interactors/        # Lógica de negocio (SignIn, SignUp, PasswordRecover)
│   ├── Registro/           # Registro de usuarios
│   ├── PasswordRecover/    # Recuperación de contraseña
│   └── ...
├── appViews/               # Pantallas principales (Inicio, Perfil)
├── nutrition/              # Calculadora de IMC
├── activityphysique/       # Sección de actividad física
├── dream/                  # Sección de sueño
└── chatbot/                # Chatbot con Gemini
```

## Configuración

1. Clona el repositorio y ábrelo en Android Studio.
2. Configura Firebase (Authentication, Firestore y Analytics) y coloca tu archivo `google-services.json` en el directorio `app/`.
3. Agrega tu `API_KEY` de Google AI en el archivo `local.properties`:
   ```properties
   API_KEY=TU_API_KEY
   ```
4. Compila y ejecuta la aplicación.

## Requisitos

- Android Studio (AGP 8.9.2, Kotlin 2.0.21)
- `compileSdk` 35, `minSdk` 23, `targetSdk` 35
- Conexión a Internet para el chatbot y Firebase

## Integrantes

- Gabriel Hernandez
- Eliecer Médina
- Joseini Garcia
- Ronald Higuera
- Luis Alvarez