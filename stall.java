import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
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
}
class stall{
public static void main(String[] args)throws IOException {
    Reader.init(System.in);
    int t=Reader.nextInt();
    int y=1;
    while(y<=t){
    int numStalls = Reader.nextInt(); // get it from user input if you like
    int k=Reader.nextInt();
    BitSet bs = new BitSet();
    // set the leftmost and the rightmost bits (which represent walls)
    bs.set(0);
    bs.set(numStalls+1);
    // now we have 10 bits gap, which represent stalls
    // like this: X__________X
    int max=0,min=0;
    for(int i=0; i<k; i++) {
        int p=nextStall(bs);
        bs.set(p);
        if (i==k-1){
        int h;
        /*for (h=p+1;h<bs.length()-1;h++){
            if (bs.get(h))break;
        }
        //System.out.println(h+"   "+p);
        h=h-p-1;*/
        h=bs.nextSetBit(p+1);
        h=h-p-1;
        //System.out.println("yy"+h);
        int h2;
        for (h2=p-1;h2>=0;h2--){
            if (bs.get(h2))break;
        }
        h2=p-h2-1;
        //System.out.println(h+" "+h2);
        max=(h2>h)?h2:h;
        min=(h2>h)?h:h2;
        //printStalls(bs);
    }
    }
    System.out.println("Case #"+y+": "+max+" "+min);
    y++;
    //printStalls(bs);
    }
}

/*public static int nextStall(BitSet bs) {
    int bestPos = 0, maxDist = bs.nextSetBit(0);
    //System.out.println("maxDist "+maxDist);
    // iterate over the set bits
    for(int pos = maxDist; pos != -1; pos = bs.nextSetBit(pos+1)) {
        int dist = bs.nextSetBit(pos+1) - pos;
        // track the position of the stall with biggest gap on the right
        if(dist > maxDist) {
            maxDist = dist;
            bestPos = pos;
        }
        //System.out.println("dist "+dist);
        //System.out.println("pos "+pos);
    }
    //System.out.println(bestPos+" "+maxDist/2);
    // return the position on the middle of the best gap
    return bestPos+maxDist/2;
}*/
public static int nextStall(BitSet bs) {
    // Find the position of the stall (or wall)
    // For which the next stall/wall is the most distant
    // bs.stream() returns stream of positions of the set bits
    int pos = bs.stream().boxed()
                .max(Comparator.comparingInt(v -> bs.nextSetBit(v+1) - v)).get();
    // Return the middle position in the gap
    return (pos+bs.nextSetBit(pos+1))/2;
}

/*public static void printStalls(BitSet bs) {
    StringBuilder sb = new StringBuilder();
    // Iterate over all the bit positions except the walls
    // walls have positions 0 and bs.length()
    for(int i=1; i<bs.length()-1; i++) {
        sb.append(bs.get(i) ? "X" : "_");
    }
    System.out.println(sb);
}*/
}