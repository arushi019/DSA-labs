import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}
//Arushi Chauhan
//AP LAB2
//Roll no: 2016019
class mess{
    private double avail;
    private double nutrition;
    private double hygiene;
    private double deliv;
    private int m_rank;
    public mess(double avail,double nutrition,double hygiene,double deliv){
        //System.out.println(nutrition);
        this.avail=avail;
        this.nutrition=nutrition;
        this.hygiene=hygiene;
        this.deliv=deliv;
        //System.out.println(this.nutrition);
        this.m_rank=-1;
    }
    public double get_avail(){
        return avail;
    }
    public double get_nutrition(){
        return nutrition;
    }
    public double get_hygiene(){
        return hygiene;
    }
    public double get_deliv(){
        return deliv;
    }
    public int compare(mess m){
    	//System.out.println(m.get_avail()+" "+this.get_avail());
    	//System.out.println(m.get_nutrition()+" "+this.get_nutrition());
        if (m.get_avail()!=this.get_avail()){
        	//System.out.println("yes");
            if (m.get_avail()>this.get_avail())return 1;
            else return -1;
        }
        else if (m.get_nutrition()!=this.get_nutrition()){
        	//System.out.println(m.get_nutrition()+" "+this.get_nutrition());
            if (m.get_nutrition()>this.get_nutrition())return 1;
            else return -1;
        }
        else if (m.get_hygiene()!=this.get_hygiene()){
            if (m.get_hygiene()>this.get_hygiene())return 1;
            else return -1;
        }
        else{
            if (m.get_deliv()<this.get_deliv())return 1;
            else return -1;
        }
    }
    public void set_m(int r){
        this.m_rank=r;
    }
    public int get_m(){
        return m_rank;
    }
    private void merge_out(mess[] m,int i,int j){
        if (j-i>=1){
            int mid=(i+j)/2;
            merge_out(m,i,mid);
            merge_out(m,mid+1,j);
            merge_in(m,i,mid,j);
        }
    }
    private void merge_in(mess[] m,int p,int mid,int q){
        mess[] temp=new mess[q-p+1];
        for (int i=0;i<q-p+1;i++){
            temp[i]=new mess(0.0,0.0,0.0,0.0);
        }
        int i=p;
        int j=mid+1;
        int k=0;
        while((i<=mid)&&(j<=q)){
            if (m[i].compare(m[j])==-1)temp[k]=m[i++];
            else temp[k]=m[j++];
            k++;
        }
        if ((i<=mid)&&(j>q)){
            while(i<=mid)temp[k++]=m[i++];
        }
        else{
            while(j<=q)temp[k++]=m[j++];
        }
        for (k=0;k<temp.length;k++){
            m[k+p]=(mess)temp[k];
        }
    }
    private void bub_mess(mess[] m,int n){
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (m[i].compare(m[j])==1){
                    mess tem=m[i];
                    m[i]=m[j];
                    m[j]=tem;
                }
            }
        }
    }
    public void do_mess_sort(mess[] m,int n){
        merge_out(m,0,n-1);
        //bub_mess(m,n);
        for (int i=0;i<n;i++){
            m[i].set_m(i+1);
            //System.out.println(m[i].avail);
        }
    }
}
class hostel{
    private double room_cond;
    private double study_fac;
    private double clean;
    private double recre;
    private int h_rank;
    public hostel(double room_cond,double study_fac,double clean,double recre){
        this.room_cond=room_cond;
        this.study_fac=study_fac;
        this.clean=clean;
        this.recre=recre;
        this.h_rank=-1;
    }
    public double get_room_cond(){
        return room_cond;
    }
    public double get_study_fac(){
        return study_fac;
    }
    public double get_clean(){
        return clean;
    }
    public double get_recre(){
        return recre;
    }
    public int compare(hostel h){
        if (h.get_room_cond()!=this.get_room_cond()){
            if (h.get_room_cond()>this.get_room_cond())return 1;
            else return -1;
        }
        else if (h.get_study_fac()!=this.get_study_fac()){
            if (h.get_study_fac()>this.get_study_fac())return 1;
            else return -1;
        }
        else if (h.get_clean()!=this.get_clean()){
            if (h.get_clean()>this.get_clean())return 1;
            else return -1;
        }
        else{
            if (h.get_recre()>this.get_recre())return 1;
            else return -1;
        }
    }
    public void set_h(int r){
        this.h_rank=r;
    }
    public int get_h(){
        return h_rank;
    }
    private void merge_out(hostel[] h,int i,int j){
        if (j-i>=1){
            int mid=(i+j)/2;
            merge_out(h,i,mid);
            merge_out(h,mid+1,j);
            merge_in(h,i,mid,j);
        }
    }
    private void merge_in(hostel[] h,int p,int mid,int q){
        hostel[] temp=new hostel[q-p+1];
        for (int i=0;i<q-p+1;i++){
            temp[i]=new hostel(0.0,0.0,0.0,0.0);
        }
        int i=p;
        int j=mid+1;
        int k=0;
        while((i<=mid)&&(j<=q)){
            if (h[i].compare(h[j])==-1)temp[k]=h[i++];
            else temp[k]=h[j++];
            k++;
        }
        if ((i<=mid)&&(j>q)){
            while(i<=mid)temp[k++]=h[i++];
        }
        else{
            while(j<=q)temp[k++]=h[j++];
        }
        for (k=0;k<temp.length;k++){
            h[k+p]=temp[k];
        }
    }
    private void bub_hos(hostel[] h,int n){
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (h[i].compare(h[j])==1){
                    hostel tem=h[i];
                    h[i]=h[j];
                    h[j]=tem;
                }
            }
        }
    }
    public void do_hostel_sort(hostel[] h,int n){
        merge_out(h,0,n-1);
        //bub_hos(h,n);
        for (int i=0;i<n;i++){
            h[i].set_h(i+1);
        }
    }
}
class lib{
    private double book_avail;
    private double dig_fac;
    private double sys_eff;
    private int l_rank;
    public lib(double book_avail,double dig_fac,double sys_eff){
        this.book_avail=book_avail;
        this.dig_fac=dig_fac;
        this.sys_eff=sys_eff;
        this.l_rank=-1;
    }
    public double get_book_avail(){
        return book_avail;
    }
    public double get_dig_fac(){
        return dig_fac;
    }
    public double get_sys_eff(){
        return sys_eff;
    }
    private double get_score(){
        return (get_book_avail()+get_dig_fac()+get_sys_eff())/3;
    }
    public int compare(lib l){
        if (l.get_score()>this.get_score())return 1;
        else return -1;
    }
    public void set_l(int r){
        this.l_rank=r;
    }
    public int get_l(){
        return l_rank;
    }
    private void merge_out(lib[] l,int i,int j){
        if (j-i>=1){
            int mid=(i+j)/2;
            merge_out(l,i,mid);
            merge_out(l,mid+1,j);
            merge_in(l,i,mid,j);
        }
    }
    private void merge_in(lib[] l,int p,int mid,int q){
        lib[] temp=new lib[q-p+1];
        for (int i=0;i<q-p+1;i++){
            temp[i]=new lib(0.0,0.0,0.0);
        }
        int i=p;
        int j=mid+1;
        int k=0;
        while((i<=mid)&&(j<=q)){
            if (l[i].compare(l[j])==-1)temp[k]=l[i++];
            else temp[k]=l[j++];
            k++;
        }
        if ((i<=mid)&&(j>q)){
            while(i<=mid)temp[k++]=l[i++];
        }
        else{
            while(j<=q)temp[k++]=l[j++];
        }
        for (k=0;k<temp.length;k++){
            l[k+p]=temp[k];
        }
    }
    private void bub_lib(lib[] m,int n){
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (m[i].compare(m[j])==1){
                    lib tem=m[i];
                    m[i]=m[j];
                    m[j]=tem;
                }
            }
        }
    }
    public void do_lib_sort(lib[] l,int n){
        merge_out(l,0,n-1);
        //bub_lib(l,n);
        for (int i=0;i<n;i++){
            l[i].set_l(i+1);
        }
    }
}
class acad{
    private double know;
    private double domain;
    private double crs_eff;
    private int a_rank;
    public acad(double know,double domain,double crs_eff){
        this.know=know;
        this.domain=domain;
        this.crs_eff=crs_eff;
        this.a_rank=-1;
    }
    public double get_know(){
        return know;
    }
    public double get_domain(){
        return domain;
    }
    public double get_crs_eff(){
        return crs_eff;
    }
    private double get_score(){
        return get_know()+get_domain()+2*get_crs_eff();
    }
    public int compare(acad a){
        if (a.get_score()>this.get_score())return 1;
        else return -1;
    }
    public void set_a(int r){
        this.a_rank=r;
    }
    public int get_a(){
        return a_rank;
    }
    private void merge_out(acad[] a,int i,int j){
        if (j-i>=1){
            int mid=(i+j)/2;
            merge_out(a,i,mid);
            merge_out(a,mid+1,j);
            merge_in(a,i,mid,j);
        }
    }
    private void merge_in(acad[] a,int p,int mid,int q){
        acad[] temp=new acad[q-p+1];
        for (int i=0;i<q-p+1;i++){
            temp[i]=new acad(0.0,0.0,0.0);
        }
        int i=p;
        int j=mid+1;
        int k=0;
        while((i<=mid)&&(j<=q)){
            if (a[i].compare(a[j])==-1)temp[k]=a[i++];
            else temp[k]=a[j++];
            k++;
        }
        if ((i<=mid)&&(j>q)){
            while(i<=mid)temp[k++]=a[i++];
        }
        else{
            while(j<=q)temp[k++]=a[j++];
        }
        for (k=0;k<temp.length;k++){
            a[k+p]=temp[k];
        }
    }
    private void bub_acad(acad[] m,int n){
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (m[i].compare(m[j])==1){
                    acad tem=m[i];
                    m[i]=m[j];
                    m[j]=tem;
                }
            }
        }
    }
    public void do_acad_sort(acad[] a,int n){
        merge_out(a,0,n-1);
        //bub_acad(a,n);
        for (int i=0;i<n;i++){
            a[i].set_a(i+1);
        }
    }
}
class college{
    private String name;
    private mess m;
    private hostel h;
    private lib l;
    private acad a;
    private double fees;
    private char grade;
    private double final_score;
    public college(int a1){
        name="abc";
        m=new mess(0.0,0.0,0.0,0.0);
        h=new hostel(0.0,0.0,0.0,0.0);
        l=new lib(0.0,0.0,0.0);
        a=new acad(0.0,0.0,0.0);
        fees=0;
        grade='L';
    }
    public college()throws IOException{
    	//Reader.init(System.in);
        name=Reader.next();
            for (int j=0;j<4;j++){
                String temp=Reader.next();
                if (j==0){
                	double a1=Reader.nextDouble();
                	double a2=Reader.nextDouble();
                	double a3=Reader.nextDouble();
                	double a4=Reader.nextDouble();
                    //m=new mess(Reader.nextDouble(),Reader.nextDouble(),Reader.nextDouble(),Reader.nextDouble());
                	//System.out.println(a1+" "+a2+" "+a3+" "+a4);
                	m=new mess(a1,a2,a3,a4);
                	//System.out.println(m.get_nutrition());
                }
                if (j==1){
                    h=new hostel(Reader.nextDouble(),Reader.nextDouble(),Reader.nextDouble(),Reader.nextDouble());
                }
                if (j==2){
                    l=new lib(Reader.nextDouble(),Reader.nextDouble(),Reader.nextDouble());
                }
                if (j==3){
                    a=new acad(Reader.nextDouble(),Reader.nextDouble(),Reader.nextDouble());
                }
            }
            String temp=Reader.next();
            double fees=Reader.nextDouble();
            temp=Reader.next();
            temp=Reader.next();
            grade=Reader.next().charAt(0);
    }
    public mess get_mess(){
        return m;
    }
    public hostel get_hostel(){
        return h;
    }
    public lib get_lib(){
        return l;
    }
    public acad get_acad(){
        return a;
    }
    public void give_score(int n){
        //System.out.println(m.get_m()+" "+h.get_h()+" "+l.get_l()+" "+a.get_a());
        final_score=0.25*(n-m.get_m()+1)+0.2*(n-h.get_h()+1)+0.25*(n-l.get_l()+1)+0.3*(n-a.get_a()+1);
    }
    public double get_final(){
        return final_score;
    }
    private int compare(college c){
        if (this.get_final()!=c.get_final()){
            if (this.get_final()<c.get_final())return 1;
            else return -1;
        }
        else if (this.fees!=c.fees){
            if (this.fees>c.fees)return 1;
            else return -1;
        }
        else{
            if (this.grade>c.grade)return 1;
            else return -1;
        }
    }
    private void merge_out(college[] c,int i,int j){
        if (j-i>=1){
            int mid=(i+j)/2;
            merge_out(c,i,mid);
            merge_out(c,mid+1,j);
            merge_in(c,i,mid,j);
        }
    }
    private void merge_in(college[] c,int p,int mid,int q){
        college[] temp=new college[q-p+1];
        for (int i=0;i<q-p+1;i++){
            temp[i]=new college(0);
        }
        int i=p;
        int j=mid+1;
        int k=0;
        while((i<=mid)&&(j<=q)){
            if (c[i].compare(c[j])==-1)temp[k]=c[i++];
            else temp[k]=c[j++];
            k++;
        }
        if ((i<=mid)&&(j>q)){
            while(i<=mid)temp[k++]=c[i++];
        }
        else{
            while(j<=q)temp[k++]=c[j++];
        }
        for (k=0;k<temp.length;k++){
            c[k+p]=temp[k];
        }
    }
    private void bub_col(college[] m,int n){
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (m[i].compare(m[j])==1){
                    college tem=m[i];
                    m[i]=m[j];
                    m[j]=tem;
                }
            }
        }
    }
    public void do_college_sort(college[] c,int n){
        for (int i=0;i<n;i++){
            c[i].give_score(n);
        }
        merge_out(c,0,n-1);
        //bub_col(c,n);
        for (int i=n-1;i>=0;i--){
            System.out.println(c[i].name+" "+c[i].get_final());
        }
    }
}
class aplab22{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        college[] col=new college[n];
        mess[] m=new mess[n];
        hostel[] h=new hostel[n];
        lib[] l=new lib[n];
        acad[] a=new acad[n];
        for (int i=0;i<n;i++){
            col[i]=new college();
            m[i]=col[i].get_mess();
            h[i]=col[i].get_hostel();
            l[i]=col[i].get_lib();
            a[i]=col[i].get_acad();
            //System.out.println(m[i]);
        }
        //System.out.println(m[1].get_nutrition());
        m[0].do_mess_sort(m,n);
        //System.out.println(m[1].get_nutrition());
        h[0].do_hostel_sort(h,n);
        l[0].do_lib_sort(l,n);
        a[0].do_acad_sort(a,n);
        col[0].do_college_sort(col,n);
        /*for (int i=0;i<n;i++){
        	System.out.println(col[i].get_mess().get_m());
        	System.out.println(col[i].get_hostel().get_h());
        	System.out.println(col[i].get_lib().get_l());
        	System.out.println(col[i].get_acad().get_a());
        }*/
    }
}