//package temperature_find;
import java.io.IOException; 
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
    private IntWritable max = new IntWritable();
    private Text word = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        StringTokenizer line = new StringTokenizer(value.toString(),",\t");
        word.set(line.nextToken());
        max.set(Integer.parseInt(line.nextToken()));
        context.write(word,max);            
        }
    }	
