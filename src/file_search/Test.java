package file_search;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Set;


public class Test {

	public static void test(FileSearcher fs) {
		String fileName="resources/mobydick.txt";
		File f=new File(fileName);
		long size=f.length();
		
		fs.loadFile(fileName);
		
		long t0=System.nanoTime();
		Set<String> result=fs.search("ship");
		//result.addAll(fs.search("the"));
		result.addAll(fs.search("ship"));
		//result.addAll(fs.search("ship"));
		//result.addAll(fs.search("ship"));
		long t1=System.nanoTime();
		
		DecimalFormat df=new DecimalFormat("###,###.###");
		long memSize=fs.getMemSize();
		System.out.println("mem size is "+df.format(memSize)+" bytes");
		System.out.println("original file size is "+df.format(size)+" bytes");
		System.out.println("the ratio is "+df.format(((double)memSize/size)));
		System.out.println("search time: "+df.format(t1-t0)+" nanosecs");
		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		test(new IOFileSearcher());
	    test(new InMemFileSearcher());
//	    test(new CacheFileSearcher());
		
		System.out.println("done");
		
		
	}

}
