# AI Tube SEO — Complete Android Project
## ✅ Crash-Free | 🚀 Play Store Ready | ⚡ Cerebras gpt-oss-120b

---

## 🔧 WHAT WAS FIXED

### 1. AdMob Crash Fix (Root Cause)
The crash with real AdMob IDs happened because:
- `MobileAds.initialize()` must complete BEFORE loading any ads
- Now all ad loading happens inside the `initialize()` callback
- Added `DELAY_APP_MEASUREMENT_INIT` meta-data to prevent startup crash
- All ad operations wrapped in try/catch — ads can NEVER crash the app
- Activity lifecycle guards: `isFinishing`/`isDestroyed` checked before every ad operation

### 2. Updated AI Model
- Changed from `llama-3.3-70b` → **`gpt-oss-120b`** (as requested)
- MAX_TOKENS updated to 2048

### 3. New Loading Animation
- Lottie animation overlay during AI generation
- Dynamic loading text ("🤖 AI is thinking..." / "🎬 Crafting viral Shorts titles...")

### 4. Attractive Home Screen
- Hero card with gradient stats
- Feature showcase cards (4 grid)
- Better input field with tips
- Polished button layout

---

## ⚠️ HOW TO ADD YOUR REAL ADMOB IDs

**Open:** `app/src/main/res/values/strings.xml`

Replace these values with your real AdMob IDs from https://apps.admob.com:

```xml
<!-- App ID from: AdMob Dashboard > Apps > Your App > App Settings -->
<string name="admob_app_id">ca-app-pub-XXXXXXXXXXXXXXXX~XXXXXXXXXX</string>

<!-- Ad Unit IDs from: AdMob Dashboard > Apps > Your App > Ad Units -->
<string name="admob_banner_id">ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX</string>
<string name="admob_interstitial_id">ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX</string>
<string name="admob_rewarded_id">ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX</string>
```

**The App ID format is:** `ca-app-pub-XXXXXXXXXXXXXXXX~XXXXXXXXXX` (note the `~` tilde)
**Ad Unit ID format is:** `ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX` (note the `/` slash)

---

## 📦 PROJECT SETUP

1. Open Android Studio → File → Open → Select this folder
2. Wait for Gradle sync
3. Replace AdMob IDs in `strings.xml`
4. Build & Run

### Gradle Requirements
- Android Gradle Plugin: 8.2.2
- Kotlin: 1.9.22
- Min SDK: 24 (Android 7.0+)
- Target SDK: 34 (Android 14)
- Compile SDK: 34

---

## 🚀 PLAY STORE CHECKLIST

- [x] Uses HTTPS only (network_security_config.xml)
- [x] minSdk 24, targetSdk 34
- [x] Proguard/R8 minification enabled for release
- [x] No logging in release builds
- [x] Privacy Policy activity included
- [x] AdMob compliant implementation
- [x] Lifecycle-safe ad operations
- [x] No hard crashes

### Before Publishing
1. ✅ Replace all AdMob test IDs with real IDs
2. ✅ Update `versionCode` and `versionName` in `app/build.gradle`
3. ✅ Generate a signed APK/AAB
4. ✅ Test on a real device with real AdMob IDs
5. ✅ Add your Privacy Policy URL

---

## 🛠️ ARCHITECTURE

```
com.aitube.seogenerator/
├── activities/
│   ├── SplashActivity      — Animated splash with Lottie
│   ├── MainActivity        — Home screen + AdMob (crash-free)
│   ├── SeoResultActivity   — SEO content results
│   ├── ShortsResultActivity — Viral Shorts titles
│   ├── HistoryActivity     — Saved generations
│   └── PrivacyPolicyActivity
├── models/                 — Data classes + UiState sealed class
├── network/                — Retrofit + OkHttp client
├── repository/             — AI API calls + error handling
├── utils/                  — Constants, Extensions, PrefsManager
└── viewmodel/              — MainViewModel with coroutines
```

---

## 📡 API CONFIGURATION

- **Endpoint:** `https://api.cerebras.ai/v1/chat/completions`
- **Model:** `gpt-oss-120b`
- **Auth:** Bearer token in `Constants.CEREBRAS_API_KEY`
- **Timeout:** 60s read / 30s connect
