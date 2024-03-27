package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    private String homeTeamName, awayTeamName;
    private int homeScore = 0, awayScore = 0;
    private TextView homeTeamTextView, awayTeamTextView, homeScoreTextView, awayScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        // Mendapatkan data dari MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            homeTeamName = extras.getString("homeTeamName");
            awayTeamName = extras.getString("awayTeamName");
        }

        // Inisialisasi TextView untuk menampilkan nama tim dan skor
        homeTeamTextView = findViewById(R.id.txt_home);
        awayTeamTextView = findViewById(R.id.txt_away);
        homeScoreTextView = findViewById(R.id.score_home);
        awayScoreTextView = findViewById(R.id.score_away);

        // Set nama tim
        homeTeamTextView.setText(homeTeamName);
        awayTeamTextView.setText(awayTeamName);

        // Inisialisasi tombol untuk menambah skor
        Button addHomeScoreButton = findViewById(R.id.btn_add_home);
        Button addAwayScoreButton = findViewById(R.id.btn_add_away);
        Button checkResultButton = findViewById(R.id.btn_result);

        // Menambahkan listener untuk tombol tambah skor
        addHomeScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeScore++;
                homeScoreTextView.setText(String.valueOf(homeScore));
            }
        });

        addAwayScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awayScore++;
                awayScoreTextView.setText(String.valueOf(awayScore));
            }
        });

        // Menambahkan listener untuk tombol cek hasil
        checkResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk memulai aktivitas ScorerActivity
                Intent intent = new Intent(MatchActivity.this, ScorerActivity.class);

                // Mengirim data skor dari tim home dan away ke ScorerActivity
                intent.putExtra("homeScore", homeScore);
                intent.putExtra("awayScore", awayScore);

                // Mengirim nama tim dari MatchActivity ke ScorerActivity
                intent.putExtra("homeTeamName", homeTeamName);
                intent.putExtra("awayTeamName", awayTeamName);

                // Memulai aktivitas ScorerActivity
                startActivity(intent);
            }
        });
    }
}
