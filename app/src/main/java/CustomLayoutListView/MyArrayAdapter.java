package CustomLayoutListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<SinhVien> {

    Activity context = null;
    int layoutId;
    ArrayList<SinhVien> myArray = null;


    //    Constructor này dùng để khởi tạo các giá trị từ MainActivity truyền vào
//	  @param context : là Activity từ Main
//    @param layoutId: Là layout custom do ta tạo (my_item_layout.xml)
//    @param arr : Danh sách sinh viên truyền từ MainActivity

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<SinhVien> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }




    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

//dòng lệnh lấy TextView ra để hiển thị Mã và tên lên
        final TextView txtdisplay = (TextView) convertView.findViewById(R.id.txtitem);
//lấy sinh viên thứ position
        final SinhVien emp = myArray.get(position);
//đưa thông tin lên TextView
//emp.toString() sẽ trả về Id và Name
        txtdisplay.setText(emp.getMaSV() + " " + emp.getHoTen());
//lấy ImageView ra để thiết lập hình ảnh cho đúng
        final ImageView imgitem = (ImageView) convertView.findViewById(R.id.imgitem);
//nếu là Nữ thì lấy hình con gái
        if (emp.isGioiTinh()) {
            imgitem.setImageResource(R.drawable.img_1);
        }

        else {
            imgitem.setImageResource(R.drawable.img);
            //nếu là Nam thì lấy hình con trai
        }


//Vì View là Object là dạng tham chiếu đối tượng, nên
//mọi sự thay đổi của các object bên trong convertView
//thì nó cũng biết sự thay đổi đó
        return convertView;//trả về View này, tức là trả luôn
//về các thông số mới mà ta vừa thay đổi

    }
}
