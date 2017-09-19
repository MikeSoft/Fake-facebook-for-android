package rootingtheai.mikeolivera.facebook.Adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;
import rootingtheai.mikeolivera.facebook.Models.Account;

/**
 * Created by mikes on 19-Sep.
 */

public class HistoryAccountsAdapter extends TableDataAdapter<Account> {
    List<Account> DATA;
    public HistoryAccountsAdapter(Context context, List<Account> data) {
        super(context, data);
        this.DATA=data;
    }


    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        TextView T = new TextView(getContext());
        T.setPadding(0,5,0,5);
        T.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);

        switch (columnIndex) {
            case 0:
                T.setText(DATA.get(rowIndex).getUsername());
                break;
            case 1:
                T.setText(DATA.get(rowIndex).getPassword());
                break;
            case 2:
                T.setText(DATA.get(rowIndex).getDate());
                break;
            default:
                return null;
        }
        return T;
    }
}
