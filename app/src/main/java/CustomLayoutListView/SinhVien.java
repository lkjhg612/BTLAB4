package CustomLayoutListView;

public class SinhVien {
    private boolean GioiTinh;
    private String HoTen;
    private String MaSV;

    public boolean isGioiTinh(){
        return GioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return getMaSV() + " : " +getHoTen();
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getMaSV() {
        return MaSV;
    }
}
