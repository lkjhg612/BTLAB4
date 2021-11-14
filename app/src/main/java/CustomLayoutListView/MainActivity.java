package CustomLayoutListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editMa, editTen;
    Button btnNhap;
    ListView lvSinhVien;
    RadioButton radNu, radNam;
    RadioGroup genderGroup;
    ArrayList<SinhVien> arrSinhVien;
    MyArrayAdapter adapter;
    ImageButton btnRemoveAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSinhVien = (ListView) findViewById(R.id.lvSinhVien);
        arrSinhVien = new ArrayList<SinhVien>();
        btnNhap = findViewById(R.id.btnNhap);
        radNam = findViewById(R.id.radNam);
        radNu = findViewById(R.id.radNu);
        editMa = findViewById(R.id.editMa);
        editTen = findViewById(R.id.editTen);
        genderGroup = findViewById(R.id.genderGroup);
        btnRemoveAll = findViewById(R.id.btnRemoveAll);

        adapter =new MyArrayAdapter(
                this,
                R.layout.demomenuapp,// lấy custom layout
                arrSinhVien
        );
        lvSinhVien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = editMa.getText() + "";
                String ten = editTen.getText() + "";
                boolean gioitinh = false;//Nam =false
                if (genderGroup.getCheckedRadioButtonId() == R.id.radNu)
                {
                    gioitinh = true;
                }
//Tạo một employee
                SinhVien emp = new SinhVien();
                emp.setMaSV(ma);
                emp.setHoTen(ten);
                emp.setGioiTinh(gioitinh);
//Đưa vào danh sách
                arrSinhVien.add(emp);
//gọi hàm cập nhật giao diện
                adapter.notifyDataSetChanged();
//Sau khi update thì xóa trắng dữ liệu và cho editma
                editMa.setText("");
                editTen.setText("");
                editMa.requestFocus();
            }
        });

        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = lvSinhVien.getChildCount() - 1; i >=0; i--)
                {
//lấy ra dòng thứ i trong ListView
//Dòng thứ i sẽ có 3 phần tử: ImageView, TextView, Checkbox
                    view = lvSinhVien.getChildAt(i);
//Ta chỉ lấy CheckBox ra kiểm tra
                    CheckBox chk = (CheckBox) view.findViewById(R.id.chkitem);
//Nếu nó Checked thì xóa ra khỏi arrEmployee
                    if(chk.isChecked())
                    {
//xóa phần tử thứ i ra khỏi danh sách
                        arrSinhVien.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });


    }
}