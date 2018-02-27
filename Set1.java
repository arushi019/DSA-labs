import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.util.StringTokenizer;



public class Set1 {



	/**

	 * @param args

	 * @throws IOException 

	 */

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		Reader.init(System.in);

		int n=Reader.nextInt();

		LinkedList l=new LinkedList();

		for(int i=0;i<n;i++)

		{

			l.add(Reader.nextInt());

		}

		l.RemoveDuplicates();

		l.display();

	}



	

}



class LinkedList

{

	Node head;

	Node rear;

	public LinkedList()

	{

		Node head=null;

		Node rear=null;

	}

	

	void add(int val)

	{

		Node n=new Node(val);

		if(head==null)

		{

			head=n;

			rear=head;

		}

		else

		{

			rear.setlink(n);

			rear=n;

		}

	}



	void display()

	{

		Node nptr=head;

		System.out.println();

		while(nptr!=null)

		{

			System.out.print(nptr.value+" ");

			nptr=nptr.getlink();

		}

	}



	// Remove duplicates from a sorted list

	void RemoveDuplicates() {

		Node current = head;

		if (current == null) return; 

		while(current.getlink()!=null)

		{

			if (current.value == current.getlink().value)

			{
				Node p=current.getlink();
				current.link=p.getlink();
				continue;

			}

			else

			{

				current = current.getlink();

			}

		}

	}

}



class Node{

	int value;

	Node link=null;

	public Node(int value)

	{

		this.value=value;

	}



	public Node()

	{

		this.value=0;

	}

	

	public Node(int value, Node next)

	{

		this.value=value;

		this.link=next;

	}

	Node getlink()

	{

		return link;

	}

	

	void setlink(Node next)

	{

		link=next;

	}

}

/**

 * 

 * You may safely assume that

 * the Reader class is not buggy

 *

 */

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

}	