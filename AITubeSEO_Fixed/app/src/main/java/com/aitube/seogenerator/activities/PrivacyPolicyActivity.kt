package com.aitube.seogenerator.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aitube.seogenerator.databinding.ActivityPrivacyPolicyBinding

class PrivacyPolicyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrivacyPolicyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "🔒 Privacy Policy"

        binding.tvPrivacy.text = buildPrivacyText()
    }

    private fun buildPrivacyText() = """
        AI Tube SEO — Privacy Policy
        
        Last updated: 2024
        
        1. DATA COLLECTION
        This app does not collect personal data. Your video topics are sent to the Cerebras AI API to generate SEO content and are not stored on our servers.
        
        2. ADVERTISING
        This app uses Google AdMob to display advertisements. AdMob may collect device information and use cookies to show relevant ads. See Google's Privacy Policy for details.
        
        3. LOCAL STORAGE
        Generated content history is stored locally on your device only and never transmitted to our servers.
        
        4. THIRD-PARTY SERVICES
        • Cerebras AI API — processes your topic queries
        • Google AdMob — provides in-app advertising
        
        5. CHILDREN'S PRIVACY
        This app is not directed at children under 13. We do not knowingly collect data from children.
        
        6. CONTACT
        For privacy concerns, contact us at support@aitubseo.app
        
        7. CHANGES
        We may update this policy. Continued use of the app constitutes acceptance of the updated policy.
    """.trimIndent()

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
