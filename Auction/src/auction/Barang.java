package auction;

public class Barang {
    private String nama_barang, nama_penjual;
    private int ID, harga;


    // Constructor
    public Barang(int ID, String nama_barang, String nama_penjual, int harga)
    {
        this.ID = ID;
        this.nama_barang = nama_barang;
        this.nama_penjual = nama_penjual;
        this.harga = harga;
    }

    // Methods
    public void detailBarang()
    {
        System.out.println("Nama  : "+nama_barang);
        System.out.println("Harga Minimum  : "+harga);
        System.out.println("Penjual  : "+nama_penjual);
    }

    // Getters dan Setters
    public String getNamaBarang() {
        return this.nama_barang;
    }

    public void setNamaBarang(String n) {
        this.nama_barang = n;
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNamaPenjual() {
        return nama_penjual;
    }

    public void setNamaPenjual(String nama_penjual) {
        this.nama_penjual = nama_penjual;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int id) {
        this.ID = id;
    }
}
