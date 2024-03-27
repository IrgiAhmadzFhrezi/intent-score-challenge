package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText homeTeamEditText, awayTeamEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi EditText untuk input nama tim
        homeTeamEditText = findViewById(R.id.home_team);
        awayTeamEditText = findViewById(R.id.away_team);

        // Inisialisasi tombol Next
        nextButton = findViewById(R.id.btn_team);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan nama tim dari EditText
                String homeTeamName = homeTeamEditText.getText().toString().trim();
                String awayTeamName = awayTeamEditText.getText().toString().trim();

                // Memastikan kedua nama tim tidak kosong sebelum melanjutkan
                if (!homeTeamName.isEmpty() && !awayTeamName.isEmpty()) {
                    // Pindah ke MatchActivity dan kirim data nama tim
                    Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                    intent.putExtra("homeTeamName", homeTeamName);
                    intent.putExtra("awayTeamName", awayTeamName);
                    startActivity(intent);
                }
            }
        });
    }
}
