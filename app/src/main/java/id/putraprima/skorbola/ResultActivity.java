// ResultActivity.java
package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Inisialisasi TextView untuk menampilkan hasil
        resultTextView = findViewById(R.id.result_text);

        // Mendapatkan data dari Intent yang memanggil activity ini
        Intent intent = getIntent();
        if (intent != null) {
            // Mendapatkan nama tim dari intent
            String homeTeamName = intent.getStringExtra("homeTeamName");
            String awayTeamName = intent.getStringExtra("awayTeamName");

            // Mendapatkan skor dari intent
            int homeScore = intent.getIntExtra("homeScore", 0);
            int awayScore = intent.getIntExtra("awayScore", 0);

            // Mendapatkan nama pemain yang mencetak gol dari intent
            String homeScorer = intent.getStringExtra("homeScorer");
            String awayScorer = intent.getStringExtra("awayScorer");

            // Menentukan tim pemenang atau hasil seri berdasarkan skor
            String winnerTeam;
            if (homeScore > awayScore) {
                winnerTeam = homeTeamName;
            } else if (awayScore > homeScore) {
                winnerTeam = awayTeamName;
            } else {
                // Jika skor sama, tetapi ada gol dicetak, maka hasilnya adalah seri
                if (!homeScorer.isEmpty() || !awayScorer.isEmpty()) {
                    winnerTeam = "Seri";
                } else {
                    // Jika skor sama dan tidak ada gol yang dicetak, tidak ada pemenang
                    winnerTeam = "Draw";
                }
            }

            // Menampilkan hasil
            String resultText = "Pemenang: " + winnerTeam + "\n\n" +
                    "Pencetak Gol Tim Rumah: " + homeScorer + "\n\n" +
                    "Pencetak Gol Tim Tamu: " + awayScorer;
            resultTextView.setText(resultText);
        } else {
            // Jika intent kosong, tampilkan pesan error
            resultTextView.setText("Error: Intent kosong");
        }
    }
}
