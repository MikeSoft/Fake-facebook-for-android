package rootingtheai.mikeolivera.facebook.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import rootingtheai.mikeolivera.facebook.Adapters.HistoryAccountsAdapter;
import rootingtheai.mikeolivera.facebook.Database.DataBaseUtils;
import rootingtheai.mikeolivera.facebook.R;

public class HistoryActivity extends Activity {

    TableView tableView;
    private static final String[] TABLE_HEADERS = {  "Username", "Password", "Date" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        tableView = (TableView) findViewById(R.id.tableView);
        tableView.setColumnCount(3);
        DataBaseUtils DBU = new DataBaseUtils(this);
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, TABLE_HEADERS));
        HistoryAccountsAdapter HAA = new HistoryAccountsAdapter(this,DBU.get_list());
        tableView.setDataAdapter(HAA);

    }

}
