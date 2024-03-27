package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ScorerActivity extends AppCompatActivity {
    private EditText homeScorerEditText;
    private EditText awayScorerEditText;
    private Button submitScorersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);

        // Inisialisasi EditText untuk memasukkan nama pencetak gol
        homeScorerEditText = findViewById(R.id.homeScorerEditText);
        awayScorerEditText = findViewById(R.id.awayScorerEditText);

        // Inisialisasi tombol Submit
        submitScorersButton = findViewById(R.id.submitScorersButton);
        submitScorersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan nama pencetak gol dari EditText
                String homeScorerName = homeScorerEditText.getText().toString().trim();
                String awayScorerName = awayScorerEditText.getText().toString().trim();

                // Pindah ke ResultActivity dan kirim data nama pencetak gol
                Intent intent = new Intent(ScorerActivity.this, ResultActivity.class);
                intent.putExtra("homeScorer", homeScorerName);
                intent.putExtra("awayScorer", awayScorerName);

                // Mengambil data skor dan nama tim dari intent yang memanggil ScorerActivity
                intent.putExtras(getIntent().getExtras());

                startActivity(intent);
            }
        });
    }
}
