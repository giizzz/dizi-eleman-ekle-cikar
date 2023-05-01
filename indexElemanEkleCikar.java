import java.util.Scanner;// index 1 olacak şekilde düzenle
public class indexElemanEkleCikar {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        System.out.print("Dizinin boyutunu giriniz-> ");
        int n= input.nextInt();
        if (n<=0){
            System.out.println("Geçersiz dizi sayisi ");
        }
        else{
            int[] array = new int[n];

            for(int i=0;i<n;i++){
                System.out.printf("Dizinin %d. elemanını girin->",i+1);
                array [i]=input.nextInt();
            }

            System.out.print("Yapmak istediğiniz işlemi seçin\nİndekse eleman eklemek için 1\nİndeksten eleman çıkarmak için 2 girin--->");
            int secim=input.nextInt();

            switch (secim){

                case 1:

                    System.out.print("Kaçıncı indekse ekleme yapmak istersiniz (Dizinin ilk elemanının indeksi 0 kabul edilsin...)-> ");
                    int i =input.nextInt();
                    System.out.print("Eklemek istediğiniz eleman kaçtır-> ");
                    int k=input.nextInt();
                    indekseElemanEkle(array, i,k);
                    break;

                case 2:

                    System.out.print("Hangi indeksi çıkarmak istersiniz (Dizinin ilk elemanının indeksi 0 kabul edilsin...)-> ");
                    i = input.nextInt();
                    indekstenElemanCikar(array, i);
                    break;

                default:

                    System.out.println("Hatalı seçim yaptınız!");//seçimin yanliş olması durumu çalışıyor
                    break;
            }
        }


    }


    public static void indekseElemanEkle(int[] myarray,int i,int k){

        int[] array = new int[myarray.length+1];

        if(i>=0 && i<=myarray.length){
            if(i==0){ // başa eleman ekleme
                array[0]=k;
                for (int x = 0; x < myarray.length; x++) {
                    array[x+1] = myarray[x];
                }
            }
            else if(i== myarray.length){//sona eleman ekleme
                for (int x = 0; x < myarray.length; x++) {
                    array[x] = myarray[x];
                }
                array[myarray.length]=k;
            }
            else {//araya eleman ekleme
                for (int x = 0; x < i; x++) {
                    array[x] = myarray[x];
                }
                array[i+1]=myarray[i];
                array[i] = k;

                for (int x = (i + 1); x < myarray.length; x++) {
                    array[x + 1] = myarray[x];
                }

            }
            for (int x = 0; x < array.length; x++) {
                System.out.println(array[x]);
            }
        }

        else{
            System.out.println("Hatalı index girildi");
        }

    }

    public static void indekstenElemanCikar(int[] myarray,int i){

        int[] array = new int[myarray.length-1];

        if(i>=0 && i<myarray.length){
            if(i==0){  // ilk elemanın çıkarılması durumu
                for(int x=1;x< myarray.length;x++){
                    array[x-1]=myarray[x];
                }
            }
            else { // ortadan ve sondan çıkarma
                for (int x = 0; x < i; x++) {
                    array[x] = myarray[x];
                }
                for (int x = i+1; x < myarray.length; x++) {
                    array[x-1] = myarray[x];
                }
            }
            for (int x = 0; x < array.length; x++) {
                System.out.println(array[x]);
            }
        }

        else{
            System.out.println("Geçersiz indeks hatası");
        }

    }
}
