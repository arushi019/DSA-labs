import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.RunWith;
import org.junit.runners.Suite;
import aplab7.*;
import java.io.*;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	c1.class,c2.class,c3.class
})
class testrunner{
	public static void main(String[] args){
		Result result=JUnitCore.runClasses(TestSuite.class);
		for (Failure failure:result.getFailures()){
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
class c1{
	@Test
	public void add1(){
		song s=new song("Let_It_Go",280.75,"Idina_Menzel");
		ObjectInputStream in=null;
		player p=null;
            try{
                in=new ObjectInputStream(new FileInputStream("p1.txt"));
                p=(player)in.readObject();
                //p1.put(p.get_name(),p);
                //System.out.println(p.get_size()+" songs");
            }finally{
                in.close();
            }
            String s1=p.disp_string();
            p.add(s);
            String s2=p.disp_string();
            s1=s1+"Let_It_Go*";
            assertEquals(s1,s2);
	}
}
class c2{
	@Test
	public void del1(){
		song s=new song("Beautiful_Day",330.56,"U2");
		ObjectInputStream in=null;
		player p=null;
            try{
                in=new ObjectInputStream(new FileInputStream("p2.txt"));
                p=(player)in.readObject();
                //p1.put(p.get_name(),p);
                //System.out.println(p.get_size()+" songs");
            }finally{
                in.close();
            }
            String s1=p.disp_string();
            p.del(s);
            String s2=p.disp_string();
            s2="Beautiful_Day*"+s2;
            assertEquals(s1,s2);
	}
}
class c3{
	@Test
	public void search1(){
		ObjectInputStream in=null;
		player p=null;
            try{
                in=new ObjectInputStream(new FileInputStream("p3.txt"));
                p=(player)in.readObject();
                //p1.put(p.get_name(),p);
                //System.out.println(p.get_size()+" songs");
            }finally{
                in.close();
            }
        String s1=new String("Against_All_Odds");
        String s2=p.search_string(s1);
        String s3="Name: Against All Odds\nSinger: Phil Collins\nDuration: 310.28";
        assertEquals(s2,s3);
	}
}