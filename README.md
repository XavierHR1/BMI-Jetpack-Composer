# ⚡ BMI Jetpack Composer

Aplicació Android desenvolupada amb **Kotlin** i **Jetpack Compose** per al càlcul i diagnòstic de l'Índex de Massa Corporal (BMI / IMC).

---

## 🚀 Funcionalitats

- **Identificació d'Usuari**: Camp d'entrada per personalitzar la consulta amb el nom de l'usuari.
- **Gestió de Pes (Mass)**: Selector dinàmic de pes en quilograms ($kg$) amb controls d'increment i decrement.
- **Ajust d'Alçada (Stature)**: Selector d'alçada en centímetres ($cm$) mitjançant un lliscador interactiu (`Slider`).
- **Càlcul del BMI**: Algorisme de càlcul basat en la fórmula estàndard:
  $$\text{BMI} = \frac{\text{pes (kg)}}{\text{alçada (m)}^2}$$
- **Avaluació de Salut**: Categoritza el resultat del BMI en diferents nivells diagnòstics:
  - **Infra-pes** ($\text{BMI} < 18.5$)
  - **Pes Normal / Òptim** ($18.5 \le \text{BMI} < 25.0$)
  - **Sobrepes** ($25.0 \le \text{BMI} < 30.0$)
  - **Obesitat** ($\text{BMI} \ge 30.0$)

---

## 🛠️ Tecnologies i Estructura

- **Llenguatge**: Kotlin.
- **Framework UI**: Jetpack Compose (declaratiu).
- **Gestió d'Estat**: Ús dels estats de Compose (`remember`, `mutableStateOf`, `mutableIntStateOf`, `mutableFloatStateOf`) per a la reactivitat instantània.
- **Material Design**: Components de Material 3.

---

## 📸 Captures de Pantalla

<!-- Reemplaça les rutes per les teves pròpies imatges o rutes relatius del repositori -->

| Introducció de Dades | Resultat i Diagnòstic |
| :---: | :---: |
| ![Captura 1 - Entrada de Dades](AFIG_AQUI_LA_RUTA_DE_LA_IMATGE_1.png) | ![Captura 2 - Resultat BMI](AFIG_AQUI_LA_RUTA_DE_LA_IMATGE_2.png) |

---

## 📌 Instal·lació i Execució

1. Clona el repositori:
   ```bash
   git clone https://github.com/XavierHR1/BMI-Jetpack-Composer.git
   ```
2. Obre el projecte a **Android Studio**.
3. Executa l'aplicació en un emulador o dispositiu Android.
