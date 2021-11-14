package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nhapHoTen;
    CheckBox mu, bay, bar;
    Button btnXuat;

    ListView lvSinhVien;

    RadioGroup rgMau;

    Spinner sQQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nhapHoTen = findViewById(R.id.oHoTen);


        mu = findViewById(R.id.chkMu);
        bay = findViewById(R.id.chkBM);
        bar = findViewById(R.id.chkBar);

        rgMau = findViewById(R.id.rgChonMau);

        sQQ = findViewById(R.id.spinnerChonQQ);

        btnXuat = findViewById(R.id.nutXuatThongTin);

        lvSinhVien = findViewById(R.id.lvSinhVien);

        // Đổ dữ liệu cho spinner quê quán

        ArrayList<String> dsQQ = new ArrayList<String>();
        dsQQ.add("Khánh Hòa");
        dsQQ.add("Hồ Chí Minh");
        dsQQ.add("Long an");
        dsQQ.add("Quảng Ngãi");
        dsQQ.add("Quảng Bình");

        ArrayAdapter adap = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, dsQQ);

        sQQ.setAdapter(adap);
        btnXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = (nhapHoTen.getText() + "").trim();

                if(ten.length() < 3){
                    nhapHoTen.requestFocus();
                    nhapHoTen.selectAll();
                    Toast.makeText(MainActivity.this, "Họ tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
                    return;
                }
                //Xử lý chọn màu

                int id = rgMau.getCheckedRadioButtonId();
                if(id == -1){
                    Toast.makeText(MainActivity.this, "Phải chọn màu", Toast.LENGTH_LONG).show();
                    return;
                }

                //Lấy màu chủ đạo
                RadioButton rad = findViewById(id);
                String mau_chon = rad.getText() + " ";

                //Kiểm tra CLB yêu thích
                String clb_thich = "";
                if(mu.isChecked()){
                    clb_thich = clb_thich + "\t" + mu.getText() + "\n";
                }

                if (bay.isChecked()){
                    clb_thich = clb_thich + "\t" + bay.getText() + "\n";
                }

                if(bar.isChecked()){
                    clb_thich = clb_thich + "\t" + bar.getText() + "\n";

                }

                //Hiển thị hộp thoại
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin cá nhân");

                //Tạo nội dung thông báo
                String msg = ten;
                 msg = msg + "\n-------------------\n";
                 msg += " Quê quán: " + sQQ.getSelectedItem();
                 msg += "\n-------------------------\n";
                 msg += "CLB yêu thích: \n";
                msg += clb_thich;
                 msg += "---------------\n";
                 msg +="Màu sắc chủ đạo: ";
                 msg+= mau_chon;

                 builder.setMessage(msg);

                 builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.cancel();
                     }
                 });

                 builder.create().show();
            }
        });





    }
}